package loginapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginapp.dao.GetUserDao;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.service.GetUserService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetUserServiceImpl.
 */
@Service("GetUserService")
public class GetUserServiceImpl implements GetUserService {

    /** The getuserdao. */
    @Autowired
    private GetUserDao getuserdao;

    /** The logger. */
    private static Logger logger = Logger.getLogger(GetUserServiceImpl.class
            .getName());

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.GetUserService#getUser(int)
     */
    public List<UserDTO> getUser(int userId) throws SystemException {
        logger.info("In GetUserServiceImpl/getUser()");

        return getuserdao.getUser(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.GetUserService#updateAddress(java.lang.String, int)
     */
    public void updateAddress(String address, int uid) throws SystemException {

        getuserdao.updateAddress(address, uid);
    }

    /**
     * Sets the user dao.
     * 
     * @param getuserDao2
     *            the new user dao
     */
    public void setuserDao(GetUserDao getuserDao2) {
        this.getuserdao = getuserDao2;

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.GetUserService#getMail(java.lang.String)
     */
    public List<UserDTO> getMail(String username) {

        return getuserdao.getMail(username);
    }

}
