
public class Usuario {
	
	//Se definen los atributos de la clase Usuario
	private String nombre;
	private int edad;
	private String DNI;

	//Constructor por defecto
	public Usuario() {
		this.nombre = "";
		this.edad = 0;
		this.DNI = "";
	}
		
	public Usuario (String nombre, int edad, String DNI){
	this.nombre = nombre;
	this.edad = edad;
	this.DNI = DNI;
	};
	
	//Se crean los metodos de la clase Usuario
	


	public String getNombre () {
	return nombre;
	}
	
	public void setNombre (String nombre) {
	this.nombre = nombre;
	}
	
	public int getEdad () {
	return edad;
	}
	
	public void setEdad (int edad) {
	this.edad = edad;
	}
	
	public String getDNI () {
	return DNI;
	}
	

	
    public boolean setDNI(String DNI){
        if(DNI.matches("^[0-9]{8}[a-zA-Z]$") || DNI.matches("^[0-9]{8}[-][a-zA-Z]$")){
        this.DNI= DNI;
        return true;
        }
        else{
            return false;
        }      
    }
	
	@Override
	public String toString() {
	return "Nombre del usuario " + this.nombre +" Edad " + this.edad +" DNI " + this.DNI; 
	}
	
	
}
