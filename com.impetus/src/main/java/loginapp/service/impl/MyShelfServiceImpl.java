package loginapp.service.impl;

import java.util.List;

import loginapp.dao.MyShelfDao;
import loginapp.exception.SystemException;
import loginapp.model.MyShelf;
import loginapp.service.MyShelfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class MyShelfServiceImpl.
 */
@Service("MyShelfService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MyShelfServiceImpl implements MyShelfService {

    /** The my shelf dao. */
    @Autowired
    private loginapp.dao.MyShelfDao myShelfDao;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.MyShelfService#addBookToShelf(int, int)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String addBookToShelf(int iSBN, int uid) throws SystemException {

        return myShelfDao.addBookToShelf(iSBN, uid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.MyShelfService#viewshelf(int)
     */
    public List<MyShelf> viewshelf(int userid) throws SystemException {

        return myShelfDao.viewshelf(userid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.MyShelfService#remove(int, int)
     */
    public void remove(int iSBN, int userId) throws SystemException {
        // TODO Auto-generated method stub
        myShelfDao.remove(iSBN, userId);

    }

    /**
     * Sets the my shelf.
     * 
     * @param myshelfDao2
     *            the new my shelf
     */
    public void setmyShelf(MyShelfDao myshelfDao2) {
        this.myShelfDao = myshelfDao2;

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.MyShelfService#isAdded(java.lang.Integer, int)
     */
    public String isAdded(Integer isbn, int uid) {
        // TODO Auto-generated method stub
        return myShelfDao.isAdded(isbn, uid);
    }

    public List<String> isOrdered(int userid) {
        
        return myShelfDao.isOrdered(userid);
    }

}
