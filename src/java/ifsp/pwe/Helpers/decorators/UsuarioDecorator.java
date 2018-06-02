package ifsp.pwe.Helpers.decorators;

import ifsp.pwe.Beans.Usuario;
import ifsp.pwe.Dao.UsuarioDao;
import ifsp.pwe.Helpers.SessionContext;
import java.io.IOException;
import javax.faces.context.FacesContext;

public abstract class UsuarioDecorator implements IUsuario{
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    protected IUsuario usuario;
    
    public UsuarioDecorator(IUsuario usuario){
        this.usuario = usuario;
    }

    @Override
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
    
    public abstract void logout() throws IOException;
    
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId(){
        return this.id;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }  
    
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
