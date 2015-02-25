package loginapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.service.EnrollNewPlanService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class EnrollNewPlanController.
 */
@Controller
public class EnrollNewPlanController {

    /** The logger. */
    private static Logger logger = Logger
            .getLogger(EnrollNewPlanController.class.getName());

    /** The enroll. */
    @Autowired
    EnrollNewPlanService enroll;

    /**
     * Enroll plan.
     * 
     * @param planId
     *            the plan id
     * @param request
     *            the request
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/enrollnewplan", method = RequestMethod.POST)
    public ModelAndView enrollPlan(@RequestParam("plan_id") int planId,
            HttpServletRequest request) throws SystemException {

        int userId = (Integer) request.getSession().getAttribute("uid");
        logger.info(planId + " " + userId);
        String res = enroll.updatePlan(planId, userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("res", res);
        mv.setViewName("/home");
        return mv;

    }

    /**
     * View.
     * 
     * @param userid
     *            the userid
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView view(@RequestParam("userId") int userid, Model model)
            throws SystemException {
        List<PlanDTO> plan = (List<PlanDTO>) enroll.view();
        PlanDTO plandto = new PlanDTO();
        model.addAttribute("plandto", plandto);
        model.addAttribute("enroll", plan);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/newPlan");
        return modelandview;
    }

    /**
     * Handle all exception.
     * 
     * @param e
     *            the e
     * @return the model and view
     */
    @ExceptionHandler(SystemException.class)
    public ModelAndView handleAllException(SystemException e) {
        logger.error("System Exception generated" + e);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("dbError", e.getMessage());
        return mv;

    }

}
