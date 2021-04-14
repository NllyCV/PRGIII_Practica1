/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_3;

import java.io.Serializable;
import java.util.Scanner;

public class Especialidad implements Serializable {

    static final long serialVersionUID = 42L;
    
    //atributo
    private String nomEspecialidad;

    transient Scanner leer = new Scanner(System.in);

    //metodos
    public void mostrar() {
        System.out.println("\t- " + this.nomEspecialidad);
    }

    //getter & setter
    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }

}
