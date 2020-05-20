package org.occ.p3.service;

import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;

public interface BorrowService {
	
	public Boolean borrowBook(Integer workId,Integer membreId);
	public Boolean extendBorrow(Integer borrowId);
	public Boolean terminateBorrow(Integer borrowId, Integer membreId);
	public void sendMailToReservationMember(Member member, Reservation reservation);
	public Boolean borrowReservation (Integer reservationId, Integer membreId);


}
