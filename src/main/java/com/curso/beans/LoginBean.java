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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    }
    
    private Funcionario funcionario;
    private Autenticador autenticador;

    public String entrar() {
            EntityManager manager = JpaUtil.getManager();

            Funcionario funcionarioBuscado = manager.createNamedQuery("Funcionario.findByUsuario", Funcionario.class)
                    .setParameter("usuario", funcionario.getUsuario())
                    .getSingleResult();
            JpaUtil.closeManager(manager);
            if (funcionarioBuscado != null &&
                    funcionarioBuscado.getSenha().equals(funcionario.getSenha())) {
                funcionario = funcionarioBuscado;
                autenticador.setLogado(true);
                return "Home?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage("Par login/senha inválido!"));
                funcionario = new Funcionario();
                return null;
            }
    }

    public void limpar(){
        System.out.println("teste");
        funcionario.setUsuario("");
        funcionario.setSenha("");
    }

    public String logout() {
        autenticador.setLogado(false);
        HttpSession session =
                (HttpSession)FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(true);
        if(session != null) {
            session.invalidate();
        }
        return "Login?faces-redirect=true";
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
    
    
}
