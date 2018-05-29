/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.Dao;

import ifsp.pwe.Beans.Produto;
import ifsp.pwe.Beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class ProdutoDao extends ConnectionFactory{
    /**
     * Busca produtos de um usuario
     * @param id identificador do usuario
     * @return lita de produtos do usuario
     */
    public List<Produto> busca(Integer id){
        List<Produto> lista = new ArrayList<Produto>();
       
        try {
            String query = "SELECT * FROM produto where id =" + id;
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if(rs == null) 
                return null;
            else{
                Produto produto = new Produto();
                Usuario usuario = new Usuario();
                while(rs.next()){
                    produto.setId           (rs.getInt("id"));
                    produto.setNome         (rs.getString("nome"));
                    produto.setDescricao    (rs.getString("descricao"));
                    produto.setValor        (rs.getFloat("valor"));     

                    String queryUsuario             = "SELECT * FROM produto where id =" + id;
                    PreparedStatement stmtUsuario   = this.connection.prepareStatement(queryUsuario);
                    ResultSet rsUsuario = stmtUsuario.executeQuery();
                    while(rsUsuario.next()){
                        usuario.setId       (rsUsuario.getInt("id"));
                        usuario.setNome     (rsUsuario.getString("nome"));
                        usuario.setEmail    (rsUsuario.getString("email"));
                        usuario.setSenha    (rs.getString("senha"));
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
}
