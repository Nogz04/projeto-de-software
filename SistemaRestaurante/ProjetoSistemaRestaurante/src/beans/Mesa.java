
package beans;

public class Mesa {
    
    private int id;
    private int numMesa;

    public Mesa(int id, int numMesa) {
        this.id = id;
        this.numMesa = numMesa;
    }
    
    public Mesa(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }


    @Override
    public String toString() {
        return numMesa + "";
    }
    
   
    
}
