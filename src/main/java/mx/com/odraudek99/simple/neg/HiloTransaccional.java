package mx.com.odraudek99.simple.neg;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class HiloTransaccional implements Runnable {

	final static Logger logger = Logger.getLogger(HiloTransaccional.class);
	
	
	NegocioImpl negocioImpl;
	
	private String nombreHilo;
	private Integer id;
	
	
	public HiloTransaccional(Integer id, String nombreHilo, NegocioImpl negocioImpl) {
		this.nombreHilo = nombreHilo;
		this.id=id;
		this.negocioImpl=negocioImpl;
	}

	public void run() {
		logger.info("Inicia hilo: "+this.id+", "+this.nombreHilo);
		negocioImpl.actualizaPadre(id, "Hilo: "+nombreHilo);
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
