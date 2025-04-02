/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.Bebida;
import beans.Comida;
import beans.Pedido;
import beans.Sobremesa;
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
 * @author mathe
 */
public class PedidosDAO {
    
    //Um objeto da classe Conexao, responsável por estabelecer a conexão com o banco de dados.
    private Conexao conexao;
    
    //Um objeto da interface Connection, que efetivamente mantém a conexão com o banco de dados.
    private Connection conn;
    
    
    
    public PedidosDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
                                               
    }
    //Criando o INSERT INTO do SQL.
    public void inserir(Pedido pedido){
        
        String sql = "INSERT INTO Pedido2 (id_mesa, id_comida, quantidade_comida, valor_comida, id_bebida, quantidade_bebida, valor_bebida, id_sobremesa, quantidade_sobremesa, valor_sobremesa) VALUES (?,?,?,?,?,?,?,?,?,?);";
        
        
        try {
            
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setInt(1, pedido.getId_mesa().getId()); 
            stmt.setInt(2, pedido.getId_comida().getId()); 
            stmt.setInt(3, pedido.getQuantidade_comida());
            stmt.setDouble(4, pedido.getId_comida().getValor());
            stmt.setInt(5, pedido.getId_bebida().getId()); 
            stmt.setInt(6, pedido.getQuantidade_bebida());
            stmt.setDouble(7, pedido.getId_bebida().getValor());
            stmt.setInt(8, pedido.getId_sobremesa().getId()); 
            stmt.setInt(9, pedido.getQuantidade_sobremesa());
            stmt.setDouble(10, pedido.getId_sobremesa().getValor());
            
            
            
            stmt.execute(); //Isso executa o comando SQL, inserindo o registro no banco de dados
            
        }catch(SQLException ex){
            System.out.println("Erro ao enviar Pedido "+ex.getMessage());
        }
        
    }
    

     

   
    
   public List<Pedido> getPedidos(){
       
       String sql = "SELECT * FROM Pedido2";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Pedido> listaPedidos = new ArrayList();
           
           while (rs.next()){
               Pedido p = new Pedido();
               ComidaDAO cDAO = new ComidaDAO();
               BebidaDAO bDAO = new BebidaDAO();
               SobremesaDAO sDAO = new SobremesaDAO();
               
               p.setId(rs.getInt("id"));
             
               // ---
               
               Comida c = cDAO.consulta(rs.getInt("id_comida"));
               p.setId_comida(c);
               
               p.setQuantidade_comida(rs.getInt("quantidade_comida"));
               
               p.setValor_bebida(rs.getDouble("valor_comida"));
               
               
               // ----
               
               Bebida b = bDAO.consulta(rs.getInt("id_bebida"));
               p.setId_bebida(b);
               
               p.setQuantidade_bebida(rs.getInt("quantidade_bebida"));
               
               p.setValor_bebida(rs.getDouble("valor_bebida"));
               
               // ---
               
               Sobremesa s = sDAO.consulta(rs.getInt("id_sobremesa"));
               p.setId_sobremesa(s);
               
               p.setQuantidade_sobremesa(rs.getInt("quantidade_sobremesa"));
               
               p.setValor_sobremesa(rs.getDouble("valor_sobremesa"));
               
               
               listaPedidos.add(p);
               
           }
           return listaPedidos;
           
           
       }catch(SQLException ex){
           System.out.println("Erro ao consultar todos os Pedidos: " + ex.getMessage());
           return null;
       }
       
   }
   
   
   public List<Bebida> getBebidasNome(String nome){
        
        String sql = "SELECT * FROM Bebida WHERE nome LIKE ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%"+ nome +"%");
            
            ResultSet rs = stmt.executeQuery();
            List<Bebida> listaBebidas = new ArrayList();
            
            
            
           while(rs.next()){
               Bebida b = new Bebida();
               b.setId(rs.getInt("id"));
               b.setNome(rs.getString("nome"));
               b.setValor(rs.getDouble("valor"));
               b.setQuantidade(rs.getInt("quantidade"));
               b.setEstado(rs.getString("estado"));
               listaBebidas.add(b);
           }  
            return listaBebidas;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar todas as Bebidas"+ex.getMessage());
            return null;
        }
    }
   
   
    
}
            
            
            
        
            
            
        
        
    

