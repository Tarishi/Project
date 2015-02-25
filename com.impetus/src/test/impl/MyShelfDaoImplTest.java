package loginapp.dao.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;
import loginapp.dao.MyShelfDao;
import loginapp.exception.UserException;
import loginapp.model.BookDTO;
import loginapp.model.UserDTO;

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
public class MyShelfDaoImplTest {
	
	@Autowired
	MyShelfDao myshelf;
	
	@Autowired
	HibernateTemplate template=null;

	/*@Test
	public void testAddBookToShelf() {
		
	}*/

	@Test
	public void testViewshelf() throws UserException {
		Assert.assertNotNull(myshelf.viewshelf(116));
	}

	@Test
	public void testRemove() throws UserException {
		myshelf.remove(10018, 116);
		/*BookDTO book=new BookDTO();
		UserDTO user=new UserDTO();
		user.setId(116);
		book.setISBN(10018);
		Assert.assertNull(template.find("from MyShelf where book=? and user=?",book,user));*/
	}

}
