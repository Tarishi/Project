package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookDAO.
 */
public interface BookDAO {

    /**
     * Adds the book.
     * 
     * @param book
     *            the book
     * @throws SystemException
     *             the system exception
     */
    void addBook(BookDTO book) throws SystemException;

    /**
     * Search.
     * 
     * @param searchBook
     *            the search book
     * @param searchAuthor
     *            the search author
     * @param searchCategory
     *            the search category
     * @param uid
     *            the uid
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<BookDTO> search(String searchBook, String searchAuthor,
            String searchCategory, int uid) throws SystemException;

    /**
     * Adds the bookid.
     * 
     * @param bookdto
     *            the bookdto
     * @param bookid
     *            the bookid
     * @throws SystemException
     *             the system exception
     */
    void addBookid(BookDTO bookdto, BookID bookid) throws SystemException;

    /**
     * Gets the book.
     * 
     * @param bookIsbn
     *            the book isbn
     * @return the book
     * @throws SystemException
     *             the system exception
     */
    List<BookDTO> getBook(int bookIsbn) throws SystemException;

    /**
     * None search.
     * 
     * @param searchTitle
     *            the search title
     * @param searchAuthor
     *            the search author
     * @param searchCategory
     *            the search category
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<BookDTO> noneSearch(String searchTitle, String searchAuthor,
            String searchCategory) throws SystemException;

    /**
     * Gets the address.
     * 
     * @param uid
     *            the uid
     * @return the address
     * @throws SystemException
     *             the system exception
     */
    List<UserDTO> getAddress(int uid) throws SystemException;

    /**
     * Autocomplete.
     * 
     * @param searchTitle
     *            the search title
     * @return the array list
     */
    List<String> autocomplete(String searchTitle);

    /**
     * Recommend.
     * 
     * @param uid
     *            the uid
     * @return the list
     */
    List<BookDTO> recommend(int uid);

    List<String> isAvailable(List<BookDTO> book) throws SystemException;

    List<BookDTO> latestArrival();

    List<String> isOrdered(List<BookDTO> book, int uid);
}
