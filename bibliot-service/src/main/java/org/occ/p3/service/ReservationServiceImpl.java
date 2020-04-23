package org.occ.p3.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.ReservationRepository;
import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;
import org.occ.p3.model.ReservationStatusEnum;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	WorkRepository workRepository;
	@Autowired
	BorrowRepository borrowRepository;
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Boolean reserveWork(Integer workId, Integer memberId) {

		Boolean toReturn = false;

		// On recupère le titre de l'oeuvre à reserver
		Work myWorkGot = workRepository.findById(workId).get();
		String workName = myWorkGot.getTitle();

		// On recupère la liste des borrow du membre.
		Member membreEmprunt = memberRepository.findById(memberId).get();
		List<Borrow> memberBorrowList = borrowRepository.findByMember(membreEmprunt);

		// on recupère la liste de réservation du membre
		List<Reservation> memberResList = reservationRepository.findByMemberId(memberId);
		
		
		//********************************** RESERVATION VALIDATION ALGO **********************************//

		boolean goReserve = false;
		// CAS N°1 : aucun borrow et aucune réservation
		if (memberBorrowList.isEmpty() && memberResList.isEmpty()) {
			goReserve = true;
			// CAS N°2 : une liste de borrow mais pas de liste de réservation CAS OK
		} else if (CollectionUtils.isNotEmpty(memberBorrowList) && memberResList.isEmpty()) {
			// On parcours la borrowList
			Integer borrowListIndex = 1;
			for (Borrow result : memberBorrowList) {

				String borrowStatus = result.getStatus().toString();
				// CAS N°2.1 : un emprunt avec le meme titre d'oeuvre existe mais deja rendu
				if ((result.workTitle.equals(workName)) && (borrowStatus.equals("Rendu"))) {
					goReserve = true;
					break;
					// CAS N°2.2 : un emprunt avec le meme titre d'oeuvre existe et n'a pas été "Rendu"
				} else if (result.workTitle.equals(workName) && (borrowStatus != "Rendu")) {
					goReserve = false;
					break;
					// CAS N°2.3 : Pas d'emprunt avec le même titre d'oeuvre
				} else if (!result.workTitle.equals(workName) && (borrowListIndex == memberBorrowList.size())) {
					goReserve = true;
					break;
				}
				borrowListIndex++;

			}
			// CAS N°3 : pas de liste de borrow et une liste de réservation active CAS OK
		} else if (memberBorrowList.isEmpty() && CollectionUtils.isNotEmpty(memberResList)) {
			Integer resListIndex = 1;
			for (Reservation result : memberResList) {

				String resStatus = result.getStatus().toString();
				Integer resWorkId = result.getWorkId();

				if (resWorkId != workId && (resListIndex == memberResList.size())) {
					goReserve = true;
					break;

					// CAS N°3.1 : L'oeuvre de la réservation est la même que celle qu'on veut réserver mais est terminée
				} else if ((resWorkId == workId) && (resStatus.equals("Terminée"))) {
					goReserve = true;
					break;

				} else {
					goReserve = false;
				}
				resListIndex++;
			}
			// CAS N°4 : Une liste de borrow ET une liste de réservation active
		} else if (CollectionUtils.isNotEmpty(memberBorrowList) && CollectionUtils.isNotEmpty(memberBorrowList)) {

			Integer borrowListIndex = 1;
			for (Borrow result : memberBorrowList) {

				String borrowStatus = result.getStatus().toString();
				// CAS N°2.1 : un emprunt avec le meme titre d'oeuvre existe mais deja rendu
				if ((result.workTitle.equals(workName)) && (borrowStatus.equals("Rendu"))) {
					goReserve = true;
					break;
					// CAS N°2.2 : un emprunt avec le meme titre d'oeuvre existe et n'a pas été "Rendu"
				} else if (result.workTitle.equals(workName) && (borrowStatus != "Rendu")) {
					goReserve = false;
					break;
					// CAS N°2.3 : Pas d'emprunt avec le même titre d'oeuvre
				} else if (!result.workTitle.equals(workName) && (borrowListIndex == memberBorrowList.size())) {
					goReserve = true;
					break;
				}
				borrowListIndex++;

			}

			if (goReserve) {
				// On parcours ensuite la reservationList
				Integer resListIndex = 1;
				for (Reservation result : memberResList) {

					String resStatus = result.getStatus().toString();
					Integer resWorkId = result.getWorkId();

					if (resWorkId != workId && (resListIndex == memberResList.size())) {
						goReserve = true;
						break;

						// CAS N°3.1 : L'oeuvre de la réservation est la même que celle qu'on veut
						// réserver mais est terminée
					} else if ((resWorkId == workId) && (resStatus.equals("Terminée"))) {
						goReserve = true;
						break;

					} else {
						goReserve = false;
					}
					resListIndex++;
				}
			}
		}
		
		//********************************** END OF VALIDATION ALGO **********************************//

		if (goReserve) {

			Integer nbReservation = myWorkGot.getReservationRealized();

			if (nbReservation < 5) {

				Reservation reservationToSave = new Reservation();
				// Association membre/Work à la reservation
				reservationToSave.setWorkId(workId);
				reservationToSave.setMemberId(memberId); //
				reservationToSave.setStartDate(new Date());
				reservationToSave.setStatus(ReservationStatusEnum.PENDING.val());
				// Décrémente la quantité réservable de l'oeuvre
				nbReservation = (nbReservation + 1);
				System.out.println("nbReservation =" + nbReservation);
				myWorkGot.setReservationRealized(nbReservation);
				// Update de l'oeuvre
				workRepository.save(myWorkGot);
				// save la res dans le repository
				reservationRepository.save(reservationToSave);

				toReturn = true;
			} else
				toReturn = false;
		}

		return toReturn;

	}

	@Override
	public Boolean cancelReservation(Integer reservationId, Integer memberId) {

		Boolean toReturn = false;
		Reservation resToCancel = reservationRepository.findById(reservationId).get();
		Work workResToCancel = workRepository.findById(resToCancel.getWorkId()).get();
		Integer maxRes = workResToCancel.getReservationRealized();
		// Set le status de la resa à "terminée"
		resToCancel.setStatus(ReservationStatusEnum.DONE.val());
		// Rajoute +1 à quantité de resa possible
		workResToCancel.setReservationRealized(maxRes - 1);
		// Sauvegarde de l'oeuvre et de la resa dans repository
		reservationRepository.save(resToCancel);
		workRepository.save(workResToCancel);
		toReturn = true;
		return toReturn;

	}

}
