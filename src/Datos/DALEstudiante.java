/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;
import entidades.Estudiante;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DALEstudiante {
    
    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static final int tamañoRegistro = 240;
    private static final String ARCHIVO = "estudiantes.txt";  
    
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
    
    public void añadirEstudiante(Estudiante alumno){
        crearArchivo();
        if(setEstudiante(numeroRegistros, alumno)){
            JOptionPane.showMessageDialog(null,"Estudiante Añadido","Mensaje",1);
            numeroRegistros++;
        }
    }
    
    public boolean setEstudiante(int i, Estudiante alumno) {
        boolean verificador = false;
        if (i >= 0 && i <= numeroRegistros) {
            if (alumno.getTamaño() > tamañoRegistro) {
                System.err.println("Tamaño de registro alumno excedido");
                
            } else {
                try {
                    flujo.seek(i * tamañoRegistro);
                    flujo.writeUTF(alumno.getCodigo());
                    flujo.writeUTF(alumno.getApellidos());
                    flujo.writeUTF(alumno.getNombre());
                    flujo.writeUTF(alumno.getDireccion());
                    flujo.writeUTF(alumno.getDni());
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
    
    public Estudiante getEstudiante(int i) {
        Estudiante alumno = null;
        crearArchivo();
        if (i >= 0 && i <= getNumeroRegistros()) {
            try {
                flujo.seek(i * tamañoRegistro);
                alumno = new Estudiante(flujo.readUTF(), flujo.readUTF(), flujo.readUTF(), flujo.readUTF(),
                         flujo.readUTF(), flujo.readBoolean());
            } catch (Exception e) {
                System.err.println("Error al retornar alumno");
            }

        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        cerrarFlujo();
        return alumno;
    }
    
    public ArrayList<Estudiante> getEstudiantes(){
        ArrayList<Estudiante> alumnos = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < getNumeroRegistros(); i++) {
                alumnos.add(getEstudiante(i));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodo getEstudiantes");
        }
        cerrarFlujo();
        return alumnos;
    }
}
