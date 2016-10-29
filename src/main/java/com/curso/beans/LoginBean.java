package com.curso.beans;

import com.curso.entidades.Funcionario;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author guilherme
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    public LoginBean() {
        this.funcionario = new Funcionario();
        usuario = "";
        senha = ""; 
    }
    
    private Funcionario funcionario;
    private String usuario;
    private String senha;
    
    public void entrar(){
        EntityManager manager = JpaUtil.getManager();
        List<Funcionario> funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
        for(Funcionario f : funcionarios){
            if(f.getUsuario().equals(usuario) && f.getSenha().equals(senha)){
                System.out.println("Seja Bem vindo!!");
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Home.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Dados Invalidos!!");
            }
            JpaUtil.closeManager(manager);
        }
    }
    
    public void limpar(){
        System.out.println("teste");
        usuario = "";
        senha = "";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
