/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */

package Ejercicio_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscoDuro extends DispositivoAlmacenamiento implements Serializable {

    static final long serialVersionUID = 42L;

    //atributo propio
    private String tipoInterfaz;

    //definición agregación
    private List<Archivo> listaArchivos;

    transient Scanner leer = new Scanner(System.in);

    public DiscoDuro() {
        listaArchivos = new ArrayList<>();
    }

    //metodos sobrescritos
    @Override
    public void llenar() {
        super.llenar();
        System.out.println("Tipo de Interfaz:");
        this.tipoInterfaz = leer.nextLine();
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Tipo Interfaz: " + this.tipoInterfaz);
        if (listaArchivos.size() > 0) {
            System.out.println(".....................................");
            System.out.println("\tARCHIVO \tTAMAÑO");
            System.out.println(".....................................");
            for (Archivo arc : listaArchivos) {
                arc.mostrar();
            }
        } else {
            System.out.println("\t- Sin archivos -");
            System.out.println("");
        }
    }

    //metodos propios
    public void addArchivo(Archivo arch) {
        listaArchivos.add(arch);
    }

    //getter & setter
    public String getTipoInterfaz() {
        return tipoInterfaz;
    }

    public void setTipoInterfaz(String tipoInterfaz) {
        this.tipoInterfaz = tipoInterfaz;
    }

    public List<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(List<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

}
