package loginapp.dao.impl;

import static loginapp.appconstant.AppConstant.EXCEPTION_SCHEDULER;
import loginapp.dao.BooksSchedulerDAO;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
//TODO: Auto-generated Javadoc

/**
 * The Class BooksSchedulerDAOImpl.
 */
@Repository
public class BooksSchedulerDAOImpl implements BooksSchedulerDAO

{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BooksSchedulerDAOImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The create temp table. */
    @Autowired
    private CreateTempTable createTempTable;

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BooksSchedulerDAOInterface#addBooks()
     */
    public void addBooks() {

        Session session = sessionFactory.getCurrentSession();
        try {

            createTempTable.createTable();
            SQLQuery query = session.createSQLQuery("CALL add_books()");
            query.executeUpdate();

        } catch (Exception e) {
            LOGGER.error(EXCEPTION_SCHEDULER + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BooksSchedulerDAOInterface#deleteBooks()
     */
    public void deleteBooks() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        try {
            createTempTable.createDeleteTable();

            SQLQuery query = session.createSQLQuery("CALL delete_books()");
            query.executeUpdate();

        } catch (Exception e) {
            LOGGER.error(EXCEPTION_SCHEDULER + e);

        }

    }

}
