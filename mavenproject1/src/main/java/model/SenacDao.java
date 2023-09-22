/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * @author marcos.vcrosa
 */
public class SenacDao {
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    private void conectar(){
        factory = Persistence.createEntityManagerFactory("WebApplication1PU");
        manager = factory.createEntityManager();
    }
    
    public Usuario validarLogin(String u, String s) {
        conectar();
        try {
            TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.findByEmailSenha", Usuario.class);
            query.setParameter("funcionarioEmailfuncionario", u);
            query.setParameter("senhausuario", s);
            return query.getSingleResult();
        }
        catch (NoResultException x) {
            return null;
        }
    }
    
    public int salvarDepartamento(Departamento departamento){
        conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(departamento);
            manager.getTransaction().commit();
            return 1;
        }
        catch(Exception erro){
            return 0;
        }
    }
    
}