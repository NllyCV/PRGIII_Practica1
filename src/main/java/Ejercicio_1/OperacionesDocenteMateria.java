/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_1;

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

public class OperacionesDocenteMateria {

    private Docente docente;
    private Materia materia;

    List<Docente> listaDocente;
    transient Scanner leer = new Scanner(System.in);

    public OperacionesDocenteMateria() {
        listaDocente = new ArrayList<>();
    }

    //metodos
    public void crearDocente() {
        docente = new Docente();
        System.out.println("... R E G I S T R O ...........");
        System.out.println("Nombre: ");
        docente.setNombre(leer.nextLine());
        System.out.println("Paterno: ");
        docente.setPaterno(leer.nextLine());
        System.out.println("Materno: ");
        docente.setMaterno(leer.nextLine());
        System.out.println("Título: ");
        docente.setTitulo(leer.nextLine());
        System.out.println("Carga Horaria: ");
        docente.setCargaHoraria(leer.nextInt());
        leer.nextLine();
        listaDocente.add(docente);
        System.out.println("\t¡Registro Realizado!");
        System.out.println("");
    }

    public void crearMateria() {
        materia = new Materia();
        System.out.println("... R E G I S T R O ...........");
        System.out.println("Materia: ");
        materia.setNombreMateria(leer.nextLine());
        System.out.println("Año: ");
        materia.setAñoMateria(leer.nextInt());
        System.out.println("Hora: ");
        materia.setHoraMateria(leer.nextInt());
        leer.nextLine();
        docente.adiMateria(materia);
    }

    public void asignarMateriaDocente() {
        if (docente != null && materia != null) {
            docente.setMateria(materia);
            System.out.println("\t¡Asignación Realizada!");
            System.out.println("");
        } else {
            System.out.println("\tSin registros");
            System.out.println("");
        }
    }

    public void mostrarDocente() {
        if (listaDocente != null && listaDocente.size() > 0) {
            System.out.println("    INFORMACIÓN  DEL  DOCENTE    ");
            System.out.println(".................................");
            for (Docente doc : listaDocente) {
                doc.mostrar();
            }
        } else {
            System.out.println("\tSin registros");
            System.out.println("");
        }
    }

    //creando archivo
    public void crearArchivo() {
        Path path = Paths.get("E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoDocenteMateria.txt");
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

    //guardando listaDocente
    public void guardarObjetos() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoDocenteMateria.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaDocente);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //cargando datos a list<Docente>
    public void leerDocente() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoDocenteMateria.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                listaDocente = (List<Docente>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
