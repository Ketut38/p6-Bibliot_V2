package org.occ.p3.service;

import java.util.Date;
import java.util.List;

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

		// On recup�re le titre de l'oeuvre � reserver
		Work myWorkGot = workRepository.findById(workId).get();
		String workName = myWorkGot.getTitle();

		// On recup�re la liste des borrow du membre.
		Member membreEmprunt = memberRepository.findById(memberId).get();
		List<Borrow> memberBorrowList = borrowRepository.findByMember(membreEmprunt);
		
		boolean goReserve = false;
		
		// On parcours la borrowList
		for (Borrow result : memberBorrowList) {
			
			String borrowStatus = result.getStatus().toString();
			// On check si le membre n'a pas dej� l'oeuvre dans sa liste de borrow
			if (result.workTitle.equals(workName) && (!"Rendu".equals(borrowStatus))) {
				
				goReserve = true;
				break;
			
			}

		}
		
		if (goReserve) {
			
			Integer maxRes = myWorkGot.getMaxResAllowed();
		
			Reservation reservationToSave = new Reservation();
			//Association membre/Work � la reservation
			reservationToSave.setWork(myWorkGot);
			reservationToSave.setMemberReserving(membreEmprunt);
			reservationToSave.setStartDate(new Date());
			reservationToSave.setStatus(ReservationStatusEnum.PENDING.val());
			//D�cr�mente la quantit� r�servable de l'oeuvre
			maxRes = maxRes--;
			myWorkGot.setMaxResAllowed(maxRes);
			//Update maxRes de l'oeuvre
			workRepository.save(myWorkGot);
			//save la res dans le repository
			reservationRepository.save(reservationToSave);
			
			toReturn = true;
			
		}
		
		
	
		return toReturn;
	}

	@Override
	public Boolean cancelReservation(Integer reservationId, Integer memberId) {
		
		Boolean toReturn = false;
		Reservation resToCancel = reservationRepository.findById(reservationId).get();
		Work workResToCancel = resToCancel.getWork();
		Integer maxRes = workResToCancel.getMaxResAllowed();
		//Set le status de la resa � "termin�e"
		resToCancel.setStatus(ReservationStatusEnum.DONE.val());
		//Rajoute +1 � quantit� de resa possible
		workResToCancel.setMaxResAllowed(maxRes++);
		//Sauvegarde de l'oeuvre et de la resa dans repository
		reservationRepository.save(resToCancel);
		workRepository.save(workResToCancel);
		toReturn = true;
		return toReturn;
		
		
	}

}
