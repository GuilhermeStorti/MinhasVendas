package com.curso.beans;

import com.curso.entidades.Autenticador;

import com.curso.entidades.Funcionario;

import com.curso.utils.JpaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Map;


/**
 *
 * @author jefferson.cardoso
 */
@ManagedBean(name = "cadastroFuncionarioBean")
@ViewScoped
public class CadastroFuncionarioBean {

       


    public CadastroFuncionarioBean() {
          this.funcionario = new Funcionario();
    }
     private Funcionario funcionario;

    
   public void salvar(){
        
            try {
                EntityManager manager = JpaUtil.getManager();
                manager.getTransaction().begin();
                manager.merge(funcionario);
                manager.getTransaction().commit();
                JpaUtil.closeManager(manager);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Funcionario salvo com sucesso"));
            }catch (Exception ex){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
            }finally {
                limpar();
            }
        }
    
   
    public void limpar(){
        
        this.funcionario = new Funcionario();
    }
    
   public Funcionario getFuncionario()
   { 
       return funcionario;
   }
   public void setFuncionario (Funcionario funcionario)
   {
       this.funcionario = funcionario;
   }

    /*private boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
