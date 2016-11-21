package com.curso.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean {
    private String nome;
    private Boolean autenticado = false;

    public Boolean autenticar(String nome, String senha) {
        this.nome = nome;
        return autenticado = (nome != null && senha != null);
    }

    public Boolean isAutenticado() {
        return autenticado;
    }

    public String getNome() {
        return nome;
    }
}
