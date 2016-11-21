package com.curso.entidades;

/**
 * Created by guilherme on 21/11/16.
 */
public class Autenticador {

    private String usuario;
    private boolean logado;

    public Autenticador() {
    }

    public Autenticador(String usuario, boolean logado) {
        this.usuario = usuario;
        this.logado = logado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
}
