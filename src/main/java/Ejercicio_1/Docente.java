/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Docente implements Serializable {

    static final long serialVersionUID = 41L;
    
    //atributos
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaHoraria;

    //definiendo asociación
    private Materia materia;
    private List<Materia> listaMaterias;

    transient Scanner leer = new Scanner(System.in);

    public Docente() {
        listaMaterias = new ArrayList<>();
    }

    //metodos
    public void adiMateria(Materia materia) {
        listaMaterias.add(materia);
        System.out.println("\t¡Registro Realizado!");
        System.out.println("");
    }

    public void mostrar() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Paterno:" + this.paterno);
        System.out.println("Materno: " + this.materno);
        System.out.println("Título: " + this.titulo);
        System.out.println("Carga Horaria: " + this.cargaHoraria);
        System.out.println("");
        if (listaMaterias.size() > 0) {
            System.out.println("........ M A T E R I A S ........");
            for (Materia mat : listaMaterias) {
                mat.mostrar();
            }
        } else {
            System.out.println("*Sin materias asignadas");
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

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

}
