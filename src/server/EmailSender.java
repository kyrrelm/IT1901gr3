package server;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A method to send emails from the Gmail account I set up for the project.
 * 
 * @author halvor
 *
 *
 *SRC: http://www.developerfusion.com/code/1975/sending-email-using-smtp-and-java/
 */
public class EmailSender
{
	final static String username = "sheepstalker2013@gmail.com";
	final static String password = "sheepsheep";
	
	/**
	 * Sends an email!
	 * 
	 * @author halvor
	 * 
	 *  
	 * @param recipent
	 * @param title
	 * @param body
	 */
	public static void sendEmail(String recipent, String title, String body)
	{
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
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipent));
			message.setSubject(title);
			message.setText(body);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	// testing
	public static void main (String args[])
	{
		sendEmail("_@_.com", "ALERT", "Your sheep EINAR has been wounded, he is at position (x, y)");
	}
}
