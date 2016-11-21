package com.curso.beans;

import com.curso.entidades.Veiculo;
import com.curso.utils.JpaUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

/**
 * Created by guilherme on 21/11/16.
 */
@SessionScoped
@ManagedBean(name = "cadastrarVeiculoBean")
public class CadastrarVeiculoBean {

    public CadastrarVeiculoBean() {
        this.veiculo = new Veiculo();
    }

    private Veiculo veiculo;

    public void salvar(){
        EntityManager manager  = JpaUtil.getManager();
        manager.getTransaction().begin();
        manager.merge(this.veiculo);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);

        limpar();
    }

    public void limpar() {
        this.veiculo = new Veiculo();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
