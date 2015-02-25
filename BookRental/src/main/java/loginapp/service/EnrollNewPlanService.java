package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;

public interface EnrollNewPlanService {

    List<PlanDTO> view() throws SystemException;

    String updatePlan(Integer planId, int userId) throws SystemException;

}
