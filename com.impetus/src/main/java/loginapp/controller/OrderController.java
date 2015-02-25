package loginapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.UserDTO;
import loginapp.service.BookService;
import loginapp.service.GetUserService;
import loginapp.service.OrderService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderController.
 */
@Controller
public class OrderController {

    /** The order service. */
    @Autowired
    private OrderService orderService;

    /** The getuserservice. */
    @Autowired
    private GetUserService getuserservice;

    /** The book service. */
    @Autowired
    private BookService bookService;

    /** The logger. */
    private static Logger logger = Logger.getLogger(OrderController.class
            .getName());

    /**
     * Order book.
     * 
     * @param ISBN
     *            the isbn
     * @param userId
     *            the user id
     * @param address
     *            the address
     * @param request
     *            the request
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/order")
    public @ResponseBody
    String orderBook(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId,
            @RequestParam("address") String address, HttpServletRequest request)
            throws SystemException {
        logger.info("In OrderController/addToShelf()");

        String requestOrder = orderService.orderBook(userId, ISBN);
        List<UserDTO> user = getuserservice.getUser(userId);
        for (UserDTO u : user) {
            String address1 = u.getAddress();
            logger.info(u.getAddress());
            if (address.equals(address1)) {

            } else {
                getuserservice.updateAddress(address, userId);
            }
        }

        List<BookDTO> book = bookService.getBook(ISBN);
        String response = requestOrder;

        if (response.equals("ordered")) {
            String message = "You have successfully placed the order request for the book ";
            String subject = "Ordered successfully";
            SendEmail mail = new SendEmail(user.get(0).getEmail(), book.get(0)
                    .getBookTitle(), message, subject);
            SendEmail.main(null);
        }
        return response;

    }

    /**
     * Books held.
     * 
     * @param userId
     *            the user id
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/booksheld")
    public @ResponseBody
    ModelAndView booksHeld(@RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("In OrderController/booksheld()");
        List order = orderService.booksheld(userId);
        logger.info(order);
        model.addAttribute("list", order);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/booksheld");
        return modelandview;

    }

    /**
     * Books requested.
     * 
     * @param userId
     *            the user id
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/bookrequested")
    public @ResponseBody
    ModelAndView booksRequested(@RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("In OrderController/booksheld()");
        List order = orderService.booksRequested(userId);
        logger.info(order);
        model.addAttribute("list", order);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/booksrequested");
        return modelandview;

    }

    /**
     * Return book.
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
    @RequestMapping(value = "/returnbook")
    public @ResponseBody
    String returnBook(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("In OrderController/returnBook()");
        String status = orderService.returnBook(userId, ISBN);
        List<UserDTO> user = getuserservice.getUser(userId);
        List<BookDTO> book = bookService.getBook(ISBN);
        logger.info(status);
        model.addAttribute("list", status);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/booksheld");

        if (status.equals("return request generated")) {
            String message = "You have successfully placed the return request for the book ";
            String subject = "returned successfully";
            SendEmail mail = new SendEmail(user.get(0).getEmail(), book.get(0)
                    .getBookTitle(), message, subject);
            SendEmail.main(null);
        }
        return status;
    }

    /**
     * Cancel book.
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
    @RequestMapping(value = "/cancelbook")
    public @ResponseBody
    String cancelBook(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("In OrderController/cancelBook()");
        String status = orderService.cancelBook(userId, ISBN);
        List<UserDTO> user = getuserservice.getUser(userId);
        List<BookDTO> book = bookService.getBook(ISBN);
        logger.info(status);
        model.addAttribute("list", status);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/booksheld");
        if (status.equals("cancelled")) {
            String message = "You have successfully placed the Cancel request for the book ";
            String subject = "cancelled successfully";
            SendEmail mail = new SendEmail(user.get(0).getEmail(), book.get(0)
                    .getBookTitle(), message, subject);
            SendEmail.main(null);
        }
        return status;

    }

    /**
     * Cancel request.
     * 
     * @param ISBN the isbn
     * @param userId
     *            the user id
     * @param model
     *            the model
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/cancelRequest")
    public @ResponseBody
    String cancelRequest(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("In OrderController/cancelBook()");
        String status = orderService.cancelRequest(userId, ISBN);
        List<UserDTO> user = getuserservice.getUser(userId);
        List<BookDTO> book = bookService.getBook(ISBN);
        logger.info(status);
        model.addAttribute("list", status);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/booksrequested");
        if (status.equals("cancelled")) {
            String message = "You have successfully placed the Cancel request for the book ";
            String subject = "cancelled successfully";
            SendEmail mail = new SendEmail(user.get(0).getEmail(), book.get(0)
                    .getBookTitle(), message, subject);
            SendEmail.main(null);
        }
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
        logger.error("System Exception generated" + e);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("dbError", e.getMessage());
        return mv;

    }

}
