package reserva_de_vuelos;

public class Asiento {
	
	private String numeroAsiento;
	private TipoAsiento tipo;
	private boolean ocupado;
	
	public Asiento(String numeroAsiento, TipoAsiento tipo, boolean ocupado) {
		this.numeroAsiento = numeroAsiento;
		this.tipo = tipo;
		this.ocupado = ocupado;
	}
	
	public void actualizarDisponibilidad(boolean disponibilidad) {
		this.ocupado = disponibilidad;
	}
	//ocupado o libre
	public boolean obtenerEstado() {
		return ocupado;
	}
	public String getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public TipoAsiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoAsiento tipo) {
		this.tipo = tipo;
	}
}
