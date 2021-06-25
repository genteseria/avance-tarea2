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
//Código, DNI, nombre, apellidos, dirección.
public class Estudiante {
    
   private String codigo;
   private String apellidos;
   private String nombre;
   private String direccion;
   private String dni;
   private boolean activo;

   //240
   
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Estudiante(String codigo, String apellidos, String nombre, String direccion, String dni, boolean activo) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.activo = activo;
    }
    
    public int getTamaño() {
        return (getCodigo().length()*2 + 2
                + getNombre().length()*2+ 2
                + getApellidos().length()*2+ 2
                + getDireccion().length()*2+ 2
                + getDni().length()*2+ 2
                +1);
    }
}
