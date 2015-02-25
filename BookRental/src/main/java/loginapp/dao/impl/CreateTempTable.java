package loginapp.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
//@Transactional(readOnly = false)
/**
 * The Class CreateTempTable.
 */
@Repository
public class CreateTempTable {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CreateTempTable.class);

    /**
     * Creates the table.
     */
    public void createTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            String create = "CREATE TABLE temp_table (bookTitle varchar(90),bookImage varchar(90),bookDescription varchar(200),bookAuthor varchar(45),bookPublisher varchar(45),bookCategory varchar(45),no_of_copies int,booksOrdered int)";
            SQLQuery query = session.createSQLQuery(create);
            query.executeUpdate();
            session.getTransaction().commit();

            session.beginTransaction();
            String csvDataRead = " LOAD DATA  INFILE '" + "d://bookbiz.csv"
                    + "' INTO TABLE temp_table "
                    + " FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"'"
                    + " LINES TERMINATED BY \'\\r\\n\'";
            query = session.createSQLQuery(csvDataRead);
            query.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            LOGGER.info("Exception in Adding Books Via Schedular");
        } finally {
            session.close();
        }

    }

    /**
     * Creates the delete table.
     */
    public void createDeleteTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            String create = "CREATE TABLE temp_delete (bookTitle varchar(20),bookAuthor varchar(20))";
            SQLQuery query = session.createSQLQuery(create);
            query.executeUpdate();
            session.getTransaction().commit();

            session.beginTransaction();
            String csvDataRead = " LOAD DATA  INFILE '"
                    + "D://bookForDelete.csv" + "' INTO TABLE temp_delete "
                    + " FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"'"
                    + " LINES TERMINATED BY \'\\r\\n\'";
            query = session.createSQLQuery(csvDataRead);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.info("Exception in Deleting Via Schedular" + e);

        } finally {

            session.close();
        }
    }

}
