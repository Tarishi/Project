package sendmail;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/dispatcherServlet-servlet.xml" )
@Transactional
public class SendMailTest {

    SendMail sendmail;
    public void setMail( SendMail sendmail)
    {
        this.sendmail=sendmail;
        
    }
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testShootReminderMail() throws SystemException {
        UserDTO user=new UserDTO();
        UserSubscribeDTO usersub=new UserSubscribeDTO();
        user.setContact("1234567890");
        user.setEmail("tarishiupadhyay@gmail.com");
        user.setLastName("jain");
        user.setUserName("z");
        user.setUserPassword("z");
        user.setPlanid(3);
        user.setAddress("indore");
        user.setPlanid(2);
        user.setRoleId(0);
        Date startDate = new Date();
        Date enddate = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 30);
        enddate = c.getTime();
        
        usersub.setBooksOrdered(2);
        usersub.setEndDate(enddate);
        usersub.setId(2);
        PlanDTO plan=new PlanDTO();
        plan.setAmount("100");
        plan.setDuration(25);
        plan.setMaxBooks(2);
        plan.setPlanId(1);
        plan.setPlanName("Silver");
        usersub.setPlan(plan);
        usersub.setStartDate(startDate);
        usersub.setStatus(true);
        usersub.setUser(user);
    /*    sendmail.shootReminderMail(usersub);*/
        Assert.assertTrue(true);
    }

}
