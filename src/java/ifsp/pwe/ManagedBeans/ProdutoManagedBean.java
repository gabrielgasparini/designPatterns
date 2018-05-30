package ifsp.pwe.ManagedBeans;

import ifsp.pwe.Beans.Produto;
import ifsp.pwe.Beans.Usuario;
import ifsp.pwe.Dao.ProdutoDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoManagedBean {
    private Integer id;
    private String nome;
    private String descricao;
    private float valor;
    
    public List<Produto> buscar(){
        List<Produto> lista = new ProdutoDao().busca(1);

        return lista;
    }
    
    public void cadastrar() throws IOException{
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setValor(this.valor);
        
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Denis");
        usuario.setEmail("denis@email.com");
        usuario.setSenha("123");
        
        produto.setUsuario(usuario);
        
        Produto result = new ProdutoDao().cadastrar(produto);

        if(result != null){
            System.out.println("Produto cadastrado com sucesso!");
        }else{
            System.out.println("Produto não foi cadastrado.");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
