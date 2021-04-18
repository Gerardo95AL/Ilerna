
public class Gasto extends Dinero {
    //constructor con parámetros.
    public Gasto (double gasto, String description) {
        this.dinero=gasto;
        this.description=description;
    }
    //Metodo toString para mostrar la información en un futuro.
    @Override
    public String toString() {
        return "Gasto: " + this.description
                + ", cantidad: " + this.dinero +"�";
    }  
}