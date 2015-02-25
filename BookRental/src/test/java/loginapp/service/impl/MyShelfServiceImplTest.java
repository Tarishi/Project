package loginapp.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import loginapp.dao.MyShelfDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.MyShelf;
import loginapp.model.UserDTO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class MyShelfServiceImplTest {

	private MyShelfDao myshelfDao;
	private MyShelfServiceImpl myshelfservice=new MyShelfServiceImpl();
	MyShelf myshelf=new MyShelf();
	BookDTO book=new BookDTO();
	UserDTO user=new UserDTO();
	
	
	@Before
	public void setUp() throws Exception {
		myshelfDao=mock(MyShelfDao.class);
		myshelfservice.setmyShelf(myshelfDao);
		myshelf.setBook(book);
		myshelf.setUser(user);
	}

	@Test
	public void testAddBookToShelf() throws SystemException {
		when(myshelfDao.addBookToShelf( 25, 25)).thenReturn("success");
		String res=myshelfservice.addBookToShelf( 25, 25);
		assertEquals(res,"success");
	}

	/*@Test
	public void testViewshelf() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}
*/
}
