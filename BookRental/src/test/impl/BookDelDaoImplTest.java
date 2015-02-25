/**
 * 
 */
package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.BookDelDao;
import loginapp.dao.LoginDAO;
import loginapp.exception.UserException;
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
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" )
@Transactional

public class BookDelDaoImplTest extends TestCase {

	private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private BookDelDao bookdeldao;
	 @Autowired
	    public void setDao(BookDelDao bookdeldao) {
	        this.bookdeldao = bookdeldao;
	    }
	 	
	 @Autowired
	 HibernateTemplate template=null;
	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#search(java.lang.String)}.
	 * @throws UserException 
	 */
	@Test
	public void testSearch() throws UserException {
		Assert.assertNotNull(bookdeldao.search("java"));
		
	}

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#delete(int)}.
	 * @throws UserException 
	 */
	@Test
	public void testDelete() throws UserException {
		Assert.assertEquals("success", bookdeldao.delete(10018));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#Update(int)}.
	 */
	/*@Test
	public void testUpdate() {
		
	}*/

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#getbook(int)}.
	 * @throws UserException 
	 */
	@Test
	public void testGetbook() throws UserException {
		Assert.assertNotNull(bookdeldao.getbook(10018));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#savebbok(loginapp.model.BookDTO)}.
	 * @throws UserException 
	 */
	@Test
	public void testSavebook() throws UserException {
		BookDTO book=new BookDTO();
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNo_of_copies(5);
		bookdeldao.savebook(book);
		Assert.assertNotNull(template.findByExample(book));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#deliveryRequest()}.
	 */
	@Test
	public void testDeliveryRequest() {
		Assert.assertNotNull(template.find("from Order where deliveryType=?)","pending"));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#CloseDelivery(int, int)}.
	 * @throws UserException 
	 */
	/*@Test
	public void testCloseDelivery() throws UserException {
		Assert.assertNotNull(bookdeldao.CloseDelivery(65, 116));
	}*/

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#returnRequest()}.
	 */
	@Test
	public void testReturnRequest() {
		
		Assert.assertNotNull(template.find("from Order where returnType=?)","pending"));
	}

	/**
	 * Test method for {@link loginapp.dao.impl.BookDelDaoImpl#CloseReturn(int, int)}.
	 * @throws UserException 
	 */
/*	@Test
	public void testCloseReturn() throws UserException {
		Assert.assertEquals("closed", bookdeldao.CloseReturn(65, 116));
	}*/

}
