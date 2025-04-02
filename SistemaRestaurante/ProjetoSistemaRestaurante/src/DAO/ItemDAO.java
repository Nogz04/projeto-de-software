/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.Item;
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
public class ItemDAO {
    
    //Um objeto da classe Conexao, responsável por estabelecer a conexão com o banco de dados.
    private Conexao conexao;
    
    //Um objeto da interface Connection, que efetivamente mantém a conexão com o banco de dados.
    private Connection conn;
    
    
    
    public ItemDAO() {
        this.conexao = new Conexao(); 
        this.conn = this.conexao.getConexao(); 
                                               
    }
    //Criando o INSERT INTO do SQL.
    public void inserir(Item item){
        
        String sql = "INSERT INTO Item (nome, categoria, valor, quantidade, descricao) VALUES (?,?,?,?,?);";
        
        
        try {
            
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setString(1, item.getNome()); 
            stmt.setString(2, item.getCategoria()); 
            stmt.setDouble(3, item.getValor()); 
            stmt.setInt(4, item.getQuantidade());
            stmt.setString(5, item.getDescricao());
            
            
            
            stmt.execute(); //Isso executa o comando SQL, inserindo o registro no banco de dados
            
        }catch(SQLException ex){
            System.out.println("Erro ao inserir item"+ex.getMessage());
        }
        
    }
    
    public Item consulta(int id){
        
        String sql = "SELECT * FROM Item WHERE id = ?;";
        
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Item i = new Item();
            
            rs.first();
            i.setId(id);
            i.setId(rs.getInt("id"));
            i.setNome(rs.getString("nome"));
            i.setCategoria(rs.getString("categoria"));
            i.setValor(rs.getDouble("valor"));
            i.setQuantidade(rs.getInt("quantidade"));
            i.setDescricao(rs.getString("descricao"));
            
            return i;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar dados do Item"+ex.getMessage());
            return null;
        }
    }
     
    
    public void atualizar(Item item){
        
        String sql = "UPDATE item set nome = ?, categoria = ?, valor = ?, quantidade = ?, descricao = ? WHERE id = ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setDouble(3, item.getValor());
            stmt.setInt(4, item.getQuantidade());
            stmt.setString(5, item.getDescricao());
            stmt.setInt(6, item.getId());
            
            stmt.execute();
            
            
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar os dados da pessoa"+ex.getMessage());
            
        }
    }
    
   
    
   public List<Item> getPessoas(){
       
       String sql = "SELECT * FROM Item";
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           
           ResultSet rs = stmt.executeQuery();
           List<Item> listaItens = new ArrayList();
           
           while (rs.next()){
               Item i = new Item();
               i.setId(rs.getInt("id"));
               i.setNome(rs.getString("nome"));
               i.setCategoria(rs.getString("categoria"));
               i.setValor(rs.getDouble("valor"));
               i.setQuantidade(rs.getInt("quantidade"));
               i.setDescricao(rs.getString("descricao"));
               listaItens.add(i);
           }
           return listaItens;
           
           
       }catch(SQLException ex){
           System.out.println("Erro ao consultar todos os itens: " + ex.getMessage());
           return null;
       }
       
   }
   
   
   public List<Item> getItensNome(String nome){
        
        String sql = "SELECT * FROM pessoa WHERE nome LIKE ?;";
        
        try {
            
            // O objeto PreparedStatement permite que você substitua os '?' no SQL com valores reais.
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%"+ nome +"%");
            
            ResultSet rs = stmt.executeQuery();
            List<Item> listaItens = new ArrayList();
            
            
            
           while(rs.next()){
               Item i = new Item();
               i.setId(rs.getInt("id"));
               i.setNome(rs.getString("nome"));
               i.setCategoria(rs.getString("categoria"));
               i.setValor(rs.getDouble("valor"));
               i.setQuantidade(rs.getInt("quantidade"));
               i.setDescricao(rs.getString("descricao"));
               listaItens.add(i);
           }  
            return listaItens;
            
        }catch(SQLException ex){
            System.out.println("Erro ao consultar todos os Itens"+ex.getMessage());
            return null;
        }
    }
   
   
    
}
            
            
            
        
            
            
        
        
    

