package loginapp.appconstant;

/**
 * @author tarishi.upadhyay
 * 
 */
public final class AppConstant {

    private AppConstant() {
    }

    public static final String LOGOUTMSG = "You have been successfully logged out.";
    public static final String LOGINERROR = "Invalid username or password.";
    public static final String PASSWORDERROR = "Enter your password";
    public static final String USERNAMEERROR = " Enter your userName";
    public static final String ERROR = "Something went wrong. Please contanct support team.";
    public static final String EXCEPTIONMSG = "Problem accessing database. Try again Later";
    public static final String CLOSED = "Closed";
    public static final String CANCELLED = "cancelled";
    public static final String PENDING = "pending";

    public static final String REQLOGINFORM = "/loginform";
    public static final String REQREGISTER = "/register";
    public static final String REQADMIN = "/admin";
    public static final String REQLOGOUT = "/logout";

    public static final String RESLOGINFORM = "loginform";
    public static final String RESREGISTER = "register";
    public static final String RESADMIN = "admin";
    public static final String RESLOGINSUCCESS = "loginsuccess";
    public static final String RESERROR = "error";
    public static final String EXCEPTION_SCHEDULER = "Exception in Calling Procedures";

    public static final String REQSAVE = "/save";
    public static final String REQADDBOOK = "/addbook";
    public static final String REQSAVEBOOK = "/savebook";
    public static final String REQSEARCH = "/search";
    public static final String REQSEARCHBOOK = "/searchbook";
    public static final String REQADDTOSHELF = "/addtoshelf";
    public static final String REQMYSHELF = "/myshelf";

    public static final String RESERRORPAGE = "Errorpage";
    public static final String RESHELLOPAGE = "Hellopage";
    public static final String RESADDBOOK = "AddBook";
    public static final String RESSEARCH = "Search";
    public static final String RESMYSHELF = "MyShelf";
}
