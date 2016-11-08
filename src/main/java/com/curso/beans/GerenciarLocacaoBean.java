package com.curso.beans;

import com.curso.entidades.Locacao;
import com.curso.utils.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean
@SessionScoped
public class GerenciarLocacaoBean {
    
    private List<Locacao> locacoes;
    Locacao locacao;

    public GerenciarLocacaoBean() {
        locacoes = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        carregarLista();
    }
    
    private void carregarLista(){
        EntityManager manager = JpaUtil.getManager();
        locacoes = manager.createQuery("SELECT l FROM Locacao l", Locacao.class).getResultList();
        JpaUtil.closeManager(manager);
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
    
    
    
}
