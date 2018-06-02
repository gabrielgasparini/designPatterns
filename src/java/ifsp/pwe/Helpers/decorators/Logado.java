package ifsp.pwe.Helpers.decorators;

import ifsp.pwe.Beans.Produto;
import ifsp.pwe.Beans.Usuario;
import ifsp.pwe.Dao.ProdutoDao;
import ifsp.pwe.Helpers.SessionContext;
import java.io.IOException;
import java.util.List;
import javax.faces.context.FacesContext;

public class Logado extends UsuarioDecorator{
    public Logado(IUsuario usuario) {
        super(usuario);
    }

    /**
     *  Faz o logout do usuário do sistema, encerrando a sessão do usuário e 
     * redirecionando o mesmo para a página inicial.
     * 
     * @throws IOException Exceção gerada para tratamento do erro no redirecionamento.
     */
    @Override
    public void logout() throws IOException {
        //Resgatando Sessão
        SessionContext sessao = SessionContext.getInstance();
        sessao.encerrarSessao();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    /**
     *  Busca produtos de um usuário logado
     * 
     * @return Lista de produtos encontrados
     */
    public List<Produto> buscarProdutos(){
        SessionContext sessao = SessionContext.getInstance();
        Usuario usuarioLogado = (Usuario)sessao.getAttribute("usuario_logado");

        List<Produto> lista = new ProdutoDao().buscar(usuarioLogado.getId());

        return lista;
    }
    
    /**
     *  Cadastra um produto para o usuário
     * 
     * @param produto Produto a ser cadastrado
     * @throws IOException Exceção gerada para tratamento do erro no redirecionamento.
     */
    public void cadastrarProduto(Produto produto) throws IOException{
        SessionContext sessao = SessionContext.getInstance();
        Usuario usuarioLogado = (Usuario)sessao.getAttribute("usuario_logado");

        produto.setUsuario(usuarioLogado);

        Produto result = new ProdutoDao().cadastrar(produto);

        if(result != null){
            System.out.println("Produto cadastrado com sucesso!");
        }else{
            System.out.println("Produto não foi cadastrado.");
        }
    }
}
