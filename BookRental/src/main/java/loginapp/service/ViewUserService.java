package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserSubscribeDTO;

public interface ViewUserService {

    List<UserSubscribeDTO> searchuser(String searchuser, String searchplan)
            throws SystemException;

    List<UserSubscribeDTO> viewall() throws SystemException;

}
