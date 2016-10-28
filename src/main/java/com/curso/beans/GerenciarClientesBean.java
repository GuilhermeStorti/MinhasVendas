package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 27/10/16.
 */
@SessionScoped
@ManagedBean(name = "gerenciarClientesBean")
public class GerenciarClientesBean {

    private List<Cliente> clientes;

    public GerenciarClientesBean() {
        clientes = new ArrayList<>();
    }

    public void carregarLista(){
        EntityManager manager = JpaUtil.getManager();
        clientes = manager.createQuery("from Cliente", Cliente.class).getResultList();
        JpaUtil.closeManager(manager);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
