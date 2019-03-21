package org.occ.p3.service;

import java.util.List;

import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.UserRepository;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.occ.p3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
@Autowired
UserRepository userRepository;
@Autowired
MemberRepository memberRepository;
@Autowired
BorrowRepository borrowRepository;

	public boolean isValidUser(String username, String password) {  
			
	Member validMember = memberRepository.findByUsernameAndPassword(username, password);    
		
	boolean toReturn;     	
	if (validMember !=null) {     		
	toReturn = true; 		
	} else{  
				
	toReturn = false; 
	}     	
		
	return toReturn; 	
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		
		return userRepository.findByUsernameAndPassword(username, password);
		
	}
	
   public Member findMemberByUsernameAndPassword(String username, String password) {
		
		return memberRepository.findByUsernameAndPassword(username, password);
		
	}
 public List<Borrow> findBorrowListByMember (Member member){
	 
	 return borrowRepository.findByMember(member);
 }

}
