/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entity.Hobby;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikolai
 */
public class PersonDTO {
    private String firstname;
    private String lastname;
    private String street;
    private String additionalinfo;
    private List<Hobby> hobbies = new ArrayList<>();
    private String email;
    private List<Phone> Phones = new ArrayList<>();
    private String zipcode;
    private String city;

    public PersonDTO(String firstname, String lastname, String street, String additionalinfo, String email, String zipcode, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.additionalinfo = additionalinfo;
        this.email = email;
        this.zipcode = zipcode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "firstname=" + firstname + ", lastname=" + lastname + ", street=" + street + ", additionalinfo=" + additionalinfo + ", hobbies=" + hobbies + ", email=" + email + ", Phones=" + Phones + ", zipcode=" + zipcode + ", city=" + city + '}';
    }
    
    

   public void addHobby(String name, String description){
     hobbies.add(new Hobby(name, description));
   }
   
   public void addPhone(String number, String description){
       Phones.add(new Phone(number, description));
   }
    
   public static class Hobby {
       String name;
       String description;

        public Hobby(String name, String description) {
            this.name = name;
            this.description = description;
        }
       
   }
   
   public static class Phone {
       String number;
       String description;

        public Phone(String number, String description) {
            this.number = number;
            this.description = description;
        }
       
   }
  
    
    
    
    
}
