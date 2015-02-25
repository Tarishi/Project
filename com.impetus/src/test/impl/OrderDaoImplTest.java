package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import loginapp.dao.OrderDao;
import loginapp.exception.UserException;

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
public class OrderDaoImplTest {

	@Autowired
	OrderDao order;
	
	@Autowired
	HibernateTemplate template;
	
	
	/*@Test
	public void testFindPlan() {
		fail("Not yet implemented"); // TODO
	}
*/
	/*@Test
	public void testOrderBook() {
	  order.orderBook(order, status)
	}*/

	@Test
	public void testBooksheld() throws UserException {
		Assert.assertNotNull(order.booksheld(116));
	}

	/*@Test
	public void testReturnBook() {
		fail("Not yet implemented"); // TODO
	}
*/
	/*@Test
	public void testCancelBook() {
		fail("Not yet implemented"); // TODO
	}
*/
	@Test
	public void testBooksRequested() throws UserException {
		order.booksRequested(116);
	}
/*
	@Test
	public void testCancelRequest() {
		fail("Not yet implemented"); // TODO
	}*/

}
