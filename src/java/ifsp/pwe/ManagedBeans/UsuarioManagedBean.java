package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class UsuarioManagedBean {
    private String email;
    private String senha;
    
    public void login() throws IOException{
        Usuario usuario = new Usuario();
        
        Boolean result =  usuario.entrar(this.email, this.senha);
        
        if(result){
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }
    
    public void logout() throws IOException{
        
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
