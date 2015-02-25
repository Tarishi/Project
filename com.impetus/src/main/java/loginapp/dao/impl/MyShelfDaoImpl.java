package loginapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.MyShelfDao;
import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.BookID;
import loginapp.model.MyShelf;
import loginapp.model.Order;
import loginapp.model.UserDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class MyShelfDaoImpl.
 */
@Repository("MyShelfDao")
public class MyShelfDaoImpl implements MyShelfDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    @Autowired
    private static Logger logger = Logger.getLogger(MyShelfDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.MyShelfDao#addBookToShelf(int, int)
     */
    @Transactional(readOnly = false)
    public String addBookToShelf(int iSBN, int uid) throws SystemException {
        try {
            List<MyShelf> list = (List<MyShelf>) template.find(
                    "from MyShelf where user.id=? and book.iSBN=?", uid, iSBN);
            if (list.isEmpty()) {

                MyShelf myShelf = new MyShelf();
                BookID bookid = new BookID();
                BookDTO bookdto = new BookDTO();
                bookdto.setISBN(iSBN);
                bookid.setBookdto(bookdto);
                myShelf.setBook(bookdto);
                UserDTO userdto = new UserDTO();
                userdto.setId(uid);
                myShelf.setUser(userdto);
                template.save(myShelf);
                return "added ";
            } else {
                return "already in Shelf";
            }
        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.MyShelfDao#viewshelf(int)
     */
    public List<MyShelf> viewshelf(int userid) throws SystemException {
        try {
            MyShelf myshelf = new MyShelf();
            UserDTO user = new UserDTO();
            user.setId(userid);
            myshelf.setUser(user);
            logger.info(template.find("from MyShelf m where m.user.id=?",
                    userid).size());
            List<MyShelf> result=(List<MyShelf>) template.find(
                    "from MyShelf m where m.user.id=?", userid);
            List<String> ordered=new ArrayList();
            for(MyShelf shelf:result)
            {
                int isbn=shelf.getBook().getISBN();
                
                List<Order> list=(List<Order>) template.find("from Order where book.bookdto.iSBN=? and userID=? and deliveryType=? and returnType!=?",isbn,userid,"Closed","Closed");
                
                logger.info(list+" "+list.size());
                if(list.isEmpty())
                {
                    ordered.add("order");
                    
                }
                else
                {
                    ordered.add("ordered");
                    
                }
            }
            return result;

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.MyShelfDao#remove(int, int)
     */
    @Transactional(readOnly = false)
    public void remove(int iSBN, int userId) throws SystemException {
        // TODO Auto-generated method stub
        try {
            MyShelf myshelf = new MyShelf();
            UserDTO user = new UserDTO();
            user.setId(userId);
            myshelf.setUser(user);
            BookDTO bookdto = new BookDTO();
            bookdto.setISBN(iSBN);
            myshelf.setBook(bookdto);
            List<MyShelf> myshelf1 = (List<MyShelf>) template.find(
                    "from MyShelf where user.id=? and book.iSBN=?", userId,
                    iSBN);
            for (MyShelf m : myshelf1) {
                template.delete(m);
            }

        } catch (DataAccessException e) {
            throw new SystemException(
                    "Problem accessing database. Try again Later" + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.dao.MyShelfDao#isAdded(java.lang.Integer, int)
     */
    public String isAdded(Integer isbn, int uid) {
        List<MyShelf> list = (List<MyShelf>) template.find(
                "from MyShelf where user.id=? and book.iSBN=?", uid, isbn);
        if (list.isEmpty()) {
            return "not added";
        } else {

            return "already in Shelf";
        }

    }

    public List<String> isOrdered(int userid) {
        MyShelf myshelf = new MyShelf();
        UserDTO user = new UserDTO();
        user.setId(userid);
        myshelf.setUser(user);
        logger.info(template.find("from MyShelf m where m.user.id=?",
                userid).size());
        List<MyShelf> result=(List<MyShelf>) template.find(
                "from MyShelf m where m.user.id=?", userid);
        List<String> ordered=new ArrayList();
        for(MyShelf shelf:result)
        {
            int isbn=shelf.getBook().getISBN();
            
            List<Order> list=(List<Order>) template.find("from Order where book.bookdto.iSBN=? and userID=? and (deliveryType=? or deliveryType=?) and returnType!=?",isbn,userid,"Closed","pending","Closed");
            
            logger.info(list+" "+list.size());
            if(list.isEmpty())
            {
                ordered.add("order");
                
            }
            else
            {
                ordered.add("ordered");
                
            }
        }
        
        return ordered;
    }

}
