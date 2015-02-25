package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.ViewUserDao;
import loginapp.exception.SystemException;

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
public class ViewUserDaoImplTest {
	
	@Autowired
	ViewUserDao viewuser;
	
	@Autowired
	HibernateTemplate template=null;
	
	@Test
	public void testSearchuser() throws SystemException {
		Assert.assertNotNull(viewuser.searchuser(" ", "Silver"));
	}

	@Test
	public void testViewall() throws SystemException {
		Assert.assertNotNull(viewuser.viewall());
	}

}
