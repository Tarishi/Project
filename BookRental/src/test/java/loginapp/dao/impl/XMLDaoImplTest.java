package loginapp.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import loginapp.dao.XMLDao;
import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;

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
public class XMLDaoImplTest {

    private XMLDao xml;
    @Autowired
    public void setDao(XMLDao xml)
    {
      this.xml=xml;    
    }
    
    @Test
    public void testAddOrUpdateSubscriptions() throws SystemException {
        List<PlanDTO> planlist=new ArrayList<PlanDTO>();
        xml.addOrUpdateSubscriptions(planlist);   

    }

}
