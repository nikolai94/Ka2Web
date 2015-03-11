package facade;
import entity.Address;
import entity.Cityinfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author petersodborgchristensen
 */
public class MyFacadeTest {
    
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

    /**
     * Test of getPerson method, of class MyFacade.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");

        int id = 0;
        MyFacade instance = new MyFacade();
        //String instance = new MyFacade().getPerson(id);

        String expResult = "";
        String result = instance.getPerson(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of addPerson method, of class MyFacade.
     * Test passed
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person person = new Person();
        Phone phone = new Phone();
        Address address = new Address();
        Cityinfo cityInfo = new Cityinfo();
        Hobby hobby = new Hobby();
        MyFacade instance = new MyFacade();
        instance.addPerson(person, phone, address, cityInfo, hobby);
    }

    /**
     * Test of getPersons method, of class MyFacade.
     * Test passed
     */
    @Test
    public void testGetPersons_0args() {
        System.out.println("getPersons");
        MyFacade instance = new MyFacade();
        String expResult = "";
        String result = instance.getPersons();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPersons method, of class MyFacade.
     */
    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zipCode = 0;
        MyFacade instance = new MyFacade();
        List<Person> expResult = new MyFacade().getPersons(zipCode);
        List<Person> result = instance.getPersons(zipCode);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCompany method, of class MyFacade.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        int cvr = 0;
        MyFacade instance = new MyFacade();
        String expResult = new Company().getCvr();
        Company result = instance.getCompany(cvr);
        assertEquals(expResult, result);

    }
    
}
