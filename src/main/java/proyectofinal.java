import java.util.Scanner;

public class proyectofinal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuantos equipos forman la liga?");
        int nEquipos = leer.nextInt();
        Equipo [] equipos=new Equipo[nEquipos];
        System.out.println("Introduce el nombre de los "+nEquipos+" equipos");
        Scanner leer2 = new Scanner(System.in);
        for (int i = 0; i < nEquipos; i++) {
            equipos[i]=new Equipo(leer2.nextLine(), 0,0,0);
        }
        System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n","POSICION", "EQUIPO", "PUNTOS", "PJ", "PG", "PE", "PP");
        for (int i = 0; i < nEquipos; i++) {
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
