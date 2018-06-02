package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Produto;
import ifsp.pwe.Beans.Usuario;
import ifsp.pwe.Helpers.decorators.IUsuario;
import ifsp.pwe.Helpers.decorators.Logado;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioManagedBean {
    private String email;
    private String senha;
    private Produto produto;
    
    public UsuarioManagedBean(){
        this.produto = new Produto();
    }
    
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

    /**
     *  DECORATOR
     *  Decora objeto usuário para que o mesmo tenha as funcionalidades de um
     * usuário logado. Podendo então chamar a função 'logout'.
     * 
     */
    public void sair(){
        IUsuario usuario = new Usuario();
        Logado usuarioLogado = new Logado(usuario);

        try{
            usuarioLogado.logout();
        }catch(IOException ex){
            throw new RuntimeException("Erro no redirecionamento do logout.");
        }
    }
    
    /**
     *  DECORATOR
     *  Decora objeto usuário para que o mesmo tenha as funcionalidades de um
     * usuário logado. Podendo então chamar a função 'buscarProdutos'.
     * 
     * @return Retorna uma lista de produtos encontrados.
     */
    public List<Produto> buscarProduto(){
        IUsuario usuario = new Usuario();
        Logado usuarioLogado = new Logado(usuario);
        
        return usuarioLogado.buscarProdutos();
    }
    
    /**
     *  DECORATOR
     *  Decora objeto usuário para que o mesmo tenha as funcionalidades de um
     * usuário logado. Podendo então chamar a função 'cadastrarProduto'.
     * 
     */
    public void cadastrarProduto(){
        IUsuario usuario = new Usuario();
        Logado usuarioLogado = new Logado(usuario);

        try{
            usuarioLogado.cadastrarProduto(this.produto);
        }catch(IOException ex){
            throw new RuntimeException("Erro ao cadastrar produto.");
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
    public Produto getProduto(){
        return this.produto;
    }
    
    /*
    public Integer getIdProduto() {
        return this.produto.getId();
    }

    public void setIdProduto(Integer id) {
        this.produto.setId(id);
    }

    public String getNomeProduto() {
        return this.produto.getNome();
    }

    public void setNomeProduto(String nome) {
        this.produto.setNome(nome);
    }

    public String getDescricaoProduto() {
        return this.produto.getDescricao();
    }

    public void setDescricaoProduto(String descricao) {
        this.produto.setDescricao(descricao);
    }

    public float getValorProduto() {
        return this.produto.getValor();
    }

    public void setValorProduto(float valor) {
        this.produto.setValor(valor);
    }*/
}
