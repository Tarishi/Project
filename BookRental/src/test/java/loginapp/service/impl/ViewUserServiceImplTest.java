package loginapp.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.ViewPlanDao;
import loginapp.dao.ViewUserDao;
import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserSubscribeDTO;

import org.junit.Before;
import org.junit.Test;

public class ViewUserServiceImplTest {
	
	private ViewUserDao viewuserdao;
	private ViewUserServiceImpl viewuserervice=new ViewUserServiceImpl();
	private List<Order> orders= new ArrayList<Order>();
	private List<UserSubscribeDTO> userSub=new ArrayList<UserSubscribeDTO>();

	@Before
	public void setUp() throws Exception {
		viewuserdao=mock(ViewUserDao.class);
		viewuserervice.setviewplanDao(viewuserdao);
	}

	@Test
	public void testSearchuser() throws SystemException {
		when(viewuserdao.searchuser(" ", " ")).thenReturn(userSub);
		List<UserSubscribeDTO> res=viewuserervice.searchuser("", "");
		assertEquals(userSub,res);
	}

	@Test
	public void testViewall() throws SystemException {
		when(viewuserdao.viewall()).thenReturn(userSub);
		List<UserSubscribeDTO> res=viewuserervice.viewall();
		assertEquals(userSub,res);
	}

}
