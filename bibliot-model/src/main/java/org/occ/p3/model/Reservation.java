package org.occ.p3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "gen_reservation", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_reservation", sequenceName = "seq_reservation", allocationSize = 1)
	private Integer id;
	
	private String status;
	
	private Date startDate;
	
	
	private Integer memberId;
	
	
	private Integer workId;
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getStatus() {
		return status;
	}

	

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Integer getMemberId() {
		return memberId;
	}



	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}



	public Integer getWorkId() {
		return workId;
	}



	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	

	
	
	
}
