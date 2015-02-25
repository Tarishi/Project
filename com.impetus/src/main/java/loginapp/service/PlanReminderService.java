package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

public interface PlanReminderService {

    List<UserSubscribeDTO> getUsersByMonth() throws SystemException;

    List<UserSubscribeDTO> getUsersByDays() throws SystemException;

    List<UserDTO> getUserSubscriptions();

    void updateSubscription(UserDTO subscription);

    List<UserSubscribeDTO> getUsersByWeeks() throws SystemException;

}
