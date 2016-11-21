package com.curso.beans;

import com.curso.entidades.Autenticador;
import com.curso.entidades.Funcionario;
import com.curso.utils.JpaUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author guilherme
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    @PostConstruct
    private void init(){
        this.autenticador = new Autenticador();
    }

    public LoginBean() {
        this.funcionario = new Funcionario();
        this.usuario = "";
        this.senha = "";
    }
    
    private Funcionario funcionario;
    private String usuario;
    private String senha;
    private Autenticador autenticador;

    public void entrar(){
        try {
            EntityManager manager = JpaUtil.getManager();
            List<Funcionario> funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
            for(Funcionario f : funcionarios){
                if(f.getUsuario().equals(usuario) && f.getSenha().equals(senha)){
                    try {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Seja bem vindo!."));
                        this.autenticador.setUsuario(f.getUsuario());
                        this.autenticador.setLogado(true);
                        inserirValidacao();
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Home.xhtml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuario ou senha invalidos."));
                    this.autenticador.setUsuario("");
                    this.autenticador.setLogado(false);
                    inserirValidacao();
                }
                JpaUtil.closeManager(manager);
            }
        }catch (Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro", "Falha ao buscar dados!"));
        }
    }

    private void inserirValidacao(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("autenticador", this.autenticador);
    }

    public void limpar(){
        System.out.println("teste");
        usuario = "";
        senha = "";
    }

    public Autenticador getAutenticador() {
        return autenticador;
    }

    public void setAutenticador(Autenticador autenticador) {
        this.autenticador = autenticador;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
