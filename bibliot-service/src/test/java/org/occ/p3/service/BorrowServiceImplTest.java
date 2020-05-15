package org.occ.p3.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.occ.p3.consumer.repository.BookRepository;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Book;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.BorrowStatusEnum;
import org.occ.p3.model.Member;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class BorrowServiceImplTest {

	@InjectMocks
	BorrowServiceImpl borrowService = new BorrowServiceImpl();

	@Mock
	MemberRepository memberRepository;
	@Mock
	WorkRepository workRepository;
	@Mock
	BorrowRepository borrowRepository;
	@Mock
	BookRepository bookRepository;
	@Mock
	UserService userService;
	@Mock
	WorkService workService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testBorrowBook() {
		
		//Arrange BookList
		Book b1 = new Book();
		b1.setId(1);
		b1.setAvailable(false);
		Book b2 = new Book();
		b2.setId(2);
		b2.setAvailable(true);
		
		List<Book> booksList = new ArrayList<Book>();
		booksList.add(b1);
		booksList.add(b2);
		
		

		// Arrange Work
		Date date = new Date();
		Work testwork = new Work();
		testwork.setId(98);
		testwork.setAuthor("testAuthor");
		testwork.setPublicationDate(date);
		testwork.setBooksList(booksList);
		// Mock workRepository
		Mockito.when(workRepository.findById(98)).thenReturn(Optional.of(testwork));
		
		 //Arrange  member 
		 Member testMember = new Member(); 
		 testMember.setId(98);
		 //Mock memberRepository
		 Mockito.when(memberRepository.findById(98)).thenReturn(Optional.of(testMember));
		 
		 
		 //Arrange BorrowList
		 Borrow bo1 = new Borrow();
		 bo1.setStatus(BorrowStatusEnum.ENCOURS.val());
		 bo1.setWorkId(16);
		 List<Borrow> memberBorrowList = new ArrayList<Borrow>();
		 memberBorrowList.add(bo1);
		 //Mock userService
		 Mockito.when(userService.findBorrowListByMember(testMember)).thenReturn(memberBorrowList);
		 
		 //Mock WorkService
		 Mockito.when(workService.isBorrowable(testwork.getId())).thenReturn(false);
		
		 
		 
		 
		 Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(b1);

		 Assert.assertTrue(borrowService.borrowBook(testwork.getId(),testMember.getId()));
	}

/*	@Test
	public void testExtendBorrow() {
		fail("Not yet implemented");
	}

	@Test
	public void testTerminateBorrow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendMailToReservationMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrowReservation() {
		fail("Not yet implemented");
	}*/

}
