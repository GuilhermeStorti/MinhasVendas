package com.curso.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by guilherme on 10/10/16.
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    public LoginBean() {
        limpar();
    }

    private String usuario;
    private String senha;

    public void entrar(){
        if (!usuario.isEmpty() && usuario != null && !senha.isEmpty() && senha != null) {
            if(usuario.equals("Guilherme") && senha.equals("123")){
                System.out.println("OK!!!");
                limpar();
            }else{
                System.out.println("Errado!");
            }
        }
    }

    public void limpar(){
        usuario = null;
        senha = null;
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
