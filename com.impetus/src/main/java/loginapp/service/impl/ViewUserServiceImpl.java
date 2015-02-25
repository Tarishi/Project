package loginapp.service.impl;

import java.util.List;

import loginapp.dao.ViewUserDao;
import loginapp.exception.SystemException;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.ViewUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewUserServiceImpl.
 */
@Service("ViewUserService")
public class ViewUserServiceImpl implements ViewUserService {

    /** The viewuserdao. */
    @Autowired
    private ViewUserDao viewuserdao;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.ViewUserService#searchuser(java.lang.String,
     * java.lang.String)
     */
    public List<UserSubscribeDTO> searchuser(String searchuser,
            String searchplan) throws SystemException {

        return viewuserdao.searchuser(searchuser, searchplan);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.ViewUserService#viewall()
     */
    public List<UserSubscribeDTO> viewall() throws SystemException {

        return viewuserdao.viewall();
    }

    /**
     * Sets the viewplan dao.
     * 
     * @param viewuserndao
     *            the new viewplan dao
     */
    public void setviewplanDao(ViewUserDao viewuserndao) {
        this.viewuserdao = viewuserndao;

    }

}
