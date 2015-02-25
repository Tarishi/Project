package loginapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.service.AdminService;
import loginapp.service.BookService;
import loginapp.service.GetUserService;

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
 * The Class AdminController.
 */
@Controller
public class AdminController {

    /** The bdel service. */
    @Autowired
    private AdminService bdelService;

    @Autowired
    private GetUserService getuserservice;

    @Autowired
    private BookService bookService;
    /** The logger. */
    static Logger logger = Logger.getLogger(AdminController.class.getName());

    /**
     * Search.
     * 
     * @param searchBook
     *            the search book
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/adminsearch", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("searchBook") String searchBook,
            Model model) throws SystemException {

        logger.info(searchBook);

        logger.info("In BookController/searchBook()");
        /* logger.info(del[0]); */
        List<BookDTO> book = bdelService.search(searchBook);
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("list", book);
        List<String> available = bookService.isAvailable(book);
        model.addAttribute("available", available);
        if (!book.isEmpty()) {
            model.addAttribute("searchbook", "true");

        } else {
            model.addAttribute("show", "Sorry. Book not found");
        }
        model.addAttribute("delete1", "true");
        logger.info(book);
        List<Order> dRequest=bdelService.deliveryRequest();
        int Dsize=dRequest.size();
        List<Order> RRequest=bdelService.returnRequest();
        int Rsize=RRequest.size();
        modelAndView.addObject("Dsize",Dsize);
        modelAndView.addObject("Rsize",Rsize);
        modelAndView.setViewName("/admin");
        return modelAndView;
    }

    /**
     * Delete.
     * 
     * @param isbn
     *            the isbn
     * @param model
     *            the model
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody
    String delete(@RequestParam("bookId") int isbn, Model model)
            throws SystemException {
        logger.info("in delete");
        logger.info(isbn);
        String res = bdelService.delete(isbn);
        if (res.equals("success"))
            return "Book Deleted";
        else
            return "Sorry book cannot be deleted";
    }

    /**
     * Updatebook.
     * 
     * @param bookdto
     *            the bookdto
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/updatebook", method = RequestMethod.POST)
    public ModelAndView Updatebook(@ModelAttribute("book") BookDTO bookdto,
            Model model) throws SystemException {
        logger.info("in Updatebook");
        logger.info(bookdto.getBookTitle());
        bdelService.savebook(bookdto);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/admin");
        model.addAttribute("searchbook", "true");
        model.addAttribute("delete1", "true");
        List<Order> dRequest=bdelService.deliveryRequest();
        int Dsize=dRequest.size();
        List<Order> RRequest=bdelService.returnRequest();
        int Rsize=RRequest.size();
        modelandview.addObject("Dsize",Dsize);
        modelandview.addObject("Rsize",Rsize);
        return modelandview;

    }

    /**
     * Update.
     * 
     * @param ISBN
     *            the isbn
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/updatebook", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView Update(@RequestParam("bookid") int ISBN, Model model)
            throws SystemException {
        logger.info("in Update");
        logger.info(ISBN);
        List<BookDTO> book = bdelService.getbook(ISBN);
        logger.info(book);
        ModelAndView modelandview = new ModelAndView();
        model.addAttribute("book", book);
        modelandview.setViewName("/update");
        return modelandview;

    }

    /**
     * Delivery request.
     * 
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/deliveryRequest", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView deliveryRequest(Model model, HttpServletRequest request)
            throws SystemException {
        logger.info("in Delivery request");
        int uid = (Integer) request.getSession().getAttribute("uid");
       
        List<Order> request1 = bdelService.deliveryRequest();
       
        for (Order order : request1) {

            List<UserDTO> user = getuserservice.getUser(order.getUserId());
            
            model.addAttribute("user", user);
            
        }
        logger.info(request1);
        
        ModelAndView modelandview = new ModelAndView();
        model.addAttribute("list", request1);
        modelandview.setViewName("/deliveryRequest");
        return modelandview;

    }

    /**
     * Close delivery.
     * 
     * @param ISBN
     *            the isbn
     * @param userId
     *            the user id
     * @param model
     *            the model
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/CloseDelivery", method = RequestMethod.GET)
    public @ResponseBody
    String CloseDelivery(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("in Delivery request");

        String status = bdelService.closeDelivery(ISBN, userId);
        logger.info(status);
        ModelAndView modelandview = new ModelAndView();
        return status;

    }

    /**
     * Return request.
     * 
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/returnRequest", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView returnRequest(Model model) throws SystemException {
        logger.info("in Return request");

        List<Order> request = bdelService.returnRequest();
        logger.info(request);
        ModelAndView modelandview = new ModelAndView();
        model.addAttribute("list", request);
        modelandview.setViewName("/returnRequest");
        return modelandview;

    }

    /**
     * Close return.
     * 
     * @param ISBN
     *            the isbn
     * @param userId
     *            the user id
     * @param model
     *            the model
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/CloseReturn", method = RequestMethod.GET)
    public @ResponseBody
    String CloseReturn(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("in Return request");

        String status = bdelService.closeReturn(ISBN, userId);
        logger.info(status);
        ModelAndView modelandview = new ModelAndView();
        return status;

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
        logger.error("System Exception generated", e);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("dbError", e.getMessage());
        return mv;

    }
}
