package loginapp.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.dao.LoginDAO;
import loginapp.dao.impl.LoginDaoImplTest;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.UserDTO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LoginServiceImplTest {
	
	private LoginDAO loginDao;
	private LoginServiceImpl loginservice = new LoginServiceImpl();
	private List<UserDTO> u=new ArrayList<UserDTO>();
	UserDTO user=new UserDTO();

	@Before
	public void setUp() throws SystemException {
		loginDao=mock(LoginDAO.class);
		loginservice.setLoginDAO(loginDao);
		
	}

	@Test
	public void testCheckLogin() throws SystemException {
		when(loginDao.checkLogin("tari", "tari")).thenReturn("success");
		String res=loginservice.checkLogin("tari", "tari");
		assertEquals(res,"success");
	}

	/*@Test
	public void testRegister() {
		when(loginDao.register(user)).thenReturn();
		String res=loginservice.checkLogin("tari", "tari");
		assertEquals(res,"success");
*/
	@Test
	public void testGetid() throws SystemException {
		when(loginDao.getid(user)).thenReturn(1);
		int res=loginservice.getid(user);
		assertEquals(res,1);
	}

}
