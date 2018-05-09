package ifsp.pwe.jsf.utils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String pagina = facesContext.getViewRoot().getViewId();
        
        
        System.out.println("imprimindo a página" + pagina);
        
        
        if("/index.xhtml".equals(pagina)){
            return;
        }
        
        NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
        handler.handleNavigation(facesContext, null, "/index?faces-redirect=true");
        facesContext.renderResponse();
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}