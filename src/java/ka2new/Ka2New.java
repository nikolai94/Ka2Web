/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka2new;

import entity.Cityinfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author nikolai
 */
public class Ka2New {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      Persistence.generateSchema("Ka2NewPU", null);
    
    
    }
    
}
