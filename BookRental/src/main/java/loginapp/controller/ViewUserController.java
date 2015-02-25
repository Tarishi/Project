package loginapp.controller;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.AdminService;
import loginapp.service.GetUserService;
import loginapp.service.ViewUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewUserController.
 */
@Controller
public class ViewUserController {

    /** The viewuser. */
    @Autowired
    ViewUserService viewuser;

    @Autowired
    private AdminService bdelservice;
    
    /** The getuser. */
    @Autowired
    GetUserService getuser;

    /** The logger. */
    static Logger logger = Logger.getLogger(AdminController.class.getName());

    /**
     * Search.
     * 
     * @param searchuser
     *            the searchuser
     * @param searchplan
     *            the searchplan
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/usersearch", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("searchuser") String searchuser,
            @RequestParam("searchplan") String searchplan, Model model)
            throws SystemException {

        logger.info(searchuser);
        logger.info(searchplan);
        logger.info("In viewuserController/searchuser()");
        List<UserSubscribeDTO> user = viewuser.searchuser(searchuser,
                searchplan);
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("list", user);
        model.addAttribute("searchuser", "true");
        model.addAttribute("delete", "true");
        logger.info(user);
        List<Order> dRequest=bdelservice.deliveryRequest();
        int Dsize=dRequest.size();
        List<Order> RRequest=bdelservice.returnRequest();
        int Rsize=RRequest.size();
        modelAndView.addObject("Dsize",Dsize);
        modelAndView.addObject("Rsize",Rsize);
        modelAndView.setViewName("/admin");
        return modelAndView;
    }

    /**
     * View all.
     * 
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/viewalluser", method = RequestMethod.GET)
    public ModelAndView viewAll(Model model) throws SystemException {

        logger.info("In viewuserController/viewall()");
        List<UserSubscribeDTO> user = viewuser.viewall();
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user", user);
        model.addAttribute("searchall", "true");
        logger.info(user);
        List<Order> dRequest=bdelservice.deliveryRequest();
        int Dsize=dRequest.size();
        List<Order> RRequest=bdelservice.returnRequest();
        int Rsize=RRequest.size();
        modelAndView.addObject("Dsize",Dsize);
        modelAndView.addObject("Rsize",Rsize);
        modelAndView.setViewName("viewall");
        return modelAndView;
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

    /**
     * Gets the forgot password.
     * 
     * @return the forgot password
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public ModelAndView getforgotPassword() {
        logger.info("in forgot password");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forgotPassword");
        return mv;
    }

    /**
     * Forgot password.
     * 
     * @param username
     *            the username
     * @return the model and view
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView forgotPassword(@RequestParam("userName") String username) {
        List<UserDTO> list = getuser.getMail(username);
        logger.info("in forgot password");
        String res;
        if (list.isEmpty()) {
            res = "user Not found";
        } else {
            res = "password has been sent to your Mail";
            String message = "Your password is ";
            String subject = "Password";
            SendEmail mail = new SendEmail(list.get(0).getEmail(), list.get(0)
                    .getUserPassword(), message, subject);
            SendEmail.main(null);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("res", res);
        mv.setViewName("forgotPassword");
        return mv;
    }
}
