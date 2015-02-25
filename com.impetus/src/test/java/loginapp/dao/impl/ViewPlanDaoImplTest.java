package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.ViewPlanDao;
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/dispatcherServlet-servlet.xml" )

@Transactional
public class ViewPlanDaoImplTest {

	@Autowired
	ViewPlanDao viewplan;
	
	@Autowired
	HibernateTemplate template=null;
	
	UserDTO user = new UserDTO();
	UserSubscribeDTO userSub =new UserSubscribeDTO();
	 
	@Test
	public void testViewPlan() throws SystemException {
		Assert.assertNotNull(viewplan.viewPlan(116));
	}

	@Test
	public void testViewProfile() throws SystemException {
		Assert.assertNotNull(viewplan.viewProfile(116));
	}

	@Test
	public void testSaveprofile() throws SystemException {
		user.setContact("1234567890");
	    user.setEmail("krati@gmail.com");
	    user.setLastName("jain");
	    user.setUserName("z");
	    user.setUserPassword("krati");
	    user.setPlanid(3);
	    user.setAddress("indore");
	    viewplan.saveprofile(user);
	    assertNotNull(template.find("select userName from UserDTO where userName=?",user.getUserName()));
		
	}

	
	
	@Test
	public void testBookHistory() throws SystemException {
		Assert.assertNotNull(viewplan.bookHistory(116));
	}

}
