package com.curso.beans;

import com.curso.entidades.Categoria;
import com.curso.entidades.Veiculo;
import com.curso.utils.JpaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 21/11/16.
 */
@ViewScoped
@ManagedBean(name = "cadastrarVeiculoBean")
public class CadastrarVeiculoBean {

    public CadastrarVeiculoBean() {
        this.veiculo = new Veiculo();
        this.categorias = new ArrayList<>();
        this.categoria = new Categoria();
        buscarCategorias();
    }

    private Veiculo veiculo;
    private List<Categoria> categorias;
    private Categoria categoria;

    public void carregarCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public void buscarCategorias(){
        EntityManager manager = JpaUtil.getManager();
        categorias = manager.createNamedQuery("Categoria.findAll").getResultList();
        JpaUtil.closeManager(manager);
    }

    public void salvar(){
        try{
            this.veiculo.setIdCategoria(this.categoria);
            EntityManager manager  = JpaUtil.getManager();
            manager.getTransaction().begin();
            manager.merge(this.veiculo);
            manager.getTransaction().commit();
            JpaUtil.closeManager(manager);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Veiculo salvo com sucesso"));
            limpar();
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao persistir dados!"));
        }
    }

    public void limpar() {
        this.veiculo = new Veiculo();
        this.categoria = new Categoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
