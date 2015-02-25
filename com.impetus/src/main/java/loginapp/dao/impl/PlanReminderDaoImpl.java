package loginapp.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import loginapp.dao.PlanReminderDao;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderDaoImpl.
 */
@Repository("PlanReminderDao")
public class PlanReminderDaoImpl implements PlanReminderDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.PlanReminderDao#getUsersByWeeks()
     */
    public List<UserSubscribeDTO> getUsersByWeeks() throws SystemException {
        List<UserSubscribeDTO> user = new ArrayList<UserSubscribeDTO>();

        Date endDate = new Date();
        Date newEndDate = null;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 7);
        endDate = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString1 = format.format(endDate);
        try {
            newEndDate = new java.sql.Date(format.parse(dateString1).getTime());

        } catch (ParseException e) {
            throw new  SystemException("parsing exception "+e);
        }

        UserSubscribeDTO u = new UserSubscribeDTO();
        u.setEndDate(newEndDate);
        user = (List<UserSubscribeDTO>) template.findByExample(u);
        return user;

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.PlanReminderDao#updateSubscription()
     */
    public void updateSubscription() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.PlanReminderDao#getUserSubscription()
     */
    public List<UserDTO> getUserSubscription() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.PlanReminderDao#getUsersByDays()
     */
    public List<UserSubscribeDTO> getUsersByDays() throws SystemException {
        List<UserSubscribeDTO> user = new ArrayList<UserSubscribeDTO>();

        Date endDate = new Date();
        Date newEndDate = null;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        endDate = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString1 = format.format(endDate);
        try {
            newEndDate = new java.sql.Date(format.parse(dateString1).getTime());

        } catch (ParseException e) {
        
            throw new  SystemException("parsing exception "+e);
        }

        UserSubscribeDTO u = new UserSubscribeDTO();
        u.setEndDate(newEndDate);
        user = (List<UserSubscribeDTO>) template.findByExample(u);
        for (UserSubscribeDTO usersub : user) {
            usersub.setStatus(false);

        }
        return user;

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.PlanReminderDao#getUsersByMonth()
     */
    public List<UserSubscribeDTO> getUsersByMonth() throws SystemException {
        List<UserSubscribeDTO> user = new ArrayList<UserSubscribeDTO>();

        Date endDate = new Date();
        Date newEndDate = null;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 30);
        endDate = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = format.format(endDate);
        try {
            newEndDate = new java.sql.Date(format.parse(dateString1).getTime());

        } catch (ParseException e) {
            throw new  SystemException("parsing exception "+e);
        }

        UserSubscribeDTO u = new UserSubscribeDTO();
        u.setEndDate(newEndDate);
        user = (List<UserSubscribeDTO>) template.findByExample(u);
        return user;

    }

}
