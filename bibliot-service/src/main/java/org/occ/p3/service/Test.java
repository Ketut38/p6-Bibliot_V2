package org.occ.p3.service;

public class Test {
	
	public static void main(String[] arg) {
		
		BatchServiceImpl batchService = new BatchServiceImpl();
		
		batchService.sendMailToLateBorrowMember();
	}

}
