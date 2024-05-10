import java.util.Comparator;
import java.util.Objects;

// Esta clase representa un equipo en la liga
public class Equipo {
    // Atributos de la clase Equipo
    public String nombre; // Nombre del equipo
    public int partidosGanados; // Número de partidos ganados
    public int partidosPerdidos; // Número de partidos perdidos
    public int partidosEmpatados; // Número de partidos empatados
    public int puntos; // Puntuación total del equipo

    // Constructor vacío
    public Equipo() {
    }

    // Constructor con todos los atributos
    public Equipo(String nombre, int partidosGanados, int partidosPerdidos, int partidosEmpatados, int puntos) {
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        // Calcula los puntos basados en los partidos ganados y empatados
        this.puntos = partidosGanados * 3 + partidosEmpatados;
    }

    // Constructor sin el nombre (para uso futuro)
    public Equipo(int partidosGanados, int partidosPerdidos, int partidosEmpatados, int puntos) {
    }

    // Getters y setters de los atributos de Equipo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Método toString para representar un equipo como una cadena de texto
    @Override
    public String toString() {
        return nombre + "\t" + puntos + "\t" + partidosGanados + "\t" + partidosEmpatados + "\t" + partidosPerdidos;
    }
}




