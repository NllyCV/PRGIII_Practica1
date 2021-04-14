/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_3;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        OperacionesHospitalEspecialidad op = new OperacionesHospitalEspecialidad();
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        do {
            System.out.println("    M E N U  D E  O P C I O N E S    ");
            System.out.println(".....................................");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Registrar Hospital");
            System.out.println("3. Crear Especialidad");
            System.out.println("4. Guardar Registros");
            System.out.println("5. Mostrar Hospitales");
            System.out.println("6. Listar Especialidades por Hospital");
            System.out.println("7. Listar Hospitales por Especialidad");
            System.out.println("8. Salir");
            System.out.println("Ingrese una Opción > ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.registrarHospital();
                    break;
                case 3:
                    op.crearEspecialidad();
                    break;
                case 4:
                    op.guardarObjetos();
                    System.out.println("\t¡Registros Guardados!");
                    break;
                case 5:
                    op.leerHospital();
                    op.mostrarHospital();
                    break;
                case 6:
                    op.verEspecialidad();
                    break;
                case 7:
                    op.verHospital();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }

}
