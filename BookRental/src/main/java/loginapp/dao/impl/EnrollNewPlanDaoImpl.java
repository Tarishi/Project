package loginapp.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import loginapp.dao.EnrollNewPlanDao;
import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class EnrollNewPlanDaoImpl.
 */
@Repository("EnrollNewPlanDao")
public class EnrollNewPlanDaoImpl implements EnrollNewPlanDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /** The logger. */
    private static Logger logger = Logger.getLogger(EnrollNewPlanDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.EnrollNewPlanDao#view()
     */
    public List<PlanDTO> view() throws SystemException {
        try {

            return (List<PlanDTO>) template.findByExample(new PlanDTO());

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.EnrollNewPlanDao#updatePlan(java.lang.Integer, int)
     */
    @Transactional(readOnly = false)
    public String updatePlan(Integer planId, int userId) throws SystemException {
        // TODO Auto-generated method stub

        try {
            List<UserDTO> userdto = (List<UserDTO>) template.find(
                    "from UserDTO where id=?", userId);
            List<UserSubscribeDTO> planend = (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO where user.id=? and status=?",
                            userId, true);
          
            logger.info(planend);
            if (!planend.isEmpty()) {
                return "Previous plan is active";
            } else {
                logger.info("in else");
                for (UserDTO user : userdto) {
                    user.setPlanid(planId);
                    template.saveOrUpdate(user);
                }

               
                PlanDTO p = new PlanDTO();
                p.setPlanId(planId);
                List<PlanDTO> plan = (List<PlanDTO>) template.find(
                        "from PlanDTO where plan_id=?", planId);
                
                UserSubscribeDTO usersub = new UserSubscribeDTO();
                UserDTO u = new UserDTO();
                u.setId(userId);
                usersub.setUser(u);
                usersub.setPlan(p);
                Date startDate = new Date();
                Date enddate = new Date();
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DAY_OF_MONTH, plan.get(0).getDuration());

                enddate = c.getTime();
                usersub.setStartDate(startDate);
                usersub.setEndDate(enddate);
                usersub.setBooksOrdered(0);
                usersub.setStatus(true);
                template.save(usersub);
                return "subscribed to new plan";
            }

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

}
