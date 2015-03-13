package facade;
import DTO.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Address;
import entity.Cityinfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import exceptions.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MyFacadeTest {
    MyFacade f = new MyFacade();
    Gson g = new Gson();
    public MyFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    public void testGetPersons_int() throws EntityNotFoundException {
       
       
            Person  p = g.fromJson(f.getPerson(2), Person.class);

            assertFalse("Fornavn MATCHER",  p.getFirstName().equals("bruger 1"));
            assertFalse("EFTERNAVN MATCHER ",  p.getLastName().equals("bruger 1 efternavn"));
            assertTrue("Fornavn MATCHER IKKE",  p.getFirstName().equals("bruger 2"));
            assertTrue("Efternavn MATCHER IKKE",  p.getLastName().equals("bruger 2 efternavn"));
     
    }
    
    
     @Test
        public void getPersonsZip() throws EntityNotFoundException {
        String id = "1600";
        
         String res = f.GetAllPersonsWhoLivesInZipcode(id);
         
         JsonArray o = new JsonParser().parse(res).getAsJsonArray();
         JsonElement oo = o.get(0);
         String fornavnFraFacade= oo.getAsJsonObject().get("firstname").getAsString();
         String efternavnFraFacade = oo.getAsJsonObject().get("lastname").getAsString();
         
         assertTrue("Sizen på zips passer ikke",o.size() == 1);
         assertTrue("fornavn matcher ikke", fornavnFraFacade.equals("bruger 2"));
         assertTrue("Lastname matcher ikke", efternavnFraFacade.equals("bruger 2 efternavn"));
 
      
    }
        
     @Test
     public void getPersons() throws EntityNotFoundException
     {
         String res = f.getPersons();
         
         JsonArray o = new JsonParser().parse(res).getAsJsonArray();
         
         assertTrue("ingen persons fundet", o.size() != 0);
     }

     @Test
     public void Getzip() throws EntityNotFoundException
     {
        String zipsJson = f.getZip();
        
        JsonArray o = new JsonParser().parse(zipsJson).getAsJsonArray();
         JsonElement oo = o.get(0);
         assertTrue("Zips str passer ikke", o.size() == 1352);  
     }
     
     @Test
     public void addPerson() throws EntityNotFoundException
     {
         PersonDTO personDto = new PersonDTO("Jonathan", "Champen", "kongevejen", "18 b", "bla@hej.dk", "2400", "Nordvest");
         
         String res1 = f.getPersons();
         JsonArray o1 = new JsonParser().parse(res1).getAsJsonArray();
         int size = o1.size();
         f.addPersonDto(personDto);
         
         String res2 = f.getPersons();
         JsonArray o2 = new JsonParser().parse(res2).getAsJsonArray();
         assertTrue("Størrelsen er ikke blevet større",size< o2.size() );
       
     }
  
    
   
    
}
