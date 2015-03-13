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

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStreet() {
        return street;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public String getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return Phones;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "firstname=" + firstname + ", lastname=" + lastname + ", street=" + street + ", additionalinfo=" + additionalinfo + ", hobbies=" + hobbies + ", email=" + email + ", Phones=" + Phones + ", zipcode=" + zipcode + ", city=" + city + '}';
    }
    
    

   public void addHobby(String name, String description){
     hobbies.add(new Hobby(name, description));
   }
   
   public void addPhone(Integer number, String description){
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
       Integer number;
       String description;

        public Integer getNumber() {
            return number;
        }

        public String getDescription() {
            return description;
        }
       

        public Phone(Integer number, String description) {
            this.number = number;
            this.description = description;
        }
       
   }
  
    
    
    
    
}
