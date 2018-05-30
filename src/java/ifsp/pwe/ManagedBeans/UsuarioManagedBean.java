package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean {
    private String email;
    private String senha;
    
    public void login() throws IOException{
        Usuario usuario = new Usuario();
        
        Usuario usuarioRetorno =  usuario.entrar(this.email, this.senha);
        
        if(usuarioRetorno == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }else{
            //Criação da Sessão    
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("usuario_logado", usuarioRetorno);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
        }
    }
    
    public void logout() throws IOException{
     
        //Resgatando Sessão  
        /*FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        
        session.getAttribute("usuario_logado");*/
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
