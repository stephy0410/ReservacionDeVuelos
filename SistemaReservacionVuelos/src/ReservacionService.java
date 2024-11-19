

public interface ReservacionService {
	void reservarAsiento(Usuario usuario, Vuelo vuelo, Asiento asiento);
	void cancelarReservacion(String reservacionId);
	void confirmarReservacion(Reservacion reservacion);

}
