/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
 * @author gilberto, matheus e romeo.
 */
public class SobremesaDAO {
    
    //Um objeto da classe Conexao, responsável por estabelecer a conexão com o banco de dados.
    private Conexao conexao;
    
    //Um objeto da interface Connection, que efetivamente mantém a conexão com o banco de dados.
    private Connection conn;
    
    
    
    public SobremesaDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
                                               
    }
    //Criando o INSERT INTO do SQL.
    public void inserir(Sobremesa sobremesa){
        
        String sql = "INSERT INTO Sobremesa (nome, valor, quantidade, descricao, estado) VALUES (?,?,?,?,?);";
        
        
        try {
            
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setString(1, sobremesa.getNome()); 
            stmt.setDouble(2, sobremesa.getValor()); 
            stmt.setInt(3, sobremesa.getQuantidade());
            stmt.setString(4, sobremesa.getDescricao());
            stmt.setString(5, sobremesa.getEstado());
            
            
            
            stmt.execute(); //Isso executa o comando SQL, inserindo o registro no banco de dados
            
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Sobremesa "+ex.getMessage());
        }
        
    }
    
    public Sobremesa consulta(int id){
        
        String sql = "SELECT * FROM Sobremesa WHERE id = ?;";
        
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Sobremesa s = new Sobremesa();
            
            rs.first();
            s.setId(id);
            s.setId(rs.getInt("id"));
            s.setNome(rs.getString("nome"));
            s.setValor(rs.getDouble("valor"));
            s.setQuantidade(rs.getInt("quantidade"));
            s.setDescricao(rs.getString("descricao"));
            s.setEstado(rs.getString("estado"));
            
            return s;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar dados da sobremesa"+ex.getMessage());
            return null;
        }
    }
     
    
    public void atualizar(Sobremesa sobremesa){
        
        String sql = "UPDATE Sobremesa set nome = ?, valor = ?, quantidade = ?, descricao = ?, estado = ? WHERE id = ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, sobremesa.getNome());
            stmt.setDouble(2, sobremesa.getValor());
            stmt.setInt(3, sobremesa.getQuantidade());
            stmt.setString(4, sobremesa.getDescricao());
            stmt.setString(5, sobremesa.getEstado());
            stmt.setInt(6, sobremesa.getId());
            
            
            stmt.execute();
            
            
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar os dados da sobremesa"+ex.getMessage());
            
        }
    }
    
   
    
   public List<Sobremesa> getSobremesas(){
       
       String sql = "SELECT * FROM Sobremesa";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Sobremesa> listaItens = new ArrayList();
           
           while (rs.next()){
               Sobremesa i = new Sobremesa();
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
           System.out.println("Erro ao consultar todas as sobremesas: " + ex.getMessage());
           return null;
       }
       
   }
   
   
   public List<Sobremesa> getSobremesasNome(String nome){
        
        String sql = "SELECT * FROM Sobremesa WHERE nome LIKE ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%"+ nome +"%");
            
            ResultSet rs = stmt.executeQuery();
            List<Sobremesa> listaSobremesas = new ArrayList();
            
            
            
           while(rs.next()){
               Sobremesa c = new Sobremesa();
               c.setId(rs.getInt("id"));
               c.setNome(rs.getString("nome"));
               c.setValor(rs.getDouble("valor"));
               c.setQuantidade(rs.getInt("quantidade"));
               c.setDescricao(rs.getString("descricao"));
               c.setEstado(rs.getString("estado"));
               listaSobremesas.add(c);
           }  
            return listaSobremesas;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar todas as sobremesas"+ex.getMessage());
            return null;
        }
    }
   
   
    
}
            
            
            
        
            
            
        
        
    

