/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.megan.shoecoweb.domain.admin;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Megan
 */
@Embeddable
public class Salary implements Serializable {
     
    private double empRate;
    private double empHour;
    private double salary;

    private Salary(){
   
    }
      private Salary(Builder builder){
        
        empRate=builder.empRate;
        empHour=builder.empHour;
        salary=builder.salary;
        
    }
      
    public static class Builder{
        
        private double empRate;
        private double empHour;
        private double salary;
        
         public Builder (double storeName){
         this.empRate = empRate;
     }
             
        
        
        public Builder empRate(double value) {
            empRate=value;
            return this;
        }
        
        public Builder empHour(double value) {
            empHour=value;
            return this;
        }
         public Builder salary(double value) {
            salary=value;
            return this;
        }
      
        public Salary build(){
            return new Salary(this);
        }
    }

    

    public void setEmpRate(double empRate) {
        this.empRate = empRate;
    }

    public double getEmpRate() {
        return empRate;
    }

    

    public double getEmpHour() {
        return empHour;
    }

    public void setEmpHour(double empHour) {
        this.empHour = empHour;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.empRate) ^ (Double.doubleToLongBits(this.empRate) >>> 32));
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
        final Salary other = (Salary) obj;
        if (Double.doubleToLongBits(this.empRate) != Double.doubleToLongBits(other.empRate)) {
            return false;
        }
        return true;
    }

   
    
}
