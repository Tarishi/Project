package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

public interface ViewPlanService {

    List<UserSubscribeDTO> viewPlan(int userid) throws SystemException;

    List<UserSubscribeDTO> viewProfile(int userid) throws SystemException;

    void saveProfile(UserDTO user) throws SystemException;

    List<Order> bookHistory(int userid) throws SystemException;

    /**
     * int getTotalRecordsOfRequest();
     * 
     * List<Order> paginationBooks(int start, int pageSize, String search, int
     * columnNum, String sortOrder);
     */

}
