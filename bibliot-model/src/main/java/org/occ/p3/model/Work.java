package org.occ.p3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="work")
public class Work implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator="gen_work", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen_work", sequenceName="seq_work", allocationSize=1)		
	private Integer id;
	
	private String title;
	
	private String author;
	
	private Date publicationDate;
	
	private String bookDescription;
	
	private Integer maxResAllowed;
	
	private Boolean reservable = new Boolean(false); 
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Book> booksList;

	public Work() {
		super();
	}
	
	public Work(String title, String author){
		this.title = title;
		this.author = author;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	public Integer getMaxResAllowed() {
		return maxResAllowed;
	}

	public void setMaxResAllowed(Integer maxResAllowed) {
		this.maxResAllowed = maxResAllowed;
	}

	public boolean isReservable() {
		return reservable;
	}

	public void setReservable(boolean reservable) {
		this.reservable = reservable;
	}



}
