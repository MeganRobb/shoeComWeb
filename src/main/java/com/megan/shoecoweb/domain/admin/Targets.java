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
public class Targets implements Serializable {
    
    private double dailyTarg;
    private double monthTarg;
    private double yearTarg;

     private Targets(){
   
    }
      private Targets(Builder builder){
        
        dailyTarg=builder.dailyTarg;
        monthTarg=builder.monthTarg;
        yearTarg=builder.yearTarg;
    }
      
    public static class Builder{
        
        private double dailyTarg;
        private double monthTarg;
        private double yearTarg;
        
             
       public Builder (double dailyTarg){
         this.dailyTarg = dailyTarg;
     }
        
        public Builder dailyTarg(double value) {
            dailyTarg=value;
            return this;
        }
        
        public Builder monthTarg(double value) {
            monthTarg=value;
            return this;
        }
        
       public Builder yearTarg(double value) {
            yearTarg=value;
            return this;
        }
        public Targets build(){
            return new Targets(this);
        }
    }

    
    public double getDailyTarg() {
        return dailyTarg;
    }

    public double getMonthTarg() {
        return monthTarg;
    }
    
    public double getYearTarg() {
        return yearTarg;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.dailyTarg) ^ (Double.doubleToLongBits(this.dailyTarg) >>> 32));
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
        final Targets other = (Targets) obj;
        if (Double.doubleToLongBits(this.dailyTarg) != Double.doubleToLongBits(other.dailyTarg)) {
            return false;
        }
        return true;
    }

   

    
}