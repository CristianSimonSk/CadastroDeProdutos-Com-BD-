
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorDB {
    
    static final String DATABASE_URL = "jdbc:mysql://localhost/cadastro";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    
    Connection connection = null;
    
    public Connection getConexao() throws SQLException{
        connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        System.out.println("Banco de Dados Conectado com Sucesso");
        return connection;
    }
}
