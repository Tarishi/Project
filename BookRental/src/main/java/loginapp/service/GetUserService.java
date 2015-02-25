package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserDTO;

public interface GetUserService {

    List<UserDTO> getUser(int userId) throws SystemException;

    void updateAddress(String address, int userId) throws SystemException;

    List getMail(String username);

}
