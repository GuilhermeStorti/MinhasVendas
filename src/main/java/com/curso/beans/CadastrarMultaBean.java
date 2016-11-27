package com.curso.beans;

import com.curso.beans.LoginBean;
import com.curso.entidades.Multa;
import com.curso.entidades.Veiculo;
import com.curso.utils.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

@ManagedBean
@SessionScoped
public class CadastrarMultaBean {
    private Multa multa = new Multa();
    private Veiculo veiculo;
    private List<Veiculo> veiculos = new ArrayList();

    public CadastrarMultaBean() {
        this.buscarVeiculos();
    }

    public void selecionarVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public void salvar() {
        EntityManager manager = JpaUtil.getManager();
        this.multa.setIdVeiculo(this.veiculo);
        manager.getTransaction().begin();
        manager.merge(this.multa);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        this.limpar();
    }

    public void buscarVeiculos() {
        try {
            EntityManager e = JpaUtil.getManager();
            this.veiculos = e.createNamedQuery("Veiculo.findAll").getResultList();
            JpaUtil.closeManager(e);
        } catch (Exception var2) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro", "Falha ao buscar veiculos!"));
        }

    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void limpar() {
        this.multa = new Multa();
    }

    public Multa getMulta() {
        return this.multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}