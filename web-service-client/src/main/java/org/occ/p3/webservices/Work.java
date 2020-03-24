
package org.occ.p3.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour work complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="work">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="booksList" type="{http://webservices.p3.occ.org/}book" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxResAllowed" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="publicationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reservable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reservations" type="{http://webservices.p3.occ.org/}reservation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "work", propOrder = {
    "author",
    "bookDescription",
    "booksList",
    "id",
    "maxResAllowed",
    "publicationDate",
    "reservable",
    "reservations",
    "title"
})
public class Work {

    protected String author;
    protected String bookDescription;
    @XmlElement(nillable = true)
    protected List<Book> booksList;
    protected Integer id;
    protected Integer maxResAllowed;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar publicationDate;
    protected boolean reservable;
    @XmlElement(nillable = true)
    protected List<Reservation> reservations;
    protected String title;

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété bookDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookDescription() {
        return bookDescription;
    }

    /**
     * Définit la valeur de la propriété bookDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookDescription(String value) {
        this.bookDescription = value;
    }

    /**
     * Gets the value of the booksList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the booksList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooksList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Book }
     * 
     * 
     */
    public List<Book> getBooksList() {
        if (booksList == null) {
            booksList = new ArrayList<Book>();
        }
        return this.booksList;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété maxResAllowed.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxResAllowed() {
        return maxResAllowed;
    }

    /**
     * Définit la valeur de la propriété maxResAllowed.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxResAllowed(Integer value) {
        this.maxResAllowed = value;
    }

    /**
     * Obtient la valeur de la propriété publicationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * Définit la valeur de la propriété publicationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublicationDate(XMLGregorianCalendar value) {
        this.publicationDate = value;
    }

    /**
     * Obtient la valeur de la propriété reservable.
     * 
     */
    public boolean isReservable() {
        return reservable;
    }

    /**
     * Définit la valeur de la propriété reservable.
     * 
     */
    public void setReservable(boolean value) {
        this.reservable = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reservation }
     * 
     * 
     */
    public List<Reservation> getReservations() {
        if (reservations == null) {
            reservations = new ArrayList<Reservation>();
        }
        return this.reservations;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
