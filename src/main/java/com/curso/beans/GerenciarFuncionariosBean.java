package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.entidades.Funcionario;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jefferson.cardoso
 */
@SessionScoped
@ManagedBean(name = "gerenciarFuncionariosBean")
public class GerenciarFuncionariosBean {
    private List<Funcionario> funcionarios;
    private Funcionario funcionario;
    private char tipoBusca;
    
    public GerenciarFuncionariosBean() {
         this.funcionarios = new ArrayList<>();
        this.funcionario = new Funcionario();
      
        
        }
    
     @PostConstruct
    public void init(){
        carregarLista();
    }
    
     public void editar(Funcionario funcionario){
        this.funcionario = funcionario;
    }

        public void excluir(Funcionario funcionario){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        funcionario = manager.find(Funcionario.class, funcionario.getIdfuncionario());
        manager.remove(funcionario);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
    }
        
      private void alterarSituacao(Funcionario funcionario, char a){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        funcionario = manager.find(Funcionario.class, funcionario.getIdfuncionario());
        manager.merge(funcionario);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
      public void ativar(Funcionario funcionario){
        alterarSituacao(funcionario, 'A');
        carregarLista();
    }
      
      public void inativar(Funcionario funcionario){
        alterarSituacao(funcionario, 'I');
        carregarLista();
    }
      
        public void carregarLista(){
        if(this.tipoBusca == 'A'){
            EntityManager manager = JpaUtil.getManager();
            funcionarios = manager.createNamedQuery("Funcionario.findBySituacao", Funcionario.class)
                    .setParameter("situacao", 'A')
                    .getResultList();
            JpaUtil.closeManager(manager);
        }else if(this.tipoBusca == 'I'){
            EntityManager manager = JpaUtil.getManager();
            funcionarios = manager.createNamedQuery("Funcionario.findBySituacao", Funcionario.class)
                    .setParameter("situacao", 'I')
                    .getResultList();
            JpaUtil.closeManager(manager);
        }else{
            EntityManager manager = JpaUtil.getManager();
            funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
            JpaUtil.closeManager(manager);
        }
    }
        
     public char getTipoBusca() {
        return tipoBusca;
    }
    
     public void setTipoBusca(char tipoBusca) {
        this.tipoBusca = tipoBusca;
    }
     
      public boolean validar(Funcionario funcionario){
        return Funcionario.getSituacao() == 'A' ? true : false;
    }
      
    public Funcionario getCFuncionario() {
        return funcionario;
    }  
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
     public List<Funcionario> getCFuncionarios() {
        return funcionarios;
    }
    
     public void setFuncionarios (List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
