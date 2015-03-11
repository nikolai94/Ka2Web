/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import entity.*;
import facade.MyFacade;

/**
 *
 * @author jones
 */
public class Ka2 {
    public static void main(String[] args) {
        MyFacade f = new MyFacade();
        
        Person p = new Person("a@b.dk","test1", "test2");
        //InfoEntity info = new InfoEntity("mailTest");
        Phone phone = new Phone(11, "testNubmer");
        
        Address add = new Address("test1", "tesst1");
        Cityinfo cityInfo = new Cityinfo("1111", "testby");
        
        Hobby hobby = new Hobby("Fodbold","Arsenal er bedst");
        
        f.addPerson(p, phone, add, cityInfo, hobby);
        
         p = new Person("ats@b.dk","tsest1", "tesst2");
        //InfoEntity info = new InfoEntity("mailTest");
         phone = new Phone(11, "testNsubmer");
        
         add = new Address("tesst1", "tesssst1");
         cityInfo = new Cityinfo("1111", "testby");
        
         hobby = new Hobby("Fodbold","Arsenal er de bedste");
        
        f.addPerson(p, phone, add, cityInfo, hobby);
      //  f.getPerson(1);
        
        System.out.println(f.getPersons());
        //System.out.println("Person"+  p2);
        //System.out.println(p2.getAddress().toString());
    }
}
