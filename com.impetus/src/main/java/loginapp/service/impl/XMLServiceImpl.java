package loginapp.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import loginapp.dao.XMLDao;
import loginapp.exception.SystemException;
import loginapp.model.PlanDTO;
import loginapp.service.XMLService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLServiceImpl.
 */
@Service("XMLService")
public class XMLServiceImpl implements XMLService {

    /** The logger. */
    private static Logger logger = Logger.getLogger(XMLServiceImpl.class
            .getName());

    /** The xmldao. */
    @Autowired
    private XMLDao xmldao;

    /**
     * *************************************************************************
     * ******************************************.
     * 
     * @param path
     *            the path
     * @param subscriptionXMLFile
     *            the subscription xml file
     * @return the string
     * @throws SAXException 
     */

    public String addOrUpdateSubscription(String path,
            MultipartFile subscriptionXMLFile) throws SAXException {

        String res = " ";
        try {

            List<PlanDTO> planList = parsingHelper(path, subscriptionXMLFile);
            res = xmldao.addOrUpdateSubscriptions(planList);

        } catch (SystemException e) {

            logger.info("Exception in Adding Plans:" + e);
        }

        return res;
    }

    // *************************************************************************************************/

    // **********************************************************************************************************************/
    /**
     * Parsing helper.
     * 
     * @param path
     *            the path
     * @param subscriptionXMLFile
     *            the subscription xml file
     * @return the list
     * @throws SystemException 
     * @throws SAXException 
     */
    public List<PlanDTO> parsingHelper(String path,
            MultipartFile subscriptionXMLFile) throws SystemException, SAXException {

        String fileName = "";
        if (!subscriptionXMLFile.isEmpty()) {
            try {
                byte[] bytes = subscriptionXMLFile.getBytes();
                String name = subscriptionXMLFile.getOriginalFilename();

                String ext = name.substring(name.lastIndexOf("."),
                        name.length());
                fileName = "" + System.currentTimeMillis() + ext;

                File file = new File(path, "resources");
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(file, "subscriptions");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File temp = new File(file, fileName);
                logger.info("Path : " + temp);

                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(bytes);
                List<PlanDTO> planList = addSubscriptionDetailsFromXMLFile(temp);

                fos.close();
                file.delete();

                return planList;
            } catch (IOException ex) {
                throw new SystemException("Exception in XML service"+ ex);
            }
        }

        return null;
    }

    /**
     * *************************************************************************
     * *********************.
     * 
     * @param file
     *            the file
     * @return the list
     * @throws SystemException 
     * @throws IOException 
     * @throws SAXException 
     */

    public List<PlanDTO> addSubscriptionDetailsFromXMLFile(File file) throws SystemException, SAXException, IOException {
        List<PlanDTO> subscriptionList = new ArrayList<PlanDTO>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("subscription");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    PlanDTO plan = new PlanDTO();
                    Element eElement = (Element) nNode;

                    plan.setMaxBooks(Integer.parseInt(eElement
                            .getElementsByTagName("max_books").item(0)
                            .getTextContent()));
                    plan.setAmount(eElement.getElementsByTagName("amount")
                            .item(0).getTextContent());
                    plan.setDuration(Integer.parseInt(eElement
                            .getElementsByTagName("duration").item(0)
                            .getTextContent()));
                    plan.setPlanName(eElement.getElementsByTagName("plan_name")
                            .item(0).getTextContent());

                    subscriptionList.add(plan);

                }
            }

            return subscriptionList;
        } catch (ParserConfigurationException e) {

            throw new SystemException("Exception in XML service"+ e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see loginapp.service.XMLService#deleteSubscriptions(java.lang.String,
     * org.springframework.web.multipart.MultipartFile)
     */
    public String deleteSubscriptions(String path,
            MultipartFile subscriptionXMLFile) throws SAXException {
        // TODO Auto-generated method stub
        String res = "";
        try {

            List<PlanDTO> planList = parsingHelper(path, subscriptionXMLFile);
            res = xmldao.deleteSubscriptions(planList);

        } catch (SystemException e) {

            logger.info("Exception in Deleting Plans:" + e);
        }

        return res;
    }

}
