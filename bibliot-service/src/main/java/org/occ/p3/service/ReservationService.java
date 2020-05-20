package org.occ.p3.service;

import java.util.List;

import org.occ.p3.model.Borrow;
import org.occ.p3.model.Reservation;

public interface ReservationService {
	
	public Boolean reserveWork(Integer workId, Integer memberId);
	public Boolean cancelReservation(Integer reservationId, Integer memberId);
	public Boolean isWorkIsBorrowed(Integer workId, List<Borrow> memberBorrowList);
	public Boolean isWorkIsReserved(Integer workId, List<Reservation> memberResList);
	

}
