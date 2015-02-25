package loginapp.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

// TODO: Auto-generated Javadoc
/**
 * The Class SendEmail.
 */
public class SendEmail {

    private static Logger logger = Logger.getLogger(SendEmail.class);
    /** The to. */
    static String to;

    /** The book name. */
    static String bookName;

    static String subject, msg;

    /**
     * Instantiates a new send email.
     * 
     * @param to
     *            the to
     * @param bookName
     *            the book name
     */
    SendEmail(String to, String bookName, String message, String subject) {

        SendEmail.to = to;
        SendEmail.bookName = bookName;
        SendEmail.subject = subject;
        SendEmail.msg = message;
    }

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    @Async
    public static void main(String[] args) {

        // Sender's email ID needs to be mentioned
        final String from = "book.at.your.step@gmail.com";// change accordingly
        /*
         * final String username = "book.at.your.step@gmail.com";//change
         * accordingly
         */
        final String password = "impetus1407";// change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    to));

            // Set Subject: header field
            message.setSubject(subject);

            // Send the actual HTML message, as big as you like
            message.setContent("<h3>Hi, </h3>" + msg + " " + bookName,
                    "text/html");

            // Send message
            Transport.send(message);
            logger.info("Sent message successfully....");
        } catch (MessagingException mex) {
            logger.info("Exception in sendinf mail " + mex);
        }

    }

}
