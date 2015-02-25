package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;
import loginapp.dao.GetUserDao;
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

public class GetUserDaoImplTest {

	@Autowired
	GetUserDao getuserdao;
	
	@Autowired
	HibernateTemplate template=null;
	
	@Test
	public void testGetUser() throws UserException {
		Assert.assertNotNull(getuserdao.getUser(116));
	}

	@Test
	public void testUpdateAddress() throws UserException {
		getuserdao.updateAddress("indore", 116);
		List<UserDTO> list= (List<UserDTO>) template.find(" from UserDTO where id=?",116);
		Assert.assertEquals("indore", list.get(0).getAddress());
	}

}
