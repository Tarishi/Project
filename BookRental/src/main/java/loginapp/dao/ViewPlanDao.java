package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ViewPlanDao.
 */
public interface ViewPlanDao {

    /**
     * View plan.
     * 
     * @param userid
     *            the userid
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<UserSubscribeDTO> viewPlan(int userid) throws SystemException;

    /**
     * View profile.
     * 
     * @param userid
     *            the userid
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<UserSubscribeDTO> viewProfile(int userid) throws SystemException;

    /**
     * Saveprofile.
     * 
     * @param user
     *            the user
     * @throws SystemException
     *             the system exception
     */
    void saveprofile(UserDTO user) throws SystemException;

    /**
     * Book history.
     * 
     * @param userid
     *            the userid
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<Order> bookHistory(int userid) throws SystemException;

    /**
     * int getTotalRecordsOfRequest();
     * 
     * List<Order> paginationBooks(int start, int pageSize, String search, int
     * columnNum, String sortOrder);
     */
}
