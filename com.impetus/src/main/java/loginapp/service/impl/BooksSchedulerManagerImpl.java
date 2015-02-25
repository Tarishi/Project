package loginapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import loginapp.dao.BooksSchedulerDAO;
import loginapp.service.BooksSchedulerManager;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksSchedulerManagerImpl.
 */
public class BooksSchedulerManagerImpl implements BooksSchedulerManager {

    /** The books scheduler dao. */
    @Autowired
    private BooksSchedulerDAO booksSchedulerDAO;

    /**
     * Sets the books scheduler dao.
     * 
     * @param booksSchedulerDAO
     *            the new books scheduler dao
     */
    public void setBooksSchedulerDAO(BooksSchedulerDAO booksSchedulerDAO) {
        this.booksSchedulerDAO = booksSchedulerDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BooksSchedulerManager#addBooks()
     */
    @Transactional
    public void addBooks() {

        booksSchedulerDAO.addBooks();

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.BooksSchedulerManager#deleteBooks()
     */
    public void deleteBooks() {
        booksSchedulerDAO.deleteBooks();

    }

}
