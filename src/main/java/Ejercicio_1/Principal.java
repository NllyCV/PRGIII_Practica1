/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        OperacionesDocenteMateria op = new OperacionesDocenteMateria();
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        do {
            System.out.println("  M E N U  D E  O P C I O N E S  ");
            System.out.println(".................................");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Registrar Docente");
            System.out.println("3. Registrar Materia");
            System.out.println("4. Asignar Materia");
            System.out.println("5. Guardar Registros");
            System.out.println("6. Información Docente");
            System.out.println("7. Salir");
            System.out.println("Ingrese una Opción > ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.crearDocente();
                    break;
                case 3:
                    op.crearMateria();
                    break;
                case 4:
                    op.asignarMateriaDocente();
                    break;
                case 5:
                    op.guardarObjetos();
                    System.out.println("\t¡Registros Guardados!");
                    break;
                case 6:
                    op.leerDocente();
                    op.mostrarDocente();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
