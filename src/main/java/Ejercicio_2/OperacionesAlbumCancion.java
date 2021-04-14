/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_2;

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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesAlbumCancion {

    private Album album;
    private Cancion cancion;

    List<Album> listaAlbum;
    transient Scanner leer = new Scanner(System.in);

    public OperacionesAlbumCancion() {
        listaAlbum = new ArrayList<>();
    }

    //metodos
    public void crearAlbum() {
        album = new Album();
        System.out.println("... R E G I S T R O ................");
        System.out.println("Nombre Álbum: ");
        album.setNombre(leer.nextLine());
        System.out.println("Artista: ");
        album.setArtista(leer.nextLine());
        System.out.println("Tipo de Formato: ");
        album.setFormato(leer.nextLine());
        System.out.println("Nro de Canciones: ");
        int nc = leer.nextInt();
        leer.nextLine();
        System.out.println("");
        System.out.println("... C A N C I O N E S ..............");
        for (int i = 1; i <= nc; i++) {
            cancion = new Cancion();
            System.out.println("Nombre de la Canción: ");
            cancion.setNombreCancion(leer.nextLine());
            System.out.println("Tiempo de Duración: ");
            cancion.setDuracion(leer.nextFloat());
            leer.nextLine();
            System.out.println("Género Musical: ");
            cancion.setGenero(leer.nextLine());
            album.adicionarCancion(cancion);
            System.out.println("....................................");
        }
        listaAlbum.add(album);
        System.out.println("\t¡Registro Realizado!");
    }

    public void mostrarInfo() {
        System.out.println(".....................................");
        System.out.println("        C O L E C C I O N E S        ");
        System.out.println(".....................................");
        if (listaAlbum != null && listaAlbum.size() > 0) {
            for (Album alb : listaAlbum) {
                alb.mostrarAlbum();
            }
        } else {
            System.out.println("\t- Sin registros -");
            System.out.println("");
        }
    }

    public void buscarCancion() {
        int sw = 0;
        System.out.println("Ingrese canción: ");
        String cancionBuscar = leer.nextLine();
        System.out.println(".....................................");
        System.out.println("      D A T O S   C A N C I Ó N      ");
        System.out.println(".....................................");
        for (Album alb : listaAlbum) {
            for (Cancion c : album.getListaCanciones()) {
                if (c.getNombreCancion().equalsIgnoreCase(cancionBuscar)) {
                    sw = 1;
                    alb.mostrarAlbumyArtista();
                }
            }
        }
        if (sw == 0) {
            System.out.println("\t- Sin resultados -");
        }
    }

    public void listarPorAlbum() {
        int sw = 0;
        System.out.println("Ingrese nombre del Álbum: ");
        String albumBuscar = leer.nextLine();
        for (Album alb : listaAlbum) {
            if (alb.getNombre().equalsIgnoreCase(albumBuscar)) {
                sw = 1;
                alb.mostrarCanciones();
            }
        }
        if (sw == 0) {
            System.out.println("\t- Sin resultados-");
        }
    }

    public void eliminarAlbum() {
        Iterator<Album> iterador = listaAlbum.iterator();
        while (iterador.hasNext()) {
            Album alb = iterador.next();
            if (alb.getNombre().equalsIgnoreCase(album.getNombre())) {
                iterador.remove();
                System.out.println("\tÁlbum Eliminado");
            }
        }
    }

    //creando archivo
    public void crearArchivo() {
        Path path = Paths.get("E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoAlbumCancion.txt");
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

    //guardando listaAlbum
    public void guardarObjetos() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoAlbumCancion.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaAlbum);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //cargando datos a list<Album>
    public void leerAlbum() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoAlbumCancion.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                listaAlbum = (List<Album>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
