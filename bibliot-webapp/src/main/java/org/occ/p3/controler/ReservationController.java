package org.occ.p3.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.occ.p3.service.BorrowService;
import org.occ.p3.service.ReservationService;
import org.occ.p3.service.UserService;
import org.occ.p3.webservices.BorrowWeb;
import org.occ.p3.webservices.BorrowWs;
import org.occ.p3.webservices.Member;
import org.occ.p3.webservices.ReservationWeb;
import org.occ.p3.webservices.ReservationWs;
import org.occ.p3.webservices.UserWeb;
import org.occ.p3.webservices.UserWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {


	BorrowWeb borrowWsService = new BorrowWeb();
	BorrowWs borrowWs = borrowWsService.getBorrowWsPort();

	UserWeb userWsService = new UserWeb();
	UserWs userWs = userWsService.getUserWsPort();

	ReservationWeb reservationWsService = new ReservationWeb();
	ReservationWs reservationWs = reservationWsService.getReservationWsPort();
	
	@RequestMapping(value = "/reservationPage", method = RequestMethod.GET)
	public ModelAndView reservationPage() {
		ModelAndView reservation = new ModelAndView("reservationPage");
		return reservation;
	}

	@RequestMapping(value="/doReservation/{workId}", method = RequestMethod.GET)
	public ModelAndView reserveBook(HttpServletRequest request, @PathVariable("workId") Integer workId) {
		System.out.println("texte recu = " + workId);
		ModelAndView modelAndView = null;
		Member memberCo = (Member) request.getSession().getAttribute("memberConnected");

		if (memberCo == null) {

			modelAndView = new ModelAndView("connexion");
			modelAndView.addObject("msg", "Veuillez vous connecter pour reserver ce livre");

		} else {

			Integer membreId = memberCo.getId();

			System.out.println(membreId);
			System.out.println("ResController");
			Boolean reserveWork = reservationWs.reserveWork(workId, membreId);

			if (reserveWork == true) {

				// lien vers jsp de recherche avec message de succ�s
				List<org.occ.p3.webservices.Reservation> memberResList = userWs.findReservationListByMemberId(membreId);
				// userService.findBorrowListByMember(memberCo);
				// Affichage de la borrowList dans un mav
				modelAndView = new ModelAndView("reservationPage");
				modelAndView.addObject("ReservationList", memberResList);
				modelAndView.addObject("msg", "La res � �t� realis�e avec succ�s");

			} else {
				modelAndView = new ModelAndView("SearchResults");
				modelAndView.addObject("msg", "Une erreur est survenue, la res n'a pas pu �tre r�alis�e");

			}

		}

		return modelAndView;
	}
	
	@RequestMapping(value = "/reservationList", method = RequestMethod.GET)
	public ModelAndView reservationList(HttpServletRequest request) {

		ModelAndView modelAndView = null;
		// On recup�re MemberConnected de la session
		Member memberCo = (Member) request.getSession().getAttribute("memberConnected");

		if (memberCo == null) {
			// Si pas de membre co on renvoie vers la page de connexion
			modelAndView = new ModelAndView("connexion");
			modelAndView.addObject("msg", "Veuillez vous connecter pour afficher vos r�servations en cours");
		} else {
			
			// On recup�re sa reservationList
			Integer membreId = memberCo.getId();
			List<org.occ.p3.webservices.Reservation> memberResList = userWs.findReservationListByMemberId(membreId);
				for (org.occ.p3.webservices.Reservation result : memberResList) {
					
					
				}
			// Affichage de la borrowList dans un mav
			modelAndView = new ModelAndView("reservationPage");
			modelAndView.addObject("ReservationList", memberResList);
		}
		return modelAndView;
	}

}
