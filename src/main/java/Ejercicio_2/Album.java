/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Album implements Serializable {

    static final long serialVersionUID = 42L;
    
    //atributos
    private String nombre;
    private String artista;
    private String formato;

    //definición composición 
    private List<Cancion> listaCanciones;

    transient Scanner leer = new Scanner(System.in);

    //constructor
    public Album() {
        listaCanciones = new ArrayList<>();
    }

    //metodos
    public void mostrarAlbum() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Artista: " + this.artista);
        System.out.println("Formato: " + this.formato);
        if (listaCanciones.size() > 0) {
            System.out.println("... C A N C I O N E S ...............");
            for (Cancion cancion : listaCanciones) {
                cancion.mostrarCancion();
            }
        }
    }

    public void adicionarCancion(Cancion cancion) {
        listaCanciones.add(cancion);
        System.out.println("\tRegistrando...");
    }

    public void mostrarAlbumyArtista() {
        System.out.println("\tAlbum: " + this.getNombre());
        System.out.println("\tArtista: " + this.artista);
        System.out.println(".....................................");
    }

    public void mostrarCanciones() {
        System.out.println("");
        System.out.println("... C A N C I O N E S ...............");
        for (Cancion cancion : listaCanciones) {
            cancion.mostrarCancion();
        }
    }

    //getter & setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

}
