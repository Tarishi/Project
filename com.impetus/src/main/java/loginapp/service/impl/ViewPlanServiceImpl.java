package loginapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginapp.dao.ViewPlanDao;
import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;
import loginapp.service.ViewPlanService;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewPlanServiceImpl.
 */
@Service("ViewPlanService")
public class ViewPlanServiceImpl implements ViewPlanService {

    /** The viewplandao. */
    @Autowired
    private ViewPlanDao viewplandao;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.ViewPlanService#viewPlan(int)
     */
    public List<UserSubscribeDTO> viewPlan(int userid) throws SystemException {

        return viewplandao.viewPlan(userid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.ViewPlanService#viewProfile(int)
     */
    public List<UserSubscribeDTO> viewProfile(int userid)
            throws SystemException {
        // TODO Auto-generated method stub
        return viewplandao.viewProfile(userid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.ViewPlanService#saveProfile(loginapp.model.UserDTO)
     */
    public void saveProfile(UserDTO user) throws SystemException {
        viewplandao.saveprofile(user);

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.ViewPlanService#bookHistory(int)
     */
    public List<Order> bookHistory(int userid) throws SystemException {
        // TODO Auto-generated method stub
        return viewplandao.bookHistory(userid);
    }

    /**
     * Sets the viewplan dao.
     * 
     * @param viewplandao2
     *            the new viewplan dao
     */
    public void setviewplanDao(ViewPlanDao viewplandao2) {
        this.viewplandao = viewplandao2;

    }

    /**
     * public int getTotalRecordsOfRequest() { // TODO Auto-generated method
     * stub return viewplandao.getTotalRecordsOfRequest(); }
     * 
     * public List<Order> paginationBooks(int start, int pageSize, String
     * search, int columnNum, String sortOrder) { // TODO Auto-generated method
     * stub return viewplandao. paginationBooks(start, pageSize,search,
     * columnNum,sortOrder); }
     */

}
