package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface XMLDao.
 */
public interface XMLDao {

    /**
     * Adds the or update subscriptions.
     * 
     * @param planList
     *            the plan list
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String addOrUpdateSubscriptions(List<PlanDTO> planList)
            throws SystemException;

    /**
     * Delete subscriptions.
     * 
     * @param planList
     *            the plan list
     * @return the string
     */
    String deleteSubscriptions(List<PlanDTO> planList);

}
