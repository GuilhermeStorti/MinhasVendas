package com.curso.beans;

import com.curso.entidades.Categoria;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by guilherme on 07/11/16.
 */
@ViewScoped
@ManagedBean(name = "categoriasBean")
public class CategoriasBean {

    private List<Categoria> categorias;
    private Categoria categoria;
    private boolean exibirEdit;
    private boolean exibirNovo;

    @PostConstruct
    private void init(){
        carregarLista();
        this.categoria = new Categoria();
        this.exibirNovo = false;
        this.exibirEdit = false;

    }

    public void voltar(){
        this.exibirNovo = false;
        this.exibirEdit = false;
    }

    public void excluir(){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        categoria = manager.find(Categoria.class, categoria.getIdCategoria());
        manager.remove(categoria);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        this.categoria = new Categoria();
        carregarLista();
    }

    public void salvarNovo(){
        if(!categoria.getDescricao().isEmpty()){
            EntityManager manager = JpaUtil.getManager();
            manager.getTransaction().begin();
            manager.merge(categoria);
            manager.getTransaction().commit();
            JpaUtil.closeManager(manager);
            this.categoria = new Categoria();
            carregarLista();
        }
        this.exibirNovo = false;
    }

    public void editar(){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        Categoria antigo = manager.find(Categoria.class, categoria.getIdCategoria());
        antigo = categoria;
        manager.merge(antigo);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
        this.categoria = new Categoria();
        this.exibirEdit = false;
    }

    public void carregarCategoriaExcluir(Categoria cat){
        this.categoria = cat;
    }

    public void carregarCategoriaEdit(Categoria cat){
        this.categoria = cat;
        this.exibirEdit = true;
    }

    public void carregarCategoriaNovo(){
        this.categoria = new Categoria();
        this.exibirNovo = true;
    }

    private void carregarLista(){
        EntityManager manager = JpaUtil.getManager();
        categorias = manager.createNamedQuery("Categoria.findAll", Categoria.class)
                .getResultList();
        JpaUtil.closeManager(manager);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isExibirEdit() {
        return exibirEdit;
    }

    public void setExibirEdit(boolean exibirEdit) {
        this.exibirEdit = exibirEdit;
    }

    public boolean isExibirNovo() {
        return exibirNovo;
    }

    public void setExibirNovo(boolean exibirNovo) {
        this.exibirNovo = exibirNovo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
