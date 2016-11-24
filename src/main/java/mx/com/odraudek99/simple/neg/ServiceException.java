package mx.com.odraudek99.simple.neg;

public class ServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	private Exception exception;
	
	public ServiceException() {
		
	}
	public ServiceException(String mensaje) {
		this.mensaje = mensaje;
	}
	public ServiceException(String mensaje, Exception exception) {
		this.mensaje = mensaje;
		this.exception = exception;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	

}
