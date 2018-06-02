package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioManagedBean {
    private String email;
    private String senha;
    
    public void entrar(){      
        Usuario usuario = new Usuario();
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);

        try{
            usuario.login();
        }catch(IOException ex){
            throw new RuntimeException("Erro no redirecionamento do login.");
        }
    }
    
    public void sair(){
        Usuario usuario = new Usuario();
        
        try{
            usuario.logout();
        }catch(IOException ex){
            throw new RuntimeException("Erro no redirecionamento do logout.");
        }
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
