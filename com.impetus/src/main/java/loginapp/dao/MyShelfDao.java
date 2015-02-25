package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.MyShelf;

// TODO: Auto-generated Javadoc
/**
 * The Interface MyShelfDao.
 */
public interface MyShelfDao {

    /**
     * Adds the book to shelf.
     * 
     * @param iSBN
     *            the isbn
     * @param uid
     *            the uid
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    String addBookToShelf(int iSBN, int uid) throws SystemException;

    /**
     * Viewshelf.
     * 
     * @param userid
     *            the userid
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<MyShelf> viewshelf(int userid) throws SystemException;

    /**
     * Removes the.
     * 
     * @param iSBN
     *            the i sbn
     * @param userId
     *            the user id
     * @throws SystemException
     *             the system exception
     */
    void remove(int iSBN, int userId) throws SystemException;

    /**
     * Checks if is added.
     * 
     * @param isbn
     *            the isbn
     * @param uid
     *            the uid
     * @return the string
     */
    String isAdded(Integer isbn, int uid);

    List<String> isOrdered(int userid);

}
