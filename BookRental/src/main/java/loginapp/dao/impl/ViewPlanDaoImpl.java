package loginapp.dao.impl;

import java.util.List;

import loginapp.dao.ViewPlanDao;
import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewPlanDaoImpl.
 */
@Repository("ViewPlanDao")
public class ViewPlanDaoImpl implements ViewPlanDao {

    private static final String EXCEPTIONMSG = "Problem accessing database. Try again Later";
    /** The template. */

    
    @Autowired
    private HibernateTemplate template = null;

    /** The logger. */
    private static Logger logger = Logger.getLogger(ViewPlanDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.ViewPlanDao#viewPlan(int)
     */
    public List<UserSubscribeDTO> viewPlan(int userid) throws SystemException {
        try {
            return (List<UserSubscribeDTO>) template
                    .find("from UserSubscribeDTO u where u.user.id=? ORDER BY(startDate) DESC",
                            userid);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.ViewPlanDao#viewProfile(int)
     */
    public List<UserSubscribeDTO> viewProfile(int userid)
            throws SystemException {
        try {
            return (List<UserSubscribeDTO>) template.find(
                    "from UserSubscribeDTO u where u.user.id=?", userid);

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.ViewPlanDao#saveprofile(loginapp.model.UserDTO)
     */
    @Transactional(readOnly = false)
    public void saveprofile(UserDTO user) throws SystemException {
        try {
            logger.info("in save profile");
            UserDTO userdto = new UserDTO();
            userdto.setUserName(user.getUserName());
            List<UserDTO> list = template.findByExample(userdto);
            for (UserDTO u : list) {
                u.setAddress(user.getAddress());
                u.setContact(user.getContact());
                u.setEmail(user.getEmail());
                template.saveOrUpdate(u);
            }
        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.ViewPlanDao#bookHistory(int)
     */
    public List<Order> bookHistory(int userid) throws SystemException {
        // TODO Auto-generated method stub
        try {

            return (List<Order>) template
                    .find("from Order where userID=? and deliveryType=? and returnType=?",
                            userid, "closed", "closed");

        } catch (DataAccessException e) {
            throw new SystemException(EXCEPTIONMSG + e);

        }
    }

    /**
     * @Transactional public List paginationBooks(int start, int pageSize, String
     *                search, int columnNum, String sortOrder) {
     * 
     *                // TODO Auto-generated method stub String col =
     *                "bookTitle"; if (columnNum == 1) { col = "bookAuthor"; }
     *                if (columnNum == 2) { col = "bookCategory"; } // if
     *                (columnNum == 3) { // col = "availableCopies"; // } // if
     *                (columnNum == 4) { // col = "numTimesRented"; // } Session
     *                session = s.getCurrentSession(); Criteria criteria =
     *                session.createCriteria(Order.class);
     *                criteria.add(Restrictions .disjunction()
     *                .add(Restrictions.like("bookTitle", search,
     *                MatchMode.ANYWHERE))
     *                .add(Restrictions.like("bookCategory", search,
     *                MatchMode.ANYWHERE)) .add(Restrictions.like("bookAuthor",
     *                search, MatchMode.ANYWHERE))); if
     *                (sortOrder.equals("asc")) {
     *                criteria.addOrder(org.hibernate.criterion.Order.asc(col));
     *                } else {
     *                criteria.addOrder(org.hibernate.criterion.Order.desc
     *                (col)); } criteria.setFirstResult(start);
     *                criteria.setMaxResults(pageSize); return criteria.list();
     * 
     *                }
     * 
     *                public int getTotalRecordsOfRequest() {
     * 
     *                // TODO Auto-generated method stub // Session session =
     *                s.getCurrentSession(); // String hql =
     *                "select count(*) from Order"; // Query query =
     *                session.createQuery(hql); return 15;
     * 
     *                }
     */

}
