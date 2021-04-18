
public class Ingreso extends Dinero {
	//Constructor con parámetros para la clase Dinero.
	public Ingreso (double ingreso, String description) {
		this.dinero = ingreso;
		this.description = description;
	}
	//Metodo toString para mostrar el ingreso y la cantidad.
	@Override
	public String toString() {

		return "Ingreso: " + this.description + ", cantidad: " + this.dinero +"�";
	}

}
