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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ReservationController {

	/*
	 * @Autowired BorrowService borrowService;
	 * 
	 * @Autowired UserService userService;
	 * 
	 * @Autowired ReservationService reservationService;
	 */
	BorrowWeb borrowWsService = new BorrowWeb();
	BorrowWs borrowWs = borrowWsService.getBorrowWsPort();

	UserWeb userWsService = new UserWeb();
	UserWs userWs = userWsService.getUserWsPort();

	ReservationWeb reservationWsService = new ReservationWeb();
	ReservationWs reservationWs = reservationWsService.getReservationWsPort();

	@RequestMapping(value = "/doReservation/{workId}", method = RequestMethod.GET)
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

				// lien vers jsp de recherche avec message de succès
				List<org.occ.p3.webservices.Borrow> memberBorrowList = userWs.findBorrowListByMember(memberCo);
				// userService.findBorrowListByMember(memberCo);
				// Affichage de la borrowList dans un mav
				modelAndView = new ModelAndView("borrowListPage");
				modelAndView.addObject("memberborrowList", memberBorrowList);
				modelAndView.addObject("msg", "L'emprunt à été realisé avec succès");

			} else {
				modelAndView = new ModelAndView("SearchResults");
				modelAndView.addObject("msg", "Une erreur est survenue, l'emprunt n'a pas pu être réalisé");

			}

		}

		return modelAndView;
	}

}
