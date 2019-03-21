
package org.occ.p3.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.occ.p3.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWorksByPublicationDate_QNAME = new QName("http://webservices.p3.occ.org/", "getWorksByPublicationDate");
    private final static QName _InitResponse_QNAME = new QName("http://webservices.p3.occ.org/", "initResponse");
    private final static QName _Init_QNAME = new QName("http://webservices.p3.occ.org/", "init");
    private final static QName _GetWorksByPublicationDateResponse_QNAME = new QName("http://webservices.p3.occ.org/", "getWorksByPublicationDateResponse");
    private final static QName _GetWorksByAuthor_QNAME = new QName("http://webservices.p3.occ.org/", "getWorksByAuthor");
    private final static QName _GetWorksByAuthorResponse_QNAME = new QName("http://webservices.p3.occ.org/", "getWorksByAuthorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.occ.p3.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link GetWorksByPublicationDate }
     * 
     */
    public GetWorksByPublicationDate createGetWorksByPublicationDate() {
        return new GetWorksByPublicationDate();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link GetWorksByAuthor }
     * 
     */
    public GetWorksByAuthor createGetWorksByAuthor() {
        return new GetWorksByAuthor();
    }

    /**
     * Create an instance of {@link GetWorksByAuthorResponse }
     * 
     */
    public GetWorksByAuthorResponse createGetWorksByAuthorResponse() {
        return new GetWorksByAuthorResponse();
    }

    /**
     * Create an instance of {@link GetWorksByPublicationDateResponse }
     * 
     */
    public GetWorksByPublicationDateResponse createGetWorksByPublicationDateResponse() {
        return new GetWorksByPublicationDateResponse();
    }

    /**
     * Create an instance of {@link Work }
     * 
     */
    public Work createWork() {
        return new Work();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorksByPublicationDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "getWorksByPublicationDate")
    public JAXBElement<GetWorksByPublicationDate> createGetWorksByPublicationDate(GetWorksByPublicationDate value) {
        return new JAXBElement<GetWorksByPublicationDate>(_GetWorksByPublicationDate_QNAME, GetWorksByPublicationDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorksByPublicationDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "getWorksByPublicationDateResponse")
    public JAXBElement<GetWorksByPublicationDateResponse> createGetWorksByPublicationDateResponse(GetWorksByPublicationDateResponse value) {
        return new JAXBElement<GetWorksByPublicationDateResponse>(_GetWorksByPublicationDateResponse_QNAME, GetWorksByPublicationDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorksByAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "getWorksByAuthor")
    public JAXBElement<GetWorksByAuthor> createGetWorksByAuthor(GetWorksByAuthor value) {
        return new JAXBElement<GetWorksByAuthor>(_GetWorksByAuthor_QNAME, GetWorksByAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorksByAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "getWorksByAuthorResponse")
    public JAXBElement<GetWorksByAuthorResponse> createGetWorksByAuthorResponse(GetWorksByAuthorResponse value) {
        return new JAXBElement<GetWorksByAuthorResponse>(_GetWorksByAuthorResponse_QNAME, GetWorksByAuthorResponse.class, null, value);
    }

}
