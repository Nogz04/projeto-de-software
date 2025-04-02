package conexao;

import java.sql.Connection;
import java.sql.*;



public class Conexao {
    
    
    public Connection getConexao(){ 
        
        try{
            
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaRestaurante2?Timezone=true&serverTimezone=UTC", "root", "matheuszinho123");
            
            System.out.println("Conexão realizada com sucesso!");
            return conn;

            
            
        }catch(Exception e){
            System.out.println("Erro ao conectar-se ao Banco de Dados" +e.getMessage());
            return null;
        }
        
        
        
    }
    
}