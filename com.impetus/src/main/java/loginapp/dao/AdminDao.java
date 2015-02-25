package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminDao.
 */
public interface AdminDao {

    /**
     * Search.
     * 
     * @param searchBook
     *            the search book
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<BookDTO> search(String searchBook) throws SystemException;

    /**
     * Delete.
     * 
     * @param iSBN
     *            the i sbn
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String delete(int iSBN) throws SystemException;

    /**
     * Update.
     * 
     * @param iSBN
     *            the i sbn
     * @return the string
     */
    String update(int iSBN);

    /**
     * Gets the book.
     * 
     * @param iSBN
     *            the i sbn
     * @return the book
     * @throws SystemException
     *             the system exception
     */
    List<BookDTO> getbook(int iSBN) throws SystemException;

    /**
     * Savebook.
     * 
     * @param bookdto
     *            the bookdto
     * @return 
     * @throws SystemException
     *             the system exception
     */
    String savebook(BookDTO bookdto) throws SystemException;

    /**
     * Delivery request.
     * 
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<Order> deliveryRequest() throws SystemException;

    /**
     * Close delivery.
     * 
     * @param iSBN
     *            the i sbn
     * @param userId
     *            the user id
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String closeDelivery(int iSBN, int userId) throws SystemException;

    /**
     * Return request.
     * 
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<Order> returnRequest() throws SystemException;

    /**
     * Close return.
     * 
     * @param iSBN
     *            the i sbn
     * @param userId
     *            the user id
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String closeReturn(int iSBN, int userId) throws SystemException;
}
