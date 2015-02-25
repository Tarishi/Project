package loginapp.dao.impl;

import static loginapp.appconstant.AppConstant.CLOSED;
import static loginapp.appconstant.AppConstant.EXCEPTIONMSG;
import static loginapp.appconstant.AppConstant.PENDING;

import java.util.Date;
import java.util.List;

import loginapp.dao.AdminDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.Order;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminDaoImpl.
 */
@Repository("BookDelDao")
public class AdminDaoImpl implements AdminDao {

    /** The logger. */
    private static Logger logger = Logger.getLogger(AdminDaoImpl.class
            .getName());

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#search(java.lang.String)
     */
    public List<BookDTO> search(String searchBook) throws SystemException {
        try {
            BookDTO bookdto = new BookDTO();
            logger.info(searchBook);
            bookdto.setBookTitle(searchBook);
            logger.info(bookdto.getBookTitle());
            bookdto.setIsActive(true);
            List<BookDTO> book = (List<BookDTO>) template
                    .findByExample(bookdto);
            logger.info(book);
            return book;
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#delete(int)
     */
    @Transactional(readOnly = false)
    public String delete(int iSBN) throws SystemException {
        try {
            List<BookDTO> list = (List<BookDTO>) template.find(
                    "from BookDTO where iSBN=?", iSBN);
            logger.info(list);
            for (BookDTO book : list) {
                book.setNoOfCopies(0);
                template.saveOrUpdate(book);
            }

            return "success";
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#Update(int)
     */
    public String update(int iSBN) {
        BookDTO bookdto = new BookDTO();
        bookdto.setISBN(iSBN);
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#getbook(int)
     */
    public List<BookDTO> getbook(int iSBN) throws SystemException {
        try {
            BookDTO book = new BookDTO();
            logger.info(iSBN);
            book.setISBN(iSBN);
            logger.info(book.getISBN());
            return (List<BookDTO>) template.findByExample(book);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#savebook(loginapp.model.BookDTO)
     */
    @Transactional(readOnly = false)
    public String savebook(BookDTO bookdto) throws SystemException {
        try {
            logger.info("in save book");
            template.saveOrUpdate(bookdto);
            return "success";
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#deliveryRequest()
     */
    public List<Order> deliveryRequest() throws SystemException {
        try {
            Order order = new Order();
            order.setDeliveryType(PENDING);
            return (List<Order>) template.findByExample(order);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#CloseDelivery(int, int)
     */
    @Transactional(readOnly = false)
    public String closeDelivery(int iSBN, int userId) throws SystemException {

        try {
            // TODO Auto-generated method stub
            BookDTO bookdto = new BookDTO();
            bookdto.setISBN(iSBN);
            int bookid = 0;
            List<BookDTO> book = (List<BookDTO>) template.find(
                    "from BookDTO b where b.iSBN=?", iSBN);
            BookID b = new BookID();
            for (BookDTO bookdt : book) {
                logger.info("in loop");
                b.setBookdto(bookdt);
                List<BookID> bookID = (List<BookID>) template.find(
                        "from BookID where availabilty=? and BISBN=?", false,
                        iSBN);
                for(int i=0;i<bookID.size();i++)
                {
                logger.info("in loop");
                bookid = bookID.get(i).getBookID();
                logger.info(bookid );
                List<Order> list = (List<Order>) template.find(
                        "from Order where userID=? and book.bookID=?", userId,
                        bookid);
                if(!list.isEmpty())
                {
                    
                    break;
                }
                }
                
            }
            Date today = new Date();
            logger.info(bookid + " " + userId);

            List<Order> list = (List<Order>) template.find(
                    "from Order where userID=? and book.bookID=? and deliveryType=?", userId,
                    bookid,"pending");
            logger.info(list);
            for (Order o : list) {
                logger.info("in loop");
                o.setDeliveryType(CLOSED);
                o.setDeliveryDate(today);
                template.saveOrUpdate(o);

            }
            return "Closed";
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#returnRequest()
     */
    public List<Order> returnRequest() throws SystemException {
        // TODO Auto-generated method stub
        try {
            return (List<Order>) template.find(
                    "from Order where returnType=?)", PENDING);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.AdminDao#CloseReturn(int, int)
     */
    @Transactional(readOnly = false)
    public String closeReturn(int iSBN, int userId) throws SystemException {
        // TODO Auto-generated method stub
        try {
            BookDTO bookdto = new BookDTO();
            bookdto.setISBN(iSBN);
            int bookid = 0;
            List<BookDTO> book = (List<BookDTO>) template.find(
                    "from BookDTO b where b.iSBN=?", iSBN);
            BookID b = new BookID();
            for (BookDTO bookdt : book) {

                b.setBookdto(bookdt);
                List<BookID> bookID = (List<BookID>) template.find(
                        "from BookID where availabilty=? and BISBN=?", false,
                        iSBN);
                bookid = bookID.get(0).getBookID();

            }
            Date today = new Date();
            logger.info(bookid + " " + userId);

            Order order = new Order();
            List<Order> list = (List<Order>) template.find(
                    "from Order where userID=? and book.bookID=?", userId,
                    bookid);
            for (Order o : list) {
                order = o;
                o.setReturnType(CLOSED);
                o.setReturnDate(today);
                template.saveOrUpdate(o);

            }
            List<UserSubscribeDTO> user = (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO where user.id=?",
                            order.getUserId());
            int bookordered = user.get(0).getBooksOrdered();

            List<BookDTO> bookDTO = (List<BookDTO>) template.find(
                    "from BookDTO where iSBN=?", iSBN);
            int booksOrdered = bookDTO.get(0).getBooksOrdered();

            int id = user.get(0).getId();
            logger.info(id);
            bookordered--;
            booksOrdered--;
            logger.info(bookordered);

            for (UserSubscribeDTO usersub : user) {
                usersub.setBooksOrdered(bookordered);
                template.saveOrUpdate(usersub);
            }
            for (BookDTO bookdto1 : bookDTO) {
                bookdto1.setBooksOrdered(booksOrdered);
                template.saveOrUpdate(bookdto1);
            }

            List<BookID> bookid1 = (List<BookID>) template.find(
                    "from BookID where bookid=?", bookid);
            for (BookID bid : bookid1) {
                bid.setAvailabilty(true);
                template.saveOrUpdate(bid);
            }

            return CLOSED;
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

}
