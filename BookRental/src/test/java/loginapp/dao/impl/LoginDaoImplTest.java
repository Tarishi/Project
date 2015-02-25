package loginapp.dao.impl;


import static org.junit.Assert.*;

import java.util.List;

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
import loginapp.exception.SystemException;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

/**
 * @author tarishi.upadhyay
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/dispatcherServlet-servlet.xml" )

@Transactional
public class LoginDaoImplTest {
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
	
	logger.info("in test");
    user.setContact("1234567890");
    user.setEmail("krati@gmail.com");
    user.setLastName("jain");
    user.setUserName("z");
    user.setUserPassword("z");
    user.setPlanid(3);
    user.setAddress("indore");
    dao.register(user);
    String name=user.getUserName();
    logger.info(name);
 	
 	userSub.setUser(user);
 	assertNotNull(template.find("select userName from UserDTO where userName=?",user.getUserName()));
 	

 		
	} 

@Test(expected=SystemException.class)
public void testRegisterException() throws SystemException
{
    UserDTO userdto = new UserDTO();
    dao.register(userdto);
}

@Test
public void testCheckLogin() throws Exception {
	String status= dao.checkLogin(user.getUserName(), user.getUserPassword());
	assertEquals("normalUser",status);
	
}

@Test
public void testGetid() throws SystemException
{
	user.setContact("1234567890");
    user.setEmail("tarishiupadhyay@gmail.com");
    user.setLastName("jain");
    user.setUserName("tari");
    user.setUserPassword("tari");
    user.setPlanid(3);
    user.setAddress("indore");
	
	assertEquals(116,dao.getid(user));
	
}
/*@Test(expected=SystemException.class)
public void testGetidException() throws SystemException
{
    UserDTO userdto = new UserDTO();
    dao.getid(userdto);
}
*/
}
	
