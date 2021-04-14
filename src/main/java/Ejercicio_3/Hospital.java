/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital implements Serializable {

    static final long serialVersionUID = 41L;
    
    //atributos
    private String nombre;
    private String direccion;
    private int nivel;

    //definición agregación
    private List<Especialidad> listaEspecialidad;

    transient Scanner leer = new Scanner(System.in);

    public Hospital() {
        listaEspecialidad = new ArrayList<>();
    }

    //metodos
    public void registrar() {
        System.out.println("... R E G I S T R O .................");
        System.out.println("Nombre: ");
        setNombre(leer.nextLine());
        System.out.println("Dirección: ");
        setDireccion(leer.nextLine());
        System.out.println("Nivel: ");
        setNivel(leer.nextInt());
        leer.nextLine();
    }

    public void agrEspecialidad(Especialidad esp) {
        listaEspecialidad.add(esp);
        System.out.println("\t¡Registro Realizado!");
        System.out.println("");
    }

    public void mostrar() {
        System.out.println(".....................................");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Dirección:" + this.direccion);
        System.out.println("Nivel: " + this.nivel);
        if (listaEspecialidad.size() > 0) {
            System.out.println("....ESPECIALIDADES...................");
            for (Especialidad e : listaEspecialidad) {
                e.mostrar();
            }
        } else {
            System.out.println("\tSin especialidades asignadas");
            System.out.println("");
        }
    }

    //getter & setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Especialidad> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }

}
