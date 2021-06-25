/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;


public class Matricula {
    
    private PeriodoAcademico perido;
    private String fecha;
    private Estudiante alumno;
    
    //750

    public Matricula(PeriodoAcademico perido, String fecha, Estudiante alumno) {
        this.perido = perido;
        this.fecha = fecha;
        this.alumno = alumno;
    }

    public PeriodoAcademico getPerido() {
        return perido;
    }

    public void setPerido(PeriodoAcademico perido) {
        this.perido = perido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Estudiante getAlumno() {
        return alumno;
    }

    public void setAlumno(Estudiante alumno) {
        this.alumno = alumno;
    }

    
     public int getTamaño() {
        return (getPerido().getTamaño()
                + getFecha().length()*2+ 2
                + getAlumno().getTamaño());

    }
}
