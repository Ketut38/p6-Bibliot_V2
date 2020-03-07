package org.occ.p3.service;

public interface ReservationService {
	
	public Boolean reserveWork(Integer workId, Integer memberId);
	public Boolean cancelReservation(Integer reservationId, Integer memberId);

}
