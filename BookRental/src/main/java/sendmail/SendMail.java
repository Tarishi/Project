package sendmail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class SendEmail.
 */
public class SendMail {

    /** The logger. */
    private static Logger logger = Logger.getLogger(SendMail.class);

    /** The to. */
    private static String to;

    /** The user name. */
    private static String subject, msg, msg1, msg2, planName, userName;

    /** The end_date. */
    private static Date endDate;

    /**
     * Instantiates a new send email.
     * 
     * @param subs
     *            the subs
     * @throws SystemException 
     */

    public void shootReminderMail(UserSubscribeDTO subs) throws SystemException {
        UserDTO user = subs.getUser();
        SendMail.to = user.getEmail();
        SendMail.subject = "Plan expiry Reminder";
        SendMail.msg = "your Plan End Date for Plan";
        SendMail.msg1 = "is";
        SendMail.msg2 = "Kindly Update Your Plan.";
        PlanDTO plan = subs.getPlan();
        SendMail.planName = plan.getPlanName();
        SendMail.endDate = subs.getEndDate();
        SendMail.userName = user.getUserName();

        // Sender's email ID needs to be mentioned
        final String from = "book.at.your.step@gmail.com";// change accordingly
        /*
         * final String username = "book.at.your.step@gmail.com";//change
         * accordingly
         */final String password = "impetus1407";// change accordingly

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
            message.setContent("<h3>Hi , </h3>" + userName + " " + msg + " "
                    + planName + " " + msg1 + " " + endDate + " " + msg2,
                    "text/html");

            // Send message
            /*Transport.send(message);*/
            logger.info("Sent message successfully....");
        } catch (MessagingException mex) {
            throw new SystemException("Exception in sending mail"+ mex);
        }

    }

}
