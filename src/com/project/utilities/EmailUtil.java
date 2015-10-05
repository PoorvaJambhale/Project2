package com.project.utilities;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Provides with <code> SendEmail <code> function which will be used to send an email to the user when a user account/ ticket is created.
 * @author Poorva
 * @version 1.0 May 7, 2015.
 */

public class EmailUtil {
	
	/**
	 * Recieves the EmialID, EmailSubject and EmailContent and uses these details to send email to the user. 
	 * @param EmailID
	 * @param Emailsubject
	 * @param EmailContent
	 * @return void
	 */	
public  void SendEmail(String EmailID, String Emailsubject, String EmailContent) {
	   System.out.println("Inside send Email");
      // Recipient's email ID needs to be mentioned.
      String to =  EmailID ;
      
      System.out.println("The email id is :" + to);

      // Sender's email ID needs to be mentioned
      String from = "bugtracker.test.email@gmail.com";
      final String username = "bugtracker.test.email@gmail.com";//change accordingly
      final String password = "xxxxxx";//change accordingly

        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
      
      System.out.println("Inside send Email 12");
      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            	System.out.println("Inside send Email 13");
            	return new PasswordAuthentication(username, password);
	   }
         });
      //Session session = Session.getDefaultInstance(props, null);

      try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	   System.out.println("Inside send Email 14");
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: header field
	   message.setSubject(Emailsubject);
	
	   // Now set the actual message
	   message.setText(EmailContent);
	   System.out.println("Inside send Email 15");
	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}