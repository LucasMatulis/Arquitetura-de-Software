
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;


public class BancoDAO {
    
     private EntityManager manager;
    
    private void conectar(){
        manager = Persistence.createEntityManagerFactory("preAVA2PU").createEntityManager();
    }
    
    public <T> int cadastrar(T obj){
        conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
            return 1;
        }   catch (RollbackException erro){ 
            //duplicação de Chave Primaria
            return 2;
        }   catch(Exception erro){
            return 0;
        }
    }
    
    public <T>List listar(String queryNomeada, Class<T> classe){
        conectar();
        try{
            return manager.createNamedQuery(queryNomeada, classe).getResultList();
        } catch(NoResultException erro){
            return null;
        }
    }
    
}
