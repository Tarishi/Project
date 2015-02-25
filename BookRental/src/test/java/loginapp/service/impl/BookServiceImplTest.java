package loginapp.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.dao.AdminDao;
import loginapp.dao.impl.LoginDaoImplTest;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;
import loginapp.model.UserDTO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class BookServiceImplTest {
	
	private BookDAO bookDao;
	private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private BookServiceImpl bookservice = new BookServiceImpl();
	private List<BookDTO> books= new ArrayList<BookDTO>();
	private List<Order> order=new ArrayList<Order>();
	private List<UserDTO> u=new ArrayList<UserDTO>();
	Order o=new Order();
	BookDTO book=new BookDTO();
	UserDTO user=new UserDTO();

	@Before
	public void setUp() throws Exception {
		bookDao =mock(BookDAO.class);
	    bookservice.setBookDao(bookDao);
	    book.setISBN(54);
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNoOfCopies(5);
		books.add(book);
		
		user.setContact("1234567890");
	    user.setEmail("krati@gmail.com");
	    user.setLastName("jain");
	    user.setUserName("z");
	    user.setUserPassword("krati");
	    user.setPlanid(3);
	    user.setAddress("indore");
	    u.add(user);
		
	}
	
	/*@Test
	public void testAddBook() {
		when(bookDao.addBook(book)).thenReturn("success");
		String res=bookservice.addBook(book);
		assertEquals(res,"success");
	}
*/
	@Test
	public void testSearch() throws SystemException {
		when(bookDao.search("", "", "",22)).thenReturn(books);
		List<BookDTO> res=bookservice.search("", "", "",22);
		assertEquals(res,books);
	}

	/*@Test
	public void testAddBookid() throws UserException {
		when(bookDao.addBookid(book, bookid)).thenReturn(books);
		List<BookDTO> res=bookservice.search("", "", "");
		assertEquals(res,books);
	}
*/
	@Test
	public void testGetBook() throws SystemException {
		when(bookDao.getBook(25)).thenReturn(books);
		List<BookDTO> res=bookservice.getBook(25);
		assertEquals(res,books);
	}

	@Test
	public void testNoneSearch() throws SystemException {
		when(bookDao.noneSearch("", "", "")).thenReturn(books);
		List<BookDTO> res=bookservice.noneSearch("", "", "");
		assertEquals(res,books);
	}

	@Test
	public void testGetAddress() throws SystemException {
		when(bookDao.getAddress(25)).thenReturn(u);
		List<UserDTO> res=bookservice.getAddress(25);
		assertEquals(res,u);
	}

}
