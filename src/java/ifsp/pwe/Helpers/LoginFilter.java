package ifsp.pwe.Helpers;

import ifsp.pwe.Beans.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario_logado");

        if(usuario == null){
            ((HttpServletResponse) response).sendRedirect("index.xhtml");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
    
}

/*@ManagedBean
public class LoginFilter{
    public void verificarLogin() throws IOException{
        SessionContext sessao = SessionContext.getInstance();
        Usuario usuario = (Usuario) sessao.getAttribute("usuario_logado");
   
        if(usuario == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }
}*/
