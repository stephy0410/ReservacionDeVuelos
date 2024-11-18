

public class Aerolinea {
	
	private String id;
	private String nombre;
	
	public Aerolinea(String id , String nombre) {
		this.id = id;
		this.nombre = nombre;	
	}
	
	public String obtenerDetalles() {
		return "Aerolinea: "+ nombre + "(ID:" + id + ")";
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
