//Importación de las librerias necesarias.
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	//Variables de la clase Cuenta
	protected double saldo;
	protected Usuario usuario;
	protected List<Gasto> gastos;
	protected List<Ingreso> ingresos;

	//Metodo constructor con parametros
	public Cuenta (Usuario usuario) {
		this.usuario = usuario;
		this.saldo = 0.0;
		this.gastos = new ArrayList<Gasto>();
		this.ingresos = new ArrayList<Ingreso>();
	}

	//Definición de los metodos getter y setter
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo (double saldo){
		this.saldo = saldo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario (Usuario usuario) {
		this.usuario = usuario;
	}

	//Definición del metodo addIngresos para sumar el ingreso al saldo.
	public double addIngresos (String description, double cantidad) {
		Ingreso nuevoIngreso = new Ingreso (cantidad, description);
		this.ingresos.add(nuevoIngreso);
		this.saldo = this.saldo + cantidad;
		return saldo;
		
	}

	//Definición del metodo addGastos para restarel ingreso al saldo.
	public double addGastos (String description, double cantidad) throws GastoException{
			double saldoProvisional = saldo - cantidad;
			//En caso de que el resultado de la resta del gasto al saldo sea negativo, salta la excepción GastoException .
			if(saldoProvisional<0) {
				throw new GastoException();
			}

		Gasto nuevoGasto = new Gasto (cantidad, description);{
		this.gastos.add(nuevoGasto);
		return saldo;
		}
	}
	//Metodo para mostrar el listado de los gastos
	public List<Gasto> getGastos(){
		return gastos;
	}

	//Metodo para mostrar el listado de los ingresos.
	public List<Ingreso> getIngresos(){
		return ingresos;
	}
	//Se define el metodo toString para mostrar por pantalla el saldo.
	@Override
	public String toString() {
		return  "Usuario: " + usuario.getNombre() +  " Saldo: " + this.saldo +"�";
	}
}
