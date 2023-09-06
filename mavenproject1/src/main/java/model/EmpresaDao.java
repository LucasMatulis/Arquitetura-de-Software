/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class EmpresaDao {
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    private void conectar(){
        factory= Persistence.createEntityManagerFactory("mavenproject1-0");
        manager= factory.createEntityManager();
    }

    
}
