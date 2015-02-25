package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import loginapp.dao.BookDAO;
import loginapp.dao.PlanReminderDao;
import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.model.UserDTO;
import loginapp.model.UserSubscribeDTO;

import org.apache.log4j.Logger;
import org.junit.Before;
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
public class PlanReminderDaoImplTest {

	private static Logger logger = Logger.getLogger(PlanReminderDaoImplTest.class);
	private PlanReminderDao plan;
	 @Autowired
	    public void setDao(PlanReminderDao plan) {
	        this.plan = plan;
	    }
	 	
	 @Autowired
	 HibernateTemplate template=null;
	
	 UserDTO user = new UserDTO();
	 UserSubscribeDTO userSub =new UserSubscribeDTO();
	

	@Test
	public void testGetUsersByWeeks() throws SystemException {
		logger.info("in test");
		Date endDate= new Date(); 
		Date newEndDate=null;
		Calendar c = Calendar.getInstance();        
		c.add(Calendar.DAY_OF_MONTH, 7);
		endDate= c.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString1 = format.format(endDate);
		try {
			newEndDate = new java.sql.Date(format.parse(dateString1)
					.getTime());

		} catch (ParseException e) {}
	 	List<UserSubscribeDTO> list=plan.getUsersByWeeks();
	 	
	 	if(!list.isEmpty())
	 	{
	 	assertEquals(newEndDate,list.get(0).getEndDate());
	 	}
	 	else
	 		assertEquals(list,plan.getUsersByWeeks());
	}

	@Test
	public void testGetUsersByDays() throws SystemException {
	logger.info("in test");
		Date endDate= new Date(); 
		Date newEndDate=null;
		Calendar c = Calendar.getInstance();        
		c.add(Calendar.DAY_OF_MONTH, 1);
		endDate= c.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString1 = format.format(endDate);
		try {
			newEndDate = new java.sql.Date(format.parse(dateString1)
					.getTime());

		} catch (ParseException e) {}
	 	List<UserSubscribeDTO> list=plan.getUsersByDays();
	 	
	 	if(!list.isEmpty())
	 	{
	 	assertEquals(newEndDate,list.get(0).getEndDate());
	 	}
	 	else
	 		assertEquals(list,plan.getUsersByDays());
	}

	@Test
	public void testGetUsersByMonth() throws SystemException {
		logger.info("in test");
		Date endDate= new Date(); 
		Date newEndDate=null;
		Calendar c = Calendar.getInstance();        
		c.add(Calendar.DAY_OF_MONTH, 30);
		endDate= c.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString1 = format.format(endDate);
		try {
			newEndDate = new java.sql.Date(format.parse(dateString1)
					.getTime());

		} catch (ParseException e) {}
	 	List<UserSubscribeDTO> list=plan.getUsersByMonth();
	 	
	 	if(!list.isEmpty())
	 	{
	 	assertEquals(newEndDate,list.get(0).getEndDate());
	 	}
	 	else
	 		assertEquals(list,plan.getUsersByMonth());
	}

}
