package org.occ.p3.consumer.repository;

import java.util.List;
import java.util.Optional;

import org.occ.p3.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends JpaRepository<Member, Integer>{

    Member findByUsernameAndPassword(String username, String password);
    
    List<Member> findAllById(Integer membreId);
    
    
}