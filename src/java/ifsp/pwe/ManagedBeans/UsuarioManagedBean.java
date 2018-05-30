package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Usuario;
import ifsp.pwe.Dao.UsuarioDao;
import ifsp.pwe.Helpers.SessionContext;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class UsuarioManagedBean {
    private String email;
    private String senha;
    
    public void login() throws IOException{      
        Usuario usuarioRetorno = new UsuarioDao().buscar(this.email, this.senha);
        
        if(usuarioRetorno == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }else{
            //Criação da Sessão
            SessionContext sessao = SessionContext.getInstance();
            sessao.setAttribute("usuario_logado", usuarioRetorno);

            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
        }
    }
    
    public void logout() throws IOException{
        //Resgatando Sessão
        SessionContext sessao = SessionContext.getInstance();
        sessao.encerrarSessao();
        
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
