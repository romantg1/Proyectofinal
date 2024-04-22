import java.util.Comparator;
import java.util.Objects;

public class Equipo {
    public String nombre;
    public int partidosGanados;
    public int partidosPerdidos;
    public int partidosEmpatados;
    public int puntos;

    public Equipo() {
    }

    public Equipo(String nombre, int partidosGanados, int partidosPerdidos, int partidosEmpatados, int puntos) {
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        this.puntos = partidosGanados*3+partidosEmpatados;
    }

    public Equipo(int partidosGanados, int partidosPerdidos, int partidosEmpatados, int puntos) {
    }

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

    @Override
    public String toString() {
        return nombre+"\t"+puntos+"\t"+partidosGanados+"\t"+partidosEmpatados+"\t"+partidosPerdidos;
    }
}



