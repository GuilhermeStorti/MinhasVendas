package com.curso.utils;

import com.curso.beans.LoginBean;
import com.curso.entidades.Funcionario;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

/**
 * Created by guilherme on 23/11/16.
 */
public class PhaseListener implements javax.faces.event.PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if("/Login.xhtml".equals(
                FacesContext.getCurrentInstance()
                        .getViewRoot().getViewId())) 		{
            return;
        }
        LoginBean usuarioBean = (LoginBean)
                FacesContext.getCurrentInstance()
                        .getExternalContext().getSessionMap().get("loginBean");
        Funcionario usuarioLogado = null;
        if (usuarioBean != null) {
            usuarioLogado = usuarioBean.getFuncionario();
        }
        if (usuarioLogado == null || !usuarioBean.getAutenticador().isLogado()) {
            FacesContext.getCurrentInstance()
                    .getApplication().getNavigationHandler()
                    .handleNavigation(FacesContext.getCurrentInstance(),
                            null, "Login?faces-redirect=true");
            FacesContext.getCurrentInstance().renderResponse();
        }
    }

    @Override
    public PhaseId getPhaseId() { return PhaseId.RESTORE_VIEW; }
}
