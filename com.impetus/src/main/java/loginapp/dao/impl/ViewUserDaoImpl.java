package loginapp.dao.impl;

import java.util.List;

import loginapp.dao.ViewUserDao;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewUserDaoImpl.
 */
@Repository("ViewUSerDao")
public class ViewUserDaoImpl implements ViewUserDao {

    /** The logger. */
    private static Logger logger = Logger.getLogger(ViewUserDaoImpl.class
            .getName());

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.ViewUserDao#searchuser(java.lang.String,
     * java.lang.String)
     */
    public List<UserSubscribeDTO> searchuser(String searchuser,
            String searchplan) throws SystemException {
        try {
            UserSubscribeDTO usersub = new UserSubscribeDTO();
            List<UserSubscribeDTO> user = null;
            if (StringUtils.isEmpty(searchplan)) {
                logger.info(searchuser);
                UserDTO u = new UserDTO();
                u.setUserName(searchuser);
                usersub.setUser(u);

                user = (List<UserSubscribeDTO>) template
                        .find("from UserSubscribeDTO user where user.user.userName=?",
                                searchuser);
                logger.info(user);

            } else if (StringUtils.isEmpty(searchuser)) {
                logger.info(searchplan);
                user = (List<UserSubscribeDTO>) template
                        .find("from UserSubscribeDTO user where user.plan.planName=?",
                                searchplan);
                logger.info(user);

            } else if (searchuser != null && searchplan != null) {
                logger.info(searchuser + searchplan);
                user = (List<UserSubscribeDTO>) template
                        .find("from UserSubscribeDTO user where user.user.userName=? and user.plan.planName=?",
                                searchuser, searchplan);
                logger.info(user);

            }
            return user;
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.ViewUserDao#viewall()
     */
    public List<UserSubscribeDTO> viewall() throws SystemException {
        try {
            logger.info("view all");
            List<UserSubscribeDTO> usersub = (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO where status=?", true);
            logger.info(usersub);
            return usersub;
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

}
