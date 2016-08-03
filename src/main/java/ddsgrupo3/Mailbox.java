package ddsgrupo3;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailbox {
	static public void enviarMail(String destinatario, String asunto, String cuerpo){
		final String username = "ddsgrupo20161c@gmail.com";
		final String password = "atrapalosya";
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
		try {
	
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ddsgrupo20161c@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario)); 
			message.setSubject(asunto); 
			message.setText(cuerpo);
	
			Transport.send(message);
	
		} catch (MessagingException e) {
			System.out.println("Hubo un error de autorizacion");
		}
	}
}
