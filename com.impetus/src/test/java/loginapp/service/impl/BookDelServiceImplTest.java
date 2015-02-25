package loginapp.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.AdminDao;
import loginapp.dao.impl.AdminDaoImpl;
import loginapp.dao.impl.LoginDaoImplTest;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


public class BookDelServiceImplTest {
	
	private AdminDao bookdelDao;
	private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private AdminServiceImpl bookservice = new AdminServiceImpl();
	private List<BookDTO> books= new ArrayList<BookDTO>();
	private List<Order> order=new ArrayList<Order>();
	Order o=new Order();
	BookDTO book=new BookDTO();

	@Before
	public void setUp() throws Exception {
		bookdelDao =mock(AdminDao.class);
	    bookservice.setBookdelDao(bookdelDao);
	    book.setISBN(54);
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNoOfCopies(5);
		books.add(book);
		
		o.setUserId(25);
		order.add(o);
       
	}

	@Test
	public void testSearch() throws SystemException {
		logger.info("list:"+books);
		when(bookdelDao.search("java")).thenReturn(books);
		logger.info("list:");
		List<BookDTO> b=bookservice.search("java");
		logger.info("list:"+b);
		assertEquals(books, b);
		assertEquals(b.size(),books.size());
	}

	@Test
	public void testDelete() throws SystemException {
		when(bookdelDao.delete(54)).thenReturn("success");
		String res=bookservice.delete(54);
		assertEquals(res,"success");
	}
	
	@Test
    public void testSavebook() throws SystemException {
        when(bookdelDao.savebook(book)).thenReturn("success");
        String res=bookservice.savebook(book);
        assertEquals(res,"success");
    }

	@Test
	public void testUpdate() throws SystemException {
		when(bookdelDao.update(54)).thenReturn("success");
		String res=bookservice.update(54);
		assertEquals(res,"success");
	}

	@Test
	public void testGetbook() throws SystemException {
		when(bookdelDao.getbook(54)).thenReturn(books);
		List<BookDTO> res=bookservice.getbook(54);
		assertEquals(res,books);

	}

	

	@Test
	public void testDeliveryRequest() throws SystemException {
		when(bookdelDao.deliveryRequest()).thenReturn(order);
		List<Order> res=bookservice.deliveryRequest();
		assertEquals(res,order);
	}

	@Test
	public void testCloseDelivery() throws SystemException {
		when(bookdelDao.closeDelivery(24, 25)).thenReturn("success");
		String res=bookservice.closeDelivery(24, 25);
		assertEquals(res,"success");
	}

	@Test
	public void testReturnRequest() throws SystemException {
		when(bookdelDao.returnRequest()).thenReturn(order);
		List<Order> res=bookservice.returnRequest();
		assertEquals(res,order);
	}

	@Test
	public void testCloseReturn() throws SystemException {
		when(bookdelDao.closeReturn(24, 25)).thenReturn("success");
		String res=bookservice.closeReturn(24, 25);
		assertEquals(res,"success");
	}

}
