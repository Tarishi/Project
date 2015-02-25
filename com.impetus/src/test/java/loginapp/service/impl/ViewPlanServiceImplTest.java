package loginapp.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.GetUserDao;
import loginapp.dao.ViewPlanDao;
import loginapp.exception.SystemException;
import loginapp.model.Order;
import loginapp.model.UserSubscribeDTO;

import org.junit.Before;
import org.junit.Test;

public class ViewPlanServiceImplTest {

	private ViewPlanDao viewplandao;
	private ViewPlanServiceImpl viewplanservice=new ViewPlanServiceImpl();
	private List<Order> orders= new ArrayList<Order>();
	private List<UserSubscribeDTO> userSub=new ArrayList<UserSubscribeDTO>();
	
	@Before
	public void setUp() throws Exception {
		
		viewplandao=mock(ViewPlanDao.class);
		viewplanservice.setviewplanDao(viewplandao);
	}

	@Test
	public void testViewPlan() throws SystemException {
		when(viewplandao.viewPlan(25)).thenReturn(userSub);
		List<UserSubscribeDTO> res=viewplanservice.viewPlan(25);
		assertEquals(userSub,res);
	}

	@Test
	public void testViewProfile() throws SystemException {
		when(viewplandao.viewProfile(25)).thenReturn(userSub);
		List<UserSubscribeDTO> res=viewplanservice.viewProfile(25);
		assertEquals(userSub,res);

	}

	/*@Test
	public void testSaveProfile() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testBookHistory() throws SystemException {
		when(viewplandao.bookHistory(25)).thenReturn(orders);
		List<Order> res=viewplanservice.bookHistory(25);
		assertEquals(userSub,res);

	}

}
