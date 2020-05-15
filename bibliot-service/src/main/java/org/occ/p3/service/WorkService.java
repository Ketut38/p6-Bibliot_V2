package org.occ.p3.service;

import org.occ.p3.model.Work;

import java.util.List;

public interface WorkService {

    public List<Work> getWorksByAuthor(String author);

    public List<Work> getWorksByPublicationDate (Integer publicationDate);

	public boolean isReservable(Integer workId);

	boolean isBorrowable(Integer workId);
	
	
	
	//public void setMaxReservable (Integer workId);
    
    
    	

}