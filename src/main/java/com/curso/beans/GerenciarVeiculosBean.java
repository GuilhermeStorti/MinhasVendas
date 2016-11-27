package com.curso.beans;

import com.curso.entidades.Veiculo;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by guilherme on 27/11/16.
 */
@ManagedBean(name = "gerenciarVeiculosBean")
@ViewScoped
public class GerenciarVeiculosBean {

    @PostConstruct
    private void init(){
        EntityManager manager = JpaUtil.getManager();
        veiculos = manager.createNamedQuery("Veiculo.findAll").getResultList();
        JpaUtil.closeManager(manager);
    }

    private List<Veiculo> veiculos;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
