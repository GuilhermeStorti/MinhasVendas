package com.curso.beans;

import com.curso.entidades.Avaria;
import com.curso.utils.JpaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;
import java.util.Map;

@ManagedBean(name = "cadastrarAvariasBean")
@ViewScoped

public class CadastrarAvariasBean {
       
        public CadastrarAvariasBean () {
        this.avaria = new Avaria();
        }
        
        private Avaria avaria;

   
        
        public void salvar(){
       
            try {
                EntityManager manager = JpaUtil.getManager();
                manager.getTransaction().begin();
                manager.merge(avaria);
                manager.getTransaction().commit();
                JpaUtil.closeManager(manager);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Avaria salva com sucesso"));
            }catch (Exception ex){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
            }finally {
                limpar();
            }
        }
        
        public void limpar(){
        this.avaria = new Avaria();
    }
        
         public Avaria getAvaria() {
        return avaria;
    }

    public void setAvaria(Avaria avaria) {
        this.avaria = avaria;
    }
        
        
      

    }
    
