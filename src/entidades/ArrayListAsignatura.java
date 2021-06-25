/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.ArrayList;

/**
 *
 * @author Jsmith
 */
public class ArrayListAsignatura {
    
    private ArrayList<Asignatura> asignaturas; 

    public ArrayListAsignatura(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

}
