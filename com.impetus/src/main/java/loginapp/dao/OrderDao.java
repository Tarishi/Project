package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.BookID;
import loginapp.model.Order;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderDao.
 */
public interface OrderDao {

    /**
     * Order book.
     * 
     * @param order
     *            the order
     * @param status
     *            the status
     * @param iSBN
     *            the i sbn
     * @param b
     *            the b
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String orderBook(Order order, String status, int iSBN, BookID b)
            throws SystemException;

    /**
     * Booksheld.
     * 
     * @param uid
     *            the uid
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<Order> booksheld(int uid) throws SystemException;

    /**
     * Return book.
     * 
     * @param userId
     *            the user id
     * @param iSBN
     *            the i sbn
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String returnBook(int userId, int iSBN) throws SystemException;

    /**
     * Cancel book.
     * 
     * @param userId
     *            the user id
     * @param iSBN
     *            the i sbn
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String cancelBook(int userId, int iSBN) throws SystemException;

    /**
     * Books requested.
     * 
     * @param userId
     *            the user id
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List booksRequested(int userId) throws SystemException;

    /**
     * Cancel request.
     * 
     * @param userId
     *            the user id
     * @param iSBN
     *            the i sbn
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String cancelRequest(int userId, int iSBN) throws SystemException;

}
