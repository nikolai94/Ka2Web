package facade;

import entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;

/**
 *
 * @author petersodborgchristensen
 */
public class MyFacade {

    EntityManagerFactory emf;
    EntityManager em;
 Gson gson;
    public MyFacade() {
        emf = Persistence.createEntityManagerFactory("Ka2NewPU");
        gson = new Gson();
    }

    public String getPerson(int id) {
        em = emf.createEntityManager();
        
        Person p2 = em.find(Person.class, id);
    
         //p2.getAddress().toString();
         
      
        
        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", p2.getFirstName());
        jo.addProperty("lastName", p2.getLastName());
        jo.addProperty("email", p2.getEmail());
        jo.addProperty("street", p2.getAddress().getStreet());
        jo.addProperty("additionalInfo", p2.getAddress().getAdditionalInfo());
        jo.addProperty("zipCode", p2.getAddress().getCityinfo().getZipcode());
        jo.addProperty("city", p2.getAddress().getCityinfo().getCity());
        JsonArray phones = new JsonArray();
        JsonObject phone1 = new JsonObject();
        for (int i = 0; i < p2.getPhones().size(); i++) {  
            phone1.addProperty("number", p2.getPhones().get(i).getNumber());
            phone1.addProperty("description", p2.getPhones().get(i).getDescription());
        }
        phones.add(phone1);
        jo.add("phones", phones);
        String jsonStr = gson.toJson(jo);
       // System.out.println("StringJson: "+jsonStr);
 
         return jsonStr;
       
       
    }

    public void addPerson(Person person, Phone phone, Address address, Cityinfo cityInfo,Hobby hobby) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            phone.AddPhoneToInfoEntity(person);
            person.addPhone(phone);

            person.addAddress(address);
            

            address.addCityInfo(cityInfo);
            
            hobby.addPerson(person);
            
            em.persist(person);
           
            em.persist(phone);
            
            em.persist(address);
            
            em.persist(cityInfo);
            
            em.persist(hobby);
            
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();

    }

    public String getPersons() {
 
        em = emf.createEntityManager();
        String q = "select infoentity from Person infoentity ";

        List<Person> list = em.createQuery(q).getResultList();
       

           // String json = new Gson().toJson(list);
            System.out.println(list);
      
       

        // gson.toJson(list);
   
        em.close();
        return "";

    }

    public List<Person> getPersons(int zipCode) {
        em = emf.createEntityManager();
        String q = "SELECT Persons FROM Person WHERE name = :zipCode";

        List<Person> list = em.createQuery(q).getResultList();
        em.close();
        return list;
    }

    public Company getCompany(int cvr) {
        em = emf.createEntityManager();
        Company c = em.find(Company.class, cvr);
        em.close();
        return c;
    }

}
