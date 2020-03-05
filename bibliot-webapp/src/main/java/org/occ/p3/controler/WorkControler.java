package org.occ.p3.controler;

import java.util.List;

import org.occ.p3.webservices.WorkWeb;
import org.occ.p3.webservices.WorkWs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkControler {

	// instanciation des WorkWeb et Workws

	WorkWeb workWsService = new WorkWeb();
	WorkWs workWs = workWsService.getWorkWsPort();

	@RequestMapping(value = "/work/{author}", method = RequestMethod.GET)

	public @ResponseBody

			List<org.occ.p3.webservices.Work> getWorksByAuthor(@PathVariable String author) {
		List<org.occ.p3.webservices.Work> workByAuthor = workWs.getWorksByAuthor(author);
		return workByAuthor;
	}

	@RequestMapping(value = "/work/{publicationDate}", method = RequestMethod.GET)

	public @ResponseBody List<org.occ.p3.webservices.Work> getWorksByPublicationDate(
			@PathVariable Integer publicationDate) {
		List<org.occ.p3.webservices.Work> workByPublicationDate = workWs.getWorksByPublicationDate(publicationDate);
		return workByPublicationDate;
	}

	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public ModelAndView searchPage() {
		ModelAndView search = new ModelAndView("search");
		return search;
	}

	@RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchText") String searchText) {

		System.out.println("texte recu = " + searchText);
		
		List<org.occ.p3.webservices.Work> workByAuthor = workWs.getWorksByAuthor(searchText);	
		
	for (org.occ.p3.webservices.Work result : workByAuthor) {

			boolean workReservable = workWs.isReservable(result.getId());
			result.setReservable(workReservable);

		}

		ModelAndView mav = new ModelAndView("SearchResults");

		mav.addObject("foundWorks", workByAuthor);
		System.out.println("taille liste recue = " + workByAuthor.size());
		return mav;
	}

}
