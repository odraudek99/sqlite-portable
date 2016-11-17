package mx.com.odraudek99.simple.dto;

public class THija {

	@Override
	public String toString() {
		return "THija [idTHija=" + idTHija + ", idTPadre=" + idTPadre + ", estatus=" + estatus + "]";
	}
	private Integer idTHija;
	private String descripcion;
	private Integer idTPadre;
	private String estatus;
	
	
	public THija() {}
	
	public THija(Integer idTHija) {
		this.idTHija = idTHija;
	}
	
	public THija(Integer idTHija, String estatus) {
		this.idTHija = idTHija;
		this.estatus=estatus;
	}

	public Integer getIdTHija() {
		return idTHija;
	}
	public void setIdTHija(Integer idTHija) {
		this.idTHija = idTHija;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdTPadre() {
		return idTPadre;
	}
	public void setIdTPadre(Integer idTPadre) {
		this.idTPadre = idTPadre;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	
	
}
