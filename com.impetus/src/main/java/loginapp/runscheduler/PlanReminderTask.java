package loginapp.runscheduler;

import java.io.IOException;
import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.PlanReminderService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sendmail.SendMail;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksTask.
 */
public class PlanReminderTask {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(PlanReminderTask.class);

    /** The books scheduler manager. */
    @Autowired
    private PlanReminderService planReminderService;

    /** The send mail. */
    private SendMail sendMail = new SendMail();

    /**
     * Sets the books scheduler manager.
     * 
     * @param planReminderService
     *            the new plan reminder service
     * @return the plan reminder service
     */

    /**
     * Sets the plan reminder service.
     * 
     * @param planReminderService
     *            the new plan reminder service
     */
    public void setPlanReminderService(PlanReminderService planReminderService) {
        this.planReminderService = planReminderService;
    }

    /**
     * Sets the send mail.
     * 
     * @param sendMail
     *            the new send mail
     */
    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }

    /**
     * Prints the message.
     */
    public void printMessage() {
        LOGGER.info("Plan Reminder schedular ~");
    }

    /**
     * Gets the users by month.
     * 
     * @return the users by month
     * @throws IOException
     * @throws SystemException 
     */
    public void getUsersByMonth() throws IOException, SystemException {

        List<UserSubscribeDTO> usersList = planReminderService
                .getUsersByMonth();
        LOGGER.info("userLIst Recievecd:" + usersList);
        shootReminderMails(usersList);

    }

    /**
     * Gets the users by week.
     * 
     * @return the users by week
     * @throws IOException
     * @throws SystemException 
     */
    public void getUsersByWeek() throws IOException, SystemException {
        List<UserSubscribeDTO> usersList = planReminderService
                .getUsersByWeeks();
        LOGGER.info("userLIst Recievec:" + usersList);
        shootReminderMails(usersList);
    }

    /**
     * Gets the users by days.
     * 
     * @return the users by days
     * @throws IOException
     * @throws SystemException 
     */
    public void getUsersByDays() throws IOException, SystemException {
        List<UserSubscribeDTO> usersList = planReminderService.getUsersByDays();
        LOGGER.info("userLIst Recievec:" + usersList);
        shootReminderMails(usersList);
    }

    /**
     * Shoot reminder mails.
     * 
     * @param usersList
     *            the users list
     * @throws SystemException 
     */
    public void shootReminderMails(List<UserSubscribeDTO> usersList)
            throws IOException, SystemException {
        LOGGER.info("List to mail" + usersList);
        for (UserSubscribeDTO subs : usersList) {
            LOGGER.info("subs" + subs);
            sendMail.shootReminderMail(subs);
        }

    }
}
