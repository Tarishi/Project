package loginapp.dao.impl;

import static loginapp.appconstant.AppConstant.EXCEPTIONMSG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.Order;
import loginapp.model.Recommendations;
import loginapp.model.UserDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class BookDaoImpl.
 */
@Repository("bookDAO")
public class BookDaoImpl implements BookDAO {

    /** The logger. */
    private static Logger logger = Logger
            .getLogger(BookDaoImpl.class.getName());

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

     /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#addBook(loginapp.model.BookDTO)
     */
    public void addBook(BookDTO book) throws SystemException {

        try {
            book.setIsActive(true);
            book.setBooksOrdered(0);
            template.save(book);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#search(java.lang.String)
     */
    @Transactional(readOnly = false)
    public List<BookDTO> search(String searchTitle, String searchAuthor,
            String searchCategory, int uid) throws SystemException {
        try {
            BookDTO bookdto = new BookDTO();
            logger.info(searchCategory);

            logger.info(bookdto.getBookTitle());
            List<BookDTO> book = null;

            if (!StringUtils.isEmpty(searchTitle)) {
                bookdto.setBookTitle(searchTitle);

            }
            if (!StringUtils.isEmpty(searchAuthor)) {
                bookdto.setBookAuthor(searchAuthor);

            }
            if (!StringUtils.isEmpty(searchCategory)) {
                bookdto.setBookCategory(searchCategory);

            }
            bookdto.setIsActive(true);
            book = template.findByExample(bookdto);
            logger.info(book);
            if (book.isEmpty()) {
                return book;

            } else {
                String author = book.get(0).getBookAuthor();
                String category = book.get(0).getBookCategory();
                Recommendations recommend = new Recommendations();
                recommend.setAuthor(author);
                recommend.setCategory(category);
                recommend.setUserID(uid);
                List<Recommendations> list = template.findByExample(recommend);
                if (list.isEmpty()) {
                    template.save(recommend);
                } else {
                    template.delete(recommend);
                    template.save(recommend);
                }
                return book;
            }
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#noneSearch(java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public List<BookDTO> noneSearch(String searchTitle, String searchAuthor,
            String searchCategory) throws SystemException {
        try {
            BookDTO bookdto = new BookDTO();
            logger.info(searchTitle);

            logger.info(bookdto.getBookTitle());
            List<BookDTO> book = null;

            if (!StringUtils.isEmpty(searchTitle)) {
                bookdto.setBookTitle(searchTitle);

            }
            if (!StringUtils.isEmpty(searchAuthor)) {
                bookdto.setBookAuthor(searchAuthor);

            }
            if (!StringUtils.isEmpty(searchCategory)) {
                bookdto.setBookCategory(searchCategory);

            }
            bookdto.setIsActive(true);
            logger.info(book);
            book = template.findByExample(bookdto);
            return book;
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#addBookid(loginapp.model.BookDTO,
     * loginapp.model.BookID)
     */
    @Transactional(readOnly = false)
    public void addBookid(BookDTO bookdto, BookID bookid)
            throws SystemException {
        // TODO Auto-generated method stub

        try {
            bookid.setAvailabilty(true);
            bookid.setBookdto(bookdto);
            logger.info(bookid.getBookdto().getISBN());
            template.save(bookid);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#getBook(int)
     */
    public List<BookDTO> getBook(int bookIsbn) throws SystemException {
        try {
            
            return (List<BookDTO>) template.find("from BookDTO where ISBN=?",
                    bookIsbn);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#getAddress(int)
     */
    public List<UserDTO> getAddress(int uid) throws SystemException {
        try {
           
            return (List<UserDTO>) template
                    .find("from UserDTO where id=?", uid);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#autocomplete(java.lang.String)
     */
    public List<String> autocomplete(String searchTitle) {

        String query = "select bookTitle from BookDTO where bookTitle like :name";

        return (List<String>) template.findByNamedParam(query, "name",
                '%' + searchTitle + '%');

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.BookDAO#recommend(int)
     */
    public List<BookDTO> recommend(int uid) {

        logger.info("in recommend");
        List<Recommendations> list = (List<Recommendations>) template.find(
                "from Recommendations where userID=?", uid);
        List<Order> list1 = (List<Order>) template.find(
                "from Order where userID=?", uid);
        logger.info(list);
        ArrayList<BookDTO> book = new ArrayList<BookDTO>();
        String author = null;

        if (list.isEmpty()) {
            return book;

        } else {
            author = list.get(0).getAuthor();
            logger.info(author);
            String category = list.get(0).getCategory();

            book.addAll((Collection<? extends BookDTO>) template.find(
                    "from BookDTO where bookAuthor!=? ", author));
            book.addAll((Collection<? extends BookDTO>) template.find(
                    "from BookDTO where bookCategory=? and bookAuthor!=? ",
                    category, author));

            if (!list1.isEmpty()) {

                BookID bookid = list1.get(0).getBook();
                BookDTO book1 = bookid.getBookdto();
                String author1 = book1.getBookAuthor();
                String category1 = book1.getBookCategory();
                book.addAll((Collection<? extends BookDTO>) template.find(
                        "from BookDTO where bookAuthor=? and bookAuthor!=?",
                        author1, author));
                book.addAll((Collection<? extends BookDTO>) template
                        .find("from BookDTO where bookCategory=? and bookAuthor!=? and bookAuthor!=?",
                                category1, author, author1));

            }
            return book;
        }

    }

    public List<String> isAvailable(List<BookDTO> book) throws SystemException {
        try
        {
        List<String> list = new ArrayList();
        for (BookDTO b : book) {
            int noOfCopies = b.getNoOfCopies();
            int bookOrdered = b.getBooksOrdered();
            if (noOfCopies - bookOrdered > 0) {
                list.add("In Stock");

            } else {
                list.add("Out Of Stock");
            }
        }
        return list;
        }
    
    catch (DataAccessException e) {
        throw new SystemException(EXCEPTIONMSG + e);
    }
    }      
    public List<BookDTO> latestArrival() {
       
        return (List<BookDTO>) template
                .find(" FROM BookDTO ORDER BY(iSBN) DESC");

    }

    public List<String> isOrdered(List<BookDTO> book,int uid) {
        List<String> ordered=new ArrayList();
        for(BookDTO b:book)
        {
            int isbn=b.getISBN();
                  
            List<Order> list=(List<Order>) template.find("from Order where book.bookdto.iSBN=? and userID=? and (deliveryType=? or deliveryType=?) and returnType!=?",isbn,uid,"Closed","pending","Closed");
            
            logger.info(list+" "+list.size());
            if(list.isEmpty())
            {
                ordered.add("order");
                
            }
            else
            {
                ordered.add("ordered");
                
            }
        }
        return ordered;
    }

}
