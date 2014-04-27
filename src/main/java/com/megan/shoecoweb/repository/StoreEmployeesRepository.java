/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.megan.shoecoweb.repository;

import com.megan.shoecoweb.domain.admin.StoreEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
/**
 *
 * @author Megan
 */
public interface StoreEmployeesRepository extends JpaRepository<StoreEmployees,Long> {
    
}
