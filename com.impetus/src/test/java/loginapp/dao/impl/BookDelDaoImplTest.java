/**
 * 
 */
package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.AdminDao;
import loginapp.dao.LoginDAO;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tarishi.upadhyay
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/dispatcherServlet-servlet.xml" )
@Transactional

public class BookDelDaoImplTest  {

	private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private AdminDao bookdeldao;
	 @Autowired
	    public void setDao(AdminDao bookdeldao) {
	        this.bookdeldao = bookdeldao;
	    }
	 	
	 @Autowired
	 HibernateTemplate template=null;
	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#search(java.lang.String)}.
	 * @throws SystemException 
	 */
	@Test
	public void testSearch() throws SystemException {
		Assert.assertNotNull(bookdeldao.search("java"));
		
	}

	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#delete(int)}.
	 * @throws SystemException 
	 */
	@Test
	public void testDelete() throws SystemException {
		Assert.assertEquals("success", bookdeldao.delete(10018));
	}

	
	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#getbook(int)}.
	 * @throws SystemException 
	 */
	@Test
	public void testGetbook() throws SystemException {
		Assert.assertNotNull(bookdeldao.getbook(10018));
	}

	
	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#savebbok(loginapp.model.BookDTO)}.
	 * @throws SystemException 
	 */
	@Test
	public void testSavebook() throws SystemException {
		BookDTO book=new BookDTO();
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNoOfCopies(5);
		bookdeldao.savebook(book);
		Assert.assertNotNull(template.findByExample(book));
	}

	@Test(expected=SystemException.class)
	public void testSavebookException() throws SystemException
	{
	    BookDTO book=new BookDTO();
	    bookdeldao.savebook(book);
	}
	
	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#deliveryRequest()}.
	 */
	@Test
	public void testDeliveryRequest() {
		Assert.assertNotNull(template.find("from Order where deliveryType=?)","pending"));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#closeDelivery(int, int)}.
	 * @throws SystemException 
	 */
	@Test
	public void testCloseDelivery() throws SystemException {
		Assert.assertEquals("Closed",bookdeldao.closeDelivery(10032, 116));
	}

	
	
	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#returnRequest()}.
	 */
	@Test
	public void testReturnRequest() {
		
		Assert.assertNotNull(template.find("from Order where returnType=?)","pending"));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.AdminDaoImpl#closeReturn(int, int)}.
	 * @throws SystemException 
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testCloseReturnException() throws SystemException {
		Assert.assertEquals("Closed", bookdeldao.closeReturn(10032, 117));
	}
	
	@Test
    public void testCloseReturn() throws SystemException {
        Assert.assertEquals("Closed", bookdeldao.closeReturn(10044, 204));
    }

}
