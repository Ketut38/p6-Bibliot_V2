package org.occ.p3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="member")
@PrimaryKeyJoinColumn(name = "id")
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
