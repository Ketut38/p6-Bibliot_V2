
package org.occ.p3.webservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "workWs", targetNamespace = "http://webservices.p3.occ.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WorkWs {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.InitResponse")
    @Action(input = "http://webservices.p3.occ.org/workWs/initRequest", output = "http://webservices.p3.occ.org/workWs/initResponse")
    public void init();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservices.Work>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWorksByPublicationDate", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.GetWorksByPublicationDate")
    @ResponseWrapper(localName = "getWorksByPublicationDateResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.GetWorksByPublicationDateResponse")
    @Action(input = "http://webservices.p3.occ.org/workWs/getWorksByPublicationDateRequest", output = "http://webservices.p3.occ.org/workWs/getWorksByPublicationDateResponse")
    public List<Work> getWorksByPublicationDate(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservices.Work>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWorksByAuthor", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.GetWorksByAuthor")
    @ResponseWrapper(localName = "getWorksByAuthorResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.GetWorksByAuthorResponse")
    @Action(input = "http://webservices.p3.occ.org/workWs/getWorksByAuthorRequest", output = "http://webservices.p3.occ.org/workWs/getWorksByAuthorResponse")
    public List<Work> getWorksByAuthor(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isReservable", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.IsReservable")
    @ResponseWrapper(localName = "isReservableResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.IsReservableResponse")
    @Action(input = "http://webservices.p3.occ.org/workWs/isReservableRequest", output = "http://webservices.p3.occ.org/workWs/isReservableResponse")
    public boolean isReservable(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

}
