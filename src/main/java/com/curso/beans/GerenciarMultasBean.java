package com.curso.beans;

import com.curso.entidades.Multa;
import com.curso.utils.JpaUtil;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean (name = "gerenciarMultasBean")
@SessionScoped
public class GerenciarMultasBean {

    private List<Multa> multas;
    Multa multa;
    
    public GerenciarMultasBean() {
        multas = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        carregarLista();
    }
    
    public void editar(Multa multa){
        this.multa = multa;
        System.out.println(this.multa);
    }
    
    public void excluir(Multa multa){
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        multa = manager.find(Multa.class, multa.getIdMulta());
        manager.remove(multa);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        carregarLista();
    }
    
    private void carregarLista(){
        EntityManager manager = JpaUtil.getManager();
        multas = manager.createQuery("from Multa", Multa.class).getResultList();
        JpaUtil.closeManager(manager);
    }
    
    public List<Multa> getMultas(){
        return multas;
    }
    
    public void setMultas(List<Multa> multas){
        this.multas = multas;
    }
    
}
