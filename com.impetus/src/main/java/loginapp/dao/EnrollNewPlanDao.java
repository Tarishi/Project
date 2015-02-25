package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EnrollNewPlanDao.
 */
public interface EnrollNewPlanDao {

    /**
     * View.
     * 
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<PlanDTO> view() throws SystemException;

    /**
     * Update plan.
     * 
     * @param planId
     *            the plan id
     * @param userId
     *            the user id
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String updatePlan(Integer planId, int userId) throws SystemException;

}
