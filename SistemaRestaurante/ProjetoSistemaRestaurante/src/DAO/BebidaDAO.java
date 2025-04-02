/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.Bebida;
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
public class BebidaDAO {
    
    //Um objeto da classe Conexao, responsável por estabelecer a conexão com o banco de dados.
    private Conexao conexao;
    
    //Um objeto da interface Connection, que efetivamente mantém a conexão com o banco de dados.
    private Connection conn;
    
    
    
    public BebidaDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
                                               
    }
    //Criando o INSERT INTO do SQL.
    public void inserir(Bebida bebida){
        
        String sql = "INSERT INTO Bebida (nome, valor, quantidade, estado) VALUES (?,?,?,?);";
        
        
        try {
            
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setString(1, bebida.getNome()); 
            stmt.setDouble(2, bebida.getValor()); 
            stmt.setInt(3, bebida.getQuantidade());
            stmt.setString(4, bebida.getEstado());
            
            
            
            stmt.execute(); //Isso executa o comando SQL, inserindo o registro no banco de dados
            
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Bebida "+ex.getMessage());
        }
        
    }
    
    public Bebida consulta(int id){
        
        String sql = "SELECT * FROM Bebida WHERE id = ?;";
        
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Bebida b = new Bebida();
            
            rs.first();
            b.setId(id);
            b.setId(rs.getInt("id"));
            b.setNome(rs.getString("nome"));
            b.setValor(rs.getDouble("valor"));
            b.setQuantidade(rs.getInt("quantidade"));
            b.setEstado(rs.getString("estado"));
            
            return b;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar dados da Bebida"+ex.getMessage());
            return null;
        }
    }
     
    
    public void atualizar(Bebida bebida){
        
        String sql = "UPDATE Bebida set nome = ?, valor = ?, quantidade = ?, estado = ? WHERE id = ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, bebida.getNome());
            stmt.setDouble(2, bebida.getValor());
            stmt.setInt(3, bebida.getQuantidade());
            stmt.setString(4, bebida.getEstado());
            stmt.setInt(5, bebida.getId());
            
            
            stmt.execute();
            
            
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar os dados da Bebida"+ex.getMessage());
            
        }
    }
    
   
    
   public List<Bebida> getBebidas(){
       
       String sql = "SELECT * FROM Bebida";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Bebida> listaBebidas = new ArrayList();
           
           while (rs.next()){
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
           System.out.println("Erro ao consultar todas as Bebidas: " + ex.getMessage());
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
            
            
            
        
            
            
        
        
    

