package loginapp.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import loginapp.dao.BookDAO;
import loginapp.dao.GetUserDao;
import loginapp.dao.OrderDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.Order;
import loginapp.model.UserSubscribeDTO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class OrderServiceImplTest {
	
	private OrderDao orderdao;
	private BookDAO bookDao;
	private GetUserDao getuser;
	private List<BookDTO> books= new ArrayList<BookDTO>();
	private List<Order> orders= new ArrayList<Order>();
	private List<UserSubscribeDTO> userSub=new ArrayList<UserSubscribeDTO>();
	private OrderServiceImpl orderservice=new OrderServiceImpl();
	Order order=new Order();
	BookDTO book=new BookDTO();
	BookID b=new BookID();

	@Before
	public void setUp() throws Exception {
		orderdao=mock(OrderDao.class);
		bookDao=mock(BookDAO.class);
		getuser=mock(GetUserDao.class);
		orderservice.setOrderDao(orderdao);
		
		book.setISBN(25);
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNoOfCopies(5);
		b.setBookdto(book);
		
		books.add(book);
		
	}

	
	@Test
	public void testBooksheld() throws SystemException {
		when(orderdao.booksheld(25)).thenReturn(orders);
		List<Order> res=orderservice.booksheld(25);
		assertEquals(orders,res);
	}

	@Test
	public void testReturnBook() throws SystemException {
		when(orderdao.returnBook(25, 25)).thenReturn("success");
		String res=orderservice.returnBook(25, 25);
		assertEquals("success",res);
	}

	@Test
	public void testCancelBook() throws SystemException {
		when(orderdao.cancelBook(25, 25)).thenReturn("success");
		String res=orderservice.cancelBook(25, 25);
		assertEquals("success",res);
	}

	@Test
	public void testBooksRequested() throws SystemException {
		when(orderdao.booksRequested(25)).thenReturn(books);
		List res=orderservice.booksRequested(25);
		assertEquals(books,res);
	}

	@Test
	public void testCancelRequest() throws SystemException {
		when(orderdao.cancelRequest(25, 25)).thenReturn("success");
		String res=orderservice.cancelRequest(25, 25);
		assertEquals("success",res);
	}

}
