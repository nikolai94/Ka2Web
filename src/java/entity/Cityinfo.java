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
import javax.persistence.OneToMany;

/**
 *
 * @author jones
 */
@Entity
public class Cityinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String zipcode;
    private String city;
    
    @OneToMany(mappedBy = "cityinfo", fetch=FetchType.EAGER)
    private List<Address> address;

    public Cityinfo(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }
    
    public void addAddress (Address addNew)
    {
        address.add(addNew);
    }        
    
    public Cityinfo()
    {
        
    }
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cityinfo{" + "zipcode=" + zipcode + ", city=" + city + ", address=" + address + '}';
    }
    
    

   
}
