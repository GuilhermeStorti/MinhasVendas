package com.curso.beans;

import com.curso.entidades.Cliente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by guilherme on 12/10/16.
 */
@ManagedBean(name = "cadastroClienteBean")
@SessionScoped
public class CadastroClienteBean {

    public CadastroClienteBean() {
        this.cliente = new Cliente();
    }

    private Cliente cliente;

    public void cadastrar(){
        System.out.println("Cadastrar");
        limpar();
    }

    public void limpar(){
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
