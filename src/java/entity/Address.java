/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jones
 */
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String AdditionalInfo;
    
    //City info
    
    private Cityinfo cityinfo;
    
    //
    @OneToMany(mappedBy = "address")
    private List<InfoEntity> infoEntitys;

    public Address(String street, String AdditionalInfo) {
        this.street = street;
        this.AdditionalInfo = AdditionalInfo;
    }
    
    
    public Address()
    {
    }
    
    public void addInfoEntity(InfoEntity infoEntity){
        infoEntitys.add(infoEntity);
    }
    
    public void addCityInfo(Cityinfo CityinfoNew){
     
        cityinfo = CityinfoNew;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    public void setAdditionalInfo(String AdditionalInfo) {
        this.AdditionalInfo = AdditionalInfo;
    }
    
    public Cityinfo getCityinfo (){
        return cityinfo;
    }
    
    
    
    public Integer getId() {
        return id;
    }
    
}
