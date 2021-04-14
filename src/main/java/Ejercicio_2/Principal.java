/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_2;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        OperacionesAlbumCancion operacion = new OperacionesAlbumCancion();
        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion = 0;
        do {
            System.out.println("                                    ");
            System.out.println("   M E N U  D E  O P C I O N E S    ");
            System.out.println("....................................");
            System.out.println("\t1. Crear Archivo");
            System.out.println("\t2. Registrar Álbum");
            System.out.println("\t3. Guardar Registros");
            System.out.println("\t4. Mostrar Colecciones");
            System.out.println("\t5. Buscar Canción");
            System.out.println("\t6. Ver Canciones por Álbum");
            System.out.println("\t7. Eliminar Álbum");
            System.out.println("\t8. Salir");
            System.out.println("");
            System.out.println("Ingrese una opción...");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    operacion.crearArchivo();
                    break;
                case 2:
                    operacion.crearAlbum();
                    break;
                case 3:
                    operacion.guardarObjetos();
                    System.out.println("\t¡Registros Guardados!");
                    break;
                case 4:
                    operacion.leerAlbum();
                    operacion.mostrarInfo();
                    break;
                case 5:
                    operacion.buscarCancion();
                    break;
                case 6:
                    operacion.listarPorAlbum();
                    break;
                case 7:
                    operacion.eliminarAlbum();
                    operacion.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }

}
