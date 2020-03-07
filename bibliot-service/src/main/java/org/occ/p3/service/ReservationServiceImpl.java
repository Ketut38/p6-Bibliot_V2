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
		
		boolean goReserve = true;
		
		// On parcours la borrowList
		for (Borrow result : memberBorrowList) {
			
			String borrowStatus = result.getStatus().toString();
			// On check si le membre n'a pas dejà l'oeuvre dans sa liste de borrow
			if (result.workTitle.equals(workName) && (!"Rendu".equals(borrowStatus))) {
				System.out.println("Vous empruntez dejà cette oeuvre!");
				goReserve = false;
				
				break;

			}

		}
		
		if (goReserve) {
			
			Integer maxRes = myWorkGot.getMaxResAllowed();
		
			Reservation reservationToSave = new Reservation();
			//Association membre/Work à la reservation
			reservationToSave.setWork(myWorkGot);
			reservationToSave.setMemberReserving(membreEmprunt);
			reservationToSave.setStartDate(new Date());
			//Décrémente la quantité réservable de l'oeuvre
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
		// TODO Auto-generated method stub
		return null;
	}

}
