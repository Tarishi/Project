package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;
import loginapp.dao.ViewPlanDao;
import loginapp.exception.UserException;
import loginapp.model.UserDTO;

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
public class ViewPlanDaoImplTest {

	@Autowired
	ViewPlanDao viewplan;
	
	@Autowired
	HibernateTemplate template=null;
	
	
	@Test
	public void testViewPlan() throws UserException {
		Assert.assertNotNull(viewplan.viewPlan(116));
	}

	@Test
	public void testViewProfile() throws UserException {
		Assert.assertNotNull(viewplan.viewProfile(116));
	}

	/*@Test
	public void testSaveprofile() throws UserException {
		UserDTO user=new UserDTO();
		    user.setContact("1234567890");
		    user.setEmail("krati@gmail.com");
		    user.setLastName("jain");
		    user.setUserName("z");
		    user.setUserPassword("krati");
		    user.setPlanid(3);
		    user.setAddress("indore");
			viewplan.saveprofile(user);
		
		
	}*/

	@Test
	public void testBookHistory() throws UserException {
		Assert.assertNotNull(viewplan.bookHistory(116));
	}

}
