/**
 * 
 */
package loginapp.exception;

/**
 * @author tarishi.upadhyay
 *
 */
public class DBException extends Exception{
	private static final long serialVersionUID = 1L;
	public DBException(String message){
		super(message);
	}
}