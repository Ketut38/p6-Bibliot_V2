package org.occ.p3.model;

public enum ReservationStatusEnum {
	PENDING("Réservée"),
	DONE("Terminée");
	
	private String status;
	
	 ReservationStatusEnum(String status) {
		 this.status=status;
	}
	 
	 public String val() {
		 return status;
	 }

}
