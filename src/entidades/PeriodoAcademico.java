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
public class PeriodoAcademico {
    private int año;
    private String semestre;
    
    //20

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public PeriodoAcademico() {
        año = 0;
        semestre = "NS";
    }


    public PeriodoAcademico(int año, String semestre) {
        this.año = año;
        this.semestre = semestre;
    }
    
    public int getTamaño(){
        return (4
                +getSemestre().length()*2+2);
        
    }
    
}
