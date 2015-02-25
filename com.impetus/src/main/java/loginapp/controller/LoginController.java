package loginapp.controller;

import static loginapp.appconstant.AppConstant.ERROR;
import static loginapp.appconstant.AppConstant.REQLOGINFORM;
import static loginapp.appconstant.AppConstant.REQLOGOUT;
import static loginapp.appconstant.AppConstant.REQREGISTER;
import static loginapp.appconstant.AppConstant.RESADMIN;
import static loginapp.appconstant.AppConstant.RESLOGINFORM;
import static loginapp.appconstant.AppConstant.RESREGISTER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.PlanDTO;
import loginapp.model.UserDTO;
import loginapp.service.AdminService;
import loginapp.service.BookService;
import loginapp.service.GetUserService;
import loginapp.service.LoginService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
 * The Class LoginController.
 * 
 * @author tarishi.upadhyay
 */
@Controller
public class LoginController {
    private Authentication auth=null;

    /** The login service. */
    @Autowired
    private LoginService loginService;

    @Autowired
    private GetUserService getuser;
    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /** The bdelservice. */
    @Autowired
    private AdminService bdelservice;

    @Autowired
    private BookService bookservice;

   
    /** The session. */
    HttpSession session;

    /** The logger. */
    private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * Show form.
     * 
     * @param model
     *            the model
     * @return the string
     */
    @RequestMapping(value = REQLOGINFORM, method = RequestMethod.GET)
    public String showForm(Model model) {
        logger.info("ENTER in showLoginform of LoginController");
        List<BookDTO> list = bookservice.latestArrival();
        model.addAttribute("list", list);
        return RESLOGINFORM;
    }

   
  
    /**
     * Show form1.
     * 
     * @param model
     *            the model
     * @return the string
     */

    /**
     * Show form1.
     * 
     * @param model
     *            the model
     * @return the string
     */
    @RequestMapping(value = REQREGISTER, method = RequestMethod.GET)
    public String showForm1(Model model) {
        UserDTO userdto = new UserDTO();
        model.addAttribute("RegisterForm", new UserDTO());

        List<PlanDTO> plan = (List<PlanDTO>) template
                .findByExample(new PlanDTO());
        /*
         * List<PlanDTO> plan= (List<PlanDTO>)template.find("from PlanDTO");
         */model.addAttribute("plan", plan);

        return RESREGISTER;
    }

    /**
     * Process form1.
     * 
     * @param dt
     *            the dt
     * @param model
     *            the model
     * @return the string
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = REQREGISTER, method = RequestMethod.POST)
    public String processForm1(@ModelAttribute("RegisterForm") UserDTO dt,
            Model model) throws Exception {

        loginService.register(dt);
        List<BookDTO> list = bookservice.latestArrival();
        model.addAttribute("list", list);
        model.addAttribute("form", dt);
        return RESLOGINFORM;

    }

    @RequestMapping(value = "checkavailability", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxCheckAvalability(Model model,
            @RequestParam("username") String userName) {
        logger.info("check in controll");
        Boolean flag = loginService.checkAvailability(userName);
        if (flag) {
            return "true";
        } else {
            logger.info("check in else controll");
            return "false";
        }
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
        mv.addObject("dbError", ERROR);
        return mv;

    }

    /**
     * Do logout.
     * 
     * @return the model and view
     */
    @RequestMapping(value = REQLOGOUT)
    public ModelAndView doLogout(Model model) {

        logger.info("in logout");
       /* session.removeAttribute("uid");
        session.removeAttribute("uname");
        session.invalidate();*/
        List<BookDTO> list = bookservice.latestArrival();
        model.addAttribute("list", list);
        return new ModelAndView(RESLOGINFORM);

    }

    
   @RequestMapping(value = "fail2login", method = RequestMethod.GET)
    public String loginfail(Model model){
        model.addAttribute("loginError", "Invalid username or password.");
        List<BookDTO> list = bookservice.latestArrival();
        model.addAttribute("list", list);
        logger.info("user is not valid");
        return RESLOGINFORM;
   
       
  
    }

    
    
    
    @RequestMapping("/home")
    public ModelAndView springsecurity(  HttpServletRequest request, HttpServletResponse response) throws SystemException
    {
        auth= SecurityContextHolder.getContext().getAuthentication();
       String username= auth.getName();
       logger.info(username);
       ModelAndView mv=new ModelAndView();
       if(username.equals("anonymousUser"))
       {
           mv.setViewName("loginform");
           
       }
       else
       {
        List<UserDTO> list=getuser.getMail(username);
        String role=list.get(0).getRole();
        int uid = list.get(0).getId();
        List<UserDTO> user = getuser.getUser(uid);
        session = request.getSession();
        session.setAttribute("uid", uid);
        session.setAttribute("user", user);
        session.setAttribute("uname", user.get(0).getUserName());
       
        if(role.equals("ROLE_USER"))
        {
           
            mv.setViewName("home");
        }
        if(role.equals("ROLE_ADMIN"))
        {
            List<Order> dRequest=bdelservice.deliveryRequest();
            int Dsize=dRequest.size();
            List<Order> RRequest=bdelservice.returnRequest();
            int Rsize=RRequest.size();
            mv.addObject("Dsize",Dsize);
            mv.addObject("Rsize",Rsize);
            mv.setViewName("admin");
        }
       }
        return mv;
        
    }
}