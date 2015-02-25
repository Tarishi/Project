package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetUserDao.
 */
public interface GetUserDao {

    /**
     * Gets the user.
     * 
     * @param userId
     *            the user id
     * @return the user
     * @throws SystemException
     *             the system exception
     */
    List<UserDTO> getUser(int userId) throws SystemException;

    /**
     * Update address.
     * 
     * @param address
     *            the address
     * @param uid
     *            the uid
     * @throws SystemException
     *             the system exception
     */
    void updateAddress(String address, int uid) throws SystemException;

    /**
     * Gets the user sub.
     * 
     * @param userid
     *            the userid
     * @return the user sub
     * @throws SystemException
     *             the system exception
     */
    List<UserSubscribeDTO> getUserSub(int userid) throws SystemException;

    /**
     * Gets the mail.
     * 
     * @param username
     *            the username
     * @return the mail
     */
    List getMail(String username);

}
