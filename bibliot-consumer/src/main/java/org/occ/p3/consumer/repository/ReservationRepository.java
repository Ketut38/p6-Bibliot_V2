package org.occ.p3.consumer.repository;

import java.util.List;


import org.occ.p3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
	
	List<Reservation> findByMemberId(Integer memberId);
	
	List<Reservation> findByWorkId(Integer workId);
	
	Iterable<Reservation> findAll();

}
