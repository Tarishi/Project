package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.BookDAO;
import loginapp.dao.BookDelDao;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" )
@Transactional
public class BookDaoImplTest extends TestCase{

	private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private BookDAO bookdao;
	 @Autowired
	    public void setDao(BookDAO bookdao) {
	        this.bookdao = bookdao;
	    }
	 	
	 @Autowired
	 HibernateTemplate template=null;
	
	@Test
	public void testAddBook() throws UserException {
		BookDTO book=new BookDTO();
		book.setBookAuthor("chetan bhagat");
		book.setBookCategory("fiction");
		book.setBookDescription("fiction book");
		book.setBookPublisher("techmax");
		book.setBooksOrdered(4);
		book.setBookTitle("3 mistake");
		book.setNo_of_copies(5);
		bookdao.addBook(book);
		Assert.assertNotNull(template.findByExample(book));
	}

	@Test
	public void testSearch() throws UserException {
		Assert.assertNotNull(bookdao.search("", "", "technical"));
	}

	@Test
	public void testNoneSearch() throws UserException {
		Assert.assertNotNull(bookdao.noneSearch("", "", "technical"));
	}

	/*@Test
	public void testAddBookid() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public void testGetBook() throws UserException {
		Assert.assertNotNull(bookdao.getBook(10018));
	}

	@Test
	public void testGetAddress() throws UserException {
		Assert.assertNotNull(bookdao.getAddress(116));
	}

}
