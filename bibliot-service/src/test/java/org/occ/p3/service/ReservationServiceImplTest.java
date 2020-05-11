package org.occ.p3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.enterprise.inject.Any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.ReservationRepository;
import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.BorrowStatusEnum;
import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;
import org.occ.p3.model.ReservationStatusEnum;
import org.occ.p3.model.Work;


@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceImplTest {
	
	@InjectMocks
	ReservationServiceImpl reservationService = new ReservationServiceImpl();
	
	@Mock
	BorrowRepository borrowRepository;
	
	@Mock
	WorkRepository workRepository;

	@Mock
	MemberRepository memberRepository;
	
	@Mock
	ReservationRepository reservationRepository;
	
	  @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }

	@Test
	public void testIsWorkIsReserved() {

		// Arrange
		Date date = new Date();

		Reservation r1 = new Reservation();
		r1.setMemberId(2);
		r1.setStartDate(date);
		r1.setStatus("Réservée");
		r1.setWorkId(7);

		Reservation r2 = new Reservation();
		r2.setMemberId(2);
		r2.setStartDate(date);
		r2.setStatus("Réservée");// REmplacer les statut par enum
		r2.setWorkId(5);

		Reservation r3 = new Reservation();
		r3.setMemberId(2);
		r3.setStartDate(date);
		r3.setStatus("Réservée");
		r3.setWorkId(4);

		List<Reservation> reservationList = new ArrayList<Reservation>();
		reservationList.add(r1);
		reservationList.add(r2);
		reservationList.add(r3);

		Assert.assertTrue(reservationService.isWorkIsReserved(7, reservationList));

	}

	/*
	 * @Test public void testCancelReservation() {
	 * 
	 * }
	 */

	@Test
	public void testReserveWork() {
		
		//Arrange Reservation
		Reservation r1 = new Reservation();
		r1.setMemberId(99);
		r1.setWorkId(99);
		r1.setStartDate(new Date());
		r1.setStatus(ReservationStatusEnum.PENDING.val());

		//Arrange Work 
		Date date = new Date(); 
		Work testwork = new Work();
		testwork.setId(99); testwork.setAuthor("testAuthor");
		testwork.setPublicationDate(date); 
		testwork.setReservationRealized(3);
		//Mock workRepository
		Mockito.when(workRepository.findById(99)).thenReturn(Optional.of(testwork));
		
		 //Arrange  member 
		 Member testMember = new Member(); 
		 testMember.setId(99);
		 //Mock memberRepository
		 Mockito.when(memberRepository.findById(99)).thenReturn(Optional.of(testMember));
		 
		 //Arrange borrowList
		 Borrow b1 = new Borrow();
		 b1.setStatus(BorrowStatusEnum.ENCOURS.val());
		 b1.setWorkId(16);
		 List<Borrow> memberBorrowList = new ArrayList<Borrow>();
		 memberBorrowList.add(b1);
		 //Mock borrowRepository
		 Mockito.when(borrowRepository.findByMember(testMember)).thenReturn(memberBorrowList);
		 
		// Act
		Mockito.when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(r1);
		//Boolean resOk = reservationService.reserveWork(99, 99); 
	    //On vérifie que la method save à été invokée
	    //Mockito.verify(reservationRepository,Mockito.times(1)).save(Mockito.any(Reservation.class));
	    Assert.assertTrue(reservationService.reserveWork(testwork.getId(),testMember.getId()));
	

	}



}
