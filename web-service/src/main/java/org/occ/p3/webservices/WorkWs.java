package org.occ.p3.webservices;
import org.occ.p3.model.Work;
import org.occ.p3.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "workWeb",name = "workWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class WorkWs {

    @Autowired
    WorkService workService;

    @WebMethod
    public List<Work> getWorksByAuthor(String author) {
     return workService.getWorksByAuthor(author);
    	
    }
    @WebMethod
    public List<Work> getWorksByPublicationDate (Integer publicationDate){
    return workService.getWorksByPublicationDate(publicationDate);
    	
    }
    
    @PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
