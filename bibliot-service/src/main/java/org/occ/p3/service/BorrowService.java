package org.occ.p3.service;

public interface BorrowService {
	
	public Boolean borrowBook(Integer workId,Integer membreId);
	public Boolean extendBorrow(Integer borrowId);
	public Boolean terminateBorrow(Integer borrowId, Integer membreId);


}
