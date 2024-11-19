
import java.util.List;

public interface AdministracionService {
    void agregarVuelo(Vuelo vuelo, List<Vuelo> vuelos);
    void editarVuelo(String vueloId, Vuelo vueloEditado, List<Vuelo> vuelos);
    void eliminarVuelo(String vueloId, List<Vuelo> vuelos);
    void gestionarHorario(String vueloId, Horario nuevoHorario, List<Vuelo> vuelos);
}
