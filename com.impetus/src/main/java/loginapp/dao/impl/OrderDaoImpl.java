package loginapp.dao.impl;

import static loginapp.appconstant.AppConstant.CANCELLED;
import static loginapp.appconstant.AppConstant.CLOSED;
import static loginapp.appconstant.AppConstant.EXCEPTIONMSG;
import static loginapp.appconstant.AppConstant.PENDING;

import java.util.Date;
import java.util.List;

import loginapp.dao.OrderDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderDaoImpl.
 */
@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /** The logger. */
    private static Logger logger = Logger.getLogger(OrderDaoImpl.class);

    /**
     * Find plan.
     * place the order for the book and saves search history
     * @param order the model class object
     * @param status the current status of requested book
     * @param iSBN the isbn of requested book
     * @param bookid the bookid of requested book
     * @return the status of request
     * @throws SystemException  the user defined  exception
     */

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.OrderDao#orderBook(loginapp.model.Order,
     * java.lang.String, int, loginapp.model.BookID)
     */
    @Transactional
    public String orderBook(Order order, String status, int iSBN, BookID bookid)
            throws SystemException {

        logger.info("Order book Dao called values reached " + order + status
                + iSBN + bookid);
        try {
            if (status.equals("ordered")) {
                Date today = new Date();
                order.setDeliveryType(PENDING);
                order.setReturnType("none");
                order.setDeliveryrequestDate(today);
                bookid.setAvailabilty(false);
                template.save(order);

                UserDTO userdto = new UserDTO();
                userdto.setId(order.getUserId());
                List<UserSubscribeDTO> user = (List<UserSubscribeDTO>) template
                        .find("from UserSubscribeDTO where user.id=?",
                                order.getUserId());
                List<BookDTO> book = (List<BookDTO>) template.find(
                        "from BookDTO where iSBN=?", iSBN);
                int booksOrdered = book.get(0).getBooksOrdered();
                int maxBookordered = user.get(0).getBooksOrdered();

                int id = user.get(0).getId();
                logger.info(id);
                maxBookordered++;
                booksOrdered++;
                logger.info(maxBookordered);

                for (UserSubscribeDTO usersub : user) {
                    usersub.setBooksOrdered(maxBookordered);
                    template.saveOrUpdate(usersub);

                }
                for (BookDTO bookdto : book) {
                    bookdto.setBooksOrdered(booksOrdered);
                    template.saveOrUpdate(bookdto);
                }

            }

            logger.info("dao code completed");
            return status;
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.OrderDao#booksheld(int)
     */
    public List<Order> booksheld(int uid) throws SystemException {
        try {
            String dType = CLOSED;
            String rType = PENDING;
            String returnType = "none";
            String cancel = CANCELLED;
            return (List<Order>) template
                    .find("from Order where userId=? and deliveryType=? and (returnType=? or returnType=?or returnType=?)",
                            uid, dType, rType, returnType, cancel);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.OrderDao#returnBook(int, int)
     */
    @Transactional(readOnly = false)
    public String returnBook(int userId, int iSBN) throws SystemException {
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

            List<Order> list = (List<Order>) template.find(
                    "from Order where userID=? and book.bookID=?", userId,
                    bookid);
            for (Order o : list) {

                o.setReturnType(PENDING);
                o.setReturnRequestDate(today);
                template.saveOrUpdate(o);

            }

            return "return request generated";
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.OrderDao#cancelBook(int, int)
     */
    @Transactional(readOnly = false)
    public String cancelBook(int userId, int iSBN) throws SystemException {
        try {
            // TODO Auto-generated method stub
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

            logger.info(bookid + " " + userId);

            List<Order> list = (List<Order>) template
                    .find("from Order where userID=? and book.bookID=? and returnType=?",
                            userId, bookid, PENDING);
            for (Order o : list) {

                o.setReturnType(CANCELLED);
                template.saveOrUpdate(o);

            }

            List<UserSubscribeDTO> user = (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO where user.id=?", userId);
            List<BookDTO> bookDTO = (List<BookDTO>) template.find(
                    "from BookDTO where iSBN=?", iSBN);
            int booksOrdered = bookDTO.get(0).getBooksOrdered();
            int maxBookordered = user.get(0).getBooksOrdered();

            int id = user.get(0).getId();
            logger.info(id);
            maxBookordered--;
            booksOrdered--;
            logger.info(maxBookordered);

            for (UserSubscribeDTO usersub : user) {
                usersub.setBooksOrdered(maxBookordered);
                template.saveOrUpdate(usersub);

            }
            for (BookDTO bookdto1 : book) {
                bookdto.setBooksOrdered(booksOrdered);
                template.saveOrUpdate(bookdto1);
            }

            return CANCELLED;
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.OrderDao#booksRequested(int)
     */
    public List booksRequested(int userId) throws SystemException {
        // TODO Auto-generated method stub
        try {
            String dType = PENDING;
            return (List<Order>) template.find(
                    "from Order where userId=? and deliveryType=? ", userId,
                    dType);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.OrderDao#cancelRequest(int, int)
     */
    @Transactional(readOnly = false)
    public String cancelRequest(int userId, int iSBN) throws SystemException {
        // TODO Auto-generated method stub
        try {
            BookDTO bookdto = new BookDTO();
            bookdto.setISBN(iSBN);
            int bookid = 0;
            List<BookDTO> book = (List<BookDTO>) template.find(
                    "from BookDTO b where b.iSBN=?", iSBN);
            BookID b = new BookID();

            List<UserSubscribeDTO> user = (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO where user.id=?", userId);
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
                logger.info("in loop1");
                usersub.setBooksOrdered(bookordered);
                template.saveOrUpdate(usersub);
            }

            for (BookDTO bookdto1 : bookDTO) {
                logger.info("in loop2");
                bookdto1.setBooksOrdered(booksOrdered);
                template.saveOrUpdate(bookdto1);
            }

            for (BookDTO bookdt : book) {
                logger.info("in loop3");
                b.setBookdto(bookdt);
                List<BookID> bookID = (List<BookID>) template.find(
                        "from BookID where availabilty=? and BISBN=?", false,
                        iSBN);
                bookid = bookID.get(0).getBookID();

            }

            logger.info(bookid + " " + userId);

            List<Order> list = (List<Order>) template
                    .find("from Order where userID=? and book.bookID=? and deliveryType=?",
                            userId, bookid, PENDING);
            logger.info(list);
            for (Order o : list) {

                o.setDeliveryType(CANCELLED);
                template.saveOrUpdate(o);

            }

            List<BookID> bookid1 = (List<BookID>) template.find(
                    "from BookID where bookid=?", bookid);
            for (BookID bid : bookid1) {
                bid.setAvailabilty(true);
                template.saveOrUpdate(bid);
            }

            return CANCELLED;
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }
}
