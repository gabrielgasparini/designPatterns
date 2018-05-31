package ifsp.pwe.Dao;

import ifsp.pwe.Beans.Produto;
import ifsp.pwe.Beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends ConnectionFactory{
    /**
     * Busca produtos de um usuario
     * @param id identificador do usuario
     * @return lita de produtos do usuario
     */
    public List<Produto> buscar(Integer id){
        List<Produto> lista = new ArrayList<Produto>();
       
        try {
            String query = "SELECT * FROM produto WHERE id_usuario = " + id;
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if(rs == null){
                return null;
            }else{
                while(rs.next()){
                    Produto produto = new Produto();
                    Usuario usuario = new Usuario();
                
                    produto.setId           (rs.getInt("id"));
                    produto.setNome         (rs.getString("nome"));
                    produto.setDescricao    (rs.getString("descricao"));
                    produto.setValor        (rs.getFloat("valor"));     

                    String queryUsuario             = "SELECT * FROM usuario where id =" + id;
                    PreparedStatement stmtUsuario   = this.connection.prepareStatement(queryUsuario);
                    ResultSet rsUsuario = stmtUsuario.executeQuery();
                    while(rsUsuario.next()){
                        usuario.setId       (rsUsuario.getInt("id"));
                        usuario.setNome     (rsUsuario.getString("nome"));
                        usuario.setEmail    (rsUsuario.getString("email"));
                        usuario.setSenha    (rsUsuario.getString("senha"));
                    }

                    produto.setUsuario(usuario);

                    lista.add(produto);
                }

                return lista;
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public Produto cadastrar(Produto produto){
        try{
            String sql = "INSERT INTO produto (nome, descricao, valor, id_usuario) VALUES(?,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString (1, produto.getNome());
            stmt.setString (2, produto.getDescricao());
            stmt.setFloat (3, produto.getValor());
            stmt.setInt (4, produto.getUsuario().getId());
            
            stmt.execute();
            stmt.close();
            this.connection.close();

            return produto;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
