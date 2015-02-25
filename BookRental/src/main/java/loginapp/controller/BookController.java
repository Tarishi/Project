package loginapp.controller;

import static loginapp.appconstant.AppConstant.REQADMIN;
import static loginapp.appconstant.AppConstant.REQSAVEBOOK;
import static loginapp.appconstant.AppConstant.REQSEARCH;
import static loginapp.appconstant.AppConstant.RESADMIN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.service.AdminService;
import loginapp.service.BookService;
import loginapp.service.GetUserService;
import loginapp.service.MyShelfService;

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

import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class BookController.
 * 
 * @author tarishi.upadhyay
 */
@Controller
public class BookController {

    /** The book service. */
    @Autowired
    private BookService bookService;

    @Autowired
    private AdminService bdelservice;
    
    /** The myshelfservice. */
    @Autowired
    MyShelfService myshelfservice;

    /** The myshelf. */
    MyShelfController myshelf;

    /** The getuserservice. */
    @Autowired
    private GetUserService getuserservice;

    /** The logger. */
    static Logger logger = Logger.getLogger(BookController.class.getName());

    /**
     * Adds the book.
     * 
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = REQADMIN, method = RequestMethod.GET)
    public ModelAndView addBook(Model model) {
        logger.info("In BookController/addBook()");
        BookDTO bookdto = new BookDTO();
        model.addAttribute("command", bookdto);
        return new ModelAndView(REQADMIN);
    }

    /**
     * Save book.
     * 
     * @param bookdto
     *            the bookdto
     * @param request
     *            the request
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = REQSAVEBOOK, method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute("command") BookDTO bookdto,
            HttpServletRequest request) throws SystemException {
        logger.info("In BookController/saveBook()");
        logger.info("bookdto");
        String fileName = "";
        if (!bookdto.getFile().isEmpty()) {
            try {
                byte[] bytes = bookdto.getFile().getBytes();
                String name = bookdto.getFile().getOriginalFilename();
                String ext = name.substring(name.lastIndexOf("."),
                        name.length());
                fileName = "" + System.currentTimeMillis() + ext;
                String rpath = request.getRealPath("/");
                logger.info(rpath);
                File file = new File(rpath, "resources");
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(file, "images");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File temp = new File(file, fileName);
                bookdto.setBookImage(fileName);
                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(bytes);
                fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        bookService.addBook(bookdto);
        for (int i = 1; i <= bookdto.getNoOfCopies(); i++) {

            bookService.addBookid(bookdto);

        }
        List<Order> dRequest=bdelservice.deliveryRequest();
        int Dsize=dRequest.size();
        List<Order> RRequest=bdelservice.returnRequest();
        int Rsize=RRequest.size();
        Model mv = null;
        mv.addAttribute("Dsize",Dsize);
        mv.addAttribute("Rsize",Rsize);
        return new ModelAndView(RESADMIN);

    }

    /**
     * Search.
     * 
     * @param searchTitle
     *            the search title
     * @param searchAuthor
     *            the search author
     * @param searchCategory
     *            the search category
     * @param model
     *            the model
     * @param request
     *            the request
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = REQSEARCH, method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("searchTitle") String searchTitle,
            @RequestParam("searchAuthor") String searchAuthor,
            @RequestParam("searchCategory") String searchCategory, Model model,
            HttpServletRequest request) throws SystemException {
        int uid = (Integer) request.getSession().getAttribute("uid");
        List<String> check = new ArrayList();
        logger.info(searchTitle);
        logger.info("In BookController/searchBook()");
        List<BookDTO> book = bookService.search(searchTitle, searchAuthor,
                searchCategory, uid);
        List<UserDTO> user = getuserservice.getUser(uid);
        List<String> available = bookService.isAvailable(book);
        List<String> ordered=bookService.isOrdered(book,uid);
        logger.info(ordered);
        int size = book.size();
        for (int i = 0; i < size; i++) {

            String status = myshelfservice
                    .isAdded((book.get(i).getISBN()), uid);
            if (status.equals("already in Shelf")) {
                check.add(i, "active");

            } else
                check.add(i, "inactive");
        }
        logger.info(check);

        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("ordered",ordered);
        model.addAttribute("available", available);
        model.addAttribute("list", book);
        model.addAttribute("user", user);
        model.addAttribute("check", check);
        if (!book.isEmpty()) {
            model.addAttribute("searchbook", "true");

        } else {
            model.addAttribute("show", "Sorry. Book not found");
        }
        logger.info(book);
        modelAndView.setViewName("/home");
        return modelAndView;
    }

    /**
     * Recommend.
     * 
     * @param uid
     *            the uid
     * @param model
     *            the model
     * @param request
     *            the request
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "recommend", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView recommend(@RequestParam("userId") int uid, Model model,
            HttpServletRequest request) throws SystemException {

        logger.info("In BookController/recommend()");
        List<BookDTO> book = bookService.recommend(uid);
        if (book.isEmpty()) {
            book = bookService.latestArrival();
            List<String> available = bookService.isAvailable(book);
            model.addAttribute("available", available);
            List<UserDTO> user = getuserservice.getUser(uid);
            List<String> ordered=bookService.isOrdered(book,uid);
            model.addAttribute("ordered",ordered);
            model.addAttribute("user", user);
            model.addAttribute("latest", "latest");
        } else {
            model.addAttribute("recommends", "recommends");
            List<String> available = bookService.isAvailable(book);
            List<String> ordered=bookService.isOrdered(book,uid);
            model.addAttribute("ordered",ordered);
            model.addAttribute("available", available);
        }
        List<String> check = new ArrayList();
        int size = book.size();
        for (int i = 0; i < size; i++) {

            String status = myshelfservice
                    .isAdded((book.get(i).getISBN()), uid);
            if (status.equals("already in Shelf")) {
                check.add(i, "active");

            } else
                check.add(i, "inactive");
        }
        
        
        model.addAttribute("check", check);
        ModelAndView modelAndView = new ModelAndView();
        List<UserDTO> user = getuserservice.getUser(uid);
        model.addAttribute("user", user);
        model.addAttribute("list", book);
        model.addAttribute("searchbook", "true");
        logger.info(book);
        modelAndView.setViewName("recommend");
        return modelAndView;
    }

    /**
     * Autocomplete.
     * 
     * @param searchTitle
     *            the search title
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws SystemException
     *             the system exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = "autocomplete", method = RequestMethod.GET)
    public @ResponseBody
    String autocomplete(@RequestParam("term") String searchTitle, Model model,
            HttpServletRequest request, HttpServletResponse response)
            throws SystemException, IOException {

        response.setContentType("application/json");
        int uid = (Integer) request.getSession().getAttribute("uid");
        logger.info(searchTitle);
        logger.info("In BookController/searchBook()");
        List<String> book = bookService.autocomplete(searchTitle);
        logger.info(book);
        ModelAndView modelAndView = new ModelAndView();

        String searchList = new Gson().toJson(book);
        return searchList;
    }

    /**
     * None search.
     * 
     * @param searchTitle
     *            the search title
     * @param searchAuthor
     *            the search author
     * @param searchCategory
     *            the search category
     * @param model
     *            the model
     * @param request
     *            the request
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/nonesearch", method = RequestMethod.POST)
    public ModelAndView noneSearch(
            @RequestParam("searchTitle") String searchTitle,
            @RequestParam("searchAuthor") String searchAuthor,
            @RequestParam("searchCategory") String searchCategory, Model model,
            HttpServletRequest request) throws SystemException {
        request.getSession().setAttribute("status", "added");
        logger.info(searchTitle);
        logger.info("In BookController/searchBook()");
        List<BookDTO> book = bookService.noneSearch(searchTitle, searchAuthor,
                searchCategory);
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("list", book);
        List<String> available = bookService.isAvailable(book);
        model.addAttribute("available", available);
        logger.info(book);
        if (!book.isEmpty()) {
            model.addAttribute("searchbook", "true");

        } else {
            model.addAttribute("show", "Sorry. Book not found");
        }
        logger.info(book);
        modelAndView.setViewName("/Search");
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

}
