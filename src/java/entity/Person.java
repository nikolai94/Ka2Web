/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author nikolai
 */
@Entity
public class Person extends InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
  

    
    @ManyToMany(mappedBy = "listPerson",fetch=FetchType.EAGER)
    private List<Hobby> hobbys;
   
    
    public Person() {
    }

    public Person(String email, String firstName, String lastName) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void addHobby(Hobby hob)
    {
        hobbys.add(hob);
    }
    
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    

     @Override
    public String toString() {
        return "Person{" + "id=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbys=" + hobbys + '}';
    }

    
    
}
