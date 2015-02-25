package loginapp.dao;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.UserSubscribeDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ViewUserDao.
 */
public interface ViewUserDao {

    /**
     * Searchuser.
     * 
     * @param searchuser
     *            the searchuser
     * @param searchplan
     *            the searchplan
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<UserSubscribeDTO> searchuser(String searchuser, String searchplan)
            throws SystemException;

    /**
     * Viewall.
     * 
     * @return the list
     * @throws SystemException
     *             the system exception
     */
    List<UserSubscribeDTO> viewall() throws SystemException;

}
