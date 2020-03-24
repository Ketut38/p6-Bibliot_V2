package org.occ.p3.consumer.repository;

import java.util.List;


import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
	
	List<Reservation> findByMember(Member member);
	
	Iterable<Reservation> findAll();

}
