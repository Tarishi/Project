package loginapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginapp.dao.PlanReminderDao;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.PlanReminderService;

@Service("PlanReminderService")
public class PlanReminderServiceImpl implements PlanReminderService {

    @Autowired
    private PlanReminderDao planReminderDao;

    public List<UserSubscribeDTO> getUsersByMonth() throws SystemException {
        return planReminderDao.getUsersByMonth();

    }

    public List<UserSubscribeDTO> getUsersByDays() throws SystemException {
        // TODO Auto-generated method stub
        return planReminderDao.getUsersByDays();
    }

    public List<UserDTO> getUserSubscriptions() {
        // TODO Auto-generated method stub
        return planReminderDao.getUserSubscription();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * loginapp.service.PlanReminderService#updateSubscription(loginapp.model
     * .UserDTO)
     */
    public void updateSubscription(UserDTO subscription) {
        planReminderDao.updateSubscription();

    }

    public List<UserSubscribeDTO> getUsersByWeeks() throws SystemException {
        // TODO Auto-generated method stub
        return planReminderDao.getUsersByWeeks();
    }

}
