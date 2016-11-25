package com.curso.beans;

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
@ViewScoped
@ManagedBean(name = "gerenciarFuncionariosBean")

public class GerenciarFuncionariosBean 
{   private List<Funcionario> funcionarios;
    private Funcionario funcionario;
    private boolean exibir = false;
    
    
    public GerenciarFuncionariosBean()
    {
        this.funcionarios = new ArrayList<>();
        this.funcionario = new Funcionario();
        
    }
    
    @PostConstruct
    public void init(){
        carregarLista();
    }
    
    public void esconder(){
        this.exibir = false;
    }
    
     public void editar(Funcionario funcionario){
        this.funcionario = funcionario;
        this.exibir = true;
    }
    
     public void voltar(){
        this.exibir = false;
    }
     
       public void salvarEdicao(){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        Funcionario antigo = manager.find(Funcionario.class, funcionario.getIdfuncionario());
        antigo = funcionario;
        manager.merge(antigo);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
        this.exibir = false;
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
        public void carregarLista(){
        
            EntityManager manager = JpaUtil.getManager();
            funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
            JpaUtil.closeManager(manager);
        }
     
        
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isExibir() {
        return exibir;
    }

    public void setExibir(boolean exibir) {
        this.exibir = exibir;
    }
  
}