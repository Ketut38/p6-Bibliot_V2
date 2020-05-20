package org.occ.p3.service;

import java.util.List;

import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;

public interface UserService {
	
 	
public Member isValidUser(String username, String password);


public Member findMember(Integer memberId);


public List<Borrow> findBorrowListByMember (Member member);

public List<Reservation> findReservationListByMemberId (Integer memberId);

}
