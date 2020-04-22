package org.occ.p3.webservices;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;
import org.occ.p3.model.User;
import org.occ.p3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Service
@WebService(serviceName = "userWeb",name = "userWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class UserWs {
	
@Autowired
UserService userService;

	@WebMethod
	public Member isValidUser(String username, String password) {
		return userService.isValidUser(username, password);
		
	}
	
	@WebMethod
	public List<Borrow> findBorrowListByMember (Member member){
		return userService.findBorrowListByMember(member);
		
	}
	@WebMethod
	public Member findMember(Integer memberId) {
		return userService.findMember(memberId);
	}
	
	@WebMethod
	public List<Reservation> findReservationListByMemberId (Integer memberId){
		return userService.findReservationListByMemberId(memberId);
	}
	
	
	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
