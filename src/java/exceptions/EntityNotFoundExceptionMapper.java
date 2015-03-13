package exceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import static oracle.jdbc.OracleDriver.isDebug;


@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(EntityNotFoundException ex) {
    boolean isDebug = false;//context.getInitParameter("debug").equals("true");
    ErrorMessage err = new ErrorMessage(ex,404,isDebug);
    err.getCode();
    err.getMessage();
    err.setDescription("Ikke fundet i databasen....");
    err.getDescription();
    err.getStackTrace();
    
    
    return Response.status(404)
    .entity(gson.toJson(err))
    .type(MediaType.APPLICATION_JSON).
    build();
    }


}
