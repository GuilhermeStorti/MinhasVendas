package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
    private Cliente cliente;

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

    private void alterarSituacao(Cliente cliente, char a){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        cliente = manager.find(Cliente.class, cliente.getIdCliente());
        cliente.setSituacao(a);
        manager.merge(cliente);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
    }

    public void ativar(Cliente cliente){
        alterarSituacao(cliente, 'A');
        carregarLista();
    }

    public void inativar(Cliente cliente){
        alterarSituacao(cliente, 'I');
        carregarLista();
    }

    private void carregarLista(){
        EntityManager manager = JpaUtil.getManager();
        clientes = manager.createQuery("from Cliente", Cliente.class).getResultList();
/*        clientes = manager.createNamedQuery("Cliente.findBySituacao", Cliente.class)
                .setParameter("situacao", 'A')
                .getResultList();*/
        JpaUtil.closeManager(manager);
    }

    public boolean validar(Cliente cliente){
        return cliente.getSituacao() == 'A' ? true : false;
    }

    public String validarCss(Cliente cliente){
        return cliente.getSituacao() == 'A' ? "situacao" : "";
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
