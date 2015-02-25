package loginapp.dao;

import loginapp.exception.SystemException;
import loginapp.model.UserDTO;

// TODO: Auto-generated Javadoc

/**
 * The Interface LoginDAO.
 * 
 * @author tarishi.upadhyay
 */
public interface LoginDAO {

    /**
     * Check login.
     * 
     * @param userName
     *            the user name
     * @param userPassword
     *            the user password
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String checkLogin(String userName, String userPassword)
            throws SystemException;

    /**
     * Register.
     * 
     * @param dt
     *            the dt
     * @throws SystemException
     *             the system exception
     */
    void register(UserDTO dt) throws SystemException;

    /**
     * Gets the id.
     * 
     * @param dt
     *            the dt
     * @return the id
     * @throws SystemException
     *             the system exception
     */
    int getid(UserDTO dt) throws SystemException;

    Boolean checkAvailability(String userName);
}
