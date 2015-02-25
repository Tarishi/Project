package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import loginapp.dao.PdfGenDAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/dispatcherServlet-servlet.xml" )

@Transactional
public class PdfGenDAOImplTest {

    private PdfGenDAO pdf;
    @Autowired
    public void setDAO(PdfGenDAO pdf)
    {
        
        this.pdf=pdf;
    }
  

    @Test
    public void testGetReports() {
        String author="All";
        String category="All";
        Date from = new Date();
        Date to = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 30);

        to= c.getTime();
        Assert.assertNotNull(pdf.getReports(author, category, from, to));
        
    }

    @Test
    public void testGetDistinctAuth() {
        Assert.assertNotNull(pdf.getDistinctAuth());
    }

    @Test
    public void testGetDistinctCat() {
        Assert.assertNotNull(pdf.getDistinctCat());
    }

}
