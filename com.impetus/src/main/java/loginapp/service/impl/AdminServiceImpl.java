package loginapp.service.impl;

import java.util.List;

import loginapp.dao.AdminDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminServiceImpl.
 */
@Service("BookDelService")
public class AdminServiceImpl implements AdminService {

    /** The bookdel dao. */
    @Autowired
    private AdminDao bookdelDao;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#search(java.lang.String)
     */
    public List<BookDTO> search(String searchBook) throws SystemException {

        return bookdelDao.search(searchBook);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#delete(int)
     */
    public String delete(int iSBN) throws SystemException {
        return bookdelDao.delete(iSBN);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#Update(int)
     */
    public String update(int iSBN) {

        return bookdelDao.update(iSBN);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#getbook(int)
     */
    public List<BookDTO> getbook(int iSBN) throws SystemException {
        // TODO Auto-generated method stub
        return bookdelDao.getbook(iSBN);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#savebook(loginapp.model.BookDTO)
     */
    public String savebook(BookDTO bookdto) throws SystemException {
         bookdelDao.savebook(bookdto);
        return "success";
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#deliveryRequest()
     */
    public List<Order> deliveryRequest() throws SystemException {
        // TODO Auto-generated method stub
        return bookdelDao.deliveryRequest();
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#CloseDelivery(int, int)
     */
    public String closeDelivery(int iSBN, int userId) throws SystemException {
        // TODO Auto-generated method stub
        return bookdelDao.closeDelivery(iSBN, userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#returnRequest()
     */
    public List<Order> returnRequest() throws SystemException {
        // TODO Auto-generated method stub
        return bookdelDao.returnRequest();
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.AdminService#CloseReturn(int, int)
     */
    public String closeReturn(int iSBN, int userId) throws SystemException {
        // TODO Auto-generated method stub
        return bookdelDao.closeReturn(iSBN, userId);
    }

    /**
     * Sets the bookdel dao.
     * 
     * @param bookdelDao2
     *            the new bookdel dao
     */
    public void setBookdelDao(AdminDao bookdelDao2) {
        // TODO Auto-generated method stub
        this.bookdelDao = bookdelDao2;

    }

}
