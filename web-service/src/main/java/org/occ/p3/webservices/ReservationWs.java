package org.occ.p3.webservices;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.occ.p3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;



@Service
@WebService(serviceName = "reservationWeb",name = "reservationWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

public class ReservationWs {
	
@Autowired
ReservationService reservationService;

	@WebMethod
	public Boolean reserveWork(Integer workId, Integer memberId) {
	return reservationService.reserveWork(workId, memberId);
	}
	
	@WebMethod
	public Boolean cancelReservation(Integer reservationId, Integer memberId) {
	return reservationService.cancelReservation(reservationId, memberId);
	}
	
	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
