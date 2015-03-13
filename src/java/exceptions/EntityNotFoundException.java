package exceptions;
/**
 *
 * @author petersodborgchristensen
 */
 
import java.io.Serializable;
import javax.ws.rs.core.Response;
 
public class EntityNotFoundException extends Exception implements Serializable
{

    public EntityNotFoundException(String msg)   {
        super(msg);
    }

    public EntityNotFoundException(Response.Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
