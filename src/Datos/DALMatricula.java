/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import entidades.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jsmith
 */
public class DALMatricula {

    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static final int tamañoRegistro = 150;
    private static final String ARCHIVO = "matricula.txt";  
    
    public void crearArchivo() {
        try {
            flujo = new RandomAccessFile(ARCHIVO, "rw");
            numeroRegistros = (int) Math.ceil((double) flujo.length() / (double) tamañoRegistro);
        } catch (IOException ex) {
            System.err.println("Problema al crear el flujo: " + ex.getMessage());
        }
    }
    
    public static void cerrarFlujo(){
        try {
            flujo.close();
            System.out.println("  Flujo cerrado correctamente");
        } catch (IOException ex) {
            System.err.println("No se pudo cerrar");
        }
    }
    
    public static int getNumeroRegistros() {
        return numeroRegistros;
    }
    
    public void añadirMatricula(Matricula matricula){
        crearArchivo();
        if(setMatricula(numeroRegistros, matricula)){
            JOptionPane.showMessageDialog(null,"Matricula Añadido","Mensaje",1);
            numeroRegistros++;
        }
    }
    
    public boolean setMatricula(int i, Matricula matricula) {
        boolean verificador = false;
        if (i >= 0 && i <= numeroRegistros) {
            if (matricula.getTamaño() > tamañoRegistro) {
                System.err.println("Tamaño de registro matricula excedido");
                
            } else {
                try {
                    flujo.seek(i * tamañoRegistro);
                    flujo.writeInt(matricula.getPerido().getAño());
                    flujo.writeUTF(matricula.getPerido().getSemestre());
                    flujo.writeUTF(matricula.getFecha());
                    flujo.writeUTF(matricula.getAlumno().getCodigo());
                    flujo.writeUTF(matricula.getAlumno().getApellidos());
                    flujo.writeUTF(matricula.getAlumno().getNombre());
                    flujo.writeUTF(matricula.getAlumno().getDireccion());
                    flujo.writeUTF(matricula.getAlumno().getDni());
                    flujo.writeBoolean(true);
                   

                    cerrarFlujo();
                    verificador = true;
                } catch (IOException ex) {
                    System.err.println("Error en " + ex);
                    verificador = false;
                }
            }
        } else {
            System.err.println("Número de registro fuera de límites.");
        }
        cerrarFlujo();
        return verificador;
    }
    
    public Matricula getMatricula(int i) {
        Matricula matricula = null;
        crearArchivo();
        if (i >= 0 && i <= getNumeroRegistros()) {
            try {
                flujo.seek(i * tamañoRegistro);
                PeriodoAcademico periodo = new PeriodoAcademico(flujo.readInt(), flujo.readUTF());
                String fecha = flujo.readUTF();
                 Estudiante alumno = new Estudiante(flujo.readUTF(), flujo.readUTF(), flujo.readUTF(), flujo.readUTF(),
                         flujo.readUTF(), flujo.readBoolean());
                 
                matricula = new Matricula(periodo, fecha, alumno);
            } catch (Exception e) {
                System.err.println("Error al retornar matricula");
            }

        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        cerrarFlujo();
        return matricula;
    }
    
    public ArrayList<Matricula> getMatriculas(){
        ArrayList<Matricula> matriculas = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < getNumeroRegistros(); i++) {
                matriculas.add(getMatricula(i));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodo getMatriculas");
        }
        cerrarFlujo();
        return matriculas;
    }
    
}
