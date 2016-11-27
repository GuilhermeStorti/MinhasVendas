package com.curso.beans;

import com.curso.entidades.Avaria;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jefferson.cardoso 26/11
 */
@ViewScoped
@ManagedBean(name = "gerenciarAvariasBean")

public class GerenciarAvariasBean {
    
        private List<Avaria> avarias;
        private Avaria avaria;
        private boolean exibir = false;

   
 
    public GerenciarAvariasBean() {
        
        this.avarias = new ArrayList<>();
        this.avaria = new Avaria();
       
    }
    
    @PostConstruct
    public void init(){
        carregarLista();
    }
     public void esconder(){
        this.exibir = false;
    }
     
     public void editar(Avaria avaria){
        this.avaria = avaria;
        this.exibir = true;
    }
     
     public void voltar(){
        this.exibir = false;
     }
    
     public void salvarEdicao(){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        Avaria antigo = manager.find(Avaria.class, avaria.getIdAvaria());
        antigo = avaria;
        manager.merge(antigo);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
        this.exibir = false;
    }
     
      public void excluir(Avaria avaria){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        avaria = manager.find(Avaria.class,avaria.getIdAvaria());
        manager.remove(avaria);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
    }
      
       public void carregarLista(){
     
            EntityManager manager = JpaUtil.getManager();
            avarias = manager.createQuery("from Avaria", Avaria.class).getResultList();
            JpaUtil.closeManager(manager);
            } 
       

    public boolean isExibir() {
        return exibir;
    }

    public void setExibir(boolean exibir) {
        this.exibir = exibir;
    }
    
    public Avaria getAvaria() {
        return avaria;
    }

    public void setAvaria(Avaria avaria) {
        this.avaria = avaria;
    }
    
    public List<Avaria> getAvarias() {
        return avarias;
    }

    public void setAvarias(List<Avaria> avarias) {
        this.avarias = avarias;
    }
       
       
     
}
