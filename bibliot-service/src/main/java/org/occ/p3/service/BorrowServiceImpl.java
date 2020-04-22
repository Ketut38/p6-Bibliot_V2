package org.occ.p3.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.occ.p3.consumer.repository.BookRepository;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.MemberRepository;
import org.occ.p3.consumer.repository.ReservationRepository;
import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Book;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.BorrowStatusEnum;
import org.occ.p3.model.Member;
import org.occ.p3.model.Reservation;
import org.occ.p3.model.ReservationStatusEnum;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	WorkRepository workRepository;
	@Autowired
	BorrowRepository borrowRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	UserService userService;

	public Boolean borrowBook(Integer workId, Integer membreId) {

		Boolean toReturn = false;

		// Recuperer le Work dont on connait l'ID (creer work repository)
		Work myWorkGot = workRepository.findById(workId).get();
		String workName = myWorkGot.getTitle();

		// recuperer la liste dans myborrowgot
		List<Book> bookList = myWorkGot.getBooksList();

		// On parcours la bookList
		for (Book result : bookList) {

			if (result.isAvailable()) {

				Borrow borrowToSave = new Borrow();
				borrowToSave.setBook(result);
				// on recupère l'Id du membre passé en parametre
				Member membreEmprunt = memberRepository.findById(membreId).get();

				// On associe le member a borrow
				borrowToSave.setMemberBorrowing(membreEmprunt);
				borrowToSave.setStartBorrowDate(new Date());

				// Calcul de la date de fin d'emprunt
				Date borrowDate = borrowToSave.getStartBorrowDate();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(borrowDate);
				calendar.add(Calendar.WEEK_OF_MONTH, 4);
				borrowToSave.setEndBorrowDate(calendar.getTime());

				// Set le statut de l'emprunt + Ajout du nom de l'oeuvre à l'emprunt +
				// décrémente MaxResAllowed

				borrowToSave.setStatus(BorrowStatusEnum.ENCOURS.val());
				borrowToSave.setWorkId(workId);
				borrowToSave.setWorkName(workName);
			

				// Save le borrow dans le repositor
				borrowRepository.save(borrowToSave);
				// Indique que le livre n'est plus disponible et on sauvegarde dans le
				// bookRepository
				result.setAvailable(false);
				bookRepository.save(result);

				// Mettre a jour la liste des emprunt du memmberCo et save

				List<Borrow> memberListBorrowToUpdate = userService.findBorrowListByMember(membreEmprunt);
				memberListBorrowToUpdate.add(borrowToSave);

				memberRepository.save(membreEmprunt);

				toReturn = true;
				break;
			}

		}
		return toReturn;
	}

	public Boolean extendBorrow(Integer borrowId) {

		Boolean toReturn = false;
		// Recuperer le borrow dont on connait l'ID
		Borrow borrowToExtend = borrowRepository.findById(borrowId).get();
		Date endBorrowDate = borrowToExtend.getEndBorrowDate();
		// Recuperer la date du jour
		Date currentDate = new Date();

		if (endBorrowDate.after(currentDate) && (borrowToExtend.isExtended() == false)) {

			// Rallonge de l'emprunt +4weeks
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(endBorrowDate);
			calendar.add(Calendar.WEEK_OF_MONTH, 4);
			borrowToExtend.setEndBorrowDate(calendar.getTime());
			// setExtended a true
			borrowToExtend.setExtended(true);
			borrowToExtend.setStatus(BorrowStatusEnum.PROLONGE.val());
			borrowRepository.save(borrowToExtend);
			toReturn = true;

		} else {

			toReturn = false;
		}

		return toReturn;
	}

	
	

	public Boolean terminateBorrow(Integer borrowId, Integer membreId) {

		Boolean toReturn = false;

		// Set le statut de l'emprunt a "rendu"
		// Recuperation de la liste de reservation pour l'oeuvre rendue
		Borrow borrowToEnd = borrowRepository.findById(borrowId).get();
		Integer workBorrowId = borrowToEnd.getWorkId();
		List<Reservation> reservationList = reservationRepository.findByWorkId(workBorrowId);

		// retourne la reservation la plus ancienne
		Reservation oldestRes = Collections.min(reservationList,
				Comparator.comparing(reservation -> reservation.getStartDate()));

		oldestRes.setStatus(ReservationStatusEnum.WAITING.val());

		// On envoie un mail au membre concerné par la reservation
		Member memberToMail = userService.findMember(oldestRes.getMemberId());
		
		sendMailToReservationMember(memberToMail,oldestRes);
		

		borrowToEnd.setStatus(BorrowStatusEnum.RENDU.val());
		// Set le book comme disponible
		Book returnedBook = borrowToEnd.getBook();
		returnedBook.setAvailable(true);
		// Sauvegarde du livre rendu
		bookRepository.save(returnedBook);
		borrowRepository.save(borrowToEnd);
		toReturn = true;
		return toReturn;
	}
	
	public void sendMailToReservationMember(Member member, Reservation reservation) {

		// config connexion au serveur SMTP gmail avec TLS
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		// ouverture de la session avec mon mail
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("test.javaketut38@gmail.com", "4HH7Q1pcrg");
			}

		});

		String memberMail = member.getMailAdress();
		Work workReserved = workRepository.getWorkById(reservation.getWorkId());

		try {
			// Creation objet mimeMessage
			MimeMessage msg = new MimeMessage(session);

			// Setting the recepients from the address variable
			msg.setRecipients(Message.RecipientType.TO, memberMail);
			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
			msg.setSubject(workReserved.getTitle() + "est disponible !");
			msg.setSentDate(new Date());
			msg.setText("L'oeuvre" + workReserved.getTitle() + "que vous avez reservée le" + reservation.getStartDate()
					+ "est disponible, merci de vous connecter sur l'application pour confirmer votre emprunt");
			msg.setHeader("XPriority", "1");
			Transport.send(msg);
			System.out.println("Mail has been sent successfully");
		} catch (MessagingException mex) {
			System.out.println("Unable to send an email" + mex);
		}

	}

	
}
