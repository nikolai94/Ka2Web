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



}
