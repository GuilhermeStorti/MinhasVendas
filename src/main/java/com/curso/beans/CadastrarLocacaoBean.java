package com.curso.beans;

import com.curso.entidades.Locacao;
import com.curso.utils.JpaUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean
@SessionScoped
public class CadastrarLocacaoBean {
    
    private Locacao locacao;

    public CadastrarLocacaoBean() {
        this.locacao = new Locacao();
    }
    
    public void salvar(){
        EntityManager manager  = JpaUtil.getManager();
        manager.getTransaction().begin();
        manager.merge(locacao);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
        
        limpar();
    }
    
    public void limpar(){
        this.locacao = new Locacao();
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
