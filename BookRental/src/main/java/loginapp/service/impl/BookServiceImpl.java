package loginapp.service.impl;

import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.UserDTO;
import loginapp.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class BookServiceImpl.
 */
@Service("bookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {

    /** The book dao. */
    @Autowired
    private BookDAO bookDao;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#addBook(loginapp.model.BookDTO)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBook(BookDTO book) throws SystemException {

        bookDao.addBook(book);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#search(java.lang.String)
     */
    public List<BookDTO> search(String searchTitle, String searchAuthor,
            String searchCategory, int uid) throws SystemException {
        return bookDao.search(searchTitle, searchAuthor, searchCategory, uid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#addBookid(loginapp.model.BookDTO)
     */
    public void addBookid(BookDTO bookdto) throws SystemException {
        BookID bookid = new BookID();
        bookDao.addBookid(bookdto, bookid);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#getBook(int)
     */
    public List<BookDTO> getBook(int bookIsbn) throws SystemException {
        return bookDao.getBook(bookIsbn);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#noneSearch(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    public List<BookDTO> noneSearch(String searchTitle, String searchAuthor,
            String searchCategory) throws SystemException {
        return bookDao.noneSearch(searchTitle, searchAuthor, searchCategory);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#getAddress(int)
     */
    public List<UserDTO> getAddress(int uid) throws SystemException {
        // TODO Auto-generated method stub
        return bookDao.getAddress(uid);
    }

    /**
     * Sets the book dao.
     * 
     * @param bookDao
     *            the new book dao
     */
    public void setBookDao(BookDAO bookDao) {
        // TODO Auto-generated method stub
        this.bookDao = bookDao;

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#autocomplete(java.lang.String)
     */
    public List<String> autocomplete(String searchTitle) {
        // TODO Auto-generated method stub
        return bookDao.autocomplete(searchTitle);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BookService#recommend(int)
     */
    public List<BookDTO> recommend(int uid) {
        // TODO Auto-generated method stub
        return bookDao.recommend(uid);
    }

    public List<String> isAvailable(List<BookDTO> book) throws SystemException {
        return bookDao.isAvailable(book);

    }

    public List<BookDTO> latestArrival() {

        return bookDao.latestArrival();
    }

    public List<String> isOrdered(List<BookDTO> book,int uid) {
        // TODO Auto-generated method stub
        return bookDao.isOrdered(book,uid);
    }

}
