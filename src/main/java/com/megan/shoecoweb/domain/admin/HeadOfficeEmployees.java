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
public class HeadOfficeEmployees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long HOEmpID;
     private String HOEmpName;
     private String HOEmpDes;
     
     @Embedded
     
     private Salary salary;
     private HeadOfficeEmployees(){
   
    }
      private HeadOfficeEmployees(Builder builder){
       
        HOEmpID=builder.HOEmpID;
        HOEmpName=builder.HOEmpName;
        HOEmpDes=builder.HOEmpDes;
        salary=builder.salary;
        
    }
      
    public static class Builder{
       
        private Long HOEmpID;
        private String HOEmpName;
        private String HOEmpDes;
        private Salary salary;
        
        public Builder(String HOEmpName) {
            this.HOEmpName = HOEmpName;
        }
        
        
      public Builder HOEmpDes(String value) {
            HOEmpDes=value;
            return this;
        }
      public Builder salary(Salary value) {
            salary=value;
            return this;
        }
      
        public HeadOfficeEmployees build(){
            return new HeadOfficeEmployees(this);}
        
       
    }

    public Salary getSalary(){
        return salary;
   
    }
    public Long getHOEmpID() {
        return HOEmpID;
    }

    public String getHOEmpName() {
        return HOEmpName;
    }
    public String getHOEmpDes() {
        return HOEmpDes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.HOEmpID);
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
        final HeadOfficeEmployees other = (HeadOfficeEmployees) obj;
        if (!Objects.equals(this.HOEmpID, other.HOEmpID)) {
            return false;
        }
        return true;
    }
   
  
}
