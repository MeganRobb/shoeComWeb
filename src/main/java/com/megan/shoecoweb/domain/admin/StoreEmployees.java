/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.megan.shoecoweb.domain.admin;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Megan
 */
@Entity
public class StoreEmployees implements Serializable{
    
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long storeEmpID;
     private String storeEmpName;
     private String storeEmpDes;
     
     @Embedded
     
     private Salary salary;
     private StoreEmployees(){
   
    }
      private StoreEmployees(Builder builder){
       
        storeEmpID=builder.storeEmpID;
        storeEmpName=builder.storeEmpName;
        storeEmpDes=builder.storeEmpDes;
        salary=builder.salary;
        
    }
      
    public static class Builder{
       
        private Long storeEmpID;
        private String storeEmpName;
        private String storeEmpDes;
        private Salary salary;
        
        public Builder(String storeEmpName) {
            this.storeEmpName = storeEmpName;
        }
        
        
      public Builder storeEmpDes(String value) {
            storeEmpDes=value;
            return this;
        }
      public Builder salary(Salary value) {
            salary=value;
            return this;
        }
      
        public StoreEmployees build(){
            return new StoreEmployees(this);}
        
       
    }

    public Salary getSalary(){
        return salary;
   
    }
    public Long getStoreEmpID() {
        return storeEmpID;
    }

    public String getStoreEmpName() {
        return storeEmpName;
    }
    public String getStoreEmpDes() {
        return storeEmpDes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.storeEmpID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StoreEmployees other = (StoreEmployees) obj;
        if (!Objects.equals(this.storeEmpID, other.storeEmpID)) {
            return false;
        }
        return true;
    }
    
}
