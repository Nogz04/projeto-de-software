/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author laboratorio
 */
public class Pedido {
    
    private int id;
    private Mesa id_mesa;
    
    private Comida id_comida;
    private int quantidade_comida;
    private double valor_comida;
  
    
    private Sobremesa id_sobremesa;
    private int quantidade_sobremesa;
    private double valor_sobremesa;
    
    private Bebida id_bebida;
    private int quantidade_bebida;
    private double valor_bebida;

    public Pedido (){
        
    }

    public double getValor_comida() {
        return valor_comida;
    }

    public void setValor_comida(double valor_comida) {
        this.valor_comida = valor_comida;
    }

    public double getValor_sobremesa() {
        return valor_sobremesa;
    }

    public void setValor_sobremesa(double valor_sobremesa) {
        this.valor_sobremesa = valor_sobremesa;
    }

    public double getValor_bebida() {
        return valor_bebida;
    }

    public void setValor_bebida(double valor_bebida) {
        this.valor_bebida = valor_bebida;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesa getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Mesa id_mesa) {
        this.id_mesa = id_mesa;
    }

    public Comida getId_comida() {
        return id_comida;
    }

    public void setId_comida(Comida id_comida) {
        this.id_comida = id_comida;
    }

    public int getQuantidade_comida() {
        return quantidade_comida;
    }

    public void setQuantidade_comida(int quantidade_comida) {
        this.quantidade_comida = quantidade_comida;
    }

    public Sobremesa getId_sobremesa() {
        return id_sobremesa;
    }

    public void setId_sobremesa(Sobremesa id_sobremesa) {
        this.id_sobremesa = id_sobremesa;
    }

    public int getQuantidade_sobremesa() {
        return quantidade_sobremesa;
    }

    public void setQuantidade_sobremesa(int quantidade_sobremesa) {
        this.quantidade_sobremesa = quantidade_sobremesa;
    }

    public Bebida getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(Bebida id_bebida) {
        this.id_bebida = id_bebida;
    }

    public int getQuantidade_bebida() {
        return quantidade_bebida;
    }

    public void setQuantidade_bebida(int quantidade_bebida) {
        this.quantidade_bebida = quantidade_bebida;
    }
 

    
    
    
    
}
