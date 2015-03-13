/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DTO.PersonDTO;
import com.google.gson.Gson;
import entity.*;
import exceptions.EntityNotFoundException;
import facade.MyFacade;
import javax.persistence.Persistence;

/**
 *
 * @author jones
 */
public class Ka2 {
    public static void main(String[] args) throws EntityNotFoundException {
        
        Persistence.generateSchema("Ka2NewPU", null);
        MyFacade f = new MyFacade();
//        
//        Person p = new Person("a@b.dk","test1", "test2");
//        //InfoEntity info = new InfoEntity("mailTest");
//        Phone phone = new Phone(11, "testNubmer");
//        
//        Address add = new Address("test1", "tesst1");
//        Cityinfo cityInfo = new Cityinfo("1111", "testby");
//        
//        Hobby hobby = new Hobby("Fodbold","Arsenal er bedst");
//        
//        f.addPerson(p, phone, add, cityInfo, hobby);
        
        
        //System.out.println(f.getZip());

   
        //System.out.println("testGetPersonOnId:"+  f.getPerson(1) );
        
        
        
        PersonDTO p = new PersonDTO("firstname11", "lastname22", "street", "aditionalinfo", "email", "1600","city");
       /* 
        p.addPhone(111111, "blejaijiad");
        p.addHobby("addhobby1", "aksdokaosd");
        p.addPhone(222222, "blejaijiad222");
        p.addHobby("addhobby2", "aksdokaosd");
        */
      //  f.addPersonDto(p);
        
        
       // f.delPerson(601);
        
        
        
        
        //Gson gson = new Gson();
        
       // String test = gson.toJson(p);
        
     //   PersonDTO po = gson.fromJson(test, PersonDTO.class);
        
        //f.getAllPersonsOnHobby("hobby 2");
        
        
        
    //  System.out.println("person " +f.GetAllPersonsWhoLivesInZipcode("1600"));
   


    //System.out.println(f.getPersons());
      // System.out.println(f.getZip() + " all zips");
        //System.out.println("Person"+  p2);
        //System.out.println(p2.getAddress().toString());
    }
}
