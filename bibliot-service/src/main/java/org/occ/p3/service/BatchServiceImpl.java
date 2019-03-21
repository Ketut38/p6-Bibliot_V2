package org.occ.p3.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.model.Book;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.BorrowStatusEnum;
import org.occ.p3.model.Member;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	BorrowRepository borrowRepository;


		//Envoyer un mail a memberMail, appeler une methode privée a developper
		 public void sendMailToLateBorrowMember() {
			 
			
		 
		        //config connexion au serveur SMTP gmail avec TLS
		        Properties props = new Properties();
		        props.put("mail.smtp.host", "true");
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", "smtp.gmail.com");
		        props.put("mail.smtp.port", "587");
		        props.put("mail.smtp.auth", "true");
		        //ouverture de la session avec mon mail
		        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication("test.javaketut38@gmail.com", "4HH7Q1pcrg");
		            }
	
		        });
		      //Recuperation de l'iterable
		    	Iterable<Borrow> borrowListGot = borrowRepository.findAll();
		    	Iterator<Borrow> listBorrowIterator = borrowListGot.iterator();
		    	
		    	while(listBorrowIterator.hasNext()) {
		    		
		    	Borrow currentBorrow = listBorrowIterator.next();
		    		
		    	Date dateFin = currentBorrow.getEndBorrowDate();
		    	Date currentDate = new Date();
		    	
		    	if (dateFin.before(currentDate) && currentBorrow.getStatus().equals(BorrowStatusEnum.ENCOURS.val()));{
		    		
		    		Member memberToMail = currentBorrow.getMemberBorrowing();
		    		String memberMail = memberToMail.getMailAdress();
		    		try {	
		      //Creation objet mimeMessage 
	            MimeMessage msg = new MimeMessage(session);
	       
	            //Setting the recepients from the address variable
	            msg.setRecipients(Message.RecipientType.TO, memberMail);
	            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
	            msg.setSubject("Mail de relance Automatique : " + timeStamp);
	            msg.setSentDate(new Date());
	            msg.setText("Ceci est un message de relance automatique blabla a completer (WorkName etc..)");
	            msg.setHeader("XPriority", "1");
	            Transport.send(msg);
	            System.out.println("Mail has been sent successfully");
		    		  } catch (MessagingException mex) {
		    	            System.out.println("Unable to send an email" + mex);
	}
	
	
	
		    	}
		 }

	
}
}



