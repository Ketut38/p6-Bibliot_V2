
package org.occ.p3.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour member complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="member">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservices.p3.occ.org/}user">
 *       &lt;sequence>
 *         &lt;element name="borrowList" type="{http://webservices.p3.occ.org/}borrow" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mailAdress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "member", propOrder = {
    "borrowList",
    "mailAdress",
    "name"
})
public class Member
    extends User
{

    @XmlElement(nillable = true)
    protected List<Borrow> borrowList;
    protected String mailAdress;
    protected String name;

    /**
     * Gets the value of the borrowList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borrowList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorrowList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Borrow }
     * 
     * 
     */
    public List<Borrow> getBorrowList() {
        if (borrowList == null) {
            borrowList = new ArrayList<Borrow>();
        }
        return this.borrowList;
    }

    /**
     * Obtient la valeur de la propriété mailAdress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAdress() {
        return mailAdress;
    }

    /**
     * Définit la valeur de la propriété mailAdress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAdress(String value) {
        this.mailAdress = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
