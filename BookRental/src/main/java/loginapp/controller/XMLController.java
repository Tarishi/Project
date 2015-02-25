package loginapp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.PlanDTO;
import loginapp.pdfgenerator.PdfGenerator;
import loginapp.service.EnrollNewPlanService;
import loginapp.service.PdfGenService;
import loginapp.service.XMLService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLController.
 */
@Controller
public class XMLController {

    /** The xmlservice. */
    @Autowired
    XMLService xmlservice;

    /** The pdf genservice. */
    @Autowired
    PdfGenService pdfGenservice;

    /** The view service. */
    @Autowired
    EnrollNewPlanService viewService;

    /** The reports. */
    private static List<Object[]> reports = null;
    /** The authors. */
    private static List<BookDTO> authors = null;

    /** The categories. */
    private static List<BookDTO> categories = null;

    /** The logger. */
    static Logger logger = Logger.getLogger(XMLController.class.getName());

    /**
     * Adds the subscriptoin xml.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/admin_addSubscriptionXML")
    public String addSubscriptoinXML(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws SystemException {
        List<PlanDTO> plansList = viewService.view();
        logger.info("Plans at Controller ->" + plansList);

        model.put("plansList", plansList);
        return "addSubscriptions";
    }

    /**
     * Adds the subscription.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param subscriptionXMLFile
     *            the subscription xml file
     * @return the model and view
     * @throws SystemException
     *             the system exception
     */
    @RequestMapping(value = "/admin_addSubscriptionXML1", method = RequestMethod.POST)
    public ModelAndView addSubscription(Model model,
            HttpServletRequest request,
            @RequestParam("file") MultipartFile subscriptionXMLFile)
            throws SystemException {

        ModelAndView modelAndView = new ModelAndView("admin");
        try {
            ServletContext context = request.getServletContext();
            String path = context.getRealPath("/");
            logger.info("XML PATH ->" + path);

            String res = null;

            String buttonClicked = request.getParameter("button");

            logger.info("button clicked is " + buttonClicked);

            if (buttonClicked.equalsIgnoreCase("Add or Update")) {

                res = xmlservice.addOrUpdateSubscription(path,
                        subscriptionXMLFile);
                if (res.equalsIgnoreCase("success")) {
                    modelAndView = new ModelAndView("admin", "msg",
                            "Plans Added Succesfully");
                } else {
                    modelAndView = new ModelAndView("admin", "msg",
                            "System Failure");
                }

            } else {

                if (buttonClicked.equalsIgnoreCase("Delete")) {

                    res = xmlservice.deleteSubscriptions(path,
                            subscriptionXMLFile);
                    if (res.equalsIgnoreCase("success")) {
                        modelAndView = new ModelAndView("/admin", "msg",
                                "Plans Deleted Succesfully");
                    } else {
                        modelAndView = new ModelAndView("/admin", "msg",
                                "Failure");
                    }

                }

            }

        } catch (Exception ex) {

        }

        List<PlanDTO> plansList = viewService.view();
        logger.info("Plans at Controller ->" + plansList);

        modelAndView.addObject("plansList", plansList);

        return modelAndView;

    }

    /**
     * Show reports.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the string
     */
    @RequestMapping(value = "admin_Reports", method = RequestMethod.GET)
    public String showReports(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {
        authors = pdfGenservice.getDistinctAuth();
        categories = pdfGenservice.getDistinctCat();

        model.put("Authors", authors);
        model.put("Categories", categories);

        return "reports";
    }

    /**
     * Gets the reports.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the reports
     */
    @RequestMapping(value = "admin_Reports", method = RequestMethod.POST)
    public String getReports(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {

        String author = request.getParameter("author");
        String category = request.getParameter("category");
        String from = request.getParameter("from");
        String to = request.getParameter("to");

        logger.info("Author" + author);
        logger.info("Category" + category);

        Date dateFrom = null;
        Date dateTo = null;

        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            df.setTimeZone(TimeZone.getDefault());
            Date date = new java.sql.Date(df.parse(from).getTime());

            DateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd",
                    Locale.ENGLISH);
            outputDateFormat.setTimeZone(TimeZone.getDefault());
            logger.info("Output date is = " + outputDateFormat.format(date));
            String dateString1 = outputDateFormat.format(date);
            dateFrom = new java.sql.Date(outputDateFormat.parse(dateString1)
                    .getTime());

            Date date1 = new java.sql.Date(df.parse(to).getTime());
            outputDateFormat.setTimeZone(TimeZone.getDefault());
            logger.info("Output date is = " + outputDateFormat.format(date1));
            String dateString2 = outputDateFormat.format(date1);
            dateTo = new java.sql.Date(outputDateFormat.parse(dateString2)
                    .getTime());

            reports = pdfGenservice.getReports(author, category, dateFrom,
                    dateTo);

        } catch (Exception e) {
            logger.info("Exception in converting date" + e);
            model.put("Msg", "");
            return "reports";
        }

        model.put("Authors", authors);
        model.put("Categories", categories);

        model.put("report", reports);

        return "reports";
    }

    /**
     * Generate pdf.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     */
    @RequestMapping(value = "admin_GeneratePdf.htm")
    public void generatePdf(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {

        PdfGenerator pdfGen = new PdfGenerator();

        response.setContentType("application/pdf");
        com.itextpdf.text.Document d = new com.itextpdf.text.Document(
                PageSize.LETTER.rotate());
        try {
            PdfWriter.getInstance(d, response.getOutputStream());
        } catch (DocumentException e) {
            
            logger.info("Document Exception" + e);
        } catch (IOException e) {
            
            logger.info("IO Exception" + e);
        }

        pdfGen.generate(reports, d);

    }

}
