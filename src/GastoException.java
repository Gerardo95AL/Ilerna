
public class GastoException extends Exception {

		private String error;
		public GastoException() {
			this.error = "No dispone de saldo suficiente";
		}
	    @Override
	    public String getMessage(){
	        return error;
	    }  
		}

