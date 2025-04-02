
package DAO;


import beans.Comida;
import beans.Mesa;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author gilberto, matheus e romeo.
 */
public class MesaDAO {
    
    //Um objeto da classe Conexao, responsável por estabelecer a conexão com o banco de dados.
    private Conexao conexao;
    
    //Um objeto da interface Connection, que efetivamente mantém a conexão com o banco de dados.
    private Connection conn;
    
    
    
    public MesaDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
                                               
    }
       
//    public void inserir(Mesa mesa){
//        
//        String sql = "INSERT INTO Mesa (numMesa) VALUES (?);";
//        
//        
//        try {
//            
//            
//            PreparedStatement stmt = this.conn.prepareStatement(sql);
//            
//            
//            stmt.setInt(1, mesa.getId()); 
//            
//            
//            
//            
//            stmt.execute(); //Isso executa o comando SQL, inserindo o registro no banco de dados
//            
//        }catch(SQLException ex){
//            System.out.println("Erro ao inserir Mesa "+ex.getMessage());
//        }
//        
//    } 
//    
    
    
    
   public List<Mesa> getMesas(){
       
       String sql = "SELECT * FROM Mesa";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Mesa> listaMesas = new ArrayList();
           
           while (rs.next()){
               Mesa m = new Mesa();
               m.setId(rs.getInt("id"));
               m.setNumMesa(rs.getInt("numMesa"));
               
               listaMesas.add(m);
           }
           return listaMesas;
           
           
       }catch(SQLException ex){
           System.out.println("Erro ao consultar todas as Mesas: " + ex.getMessage());
           return null;
       }
       
   }
   
   

   
   
    
}
            
            
            
        
            
            
        
        
    

