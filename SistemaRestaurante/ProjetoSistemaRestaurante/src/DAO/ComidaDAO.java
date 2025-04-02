/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.Comida;
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
public class ComidaDAO {
    
    //Um objeto da classe Conexao, responsável por estabelecer a conexão com o banco de dados.
    private Conexao conexao;
    
    //Um objeto da interface Connection, que efetivamente mantém a conexão com o banco de dados.
    private Connection conn;
    
    
    
    public ComidaDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
                                               
    }
    //Criando o INSERT INTO do SQL.
    public void inserir(Comida Comida){
        
        String sql = "INSERT INTO Comida (nome, valor, quantidade, descricao, estado) VALUES (?,?,?,?,?);";
        
        
        try {
            
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setString(1, Comida.getNome()); 
            stmt.setDouble(2, Comida.getValor()); 
            stmt.setInt(3, Comida.getQuantidade());
            stmt.setString(4, Comida.getDescricao());
            stmt.setString(5, Comida.getEstado());
            
            
            
            stmt.execute(); //Isso executa o comando SQL, inserindo o registro no banco de dados
            
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Comida "+ex.getMessage());
        }
        
    }
    
    public Comida consulta(int id){
        
        String sql = "SELECT * FROM Comida WHERE id = ?;";
        
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Comida c = new Comida();
            
            rs.first();
            c.setId(id);
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setValor(rs.getDouble("valor"));
            c.setQuantidade(rs.getInt("quantidade"));
            c.setDescricao(rs.getString("descricao"));
            c.setEstado(rs.getString("estado"));
            
            return c;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar dados da Comida"+ex.getMessage());
            return null;
        }
    }
     
    
    public void atualizar(Comida comida){
        
        String sql = "UPDATE Comida set nome = ?, valor = ?, quantidade = ?, descricao = ?, estado = ? WHERE id = ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, comida.getNome());
            stmt.setDouble(2, comida.getValor());
            stmt.setInt(3, comida.getQuantidade());
            stmt.setString(4, comida.getDescricao());
            stmt.setString(5, comida.getEstado());
            stmt.setInt(6, comida.getId());
            
            
            stmt.execute();
            
            
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar os dados da Comida"+ex.getMessage());
            
        }
    }
    
   
    
   public List<Comida> getComidas(){
       
       String sql = "SELECT * FROM Comida";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Comida> listaItens = new ArrayList();
           
           while (rs.next()){
               Comida i = new Comida();
               i.setId(rs.getInt("id"));
               i.setNome(rs.getString("nome"));
               i.setValor(rs.getDouble("valor"));
               i.setQuantidade(rs.getInt("quantidade"));
               i.setDescricao(rs.getString("descricao"));
               i.setEstado(rs.getString("estado"));
               listaItens.add(i);
           }
           return listaItens;
           
           
       }catch(SQLException ex){
           System.out.println("Erro ao consultar todos as comidas: " + ex.getMessage());
           return null;
       }
       
   }
   
   
   public List<Comida> getComidasNome(String nome){
        
        String sql = "SELECT * FROM Comida WHERE nome LIKE ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%"+ nome +"%");
            
            ResultSet rs = stmt.executeQuery();
            List<Comida> listaComidas = new ArrayList();
            
            
            
           while(rs.next()){
               Comida c = new Comida();
               c.setId(rs.getInt("id"));
               c.setNome(rs.getString("nome"));
               c.setValor(rs.getDouble("valor"));
               c.setQuantidade(rs.getInt("quantidade"));
               c.setDescricao(rs.getString("descricao"));
               c.setEstado(rs.getString("estado"));
               listaComidas.add(c);
           }  
            return listaComidas;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar todas as comidas"+ex.getMessage());
            return null;
        }
    }
   
   
    
}
            
            
            
        
            
            
        
        
    

