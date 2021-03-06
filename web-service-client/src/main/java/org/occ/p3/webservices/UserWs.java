
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
@WebService(name = "userWs", targetNamespace = "http://webservices.p3.occ.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserWs {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.InitResponse")
    @Action(input = "http://webservices.p3.occ.org/userWs/initRequest", output = "http://webservices.p3.occ.org/userWs/initResponse")
    public void init();

    /**
     * 
     * @param arg0
     * @return
     *     returns org.occ.p3.webservices.Member
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findMember", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.FindMember")
    @ResponseWrapper(localName = "findMemberResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.FindMemberResponse")
    @Action(input = "http://webservices.p3.occ.org/userWs/findMemberRequest", output = "http://webservices.p3.occ.org/userWs/findMemberResponse")
    public Member findMember(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.occ.p3.webservices.Member
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isValidUser", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.IsValidUser")
    @ResponseWrapper(localName = "isValidUserResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.IsValidUserResponse")
    @Action(input = "http://webservices.p3.occ.org/userWs/isValidUserRequest", output = "http://webservices.p3.occ.org/userWs/isValidUserResponse")
    public Member isValidUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservices.Reservation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findReservationListByMemberId", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.FindReservationListByMemberId")
    @ResponseWrapper(localName = "findReservationListByMemberIdResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.FindReservationListByMemberIdResponse")
    @Action(input = "http://webservices.p3.occ.org/userWs/findReservationListByMemberIdRequest", output = "http://webservices.p3.occ.org/userWs/findReservationListByMemberIdResponse")
    public List<Reservation> findReservationListByMemberId(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservices.Borrow>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findBorrowListByMember", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.FindBorrowListByMember")
    @ResponseWrapper(localName = "findBorrowListByMemberResponse", targetNamespace = "http://webservices.p3.occ.org/", className = "org.occ.p3.webservices.FindBorrowListByMemberResponse")
    @Action(input = "http://webservices.p3.occ.org/userWs/findBorrowListByMemberRequest", output = "http://webservices.p3.occ.org/userWs/findBorrowListByMemberResponse")
    public List<Borrow> findBorrowListByMember(
        @WebParam(name = "arg0", targetNamespace = "")
        Member arg0);

}
