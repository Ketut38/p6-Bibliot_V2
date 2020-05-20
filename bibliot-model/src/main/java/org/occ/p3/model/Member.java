package org.occ.p3.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="member")
@PrimaryKeyJoinColumn(referencedColumnName= "id")
public class Member extends User {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String mailAdress;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getMailAdress() {
		return mailAdress;
	}


	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	
	
}
