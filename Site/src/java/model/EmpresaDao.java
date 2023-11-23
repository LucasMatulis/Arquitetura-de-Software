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
    
    public enum SaveResult{
        SUCESSO, CHAVEDUPLICADA, NAOCADASTRADO,ERRO
    }
    
    public <T> SaveResult cadastrar(T obj){
        conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
            return SaveResult.SUCESSO;
        }   catch (RollbackException erro){ 
            //duplicação de Chave Primaria
            return SaveResult.CHAVEDUPLICADA;
        }   catch(Exception erro){
            return SaveResult.ERRO;
        }
    }
    
    public <T> List listar(String quertNomeada, Class<T> classe){
        conectar();
        try {
            return manager.createNamedQuery(quertNomeada, classe).getResultList();
        } catch (NoResultException erro) {
            return null;
        }
    }
    
    //pk = chave primaria
    public <T> SaveResult excluir(String pk, Class<T> classe) {
        conectar();
        try {
            T obj = manager.find(classe, pk);
            if (obj == null) { //Não encontrou o departamento
                return SaveResult.NAOCADASTRADO;
            } else { //Encontrou o departamento
                manager.getTransaction().begin();
                manager.remove(obj); //Exclui o departamento
                manager.getTransaction().commit();
                return SaveResult.SUCESSO;
            }
        } catch (Exception erro) {
            return SaveResult.ERRO;
        }
    }
    
    public <T>T buscar(Class<T> classe, String pk){
        conectar();        
        try{
            return manager.find(classe, pk);
        } catch(Exception erro){
            return null;
        }
    }
    
    public int alterar(String i, String n, String t){
        conectar();
        try{
        Departamento dep = manager.find(Departamento.class, i);
        dep.setNomeDep(n);
        dep.setTelefoneDep(t);
        manager.getTransaction().begin();
        manager.merge(dep);
        manager.getTransaction().commit();
        return 1;
        } catch (Exception erro){
            return 0;
        }    
    }
}