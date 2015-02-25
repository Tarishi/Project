package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import loginapp.dao.BookDAO;
import loginapp.dao.AdminDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;

import org.apache.log4j.Logger;
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
public class BookDaoImplTest{

    private static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
    private BookDAO bookdao;
    @Autowired
    public void setDao(BookDAO bookdao) {
        this.bookdao = bookdao;
    }

    @Autowired
    HibernateTemplate template=null;

    @Test
    public void testAddBook() throws SystemException {
        BookDTO book=new BookDTO();
        book.setBookAuthor("chetan bhagat");
        book.setBookCategory("fiction");
        book.setBookDescription("fiction book");
        book.setBookPublisher("techmax");
        book.setBooksOrdered(4);
        book.setBookTitle("3 mistake");
        book.setNoOfCopies(5);
        bookdao.addBook(book);
        Assert.assertNotNull(template.findByExample(book));
    }

    @Test(expected= SystemException.class)
    public void testAddBookException() throws SystemException
    {
        BookDTO book=new BookDTO();
        bookdao.addBook(book);

    }
    @Test
    public void testSearch() throws SystemException {
        
        Assert.assertNotNull(bookdao.search("", "", "technical",25));
        
     }

    @Test
    public void testNoneSearch() throws SystemException {
        Assert.assertNotNull(bookdao.noneSearch("", "", "technical"));
    }

    @Test
    public void testAddBookid() throws SystemException {
        BookDTO book=new BookDTO();
        book.setBookAuthor("chetan bhagat");
        book.setBookCategory("fiction");
        book.setBookDescription("fiction book");
        book.setBookPublisher("techmax");
        book.setBooksOrdered(4);
        book.setBookTitle("3 mistake");
        book.setNoOfCopies(2);
        template.save(book);
        BookID bookid=new BookID();
        bookdao.addBookid(book, bookid);
    }
    @Test(expected= SystemException.class)
    public void testAddBookidException() throws SystemException
    {
        BookDTO book=new BookDTO();
        BookID bookid=new BookID();
        bookdao.addBookid(book,bookid);

    }
    @Test
    public void testGetBook() throws SystemException {
        Assert.assertNotNull(bookdao.getBook(10018));
    }
/*
    @Test(expected= SystemException.class)
    public void testGetBookException() throws SystemException
    {

        bookdao.getBook(-1);
    }*/

    @Test
    public void testGetAddress() throws SystemException {
        Assert.assertNotNull(bookdao.getAddress(116));
    }

   /* @Test(expected= SystemException.class)
    public void testGetAddressException() throws SystemException
    {

        bookdao.getAddress(-1);
    }
*/
    @Test
    public void testRecommend()
    {
        Assert.assertNotNull(bookdao.recommend(116));


    }

    @Test
    public void testRecommendException()
    {
        Assert.assertNotNull(bookdao.recommend(-1));


    }

    @Test
	public void testIsAvailable() throws SystemException
	{
        BookDTO book=new BookDTO();
        List<BookDTO> books= new ArrayList<BookDTO>();
        book.setISBN(54);
        book.setBookAuthor("chetan bhagat");
        book.setBookCategory("fiction");
        book.setBookDescription("fiction book");
        book.setBookPublisher("techmax");
        book.setBooksOrdered(4);
        book.setBookTitle("3 mistake");
        book.setNoOfCopies(5);
        books.add(book);
		Assert.assertNotNull(bookdao.isAvailable(books));


	}
   
}
