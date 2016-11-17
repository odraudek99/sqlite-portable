package mx.com.odraudek99.simple.dto;

import java.util.ArrayList;
import java.util.List;

public class TPadre {

	private Integer idTPadre;
	private String descripcion;
	private Integer estatus;
	
	private List<THija> detalle;
	
	public TPadre() {
		
	}
	public TPadre(Integer idTPadre) {
		super();
		this.idTPadre = idTPadre;
	}
	
	
	public Integer getIdTPadre() {
		return idTPadre;
	}
	public void setIdTPadre(Integer idTPadre) {
		this.idTPadre = idTPadre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public List<THija> getDetalle() {
		
		if (detalle == null) {
			detalle = new ArrayList<THija>();
		}
		return detalle;
	}
	public void setDetalle(List<THija> detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "TPadre [idTPadre=" + idTPadre + ", estatus=" + estatus +"]";
	}
	
	

}
