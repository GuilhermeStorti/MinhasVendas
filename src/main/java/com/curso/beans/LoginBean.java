package com.curso.beans;

import com.curso.entidades.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
        System.out.println("teste");
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
