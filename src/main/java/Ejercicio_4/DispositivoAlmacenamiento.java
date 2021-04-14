/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_4;

import java.io.Serializable;
import java.util.Scanner;

public class DispositivoAlmacenamiento implements Serializable {

    static final long serialVersionUID = 41L;

    //atributos
    String marca;
    double capacidad;
    double espacioDisponible;

    transient Scanner leer = new Scanner(System.in);

    //metodos
    public void llenar() {
        System.out.println("... R E G I S T R O .................");
        System.out.println("Marca:");
        this.marca = leer.nextLine();
        System.out.println("Capacidad en MB:");
        this.capacidad = leer.nextDouble();
        System.out.println("Espacio Disponible en MB:");
        this.espacioDisponible = leer.nextDouble();
        leer.nextLine();
    }

    public void mostrar() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Capacidad: " + this.capacidad + " MB");
        System.out.println("Espacio Disponible: " + this.espacioDisponible + " MB");
    }

    //getter & setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }

}
