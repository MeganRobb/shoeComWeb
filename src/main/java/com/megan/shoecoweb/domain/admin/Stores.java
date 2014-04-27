/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.megan.shoecoweb.domain.admin;

import com.megan.shoecoweb.domain.admin.StoreAddress;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/** *
 * @author Megan
 */
@Entity
public class Stores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long store_id;
    //@Column(unique = true)
    private String storeName;
    private int staffAmt;
    
    @Embedded
    private StoreAddress storeAdd;
   
    private Targets target;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private List<StoreEmployees> storeEmp;
   
    
    
    
private Stores (Builder builder){
    store_id= builder.store_id;
    storeName= builder.storeName;
    staffAmt= builder.staffAmt;
    storeAdd= builder.storeAdd;
    target= builder.target;
    storeEmp=builder.storeEmp;
}
private Stores(){
}

    
 public static class Builder{
     private Long store_id;
     private String storeName;
     private int staffAmt;
     private StoreAddress storeAdd;
     private Targets target;
     private List<StoreEmployees> storeEmp;
     
     public Builder (String storeName){
         this.storeName = storeName;
     }

     public Builder store_id(Long value){
         store_id = value;
         return this;
     }
      public Builder staffAmt(int value){
         staffAmt = value;
         return this;
     }
       public Builder storeAdd(StoreAddress value){
         storeAdd = value;
         return this;
     }
       public Builder target(Targets value){
         target = value;
         return this;
     }
      public Builder storeEmp(List<StoreEmployees> value){
            storeEmp = value;
            return this;
        }
     public Builder store(Stores store){
         store_id=store.getStore_id();
         storeName=store.getStoreName();
         staffAmt=store.getStaffAmt();
         storeAdd=store.getStoreAdd();
         target=store.getTarget();
         storeEmp=store.getStoreEmp();
         return this;
     }
         
     public Stores build(){
         return new Stores(this);}
     
     }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<StoreEmployees> getStoreEmp() {
        return storeEmp;
    }

    public Long getStore_id() {
        return store_id;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getStaffAmt() {
        return staffAmt;
    }

    public StoreAddress getStoreAdd() {
        return storeAdd;
    }

    public Targets getTarget() {
        return target;
    }

        
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (store_id != null ? store_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.store_id == null && other.store_id != null) || (this.store_id != null && !this.store_id.equals(other.store_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.megan.shoecoweb.domain.Stores[ store_id=" + store_id + " ]";
    }
    
}
