package org.occ.p3.consumer.repository;



import java.util.Date;
import java.util.List;

import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface BorrowRepository extends CrudRepository<Borrow, Integer> {
	
List<Borrow> findByMember(Member member);
Iterable<Borrow> findAll();


}
