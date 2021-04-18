
public class GastoException extends Exception {
	//Definición de variables
		private String error;
		//Método de la excepción.
		public GastoException() {

			this.error = "No dispone de saldo suficiente";
		}
	//Metodo toString para mostrar la excepción en un futuro.
	    @Override
	    public String getMessage(){
			return error;
	    }  
		}

