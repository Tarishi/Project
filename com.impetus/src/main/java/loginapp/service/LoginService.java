package loginapp.service;

import loginapp.exception.SystemException;
import loginapp.model.UserDTO;

/**
 * @author tarishi.upadhyay
 * 
 */
public interface LoginService {

    String checkLogin(String userName, String userPassword)
            throws SystemException;

    void register(UserDTO dt) throws SystemException;

    int getid(UserDTO dt) throws SystemException;

    Boolean checkAvailability(String userName);

}
