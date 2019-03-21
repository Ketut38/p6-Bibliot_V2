package org.occ.p3.webservices;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.occ.p3.model.Book;
import org.occ.p3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Service
@WebService(serviceName = "bookWeb", name = "bookWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class BookWs {

	@Autowired
	BookService bookService;

	@WebMethod
	public Book getBookById(Integer bookId) {
	return bookService.getBookById(bookId);
		
	}

	@WebMethod
	public Book saveNewBook(Book book) {
	return bookService.saveNewBook(book);
		
	}

	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
	}

}
