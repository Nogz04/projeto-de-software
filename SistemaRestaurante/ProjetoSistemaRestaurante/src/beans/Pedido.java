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
    private Sobremesa id_sobremesa;
    private Bebida id_bebida;

    public Pedido(int id, Mesa id_mesa) {
        this.id = id;
        this.id_mesa = id_mesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comida getId_comida() {
        return id_comida;
    }

    public void setId_comida(Comida id_comida) {
        this.id_comida = id_comida;
    }

    public Sobremesa getId_sobremesa() {
        return id_sobremesa;
    }

    public void setId_sobremesa(Sobremesa id_sobremesa) {
        this.id_sobremesa = id_sobremesa;
    }

    public Bebida getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(Bebida id_bebida) {
        this.id_bebida = id_bebida;
    }

    
    
    public Mesa getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Mesa id_mesa) {
        this.id_mesa = id_mesa;
    }
    
    
    
}
