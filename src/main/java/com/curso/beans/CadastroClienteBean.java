package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.utils.JpaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 * Created by guilherme on 12/10/16.
 */
@ManagedBean(name = "cadastroClienteBean")
@ViewScoped
public class CadastroClienteBean {

    public CadastroClienteBean() {
        this.cliente = new Cliente();
    }

    private Cliente cliente;

    public void salvar(){
        try {
            EntityManager manager = JpaUtil.getManager();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cliente salvo com sucesso"));
            manager.getTransaction().begin();
            manager.merge(cliente);
            manager.getTransaction().commit();
            JpaUtil.closeManager(manager);
        }catch (Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }

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
