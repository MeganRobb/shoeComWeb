/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.megan.shoecoweb.domain.admin;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Megan
 */
@Embeddable
public class StoreAddress implements Serializable {
    
    private String address;
    private String landline;

    private StoreAddress(){
   
    }
      private StoreAddress(Builder builder){
       
        address=builder.address;
        landline=builder.landline;
        
    }
      
    public static class Builder{
       
        private String address;
        private String landline;
        
        public Builder(String address) {
            this.address = address;
        }
        
        public Builder landline(String value) {
            landline=value;
            return this;
        }
        
      
        public StoreAddress build(){
            return new StoreAddress(this);
        }
    }

    public String getAddress() {
        return address;
    }

    public String getLandLine() {
        return landline;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.landline);
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
        final StoreAddress other = (StoreAddress) obj;
        if (!Objects.equals(this.landline, other.landline)) {
            return false;
        }
        return true;
    }

    
    }
    
   

   

    
