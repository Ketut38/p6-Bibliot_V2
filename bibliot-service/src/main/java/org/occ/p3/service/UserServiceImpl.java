package org.occ.p3.service;

import java.util.List;

import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	

@Autowired
MemberRepository memberRepository;
@Autowired
BorrowRepository borrowRepository;

	public Member isValidUser(String username, String password) {  
			
	Member validMember = memberRepository.findByUsernameAndPassword(username, password);    
		
	return validMember; 	
	}

	
 public List<Borrow> findBorrowListByMember (Member member){
	 
	 return borrowRepository.findByMember(member);
 }

}
