package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Usuario;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioManagedBean {
    private String email;
    private String senha;
    
    public void login(){
        Usuario usuario = new Usuario();
        
        Boolean result =  usuario.entrar(this.email, this.senha);
        
        if(result){
            System.out.println("Logou!");
        }else{
            System.out.println("Não logou!");
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
