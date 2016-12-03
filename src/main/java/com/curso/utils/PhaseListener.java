package com.curso.utils;

import com.curso.beans.LoginBean;
import com.curso.entidades.Funcionario;

import java.io.IOException;

import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
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
    	FacesContext facesContext = event.getFacesContext().getCurrentInstance();
    	ExternalContext externalContext = facesContext.getExternalContext();
    	NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
    	
        if("/Login.xhtml".equals(facesContext.getViewRoot().getViewId())) {
            return;
        }
        
        LoginBean usuarioBean = (LoginBean) externalContext.getSessionMap().get("loginBean");
        Funcionario usuarioLogado = null;
        
        if (usuarioBean != null) {
            usuarioLogado = usuarioBean.getFuncionario();
        }
        if (usuarioLogado == null || !usuarioBean.getAutenticador().isLogado()) {            
           handler.handleNavigation(facesContext, null, "forbidden");
           facesContext.renderResponse();
        }
    }

    @Override
    public PhaseId getPhaseId() { return PhaseId.RESTORE_VIEW; }
}
