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

    public Mesa getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Mesa id_mesa) {
        this.id_mesa = id_mesa;
    }
    
    
    
}
