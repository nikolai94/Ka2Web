/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author nikolai
 */
@Entity
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    
    @OneToMany(mappedBy = "infoEntity")
    List <Phone> Phones = new  ArrayList();
    
    @ManyToOne
    private Address address; 
    
    public Address getAddress()
    {
        return address;
    }
    
    public InfoEntity() {
    }

    public InfoEntity(String email) {
        this.email = email;
    }
    
   
    
    public String getEmail() {
        return email;
    }
    public void addAddress(Address add){
        address = add;
    }
    
    public void addPhone(Phone p)
    {
        Phones.add(p);
    }
    
    public List<Phone> getPhones(){
        return Phones;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    
}
