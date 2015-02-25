package loginapp.controller;

import static loginapp.appconstant.AppConstant.RESERROR;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import loginapp.exception.SystemException;
import loginapp.model.MyShelf;
import loginapp.model.UserDTO;
import loginapp.service.BookService;
import loginapp.service.GetUserService;
import loginapp.service.MyShelfService;

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
 * The Class MyShelfController.
 */
@Controller
public class MyShelfController {

    /** The myshelfservice. */
    @Autowired
    MyShelfService myshelfservice;

    /** The getuserservice. */
    @Autowired
    private GetUserService getuserservice;

    /** The bookservice. */
    @Autowired
    BookService bookservice;
    



    /** The logger. */
    private static Logger logger = Logger.getLogger(MyShelfController.class);

    /**
     * Adds the to shelf.
     * 
     * @param ISBN
     *            the isbn
     * @param userId
     *            the user id
     * @param model
     *            the model
     * @param request
     *            the request
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/addtoshelf", method = RequestMethod.GET)
    public @ResponseBody
    String addToShelf(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model,
            HttpServletRequest request) throws SystemException {
        logger.info("In MyShelfController/addToShelf()");
        String status = myshelfservice.addBookToShelf(ISBN, userId);
        logger.info(status);
        String response = "Added to Myshelf";
        model.addAttribute("status", status);
        return status;

    }

    /**
     * Viewshelf.
     * 
     * @param userid
     *            the userid
     * @param model
     *            the model
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/viewShelf", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView viewshelf(@RequestParam("userId") int userid, Model model)
            throws SystemException {
        logger.info("In MyShelfController/viewShelf()");

        List<MyShelf> list = myshelfservice.viewshelf(userid);
        /*
         * for(MyShelf myshelf:list) { BookDTO bookdto=myshelf.getBook();
         * Set<BookID> books = bookdto.getBookid(); BookID b =new BookID(); for
         * (Iterator<BookID> iterator = (books).iterator(); iterator.hasNext();)
         * { b =iterator.next(); List<BookDTO>
         * book=bookservice.getBook(b.getBookID()); List<String>
         * available=bookservice.isAvailable(book);
         * model.addAttribute("available",available); } }
         */
        List<UserDTO> user = getuserservice.getUser(userid);
        model.addAttribute("user", user);
        List<String> ordered=myshelfservice.isOrdered(userid);
        model.addAttribute("ordered",ordered);
        model.addAttribute("list", list);

        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/myshelf");
        return modelandview;
    }

    /**
     * Removes the.
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
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public @ResponseBody
    String remove(@RequestParam("bookId") int ISBN,
            @RequestParam("userId") int userId, Model model)
            throws SystemException {
        logger.info("In MyShelfController/addToShelf()");
        myshelfservice.remove(ISBN, userId);
        String response = "Removed";
        return response;

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
        return new ModelAndView(RESERROR, "dberror", e.getMessage());

    }

}
