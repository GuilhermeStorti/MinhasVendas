package com.curso.beans;

import com.curso.entidades.Cliente;
import com.curso.entidades.Locacao;
import com.curso.entidades.Veiculo;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by guilherme on 26/11/16.
 */
@ManagedBean(name="relatoriosBean")
@ViewScoped
public class RelatoriosBean {

    private List<Locacao> locacoes;
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;

    @PostConstruct
    private void init(){
        EntityManager manager = JpaUtil.getManager();
        locacoes = manager.createQuery("from Locacao", Locacao.class).getResultList();
        veiculos = manager.createQuery("from Veiculo", Veiculo.class).getResultList();
        clientes = manager.createQuery("from Cliente", Cliente.class).getResultList();
        JpaUtil.closeManager(manager);
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
