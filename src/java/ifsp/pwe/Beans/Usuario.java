package ifsp.pwe.Beans;

import ifsp.pwe.Dao.UsuarioDao;
import ifsp.pwe.Helpers.SessionContext;
import java.io.IOException;
import javax.faces.context.FacesContext;

public class Usuario{
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    
    /**
     *  FAÇADE
     *  Efetua login no sistema.
     *  Implementa o design pattern 'façace', pois chama uma funcionalidade de
     * busca de dados no banco de dados e chama outra funcionalidade que cria 
     * uma sessão para o usuário no sistema.
     * 
     * @throws IOException Exceção gerada para tratamento do erro no redirecionamento.
     */
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
    
    /**
     *  Faz o logout do usuário do sistema, encerrando a sessão do usuário e 
     * redirecionando o mesmo para a página inicial.
     * 
     * @throws IOException Exceção gerada para tratamento do erro no redirecionamento.
     */
    public void logout() throws IOException{
        //Resgatando Sessão
        SessionContext sessao = SessionContext.getInstance();
        sessao.encerrarSessao();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }  
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}