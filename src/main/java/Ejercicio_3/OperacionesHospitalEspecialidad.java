/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesHospitalEspecialidad {

    private Hospital hospital;
    private Especialidad especialidad;

    List<Hospital> listaHospital;
    transient Scanner leer = new Scanner(System.in);

    public OperacionesHospitalEspecialidad() {
        listaHospital = new ArrayList<>();
    }

    //metodos
    public void registrarHospital() {
        hospital = new Hospital();
        hospital.registrar();
        listaHospital.add(hospital);
        System.out.println("\t¡Registro Realizado!");
        System.out.println("");
    }

    public void crearEspecialidad() {
        especialidad = new Especialidad();
        System.out.println("... R E G I S T R O .................");
        System.out.println("Especialidad: ");
        especialidad.setNomEspecialidad(leer.nextLine());
        hospital.agrEspecialidad(especialidad);
    }

    public void mostrarHospital() {
        if (listaHospital != null && listaHospital.size() > 0) {
            System.out.println("   L I S T A   H O S P I T A L E S   ");
            for (Hospital hos : listaHospital) {
                hos.mostrar();
            }
        } else {
            System.out.println("\t- Sin registros -");
            System.out.println("");
        }
    }

    public void verEspecialidad() {
        int sw = 0;
        if (listaHospital != null && listaHospital.size() > 0) {
            System.out.println("Ingrese nombre del Hospital: ");
            String hosBuscar = leer.nextLine();
            System.out.println("");
            System.out.println("        INFORMACIÓN  HOSPITAL        ");
            for (Hospital hos : listaHospital) {
                if (hos.getNombre().equalsIgnoreCase(hosBuscar)) {
                    sw = 1;
                    hos.getListaEspecialidad();
                    hos.mostrar();
                    System.out.println("");
                }
            }
        }
        if (sw == 0) {
            System.out.println("\t- Sin registros -");
            System.out.println("");
        }
    }

    public void verHospital() {
        int sw = 0;
        if (listaHospital != null && listaHospital.size() > 0) {
            System.out.println("Ingrese especialidad: ");
            String espBuscar = leer.nextLine();
            System.out.println("");
            System.out.println("        INFORMACIÓN  HOSPITAL        ");
            for (Especialidad esp : hospital.getListaEspecialidad()) {
                if (esp.getNomEspecialidad().equalsIgnoreCase(espBuscar)) {
                    sw = 1;
                    hospital.getListaEspecialidad();
                    hospital.mostrar();
                    System.out.println("");
                }
            }
        }
        if (sw == 0) {
            System.out.println("\t- Sin registros -");
            System.out.println("");
        }
    }

    //creando archivo
    public void crearArchivo() {
        Path path = Paths.get("E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoHospitalEspecialidad.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("\tArchivo creado");
            } else {
                System.out.println("\tNo se puede crear - El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }

    //guardando listaHospital
    public void guardarObjetos() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoHospitalEspecialidad.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaHospital);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //cargando datos a list<Hospital>
    public void leerHospital() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoHospitalEspecialidad.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                listaHospital = (List<Hospital>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
