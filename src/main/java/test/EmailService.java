package test;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailService {
	EmailService() {
		// system.out
	}
	static Logger logger = Logger.getLogger(EmailService.class.getName());

	public void sendEmail(String email, String subject, List<Home> home) {

		// Recipient's email ID needs to be mentioned.
		String to = email;

		// Sender's email ID needs to be mentioned
		String from = "nabeel.kayed25@gmail.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("nabeel.kayed25@gmail.com", "Nabeel11/");

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(subject);
			String messagetext = "";
			// Now set the actual message
			StringBuilder bld = new StringBuilder();
			for (Home h : home)
				bld.append(h.toString() + "\n");
			messagetext = bld.toString();
			message.setText(messagetext);
			logger.log(Level.SEVERE,"sending...");
			// Send message
			Transport.send(message);
			logger.log(Level.SEVERE,"Sent message successfully....");
		} catch (MessagingException mex) {
			logger.log(Level.SEVERE, mex.toString());
		}

	}
}
