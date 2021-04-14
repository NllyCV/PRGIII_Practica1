/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_2;

import java.io.Serializable;

public class Cancion implements Serializable {

    static final long serialVersionUID = 43L;
    
    //atributos
    private String nombreCancion;
    private float duracion;
    private String genero;

    //metodos
    public void mostrarCancion() {
        System.out.println("\tTítulo: " + this.nombreCancion);
        System.out.println("\tDuración: " + this.duracion);
        System.out.println("\tGénero: " + this.genero);
        System.out.println(".....................................");
    }

    //getter & setter
    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
