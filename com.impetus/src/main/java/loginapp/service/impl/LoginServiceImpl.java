package loginapp.service.impl;

import loginapp.dao.LoginDAO;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.service.LoginService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc

/**
 * The Class loginserviceimpl.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    /** The logger. */
    private static Logger logger = Logger.getLogger(LoginServiceImpl.class);
    /** The login dao. */
    @Autowired
    private LoginDAO loginDAO;

    /**
     * Sets the login dao.
     * 
     * @param loginDAO
     *            the new login dao
     */
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.LoginService#checkLogin(java.lang.String,
     * java.lang.String)
     */
    public String checkLogin(String userName, String userPassword)
            throws SystemException {
        logger.info("In Service class...Check Login");
        return loginDAO.checkLogin(userName, userPassword);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.LoginService#register(loginapp.model.UserDTO)
     */
    public void register(UserDTO dt) throws SystemException {
        logger.info("In Service class...register");
        loginDAO.register(dt);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.LoginService#getid(loginapp.model.UserDTO)
     */
    public int getid(UserDTO dt) throws SystemException {

        return loginDAO.getid(dt);
    }

    public Boolean checkAvailability(String userName) {
        // TODO Auto-generated method stub
        return loginDAO.checkAvailability(userName);
    }
}