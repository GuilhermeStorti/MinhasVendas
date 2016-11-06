package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.utils.JpaUtil;
import org.primefaces.context.RequestContext;

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
        cliente.setSituacao('A');
    }

    private Cliente cliente;


    private boolean validar(){
        int i = 0;
        if(cliente.getNome() == null || cliente.getNome().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Nome é obrigatório!"));
            i++;
        }
        if(cliente.getCpf() == null || cliente.getCpf().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "CPF é obrigatório!"));
            i++;
        }

        if(i != 0){
            return false;
        }else{
            return true;
        }
    }

    public void salvar(){
        if(validar()){
            try {
                EntityManager manager = JpaUtil.getManager();
                manager.getTransaction().begin();
                manager.merge(cliente);
                manager.getTransaction().commit();
                JpaUtil.closeManager(manager);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cliente salvo com sucesso"));
            }catch (Exception ex){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
            }finally {
                limpar();
            }
        }
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
