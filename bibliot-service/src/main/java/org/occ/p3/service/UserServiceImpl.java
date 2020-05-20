package org.occ.p3.service;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.ReservationRepository;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BorrowRepository borrowRepository;
	@Autowired
	ReservationRepository reservationRepository;

	public Member isValidUser(String username, String password) {

		Member validMember = memberRepository.findByUsernameAndPassword(username, password);

		return validMember;
	}

	public List<Borrow> findBorrowListByMember(Member member) {

		return borrowRepository.findByMember(member);
	}

	public Member findMember(Integer memberId) {
		return memberRepository.findById(memberId).get();
	}

	
	public List<Reservation> findReservationListByMemberId(Integer memberId) {
		
		return reservationRepository.findByMemberId(memberId);
	}

}
