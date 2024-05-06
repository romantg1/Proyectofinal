import java.util.Random;
import java.util.Scanner;
public class proyectofinal {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        Equipo [] equipos = rellenarEquipos();
        int a = 0;
        do {
            System.out.println("1- Nueva jornada \t 2- Mostrar clasificacion \t 3- Finalizar liga");
            a = leer.nextInt();
            switch (a){
                case 1:
                    añadirResultados(equipos);
                    break;
                case 2:
                    ordenar(equipos);
                    clasificacion(equipos);
                    break;
                case 3:
                    clasificacion(equipos);
                    break;
            }
        }while(a!=3);
    }
    // Método para añadir los equipos que formarán la liga
    public static Equipo[] rellenarEquipos(){
        System.out.println("Cuantos equipos forman la liga?");
        int nEquipos = leer.nextInt();
        leer.nextLine();
        Equipo [] equipos=new Equipo[nEquipos];
        System.out.println("Introduce el nombre de los "+nEquipos+" equipos");
        for (int i = 0; i < nEquipos; i++) {
            equipos[i]=new Equipo(leer.nextLine(), 0,0,0,0);
        }
        return equipos;
    }
    //Método para mostrar la clasificación de la liga
    public static void clasificacion(Equipo[]equipos){
        int cont=1;
        System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n","POSICION", "EQUIPO", "PUNTOS", "PJ", "PG", "PE", "PP");
        for (int i = equipos.length-1; i > 0; i--) {
            System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n",
                    cont++,
                    equipos[i].getNombre(),
                    equipos[i].getPuntos(),
                    (equipos[i].getPartidosGanados()+equipos[i].getPartidosEmpatados()+equipos[i].getPartidosPerdidos()),
                    equipos[i].getPartidosGanados(),
                    equipos[i].getPartidosEmpatados(),
                    equipos[i].getPartidosPerdidos());
        }
    }
    //Método para añadir los resultados de una nueva jornada a la liga
    public static void añadirResultados(Equipo[]equipos){
        for (int i = 0; i < equipos.length; i++) {
            System.out.println("Cual fue el resultado del "+equipos[i].getNombre()+" ?");
            System.out.println("(1 = Victoria\t2 = Empate\t3 = Derrota)");
            int resultado = leer.nextInt();
            if (resultado == 1){
                equipos[i].setPartidosGanados(equipos[i].getPartidosGanados()+1);
            } else if (resultado == 2) {
                equipos[i].setPartidosEmpatados(equipos[i].getPartidosEmpatados()+1);
            } else if (resultado == 3) {
                equipos[i].setPartidosPerdidos(equipos[i].getPartidosPerdidos()+1);
            } else {
                System.out.println("Resultado incorrecto");
                i--;
            }
            calcurarPuntos(equipos);
        }
    }

    public static void calcurarPuntos(Equipo[]equipos){
        for (int i = 0; i < equipos.length; i++) {
            equipos[i].setPuntos((equipos[i].getPartidosGanados()*3)+equipos[i].getPartidosEmpatados());
        }
    }
    public static void ordenar(Equipo[] equipos) {
        boolean cambio;
        do {
            cambio = false;
            for (int i = 0; i < equipos.length - 1; i++) {
                if (equipos[i].getPuntos() > equipos[i + 1].getPuntos()) {
                    Equipo temp = equipos[i];
                    equipos[i] = equipos[i + 1];
                    equipos[i + 1] = temp;
                    cambio = true;
                }
            }
        } while (cambio);
    }
}
