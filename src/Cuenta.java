import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	protected double saldo;
	protected Usuario usuario;
	protected List<Gasto> gastos;
	protected List<Ingreso> ingresos;
	
	public Cuenta (Usuario usuario) {
		this.usuario = usuario;
		this.saldo = 0.0;
		this.gastos = new ArrayList<Gasto>();
		this.ingresos = new ArrayList<Ingreso>();
	}
	
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
	
	public double addIngresos (String description, double cantidad) {
		Ingreso nuevoIngreso = new Ingreso (cantidad, description);
		this.ingresos.add(nuevoIngreso);
		this.saldo = this.saldo + cantidad;
		return saldo;
		
	}
	
	public double addGastos (String description, double cantidad) {
		try{
			this.saldo = this.saldo - cantidad;
						
			if(this.getSaldo()<0) {
				throw new GastoException();
			}
		}
		
		catch (GastoException error) {
			System.out.println(error.getMessage());
		}
		
		Gasto nuevoGasto = new Gasto (cantidad, description);{
		this.gastos.add(nuevoGasto);
		return saldo;
		}
	}
		
	public List<Gasto> getGastos(){
		return gastos;
	}
	public List<Ingreso> getIngresos(){
		return ingresos;
	}
	@Override
	public String toString() {
		return  "Usuario: " + usuario.getNombre() +  " Saldo: " + this.saldo +"€";
	}
}
