package org.occ.p3.service;

import org.occ.p3.model.Work;

import java.util.List;

import org.occ.p3.model.Book;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.Member;

public interface BorrowService {
	
	public Boolean borrowBook(Integer workId,Integer membreId);
	public Boolean extendBorrow(Integer borrowId);
	public Boolean terminateBorrow(Integer borrowId, Integer membreId);

//	
//	public Works getOriginWork();
//	
//    public Works getBookList (Integer workId);
//    
//    public Book findAvailableBook (Integer bookId);

}
