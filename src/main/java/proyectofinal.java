import java.util.Scanner;
public class proyectofinal {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        Equipo [] equipos = rellenarEquipos();
        clasificacion(equipos);
    }
    // Método para añadir los equipos que formarán la liga
    public static Equipo[] rellenarEquipos(){
        System.out.println("Cuantos equipos forman la liga?");
        int nEquipos = leer.nextInt();
        leer.nextLine();
        Equipo [] equipos=new Equipo[nEquipos];
        System.out.println("Introduce el nombre de los "+nEquipos+" equipos");
        for (int i = 0; i < nEquipos; i++) {
            equipos[i]=new Equipo(leer.nextLine(), 0,0,0);
        }
        return equipos;
    }
    //Método para mostrar la clasificación de la liga
    public static void clasificacion(Equipo[]equipos){
        System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n","POSICION", "EQUIPO", "PUNTOS", "PJ", "PG", "PE", "PP");
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n",
                    i+1,
                    equipos[i].getNombre(),
                    ((equipos[i].getPartidosGanados()*3)+equipos[i].getPartidosGanados()),
                    (equipos[i].getPartidosGanados()+equipos[i].getPartidosEmpatados()+equipos[i].getPartidosPerdidos()),
                    equipos[i].getPartidosGanados(),
                    equipos[i].getPartidosEmpatados(),
                    equipos[i].getPartidosPerdidos());
        }
    }
}
