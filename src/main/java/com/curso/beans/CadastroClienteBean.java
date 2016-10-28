package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.utils.JpaUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

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

    public void salvar(){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);

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
