package org.occ.p3.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.occ.p3.service.BorrowService;
import org.occ.p3.service.UserService;
import org.occ.p3.webservices.BorrowWeb;
import org.occ.p3.webservices.BorrowWs;
import org.occ.p3.webservices.Member;
import org.occ.p3.webservices.UserWeb;
import org.occ.p3.webservices.UserWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BorrowController{
	
@Autowired
BorrowService borrowService;
@Autowired
UserService userService;

BorrowWeb borrowWsService = new BorrowWeb();
BorrowWs borrowWs = borrowWsService.getBorrowWsPort();

UserWeb userWsService = new UserWeb();
UserWs userWs = userWsService.getUserWsPort();




@RequestMapping(value="/borrow/{workId}", method=RequestMethod.GET)
	public ModelAndView borrowBook(HttpServletRequest request, @PathVariable("workId") Integer workId) {

		ModelAndView modelAndView = null;
		Member memberCo = (Member) request.getSession().getAttribute("memberConnected");

		if (memberCo == null) {

			modelAndView = new ModelAndView("connexion");
			modelAndView.addObject("msg", "Veuillez vous connecter pour emprunter un livre");

		} else {

			Integer membreId = memberCo.getId();

			System.out.println(membreId);

			Boolean emprunt = borrowWs.borrowBook(workId, membreId);

			if (emprunt == true) {

				// lien vers jsp de recherche avec message de succès
				List<org.occ.p3.webservices.Borrow> memberBorrowList = userWs.findBorrowListByMember(memberCo);
						//userService.findBorrowListByMember(memberCo);
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

	@RequestMapping(value = "/borrowList", method = RequestMethod.GET)
	public ModelAndView borrowList(HttpServletRequest request) {

		ModelAndView modelAndView = null;
		// On recupère MemberConnected de la session
		Member memberCo = (Member) request.getSession().getAttribute("memberConnected");

		if (memberCo == null) {
			// Si pas de membre co on renvoie vers la page de connexion
			modelAndView = new ModelAndView("connexion");
			modelAndView.addObject("msg", "Veuillez vous connecter pour afficher vos prêts en cours");
		} else {
			
			// On recupère sa borrowList
			List<org.occ.p3.webservices.Borrow> memberBorrowList = userWs.findBorrowListByMember(memberCo); 
					//userService.findBorrowListByMember(memberCo);
			// Affichage de la borrowList dans un mav
			modelAndView = new ModelAndView("borrowListPage");
			modelAndView.addObject("memberborrowList", memberBorrowList);
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/extendBorrow/{borrowId}", method=RequestMethod.GET)
	public ModelAndView extendBorrow(HttpServletRequest request, @PathVariable("borrowId") Integer borrowId) {
		
		ModelAndView modelAndView = null;
		// On recupère MemberConnected de la session
		Member memberCo = (Member) request.getSession().getAttribute("memberConnected");
		Boolean extend = borrowWs.extendBorrow(borrowId);
				//borrowService.extendBorrow(borrowId);

		if (extend == true) {

			// lien vers jsp de recherche avec message de succès
			// On recupère sa borrowList
			List<org.occ.p3.webservices.Borrow> memberBorrowList = userWs.findBorrowListByMember(memberCo);
					//userService.findBorrowListByMember(memberCo);
			// Affichage de la borrowList dans un mav
			modelAndView = new ModelAndView("borrowListPage");
			modelAndView.addObject("memberborrowList", memberBorrowList);
			modelAndView.addObject("msg", "L'extension de l'emprunt a été realisée avec succès");

		} else {
			modelAndView = new ModelAndView("borrowListPage");
			modelAndView.addObject("msg", "Une erreur est survenue, l'extension n'a pas pu être réalisée");

		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/borrowToEnd/{borrowId}", method = RequestMethod.GET)
	public ModelAndView borrowToEnd(HttpServletRequest request, @PathVariable("borrowId") Integer borrowId) {

		ModelAndView modelAndView = null;

		// On recupère MemberConnected de la session
		Member memberCo = (Member) request.getSession().getAttribute("memberConnected");
		Integer membreId = memberCo.getId();
		Boolean endBorrow = borrowWs.terminateBorrow(borrowId, membreId);
				

		if (endBorrow == true) {

			// lien vers jsp de list avec message de succès
			// On recupère sa borrowList
			List<org.occ.p3.webservices.Borrow> memberBorrowList = userWs.findBorrowListByMember(memberCo);
					//userService.findBorrowListByMember(memberCo);
			// Affichage de la borrowList dans un mav
			modelAndView = new ModelAndView("borrowListPage");
			modelAndView.addObject("memberborrowList", memberBorrowList);
			modelAndView.addObject("msg", "Le livre à été rendu avec succès");

		} else {
			modelAndView = new ModelAndView("borrowListPage");
			modelAndView.addObject("msg", "Une erreur est survenue, impossible de rendre le livre");
		}
		return modelAndView;
	}
}
