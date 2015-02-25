package loginapp.service;

import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

public interface XMLService {

    String addOrUpdateSubscription(String path,
            MultipartFile subscriptionXMLFile) throws SAXException;

    String deleteSubscriptions(String path, MultipartFile subscriptionXMLFile) throws SAXException;

}
