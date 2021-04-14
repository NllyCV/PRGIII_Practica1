/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_4;

import java.io.Serializable;
import java.util.Scanner;

public class Archivo implements Serializable {

    static final long serialVersionUID = 43L;

    //atributos
    String nombreArchivo;
    double tamañoArchivo;

    transient Scanner leer = new Scanner(System.in);

    //metodos
    public void mostrar() {
        System.out.println("\t" + this.nombreArchivo + "\t" + this.tamañoArchivo + " MB");
    }

    //getter & setter
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public double getTamañoArchivo() {
        return tamañoArchivo;
    }

    public void setTamañoArchivo(double tamañoArchivo) {
        this.tamañoArchivo = tamañoArchivo;
    }

}
