package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookService.
 */
public interface BookService {

    /**
     * Adds the book.
     * 
     * @param book
     *            the book
     * @throws SystemException
     */
    void addBook(BookDTO book) throws SystemException;

    /**
     * Search.
     * 
     * @param searchBook
     *            the search book
     * @param searchCategory
     * @param searchAuthor
     * @param uid
     * @return the list
     * @throws SystemException
     */
    List<BookDTO> search(String searchTitle, String searchAuthor,
            String searchCategory, int uid) throws SystemException;

    void addBookid(BookDTO bookdto) throws SystemException;

    List<BookDTO> getBook(int bookId) throws SystemException;

    List<BookDTO> noneSearch(String searchTitle, String searchAuthor,
            String searchCategory) throws SystemException;

    List<UserDTO> getAddress(int uid) throws SystemException;

    List<String> autocomplete(String searchTitle);

    List<BookDTO> recommend(int uid);

    List<String> isAvailable(List<BookDTO> book) throws SystemException;

    List<BookDTO> latestArrival();

    List<String> isOrdered(List<BookDTO> book, int uid);
}
