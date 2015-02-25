package loginapp.controller;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.ViewPlanService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewPlanController.
 */
@Controller
public class ViewPlanController {

    /** The viewplan. */
    @Autowired
    ViewPlanService viewplan;

    /** The logger. */
    private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * View plan.
     * 
     * @param userid
     *            the userid
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/viewPlan", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView viewPlan(@RequestParam("userId") int userid, Model model)
            throws SystemException {
        List<UserSubscribeDTO> plan = viewplan.viewPlan(userid);
        model.addAttribute("plan", plan);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/plan");
        return modelandview;

    }

    /**
     * View profile.
     * 
     * @param userid
     *            the userid
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView viewProfile(@RequestParam("userId") int userid, Model model)
            throws SystemException {
        List<UserSubscribeDTO> user = viewplan.viewProfile(userid);
        model.addAttribute("user", user);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/profile");
        return modelandview;

    }

    /**
     * Update profile.
     * 
     * @param user
     *            the user
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView updateProfile(@ModelAttribute("user") UserDTO user, Model model)
            throws SystemException {
        viewplan.saveProfile(user);
        model.addAttribute("user", user);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/home");
        modelandview.addObject("active", "true");
        modelandview.addObject("saved", "Changes saved");
        return modelandview;

    }

    /**
     * Book history.
     * 
     * @param userid
     *            the userid
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/bookHistory", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView bookHistory(@RequestParam("userId") int userid, Model model)
            throws SystemException {
        List<Order> history = viewplan.bookHistory(userid);
        model.addAttribute("history", history);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/bookhistory");
        return modelandview;

    }

    /**
     * @RequestMapping("/userPagination") public @ResponseBody String
     *                                    paginationBooks(@RequestParam("draw")
     *                                    int draw,
     * @RequestParam("start") int start,
     * @RequestParam("length") int pageSize,
     * @RequestParam("search[value]") String search,
     * @RequestParam("order[0][column]") int columnNum,
     * @RequestParam("order[0][dir]") String sortOrder) {
     * 
     *                                logger.info("-->" + draw + " " + start +
     *                                "  " + pageSize +" "+ search+
     *                                columnNum+" "+sortOrder+ "<--"); int
     *                                totalRecords =
     *                                viewplan.getTotalRecordsOfRequest();
     *                                List<Order> requests =
     *                                viewplan.paginationBooks(start, pageSize,
     *                                search, columnNum, sortOrder); Gson gson =
     *                                new Gson(); Map<String, Object> requestMap
     *                                = new HashMap<String, Object>();
     *                                requestMap.put("draw", draw);
     *                                requestMap.put("recordsTotal",
     *                                totalRecords);
     *                                requestMap.put("recordsFiltered",
     *                                totalRecords); requestMap.put("data",
     *                                requests);
     * 
     *                                // JsonObject jsonResponse = new
     *                                JsonObject();
     * 
     *                                System.out.println(gson.toJsonTree(
     *                                requestMap).toString()); return
     *                                gson.toJsonTree(requestMap).toString(); }
     */

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
