package Rest;
import DTO.PersonDTO;
import com.google.gson.Gson;
import entity.*;
import exceptions.EntityNotFoundException;
import facade.MyFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author petersodborgchristensen
 */
@Path("")
public class GenericResource {

    @Context
    private UriInfo context;

    MyFacade facade = new MyFacade();
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    //list af zip codes
   //færdig
    @GET
    @Path("getzip")
    @Produces("application/json")
    public String getJsonZip() throws EntityNotFoundException {
        return facade.getZip();
    }

    //get alle persons som bor i en given by
    //færdig
    @GET
    @Path("getpersononzip/{zip}")
    @Produces("application/json")
    public String getJsonGetPersonOnZip(@PathParam("zip") String zip)throws EntityNotFoundException {

        return facade.GetAllPersonsWhoLivesInZipcode(zip);

  
    }
    //personer med en given hobby
    //færdig
    @GET
    @Path("complete")
    @Produces("application/json")
    public String getJsonGetAllPersons() throws EntityNotFoundException {
         return facade.getPersons();
    }
    
    //person med en given id
    //færdig
    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public String getJsonGetPersonOnId(@PathParam("id") int id) throws EntityNotFoundException {
         return facade.getPerson(id);
    }

   
    //opret person
    @POST
    @Path("opretperson")
    @Produces("application/json")
    public String opretPerson(String str) {
       
       Gson gson = new Gson();
       PersonDTO dto = gson.fromJson(str, PersonDTO.class);

       return dto + ""; 
    }
    
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  public void AddPerson(String jsonPerson) throws EntityNotFoundException  {
      
     Gson g = new Gson();
     facade.addPersonDto(g.fromJson(jsonPerson, PersonDTO.class));
    
  }
    
}
