package loginapp.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.dao.GetUserDao;
import loginapp.dao.impl.LoginDaoImplTest;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.UserDTO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class GetUserServiceImplTest {

	private GetUserDao getuserDao;
	private GetUserServiceImpl getuserservice = new GetUserServiceImpl();
	private List<BookDTO> books= new ArrayList<BookDTO>();
	private List<Order> order=new ArrayList<Order>();
	private List<UserDTO> u=new ArrayList<UserDTO>();
	Order o=new Order();
	BookDTO book=new BookDTO();
	UserDTO user=new UserDTO();
	
	@Before
	public void setUp() throws Exception {
		getuserDao =mock(GetUserDao.class);
	    getuserservice.setuserDao(getuserDao);
	}

	@Test
	public void testGetUser() throws SystemException {
		when(getuserDao.getUser(25)).thenReturn(u);
		List<UserDTO> res=getuserservice.getUser(25);
		assertEquals(res,u);
		
	}

	/*@Test
	public void testUpdateAddress() throws UserException {
		when(getuserDao.updateAddress("indore", 23)).thenReturn(u);
		List<UserDTO> res=getuserservice.getUser(25);
		assertEquals(res,u);
		
	}
	
	@Test
	public void testGetUser() throws UserException {
		when(getuserDao.getUser(25)).thenReturn(u);
		List<UserDTO> res=getuserservice.getUser(25);
		assertEquals(res,u);
		
	}*/
}
