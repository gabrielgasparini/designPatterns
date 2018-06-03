package ifsp.pwe.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {
    private String serverName = "localhost";
    private String mydatabase = "gerenciador_produto";
    private String url = "jdbc:mysql://" + this.serverName + "/" + this.mydatabase;
    private String username = "root";
    private String password = "";
    
    protected Connection connection;

    public ConnectionFactory(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
        }catch(ClassNotFoundException ex){
            throw new RuntimeException("O driver especificado não foi encontrado.");
        }catch(SQLException ex){
            throw new RuntimeException("Não foi possível conectar ao banco de dados.");
        }
    }
}
