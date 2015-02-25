package loginapp.dao;

import java.util.Date;
import java.util.List;

import loginapp.model.BookDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PdfGenDAO.
 */
public interface PdfGenDAO {

    /**
     * Gets the reports.
     * 
     * @param author
     *            the author
     * @param category
     *            the category
     * @param fromDate
     *            the from date
     * @param toDate
     *            the to date
     * @return the reports
     */
    List<Object[]> getReports(String author, String category, Date fromDate,
            Date toDate);

    /**
     * Gets the distinct auth.
     * 
     * @return the distinct auth
     */
    List<BookDTO> getDistinctAuth();

    /**
     * Gets the distinct cat.
     * 
     * @return the distinct cat
     */
    List<BookDTO> getDistinctCat();

}
