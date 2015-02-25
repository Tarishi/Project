package loginapp.dao.impl;

import java.util.Date;
import java.util.List;

import loginapp.dao.PdfGenDAO;
import loginapp.model.BookDTO;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfGenDAOImpl.
 */
@Repository("pdfGenDAO")
public class PdfGenDAOImpl implements PdfGenDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PdfGenDAOImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PdfGenDAO#getReports(java.util.List,
     * java.util.Date, java.util.Date)
     */
    public List<Object[]> getReports(String author, String category,
            Date fromDate, Date toDate) {
        // TODO Auto-generated method stub

        Session session = sessionFactory.openSession();

        LOGGER.info("Author" + author);
        LOGGER.info("Category" + author);
        LOGGER.info("From Date" + fromDate);
        LOGGER.info("To Date" + toDate);
        LOGGER.info(author);
        LOGGER.info(category);

        try {

            String commonQuery = "SELECT b.bookCategory as category,b.bookAuthor as author,b.bookTitle as title,COUNT(*)total, SUM(CASE WHEN deliveryType='cancelled' THEN 1 ELSE 0 END) cancelled,SUM(CASE WHEN returnType='Closed' THEN 1 ELSE 0 END)returned,SUM(CASE WHEN deliveryType='Closed' THEN 1 ELSE 0 END)delivered FROM requestbook,book b,book_id id  WHERE deliveryRequestDate BETWEEN '"
                    + fromDate + "' AND '" + toDate;

            String query;
            
            String all = "all";

            if (author.equalsIgnoreCase(all) && category.equalsIgnoreCase(all)) {

                query = commonQuery

                + "'  AND biSBN=b.iSBN GROUP BY iSBN";
            } else if (author.equalsIgnoreCase(all) && !category.equalsIgnoreCase(all)) {
                query = commonQuery + "'  AND biSBN=b.iSBN AND bookCategory='"
                        + category + "' GROUP BY iSBN";
            } else if (category.equalsIgnoreCase(all) && !author.equalsIgnoreCase(all)) {
                query = commonQuery + "'  AND biSBN=b.iSBN AND bookAuthor='"
                        + author + "'GROUP BY iSBN";
            } else {
                query = commonQuery + "'  AND biSBN=b.iSBN AND bookCategory='"
                        + category + "' AND bookAuthor='" + author
                        + "'GROUP BY iSBN";
            }

            SQLQuery q = session.createSQLQuery(query);
            LOGGER.info(author);
            LOGGER.info(category);
            return (List<Object[]>) q.list();  

        } catch (HibernateException e) {
            LOGGER.info("Exception in DAO ->" + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PdfGenDAO#getDistinctAuth()
     */
    public List<BookDTO> getDistinctAuth() {
        // TODO Auto-generated method stub

        try {

            return (List<BookDTO>) template
                    .find("select distinct bookAuthor from BookDTO ");

        } catch (HibernateException e) {
            LOGGER.info("Exception caught in Getting Books for Report" + e);
            return null;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PdfGenDAO#getDistinctCat()
     */
    public List<BookDTO> getDistinctCat() {
        // TODO Auto-generated method stub
        try {

            List<BookDTO> resultRecords = (List<BookDTO>) template
                    .find("select distinct bookCategory from BookDTO ");
            LOGGER.info("LIST RETREIVED" + resultRecords);
            return resultRecords;

        } catch (HibernateException e) {
            LOGGER.info("Exception caught in Getting Distinct Categories " + e);
            return null;
        }

    }

}
