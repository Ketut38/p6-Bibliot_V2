package org.occ.p3.consumer.repository;

import org.occ.p3.model.Member;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Member, Integer>{
	
	Member findByUsernameAndPassword(String username, String password);

}
