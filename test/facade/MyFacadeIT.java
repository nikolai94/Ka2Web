/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import entity.Person;
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
public class MyFacadeIT {
    
    public MyFacadeIT() {
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
        Person expResult = null;
        Person result = instance.getPerson(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class MyFacade.
     */
    @Test
    public void testGetPersons_0args() {
        System.out.println("getPersons");
        MyFacade instance = new MyFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class MyFacade.
     */
    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zipCode = 0;
        MyFacade instance = new MyFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(zipCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompany method, of class MyFacade.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        int cvr = 0;
        MyFacade instance = new MyFacade();
        Company expResult = null;
        Company result = instance.getCompany(cvr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
