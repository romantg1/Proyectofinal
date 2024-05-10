import java.util.Random;
import java.util.Scanner;

// Clase principal del proyecto

/**
 * @author daw128
 * @version final
 */
public class proyectofinal {
    // Objeto Scanner para entrada de datos
    static Scanner leer = new Scanner(System.in);

    /**
     * Método principal del programa
     * @param args
     */
    // Método principal del programa
    public static void main(String[] args) {
        // Se crean los equipos y se guarda en la variable equipos
        Equipo[] equipos = rellenarEquipos();
        // Variable para guardar la opción seleccionada por el usuario
        int opcion = 0;
        // Bucle que se repite hasta que el usuario decide finalizar la liga
        do {
            // Se muestran las opciones disponibles
            System.out.println("1- Nueva jornada \t 2- Mostrar clasificacion \t 3- Finalizar liga");
            // Se lee la opción seleccionada por el usuario
            opcion = leer.nextInt();
            // Se ejecuta la acción correspondiente a la opción seleccionada
            switch (opcion){
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
        } while (opcion != 3); // El bucle se repite hasta que el usuario selecciona la opción 3
    }
    /**
     * Método para añadir los equipos que formarán la liga
     * @param
     */
    // Método para añadir los equipos que formarán la liga
    public static Equipo[] rellenarEquipos(){
        // Se solicita al usuario ingresar la cantidad de equipos
        System.out.println("Cuantos equipos forman la liga?");
        int nEquipos = leer.nextInt();
        leer.nextLine(); // Se consume el salto de línea pendiente
        // Se crea un arreglo de objetos Equipo con la cantidad de equipos ingresada por el usuario
        Equipo[] equipos = new Equipo[nEquipos];
        // Se solicita al usuario ingresar el nombre de cada equipo y se crea un objeto Equipo con ese nombre
        System.out.println("Introduce el nombre de los " + nEquipos + " equipos");
        for (int i = 0; i < nEquipos; i++) {
            equipos[i] = new Equipo(leer.nextLine(), 0, 0, 0, 0);
        }
        return equipos; // Se devuelve el arreglo de equipos creado
    }
    /**
     * Método para mostrar la clasificación de la liga
     * @param
     */
    // Método para mostrar la clasificación de la liga
    public static void clasificacion(Equipo[] equipos){
        // Contador para enumerar los equipos en la clasificación
        int cont = 1;
        // Se imprime la cabecera de la tabla de clasificación
        System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n","POSICION", "EQUIPO", "PUNTOS", "PJ", "PG", "PE", "PP");
        // Se recorre el arreglo de equipos (de atrás hacia adelante) para mostrar la clasificación
        for (int i = equipos.length-1; i >= 0; i--) {
            // Se imprime la información de cada equipo en la clasificación
            System.out.printf("%-9s%-20s%-8s%-3s%-3s%-3s%-3s%n",
                    cont++,
                    equipos[i].getNombre(),
                    equipos[i].getPuntos(),
                    (equipos[i].getPartidosGanados() + equipos[i].getPartidosEmpatados() + equipos[i].getPartidosPerdidos()),
                    equipos[i].getPartidosGanados(),
                    equipos[i].getPartidosEmpatados(),
                    equipos[i].getPartidosPerdidos());
        }
    }
    /**
     * Método para añadir los resultados de una nueva jornada a la liga
     * @param
     */
    // Método para añadir los resultados de una nueva jornada a la liga
    public static void añadirResultados(Equipo[] equipos){
        // Bucle para recorrer todos los equipos y solicitar los resultados de sus partidos
        for (int i = 0; i < equipos.length; i++) {
            // Se solicita al usuario ingresar el resultado del partido para el equipo actual
            System.out.println("Cual fue el resultado del " + equipos[i].getNombre() + " ?");
            System.out.println("(1 = Victoria\t2 = Empate\t3 = Derrota)");
            int resultado = leer.nextInt(); // Se lee el resultado ingresado por el usuario
            // Se actualizan los datos del equipo según el resultado ingresado
            if (resultado == 1){
                equipos[i].setPartidosGanados(equipos[i].getPartidosGanados() + 1);
            } else if (resultado == 2) {
                equipos[i].setPartidosEmpatados(equipos[i].getPartidosEmpatados() + 1);
            } else if (resultado == 3) {
                equipos[i].setPartidosPerdidos(equipos[i].getPartidosPerdidos() + 1);
            } else {
                System.out.println("Resultado incorrecto");
                i--; // Se resta 1 a i para repetir la pregunta sobre el mismo equipo
            }
            // Se recalculan los puntos del equipo luego de ingresar el resultado
            calcularPuntos(equipos);
        }
    }
    /**
     * Método para calcular los puntos de cada equipo en base a los resultados
     * @param
     */
    // Método para calcular los puntos de cada equipo en base a los resultados
    public static void calcularPuntos(Equipo[] equipos){
        // Bucle para recorrer todos los equipos y calcular sus puntos
        for (int i = 0; i < equipos.length; i++) {
            equipos[i].setPuntos((equipos[i].getPartidosGanados() * 3) + equipos[i].getPartidosEmpatados());
        }
    }
    /**
     * Método para ordenar los equipos según la cantidad de puntos obtenidos
     * @param
     */
    // Método para ordenar los equipos según la cantidad de puntos obtenidos
    public static void ordenar(Equipo[] equipos) {
        boolean cambio;
        // Bucle para repetir el proceso de ordenación hasta que no haya intercambios
        do {
            cambio = false; // Se inicializa cambio como falso
            // Bucle para recorrer los equipos y realizar intercambios si es necesario
            for (int i = 0; i < equipos.length - 1; i++) {
                // Se compara el número de puntos de dos equipos consecutivos y se intercambian si están en el orden incorrecto
                if (equipos[i].getPuntos() > equipos[i + 1].getPuntos()) {
                    Equipo temp = equipos[i]; // Se guarda el equipo actual en una variable temporal
                    equipos[i] = equipos[i + 1]; // Se mueve el equipo siguiente a la posición actual
                    equipos[i + 1] = temp; // Se coloca el equipo guardado en la posición siguiente
                    cambio = true; // Se indica que se realizó un intercambio
                }
            }
        } while (cambio); // El bucle se repite mientras se realicen intercambios
    }
}
