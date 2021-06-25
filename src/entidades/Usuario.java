/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

public class Usuario {
    
    private Estudiante alumno;
    private String usuario;
    private String contraseña;

    public Usuario(Estudiante alumno, String usuario, String contraseña) {
        this.alumno = alumno;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Estudiante getAlumno() {
        return alumno;
    }

    public void setAlumno(Estudiante alumno) {
        this.alumno = alumno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

     public int getTamaño() {
        return (getAlumno().getTamaño()
                + getContraseña().length()*2+ 2
                + getUsuario().length()*2+ 2
);
    }
    
}
