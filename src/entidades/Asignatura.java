/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author Jsmith
 */
public class Asignatura {
    
    private String codigo;
    private String nombre;
    private int creditos;
    private int ciclo;
    private boolean estado;
    //90

    public Asignatura(String codigo, String nombre, int creditos, int ciclo,boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.ciclo = ciclo;
        this.estado=estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
        public int getTamaño() {
        return (getCodigo().length()*2 + 2
                + getNombre().length()*2+ 2
                +4
                +4
                +1
                );
    }
}
