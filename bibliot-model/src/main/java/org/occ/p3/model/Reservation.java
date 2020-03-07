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
	
	private Member memberReserving;
	
	public String workTitle;
	

	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Work work;

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

	public Member getMemberReserving() {
		return memberReserving;
	}

	public void setMemberReserving(Member memberReserving) {
		this.memberReserving = memberReserving;
	}
	
	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
	
	
	
}
