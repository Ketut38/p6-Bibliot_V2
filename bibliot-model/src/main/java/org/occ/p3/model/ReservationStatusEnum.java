package org.occ.p3.model;

public enum ReservationStatusEnum {
	PENDING("R�serv�e"),
	DONE("Termin�e");
	
	private String status;
	
	 ReservationStatusEnum(String status) {
		 this.status=status;
	}
	 
	 public String val() {
		 return status;
	 }

}
