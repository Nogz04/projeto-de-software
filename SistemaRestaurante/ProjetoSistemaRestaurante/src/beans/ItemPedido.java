/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author laboratorio
 */
public class ItemPedido {
    
    private int idItemPedidos;
    
    private Pedido id_Pedido;
    private int quantidade;

    public ItemPedido(int idItemPedidos, Pedido id_Pedido, int quantidade) {
        this.idItemPedidos = idItemPedidos;
        
        this.id_Pedido = id_Pedido;
        this.quantidade = quantidade;
    }

    
    
    public int getIdItemPedidos() {
        return idItemPedidos;
    }

    public void setIdItemPedidos(int idItemPedidos) {
        this.idItemPedidos = idItemPedidos;
    }

    

    public Pedido getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(Pedido id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }    
}
