package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.entidades.Locacao;
import com.curso.entidades.Veiculo;
import com.curso.utils.JpaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class CadastrarLocacaoBean {
    
    private Locacao locacao;

    private Cliente cliente;

    private List<Veiculo> veiculos;

    private Veiculo veiculo;

    public CadastrarLocacaoBean() {
        this.locacao = new Locacao();
        this.cliente = new Cliente();
        this.veiculos = new ArrayList<>();
        this.veiculo = new Veiculo();
        buscarVeiculos();
    }
    
    public void salvar(){
        EntityManager manager  = JpaUtil.getManager();
        manager.getTransaction().begin();
        manager.merge(locacao);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        
        limpar();
    }

    public void selecionarVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public void buscarVeiculos(){
        try {
            EntityManager manager = JpaUtil.getManager();
            veiculos = manager.createNamedQuery("Veiculo.findAll").getResultList();
            JpaUtil.closeManager(manager);
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro", "Falha ao buscar veiculos!"));
        }
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void selecionarCliente(Cliente cliente){
        System.out.println();
        this.cliente = cliente;
    }
    
    public void limpar(){
        this.locacao = new Locacao();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
    
    public void listartodos(){
        
    }
    
}
