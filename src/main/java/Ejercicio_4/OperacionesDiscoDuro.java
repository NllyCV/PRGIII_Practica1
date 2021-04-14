/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_4;

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

public class OperacionesDiscoDuro {

    private DiscoDuro disco;
    private Archivo archivo;

    List<DiscoDuro> listaAlmacenamiento;
    transient Scanner leer = new Scanner(System.in);

    public OperacionesDiscoDuro() {
        listaAlmacenamiento = new ArrayList<>();
    }

    //metodos
    public void crearDisco() {
        disco = new DiscoDuro();
        disco.llenar();
        listaAlmacenamiento.add(disco);
        System.out.println("\t¡Registro Realizado!");
        System.out.println("");
    }

    public void nuevoArchivo() {
        archivo = new Archivo();
        System.out.println("... REGISTRO ARCHIVOS ...............");
        System.out.println("Nombre: ");
        archivo.setNombreArchivo(leer.nextLine());
        System.out.println("Tamaño:");
        archivo.setTamañoArchivo(leer.nextFloat());
        leer.nextLine();
        if (archivo.getTamañoArchivo() < disco.capacidad && archivo.getTamañoArchivo() < disco.espacioDisponible) {
            disco.espacioDisponible = disco.espacioDisponible - archivo.getTamañoArchivo();
            disco.addArchivo(archivo);
            System.out.println("\t¡Archivo Guardado!");
        } else {
            System.out.println("\tNo se puede agregar - Espacio insuficiente.");
        }
    }

    public void mostrarArchivos() {
        if (listaAlmacenamiento != null && listaAlmacenamiento.size() > 0) {
            System.out.println("         D I S C O   D U R O         ");
            System.out.println(".....................................");
            for (DiscoDuro disc : listaAlmacenamiento) {
                disc.mostrar();
            }
        } else {
            System.out.println("\t- Sin registros -");
            System.out.println("");
        }
    }

    public void eliminarArchivo() {
        int sw = 0;
        System.out.println("   E L I M I N A R   A R C H I V O   ");
        System.out.println("Ingrese nombre del archivo");
        String archEliminar = leer.nextLine();
        for (Archivo a : disco.getListaArchivos()) {
            if (a.getNombreArchivo().equalsIgnoreCase(archEliminar)) {
                sw = 1;
                disco.getListaArchivos().remove(a);
                disco.espacioDisponible = disco.espacioDisponible + archivo.tamañoArchivo;
                System.out.println("\t¡Archivo Eliminado!");
            }
        }
        if (sw == 0) {
            System.out.println("\tArchivo no encontrado");
        }

    }

    //creando archivo
    public void crearArchivo() {
        Path path = Paths.get("E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoDiscoDuro.txt");
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

    //guardando listaAlmacenamiento
    public void guardarObjetos() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoDiscoDuro.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaAlmacenamiento);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //cargando datos a list<DiscoDuro>
    public void leerHospital() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoDiscoDuro.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                listaAlmacenamiento = (List<DiscoDuro>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
