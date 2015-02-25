package loginapp.controller;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.service.BookService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class RestController {
    
    /** The Constant LOGGER. */
   
    @Autowired
    private BookService bookService;
    
    static Logger logger = Logger.getLogger(RestController.class.getName());
    /**
     * Gets the book.
     * 
     * @return the book
     * @throws SystemException 
     */
   

    @RequestMapping(value="/rest/search/{id}",method=RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public List<BookDTO> getBook(@PathVariable int id) throws SystemException {

     
               
        logger.info("Rest request to get recent books");
        
        List<BookDTO> book=bookService.getBook(id);
        System.out.println(book);
        return book;
    }
}

