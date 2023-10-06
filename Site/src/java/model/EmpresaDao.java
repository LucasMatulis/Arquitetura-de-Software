package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class EmpresaDao {
    private EntityManager manager;
    
    private void conectar(){
        manager = Persistence.createEntityManagerFactory("SitePU").createEntityManager();
    }
    
    public Usuario validarLogin(String u, String s){
        conectar();
        try{            
            TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.findByEmailSenha", Usuario.class);
            query.setParameter("emailFun", u);
            query.setParameter("senhaUsu", s);
            return query.getSingleResult();
        } catch(NoResultException x){
            return null;
        }   
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
    
    public <T>int excluir(String pk, Class<T> classe){
        conectar();
        try{
            T obj= manager.find(classe, pk);
            if(obj==null){
                return 2;
            }else{
                manager.getTransaction().begin();
                manager.remove(obj);
                manager.getTransaction().commit();
                return 1;
            }
        }catch(Exception erro){
            return 0;
        }
    }
}
