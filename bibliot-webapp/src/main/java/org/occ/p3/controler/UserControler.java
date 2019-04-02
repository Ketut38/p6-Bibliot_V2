package org.occ.p3.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.occ.p3.webservices.UserWeb;
import org.occ.p3.webservices.UserWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControler {
	@Autowired
	private HttpServletRequest request;
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String login() {
		return "connexion";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("connexion");
		 return modelAndView;
	}

	
	/*@Autowired
	UserService userService;*/
	
	UserWeb userWsService = new UserWeb();
	UserWs userWs = userWsService.getUserWsPort();

	@RequestMapping(value = "/authentificate", method = RequestMethod.POST)
	public ModelAndView authentification(HttpServletRequest request) {
		org.occ.p3.webservices.Member result;
		System.out.println("toto nous sommes bien arrivés");

		ModelAndView modelAndView = null;

		String username = request.getParameter("user");
		String password = request.getParameter("password");

		if (username != null & password != null) {

			
			result = userWs.isValidUser(username, password);
					

			if (result != null) {
				System.out.println("l'utilisateur existe");
				

				// Je dis que le mec est connecté
				org.occ.p3.webservices.Member memberConnected = userWs.isValidUser(username, password); 
						//userService.findMemberByUsernameAndPassword(username,password);
				System.out.println("le membre connecté a enregistré est " +memberConnected);
				request.getSession().setAttribute("connected", true);
				request.getSession().setAttribute("memberConnected", memberConnected);
				modelAndView = new ModelAndView("profil");
				modelAndView.addObject("memberConnected", memberConnected);
				System.out.println("le membre est connecté");
				//System.out.println(memberConnected.getName());
				

			} else {

				modelAndView = new ModelAndView("/connexion");
				modelAndView.addObject("msg", "Wrong username and or password");

			}
		} else {

			modelAndView = new ModelAndView("/error");
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public ModelAndView logout(HttpSession session) {
		
		ModelAndView modelAndView = null;
		
		session.invalidate();
		modelAndView = new ModelAndView("/connexion");
		modelAndView.addObject("msg", "Vous êtes deconnecté");
	    
	    return modelAndView;
	  }
	

}

