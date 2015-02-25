package loginapp.service.impl;

import java.util.List;

import loginapp.dao.EnrollNewPlanDao;
import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.service.EnrollNewPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class EnrollNewPlanServiceImpl.
 */
@Service("EnrollNewPlanService")
public class EnrollNewPlanServiceImpl implements EnrollNewPlanService {

    /** The enrolldao. */
    @Autowired
    private EnrollNewPlanDao enrolldao;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.EnrollNewPlanService#view()
     */
    public List<PlanDTO> view() throws SystemException {
        return enrolldao.view();
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.EnrollNewPlanService#updatePlan(java.lang.Integer,
     * int)
     */
    public String updatePlan(Integer planId, int userId) throws SystemException {
        return enrolldao.updatePlan(planId, userId);

    }

    /**
     * Enrolldao.
     * 
     * @param enrolldao2
     *            the enrolldao2
     */
    public void enrolldao(EnrollNewPlanDao enrolldao2) {
        this.enrolldao = enrolldao2;

    }

}
