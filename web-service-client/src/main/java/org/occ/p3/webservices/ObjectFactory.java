
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

    private final static QName _InitResponse_QNAME = new QName("http://webservices.p3.occ.org/", "initResponse");
    private final static QName _CancelReservation_QNAME = new QName("http://webservices.p3.occ.org/", "cancelReservation");
    private final static QName _Init_QNAME = new QName("http://webservices.p3.occ.org/", "init");
    private final static QName _ReserveWork_QNAME = new QName("http://webservices.p3.occ.org/", "reserveWork");
    private final static QName _ReserveWorkResponse_QNAME = new QName("http://webservices.p3.occ.org/", "reserveWorkResponse");
    private final static QName _CancelReservationResponse_QNAME = new QName("http://webservices.p3.occ.org/", "cancelReservationResponse");

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
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link CancelReservation }
     * 
     */
    public CancelReservation createCancelReservation() {
        return new CancelReservation();
    }

    /**
     * Create an instance of {@link CancelReservationResponse }
     * 
     */
    public CancelReservationResponse createCancelReservationResponse() {
        return new CancelReservationResponse();
    }

    /**
     * Create an instance of {@link ReserveWork }
     * 
     */
    public ReserveWork createReserveWork() {
        return new ReserveWork();
    }

    /**
     * Create an instance of {@link ReserveWorkResponse }
     * 
     */
    public ReserveWorkResponse createReserveWorkResponse() {
        return new ReserveWorkResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "cancelReservation")
    public JAXBElement<CancelReservation> createCancelReservation(CancelReservation value) {
        return new JAXBElement<CancelReservation>(_CancelReservation_QNAME, CancelReservation.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveWork }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "reserveWork")
    public JAXBElement<ReserveWork> createReserveWork(ReserveWork value) {
        return new JAXBElement<ReserveWork>(_ReserveWork_QNAME, ReserveWork.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveWorkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "reserveWorkResponse")
    public JAXBElement<ReserveWorkResponse> createReserveWorkResponse(ReserveWorkResponse value) {
        return new JAXBElement<ReserveWorkResponse>(_ReserveWorkResponse_QNAME, ReserveWorkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.p3.occ.org/", name = "cancelReservationResponse")
    public JAXBElement<CancelReservationResponse> createCancelReservationResponse(CancelReservationResponse value) {
        return new JAXBElement<CancelReservationResponse>(_CancelReservationResponse_QNAME, CancelReservationResponse.class, null, value);
    }

}
