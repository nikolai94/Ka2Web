package facade;

import DTO.PersonDTO;
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
                  
        List<PersonDTO> listDTO = new ArrayList<>();
        for (Person p : list) {
            
            // List<Phone> Phones, String zipcode, String city
            PersonDTO dto = new PersonDTO(p.getFirstName(), p.getLastName(), p.getAddress().getStreet(), p.getAddress().getAdditionalInfo(), p.getEmail(), p.getAddress().getCityinfo().getZipcode(), p.getAddress().getCityinfo().getCity());
            for (Hobby h : p.Gethobby()){ 
                 dto.addHobby(h.getName(), h.getDescription());
           }
            for(Phone phone : p.getPhones()) dto.addPhone(""+phone.getNumber(), phone.getDescription());
            
            listDTO.add(dto);
        }

           String json = new Gson().toJson(listDTO);

   
        em.close();
        return json;

    }

    public String getPersons(int zipCode) {
        em = emf.createEntityManager();
        String q = "SELECT Persons FROM Person WHERE name = :zipCode";

        List<Person> list = em.createQuery(q).getResultList();
        String json = new Gson().toJson(list);
        em.close();
        return json;
    }

    public Company getCompany(int cvr) {
        em = emf.createEntityManager();
        Company c = em.find(Company.class, cvr);
        em.close();
        return c;
    }
    
    public String getZip()
    {
        em = emf.createEntityManager();
        String q = "SELECT cityinfo.city,cityinfo.zipcode FROM Cityinfo cityinfo";
        List<Cityinfo> list = em.createQuery(q).getResultList();
        em.close();
        
         String jsonStr = gson.toJson(list);
         
         return jsonStr;
    }
    
    public String GetAllPersonsWhoLivesInZipcode(String zipcode)
    {
        em = emf.createEntityManager();
        String q = "select p from Person p where p.address.cityinfo.zipcode=:zipCode";
        List<Person> list = em.createQuery(q).setParameter("zipCode", zipcode).getResultList();
       
        List<PersonDTO> personDTO = new ArrayList<>();
        for (Person p : list) {
            PersonDTO DTO = new PersonDTO(p.getFirstName(),p.getLastName(), p.getAddress().getStreet(), p.getAddress().getAdditionalInfo(), p.getEmail(), p.getAddress().getCityinfo().getZipcode(), p.getAddress().getCityinfo().getCity() );
            
            for (Hobby h : p.Gethobby()) {
                DTO.addHobby(h.getName(), h.getDescription());
            }
            for (Phone phone : p.getPhones()) {
                DTO.addPhone(""+phone.getNumber(), phone.getDescription());
            }
        
            personDTO.add(DTO);
        }
        
        em.close();
        
        String json = gson.toJson(personDTO);
        return json;
    }
    
    
    public String getAllPersonsOnHobby(String HobbyName){
    
          em = emf.createEntityManager();
          
          String query = "select h from Person h WHERE h.Gethobby.name=:hobbyName";
          List<Person> list = em.createQuery(query).setParameter("hobbyName", HobbyName).getResultList();
          
          em.close();
          
        
        return list.toString();
    }
  
}
