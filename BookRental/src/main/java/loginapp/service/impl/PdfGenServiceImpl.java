package loginapp.service.impl;

import loginapp.dao.PdfGenDAO;
import loginapp.model.*;
import loginapp.service.PdfGenService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfGenServiceImpl.
 */
@Service("pdfGenService")
public class PdfGenServiceImpl implements PdfGenService {

    /** The pdf gen dao. */
    @Autowired
    private PdfGenDAO pdfGenDAO;

    /**
     * Sets the pdf gen dao.
     * 
     * @param pdfGenDAO
     *            the new pdf gen dao
     */
    public void setPdfGenDAO(PdfGenDAO pdfGenDAO) {
        this.pdfGenDAO = pdfGenDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.pdfgen.PdfGenService#getReports(java.lang.String,
     * java.lang.String, java.util.Date, java.util.Date)
     */
    public List<Object[]> getReports(String author, String category, Date from,
            Date to) {

        return pdfGenDAO.getReports(author, category, from, to);

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.pdfgen.PdfGenService#getDistinctAuth()
     */
    public List<BookDTO> getDistinctAuth() {
        // TODO Auto-generated method stub
        return pdfGenDAO.getDistinctAuth();
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.pdfgen.PdfGenService#getDistinctCat()
     */
    public List<BookDTO> getDistinctCat() {
        // TODO Auto-generated method stub
        return pdfGenDAO.getDistinctCat();
    }

}
