package loginapp.dao.impl;

import java.util.List;

import loginapp.dao.GetUserDao;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class GetUserDaoImpl.
 */
@Repository("GetUserDao")
public class GetUserDaoImpl implements GetUserDao {

    private static Logger logger = LoggerFactory
            .getLogger(GetUserDaoImpl.class);
    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.GetUserDao#getUser(int)
     */
    public List<UserDTO> getUser(int userId) throws SystemException {
        try {

            return (List<UserDTO>) template.find("from UserDTO where id=?",
                    userId);

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.GetUserDao#getUserSub(int)
     */
    public List<UserSubscribeDTO> getUserSub(int userId) throws SystemException {
        try {
            return (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO user where user.user.id=? and status=?",
                            userId, true);

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.GetUserDao#updateAddress(java.lang.String, int)
     */
    @Transactional(readOnly = false)
    public void updateAddress(String address, int uid) throws SystemException {
        // TODO Auto-generated method stub
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(uid);
            List<UserDTO> user = (List<UserDTO>) template
                    .findByExample(userDTO);
            for (UserDTO userdto : user) {
                userdto.setAddress(address);
                logger.info(userdto.getAddress());

                template.saveOrUpdate(userdto);

            }
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.GetUserDao#getMail(java.lang.String)
     */
    public List getMail(String username) {
        UserDTO user = new UserDTO();
        user.setUserName(username);
        List<UserDTO> list = (List<UserDTO>) template.findByExample(user);

        return list;
    }

}
