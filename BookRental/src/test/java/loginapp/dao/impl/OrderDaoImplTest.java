package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.OrderDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.Order;

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
public class OrderDaoImplTest {

	@Autowired
	OrderDao orderdao;
	
	@Autowired
	HibernateTemplate template;
	
	
	
	@Test
	public void testOrderBook() throws SystemException {
				
		Order order = new Order();
		BookDTO bookdto=new BookDTO();
		bookdto.setISBN(10023);
		int bookid = 0;
		List<BookDTO> book=(List<BookDTO>) template.find("from BookDTO b where b.iSBN=?",10023);
		BookID b =new BookID();
		for(BookDTO bookdt:book)
		{
		 Set<BookID> books = bookdt.getBookid();
         bookid = 0;
		
         for (Iterator<BookID> iterator = books.iterator(); iterator.hasNext();)
 		{
 				 b =iterator.next(); 
 				System.out.println(b);

         
				if(b.getAvailabilty())
				{
					bookid=b.getBookID();
					break;
				}
				
		}				
		}
		order.setBook(b);
		order.setUserId(117);
		
	    String status="ordered";
	  
	    int ISBN=10023;
	    String result=orderdao.orderBook(order, status, ISBN,b);
	    assertEquals("ordered", result);
	}

	/*@Test(expected=SystemException.class)
	public void testOrderBookException() throws SystemException
	{
	    Order order = new Order();
	    BookID b =new BookID();
	    orderdao.orderBook(order, "", -1,b);
	    
	}*/
	
	@Test
	public void testBooksheld() throws SystemException {
		Assert.assertNotNull(orderdao.booksheld(117));
	}

	/*@Test(expected=SystemException.class)
	public void testBooksHeldException() throws SystemException
	{
	    orderdao.booksheld(-1);
	    
	}*/
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testReturnBookException() throws SystemException {
		String result=orderdao.returnBook(117, 10032);
		assertEquals("return request generated", result);
	}

	@Test
    public void testReturnBook() throws SystemException {
        String result=orderdao.returnBook(116, 10030);
        assertEquals("return request generated", result);
    }
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testCancelBookException() throws SystemException {
		String result= orderdao.cancelBook(117, 10032);
		assertEquals("cancelled", result);
	}
    @Test
    public void testCancelBook() throws SystemException {
        String result= orderdao.cancelBook(203, 10044);
        assertEquals("cancelled", result);
    }
	@Test
	public void testBooksRequested() throws SystemException {
		orderdao.booksRequested(117);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testCancelRequestException() throws SystemException {
		String result= orderdao.cancelRequest(117, 10032);
		assertEquals("cancelled", result);
		
	}
	@Test
    public void testCancelRequest() throws SystemException {
        String result= orderdao.cancelRequest(204, 10044);
        assertEquals("cancelled", result);
        
    }
}
