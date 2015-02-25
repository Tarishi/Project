package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.MyShelfDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.MyShelf;
import loginapp.model.UserDTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/dispatcherServlet-servlet.xml" )
@Transactional
public class MyShelfDaoImplTest {
	
	@Autowired
	MyShelfDao myshelf;
	
	@Autowired
	HibernateTemplate template=null;

	@Test
	public void testAddBookToShelf() throws SystemException {
		MyShelf m=new MyShelf();
		BookDTO book=new BookDTO();
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNoOfCopies(5);
		
		UserDTO user = new UserDTO();
		user.setContact("1234567890");
	    user.setEmail("krati@gmail.com");
	    user.setLastName("jain");
	    user.setUserName("z");
	    user.setUserPassword("krati");
	    user.setPlanid(3);
	    user.setAddress("indore");
	    
		m.setBook(book);
		m.setUser(user);
		
		assertEquals("already in Shelf",myshelf.addBookToShelf(10031, 117));
		}

	@Test
	public void testViewshelf() throws SystemException {
		Assert.assertNotNull(myshelf.viewshelf(116));
	}

	@Test
	public void testRemove() throws SystemException {
		myshelf.remove(10018, 116);
		List<MyShelf> list=new ArrayList<MyShelf>();
		List<MyShelf>res=(List<MyShelf>) template.find("from MyShelf where user.id=? and book.iSBN=?", 116,10018);
		assertEquals(list,res);
	}
	
	@Test
	public void testIsAdded()
	{
	   
	    Assert.assertNotNull( "added", myshelf.isAdded(10018, 116));
	    assertNotNull("already in Shelf",myshelf.isAdded(10023, 116) );
	   
	}
	

}
