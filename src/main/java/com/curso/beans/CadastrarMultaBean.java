package com.curso.beans;

import com.curso.entidades.Multa;
import com.curso.utils.JpaUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean
@SessionScoped
public class CadastrarMultaBean {

    public CadastrarMultaBean() {
        this.multa = new Multa();
    }
    
    private Multa multa;
    
    public void salvar(){
        EntityManager manager  = JpaUtil.getManager();
        manager.getTransaction().begin();
        manager.merge(multa);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        
        limpar();
    }

    public void limpar() {
        this.multa = new Multa();
    }
    
    public Multa getMulta(){
        return multa;
    }
    
    public void setMulta(Multa multa){
        this.multa = multa;
    }
    
}
