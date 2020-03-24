
package org.occ.p3.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "reservationWeb", targetNamespace = "http://webservices.p3.occ.org/", wsdlLocation = "http://lfr011641:8080/bibliot-webapp/ws/ReserveWs?wsdl")
public class ReservationWeb
    extends Service
{

    private final static URL RESERVATIONWEB_WSDL_LOCATION;
    private final static WebServiceException RESERVATIONWEB_EXCEPTION;
    private final static QName RESERVATIONWEB_QNAME = new QName("http://webservices.p3.occ.org/", "reservationWeb");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://lfr011641:8080/bibliot-webapp/ws/ReserveWs?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RESERVATIONWEB_WSDL_LOCATION = url;
        RESERVATIONWEB_EXCEPTION = e;
    }

    public ReservationWeb() {
        super(__getWsdlLocation(), RESERVATIONWEB_QNAME);
    }

    public ReservationWeb(WebServiceFeature... features) {
        super(__getWsdlLocation(), RESERVATIONWEB_QNAME, features);
    }

    public ReservationWeb(URL wsdlLocation) {
        super(wsdlLocation, RESERVATIONWEB_QNAME);
    }

    public ReservationWeb(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RESERVATIONWEB_QNAME, features);
    }

    public ReservationWeb(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReservationWeb(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ReservationWs
     */
    @WebEndpoint(name = "reservationWsPort")
    public ReservationWs getReservationWsPort() {
        return super.getPort(new QName("http://webservices.p3.occ.org/", "reservationWsPort"), ReservationWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReservationWs
     */
    @WebEndpoint(name = "reservationWsPort")
    public ReservationWs getReservationWsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.p3.occ.org/", "reservationWsPort"), ReservationWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RESERVATIONWEB_EXCEPTION!= null) {
            throw RESERVATIONWEB_EXCEPTION;
        }
        return RESERVATIONWEB_WSDL_LOCATION;
    }

}
