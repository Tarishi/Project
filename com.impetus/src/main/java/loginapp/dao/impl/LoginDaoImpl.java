package loginapp.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import loginapp.dao.LoginDAO;
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
 * The Class logindaoimpl.
 * 
 * @author tarishi.upadhyay
 */
@Repository("logindao")
public class LoginDaoImpl implements LoginDAO {

    /** The logger. */
    private static Logger logger = Logger.getLogger(LoginDaoImpl.class);
    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.logindao#register(java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */

    @Transactional(readOnly = false)
    public void register(UserDTO dt) throws SystemException {
        try {
            dt.setRoleId(0);
            dt.setRole("ROLE_USER");
            dt.setEnabled(1);
            template.save(dt);
            UserSubscribeDTO user = new UserSubscribeDTO();
            UserDTO u = new UserDTO();
            PlanDTO p = new PlanDTO();

            u.setId(dt.getId());
            p.setPlanId(dt.getPlanid());

            user.setUser(u);
            user.setPlan(p);

            PlanDTO pp = new PlanDTO();
            pp.setPlanId(dt.getPlanid());
            List<PlanDTO> find = (List<PlanDTO>) template.findByExample(p);

            Date startDate = new Date();
            Date enddate = new Date();
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, find.get(0).getDuration());

            enddate = c.getTime();
            logger.info("To print tommorrows date  " + enddate);
            user.setStartDate(startDate);
            user.setEndDate(enddate);
            user.setBooksOrdered(0);
            user.setStatus(true);
            template.save(user);
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.LoginDAO#checkLogin(java.lang.String, java.lang.String)
     */
    public String checkLogin(String userName, String userPassword)
            throws SystemException {
        try {
            logger.info("in check login method of dao");
            String userFound = "none";
            logger.info(userName);
            logger.info(userFound);
            UserDTO dt = new UserDTO();
            dt.setUserName(userName);
            logger.info(dt.getUserName());
            dt.setUserPassword(userPassword);

            List<UserDTO> list = template.findByExample(dt);

            for (UserDTO dto : list) {
                logger.info("in for loop" + dto.getRoleId());

                if ((list != null) && dto.getRoleId() == 0) {
                    userFound = "normalUser";
                    logger.info(userFound);
                } else {
                    if ((dto != null) && dto.getRoleId() == 1) {
                        userFound = "Admin";
                    }
                }
            }
            return userFound;

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.LoginDAO#getid(loginapp.model.UserDTO)
     */
    public int getid(UserDTO dt) throws SystemException {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(dt.getUserName());
            List<UserDTO> userdto = (List<UserDTO>) template
                    .findByExample(userDTO);
            int uid = 0;
            for (UserDTO user : userdto) {
                uid = user.getId();

            }
            logger.info(uid);
            return uid;
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    public Boolean checkAvailability(String userName) {
        logger.info("dao name" + userName);
        List<UserDTO> u = (List<UserDTO>) template.find(
                "from UserDTO where userName=?", userName);
        if (u.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
