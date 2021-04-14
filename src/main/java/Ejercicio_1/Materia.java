/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_1;

import java.io.Serializable;

public class Materia implements Serializable {

    static final long serialVersionUID = 42L;
    
    //atributos
    private String nombreMateria;
    private int añoMateria;
    private int horaMateria;

    //metodos
    public void mostrar() {
        System.out.println("Materia: " + this.nombreMateria);
        System.out.println("Año:" + this.añoMateria);
        System.out.println("Hora: " + this.horaMateria);
        System.out.println(".................................");
    }

    //getter & setter
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAñoMateria() {
        return añoMateria;
    }

    public void setAñoMateria(int añoMateria) {
        this.añoMateria = añoMateria;
    }

    public int getHoraMateria() {
        return horaMateria;
    }

    public void setHoraMateria(int horaMateria) {
        this.horaMateria = horaMateria;
    }

}
