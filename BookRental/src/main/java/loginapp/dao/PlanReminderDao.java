package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanReminderDao.
 */
public interface PlanReminderDao {

    /**
     * Gets the users by weeks.
     * 
     * @return the users by weeks
     * @throws SystemException 
     */
    List<UserSubscribeDTO> getUsersByWeeks() throws SystemException;

    /**
     * Update subscription.
     */
    void updateSubscription();

    /**
     * Gets the user subscription.
     * 
     * @return the user subscription
     */
    List<UserDTO> getUserSubscription();

    /**
     * Gets the users by days.
     * 
     * @return the users by days
     * @throws SystemException 
     */
    List<UserSubscribeDTO> getUsersByDays() throws SystemException;

    /**
     * Gets the users by month.
     * 
     * @return the users by month
     * @throws SystemException 
     */
    List<UserSubscribeDTO> getUsersByMonth() throws SystemException;

}
