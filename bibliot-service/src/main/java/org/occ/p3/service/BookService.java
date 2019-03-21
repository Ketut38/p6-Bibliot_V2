package org.occ.p3.service;

import org.occ.p3.model.Book;


public interface BookService {

	public Book getBookById(Integer bookId);
	
	public Book saveNewBook(Book book);
	
}
