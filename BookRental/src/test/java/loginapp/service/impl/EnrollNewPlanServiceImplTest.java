package loginapp.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.dao.AdminDao;
import loginapp.dao.EnrollNewPlanDao;
import loginapp.dao.impl.LoginDaoImplTest;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.PlanDTO;
import loginapp.model.UserDTO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class EnrollNewPlanServiceImplTest {

	private EnrollNewPlanDao enrolldao;
	private EnrollNewPlanServiceImpl enrollservice = new EnrollNewPlanServiceImpl();
	private List<PlanDTO> plan= new ArrayList<PlanDTO>();
	private List<Order> order=new ArrayList<Order>();
	Order o=new Order();
	BookDTO book=new BookDTO();
	
	@Before
	public void setUp() throws Exception {
		enrolldao =mock(EnrollNewPlanDao.class);
	    enrollservice.enrolldao(enrolldao);
	}

	@Test
	public void testView() throws SystemException {
		when(enrolldao.view()).thenReturn(plan);
		List<PlanDTO> res=enrolldao.view();
		assertEquals(res,plan);
	}

}
