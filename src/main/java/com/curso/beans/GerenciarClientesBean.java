package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 27/10/16.
 */
@ViewScoped
@ManagedBean(name = "gerenciarClientesBean")
public class GerenciarClientesBean {

    private List<Cliente> clientes;
    Cliente cliente;

    public GerenciarClientesBean() {
        clientes = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        carregarLista();
    }

    public void editar(Cliente cliente){
        this.cliente = cliente;
        System.out.println(this.cliente);
    }

    public void excluir(Cliente cliente){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        cliente = manager.find(Cliente.class, cliente.getIdCliente());
        manager.remove(cliente);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
    }

    private void carregarLista(){
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
