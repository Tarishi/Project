package loginapp.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import loginapp.dao.BookDAO;
import loginapp.dao.GetUserDao;
import loginapp.dao.OrderDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.GetUserService;
import loginapp.service.OrderService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderServiceImpl.
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    /** The order dao. */
    @Autowired
    private loginapp.dao.OrderDao orderDao;

    /** The book dao. */
    @Autowired
    private BookDAO bookDao;

    @Autowired
    private GetUserService getuserservice;

    /** The getuser. */
    @Autowired
    private GetUserDao getuser;

    /** The logger. */
    private static Logger logger = Logger.getLogger(OrderServiceImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.OrderService#orderBook(int, int)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String orderBook(int userId, int iSBN) throws SystemException {

        Order order = new Order();
        BookDTO bookdto = new BookDTO();
        bookdto.setISBN(iSBN);
        String status = "";
        List<BookDTO> book = (List<BookDTO>) bookDao.getBook(iSBN);
        BookID b = new BookID();
        for (BookDTO bookdt : book) {
            Set<BookID> books = bookdt.getBookid();
          
            for (Iterator<BookID> iterator = (books).iterator(); iterator
                    .hasNext();) {
                b = iterator.next();
                logger.info(b);

                if (b.getAvailabilty()) {

                    logger.info("entered if condition");
                    status = "";
                    break;
                } else {

                    logger.info("Entered Else Condition avail ="
                            + b.getAvailabilty());
                    logger.info(status);
                    status = "book not available";
                }

            }
        }
        order.setBook(b);
        List<UserDTO> userName = getuserservice.getUser(userId);
        order.setUserName(userName.get(0).getUserName());
        order.setUserId(userId);
        logger.info(status);
        int userid = order.getUserId();
        Date today = new Date();
        Date planEndDate;
        int booksordered;
        int maxbooks;
        if (status.equals("")) {
            logger.info(status);
            List<UserSubscribeDTO> user = (List<UserSubscribeDTO>) getuser
                    .getUserSub(userid);
            for (UserSubscribeDTO u : user) {
                planEndDate = u.getEndDate();
                if (planEndDate.before(today)) {
                    status = "plan ended";

                } else {
                    booksordered = u.getBooksOrdered();
                    maxbooks = u.getPlan().getMaxBooks();
                    if (booksordered >= maxbooks) {
                        status = "Cannot Request more books";
                    } else {
                        if (status.equals("")) {
                            status = "ordered";
                        }
                    }
                }

            }
        }
        logger.info(status);
        logger.info("service code successfully completed");

        return orderDao.orderBook(order, status, iSBN, b);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.OrderService#booksheld(int)
     */
    public List<Order> booksheld(int uid) throws SystemException {

        return orderDao.booksheld(uid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.OrderService#returnBook(int, int)
     */
    public String returnBook(int userId, int iSBN) throws SystemException {
        // TODO Auto-generated method stub
        return orderDao.returnBook(userId, iSBN);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.OrderService#cancelBook(int, int)
     */
    public String cancelBook(int userId, int iSBN) throws SystemException {
        // TODO Auto-generated method stub
        return orderDao.cancelBook(userId, iSBN);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.OrderService#booksRequested(int)
     */
    public List booksRequested(int userId) throws SystemException {
        // TODO Auto-generated method stub
        return orderDao.booksRequested(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.OrderService#cancelRequest(int, int)
     */
    public String cancelRequest(int userId, int iSBN) throws SystemException {
        // TODO Auto-generated method stub
        return orderDao.cancelRequest(userId, iSBN);
    }

    /**
     * Sets the order dao.
     * 
     * @param orderdao2
     *            the new order dao
     */
    public void setOrderDao(OrderDao orderdao2) {
        this.orderDao = orderdao2;
    }
}
