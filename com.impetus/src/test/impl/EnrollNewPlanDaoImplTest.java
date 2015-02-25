package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.EnrollNewPlanDao;
import loginapp.exception.UserException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" )
@Transactional

public class EnrollNewPlanDaoImplTest extends TestCase{
	
	@Autowired
	EnrollNewPlanDao enroll;
	
	@Autowired
	HibernateTemplate template=null;
	

	@Test
	public void testView() throws UserException {
		Assert.assertNotNull(enroll.view());
	}

	@Test
	public void testUpdatePlan() throws UserException {
		enroll.updatePlan(3, 116);
		Assert.assertNotNull(template.find("from UserSubscribeDTO where id=?",116));
	}

}
