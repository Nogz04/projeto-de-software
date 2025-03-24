/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author laboratorio
 */
public class Item {
    
   private int id;
   private String categoriaItem;
   private double valorItem;
   private int quantidadeItem;

    public Item(int id, String categoriaItem, double valorItem, int quantidadeItem) {
        this.id = id;
        this.categoriaItem = categoriaItem;
        this.valorItem = valorItem;
        this.quantidadeItem = quantidadeItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriaItem() {
        return categoriaItem;
    }

    public void setCategoriaItem(String categoriaItem) {
        this.categoriaItem = categoriaItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
   
   
    
}
