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
    private Item id_Item;
    private Pedido id_Pedido;
    private int quantidadePedidos;

    public ItemPedido(int idItemPedidos, Item id_Item, Pedido id_Pedido, int quantidadePedidos) {
        this.idItemPedidos = idItemPedidos;
        this.id_Item = id_Item;
        this.id_Pedido = id_Pedido;
        this.quantidadePedidos = quantidadePedidos;
    }

    
    
    public int getIdItemPedidos() {
        return idItemPedidos;
    }

    public void setIdItemPedidos(int idItemPedidos) {
        this.idItemPedidos = idItemPedidos;
    }

    public Item getId_Item() {
        return id_Item;
    }

    public void setId_Item(Item id_Item) {
        this.id_Item = id_Item;
    }

    public Pedido getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(Pedido id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public int getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void setQuantidadePedidos(int quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }
    
    
}
