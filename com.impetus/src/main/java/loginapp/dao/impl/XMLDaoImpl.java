package loginapp.dao.impl;

import java.util.List;

import loginapp.dao.XMLDao;
import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLDaoImpl.
 */
@Repository("XMLDao")
public class XMLDaoImpl implements XMLDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.XMLDao#addOrUpdateSubscriptions(java.util.List)
     */
    @Transactional(readOnly = false)
    public String addOrUpdateSubscriptions(List<PlanDTO> plans)
            throws SystemException {
        // TODO Auto-generated method stub

        try {
            for (PlanDTO p : plans) {

                List<PlanDTO> plan = (List<PlanDTO>) template.find(
                        "from PlanDTO where plan_name=?", p.getPlanName());
                if (plan != null) {
                    for (PlanDTO plandto : plan) {
                        plandto.setAmount(p.getAmount());
                        plandto.setDuration(p.getDuration());
                        plandto.setMaxBooks(p.getMaxBooks());
                        template.saveOrUpdate(plandto);
                    }
                } else {

                    template.saveOrUpdate(p);

                }
            }
            return "Success";
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.XMLDao#deleteSubscriptions(java.util.List)
     */
    public String deleteSubscriptions(List<PlanDTO> planList) {
        // TODO Auto-generated method stub
        return null;
    }

}
