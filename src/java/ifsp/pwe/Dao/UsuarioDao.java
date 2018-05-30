package ifsp.pwe.Dao;

import ifsp.pwe.Beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends ConnectionFactory{
    public Usuario buscar(String email, String senha){
        if(email == null || senha == null){
            return null;
        }

        try{
            String sql = "SELECT * FROM usuario WHERE email = '"+email+"' AND senha = '"+senha+"'";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next()){
                return null;
            }

            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            rs.close();
            stmt.close();
            this.connection.close();

            return usuario;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}