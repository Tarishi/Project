package loginapp.service;

import loginapp.model.BookDTO;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface PdfGenService.
 */
public interface PdfGenService {

    /**
     * Gets the reports.
     * 
     * @param author
     *            the author
     * @param from
     *            the from
     * @param to
     *            the to
     * @return the reports
     */
    List<Object[]> getReports(String author, String category, Date from, Date to);

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