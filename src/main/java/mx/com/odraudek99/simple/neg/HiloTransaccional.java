package mx.com.odraudek99.simple.neg;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class HiloTransaccional implements Runnable {

	final static Logger logger = Logger.getLogger(HiloTransaccional.class);
	
	
	NegocioImpl negocioImpl;
	
	private String nombreHilo;
	private Integer id;
	
	public static List<String> errores = new ArrayList<String>();
	
	public HiloTransaccional(Integer id, String nombreHilo, NegocioImpl negocioImpl) {
		this.nombreHilo = nombreHilo;
		this.id=id;
		this.negocioImpl=negocioImpl;
	}

	public void run() {
		logger.info("Inicia hilo: "+this.id+", "+this.nombreHilo);
		try {
			negocioImpl.actualizaPadre(id, "H_"+nombreHilo);
		} catch (ServiceException e) {
			logger.error("Error :::: "+e.getMensaje());
			errores.add("Error: "+nombreHilo);
		}
		logger.info("Termina hilo: "+nombreHilo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}
	
	

}
