package loginapp.dao.impl;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.LoginDAO;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

/**
 * @author tarishi.upadhyay
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" )

@Transactional
public class LoginDaoImplTest extends TestCase {
	private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private LoginDAO dao;
	 @Autowired
	    public void setDao(LoginDAO dao) {
	        this.dao = dao;
	    }
	 	
	 @Autowired
	 HibernateTemplate template=null;
	 
	 UserDTO user = new UserDTO();
	 UserSubscribeDTO userSub =new UserSubscribeDTO();
 /**
 * @throws Exception
 */
@Test
	public void testregister() throws Exception {
	
	
    user.setContact("1234567890");
    user.setEmail("krati@gmail.com");
    user.setLastName("jain");
    user.setUserName("z");
    user.setUserPassword("krati");
    user.setPlanid(3);
    user.setAddress("indore");
    dao.register(user);
    String name=user.getUserName();
    System.out.println(name);
 	String a=dao.checkLogin(user.getUserName(), user.getUserPassword());
 	System.out.println(a);
 	
 	userSub.setUser(user);
 	Assert.assertNotNull(template.find("select userName from UserDTO where userName=?",user.getUserName()));
 	

 		
	} 

@Test
public void testCheckLogin() throws Exception {
	String status= dao.checkLogin(user.getUserName(), user.getUserPassword());
	Assert.assertEquals("normalUser",status);
	
}
}
	
