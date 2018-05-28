package ifsp.pwe.Dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionFactory {
    private String url = "jdbc:msql://192.168.1.7/";
    private String banco = "loja";
    private String usuario = "root";
    private String senha = "";
    
    
    protected Connection connection;

    public ConnectionFactory(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            this.connection = DriverManager.getConnection(this.url+this.banco, this.usuario, this.senha);
        }catch(ClassNotFoundException ex){
            throw new RuntimeException("O driver especificado não foi encontrado.");
        }catch(SQLException ex){
            throw new RuntimeException("Não foi possível conectar ao banco de dados.");
        }
    }
}
