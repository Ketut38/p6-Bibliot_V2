
package org.occ.p3.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour borrow complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="borrow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="book" type="{http://webservices.p3.occ.org/}book" minOccurs="0"/>
 *         &lt;element name="endBorrowDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="extended" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memberBorrowing" type="{http://webservices.p3.occ.org/}member" minOccurs="0"/>
 *         &lt;element name="startBorrowDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="workName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "borrow", propOrder = {
    "workTitle",
    "book",
    "endBorrowDate",
    "extended",
    "id",
    "memberBorrowing",
    "startBorrowDate",
    "status",
    "workId",
    "workName"
})
public class Borrow {

    protected String workTitle;
    protected Book book;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endBorrowDate;
    protected boolean extended;
    protected Integer id;
    protected Member memberBorrowing;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startBorrowDate;
    protected String status;
    protected Integer workId;
    protected String workName;

    /**
     * Obtient la valeur de la propri�t� workTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkTitle() {
        return workTitle;
    }

    /**
     * D�finit la valeur de la propri�t� workTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkTitle(String value) {
        this.workTitle = value;
    }

    /**
     * Obtient la valeur de la propri�t� book.
     * 
     * @return
     *     possible object is
     *     {@link Book }
     *     
     */
    public Book getBook() {
        return book;
    }

    /**
     * D�finit la valeur de la propri�t� book.
     * 
     * @param value
     *     allowed object is
     *     {@link Book }
     *     
     */
    public void setBook(Book value) {
        this.book = value;
    }

    /**
     * Obtient la valeur de la propri�t� endBorrowDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndBorrowDate() {
        return endBorrowDate;
    }

    /**
     * D�finit la valeur de la propri�t� endBorrowDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndBorrowDate(XMLGregorianCalendar value) {
        this.endBorrowDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� extended.
     * 
     */
    public boolean isExtended() {
        return extended;
    }

    /**
     * D�finit la valeur de la propri�t� extended.
     * 
     */
    public void setExtended(boolean value) {
        this.extended = value;
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
     * Obtient la valeur de la propri�t� memberBorrowing.
     * 
     * @return
     *     possible object is
     *     {@link Member }
     *     
     */
    public Member getMemberBorrowing() {
        return memberBorrowing;
    }

    /**
     * D�finit la valeur de la propri�t� memberBorrowing.
     * 
     * @param value
     *     allowed object is
     *     {@link Member }
     *     
     */
    public void setMemberBorrowing(Member value) {
        this.memberBorrowing = value;
    }

    /**
     * Obtient la valeur de la propri�t� startBorrowDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartBorrowDate() {
        return startBorrowDate;
    }

    /**
     * D�finit la valeur de la propri�t� startBorrowDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartBorrowDate(XMLGregorianCalendar value) {
        this.startBorrowDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * D�finit la valeur de la propri�t� status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propri�t� workId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWorkId() {
        return workId;
    }

    /**
     * D�finit la valeur de la propri�t� workId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWorkId(Integer value) {
        this.workId = value;
    }

    /**
     * Obtient la valeur de la propri�t� workName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * D�finit la valeur de la propri�t� workName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkName(String value) {
        this.workName = value;
    }

}
