
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
 *         &lt;element name="publicationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reservable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reservationRealized" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "publicationDate",
    "reservable",
    "reservationRealized",
    "title"
})
public class Work {

    protected String author;
    protected String bookDescription;
    @XmlElement(nillable = true)
    protected List<Book> booksList;
    protected Integer id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar publicationDate;
    protected boolean reservable;
    protected Integer reservationRealized;
    protected String title;

    /**
     * Obtient la valeur de la propri�t� author.
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
     * D�finit la valeur de la propri�t� author.
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
     * Obtient la valeur de la propri�t� bookDescription.
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
     * D�finit la valeur de la propri�t� bookDescription.
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
     * Obtient la valeur de la propri�t� id.
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
     * D�finit la valeur de la propri�t� id.
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
     * Obtient la valeur de la propri�t� publicationDate.
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
     * D�finit la valeur de la propri�t� publicationDate.
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
     * Obtient la valeur de la propri�t� reservable.
     * 
     */
    public boolean isReservable() {
        return reservable;
    }

    /**
     * D�finit la valeur de la propri�t� reservable.
     * 
     */
    public void setReservable(boolean value) {
        this.reservable = value;
    }

    /**
     * Obtient la valeur de la propri�t� reservationRealized.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReservationRealized() {
        return reservationRealized;
    }

    /**
     * D�finit la valeur de la propri�t� reservationRealized.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReservationRealized(Integer value) {
        this.reservationRealized = value;
    }

    /**
     * Obtient la valeur de la propri�t� title.
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
     * D�finit la valeur de la propri�t� title.
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
