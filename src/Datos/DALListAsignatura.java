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
public class DALListAsignatura {
    
    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static int tamañoRegistro = 400;
    private static final String ARCHIVO = "asignaturasEstudiante.txt";  
    
    public void crearArchivo() {
        try {
            flujo = new RandomAccessFile(ARCHIVO, "rw");
            //Conocer cuantos registros tengo
            numeroRegistros = (int) Math.ceil((double) flujo.length() / (double) tamañoRegistro);
        } catch (IOException ex) {
            System.err.println("Problema al crear el flujo: " + ex.getMessage());
        }
    }
    
    public void reescribirArchivo(){
        try {
            crearArchivo();
            long cantidad = flujo.length();
            JOptionPane.showMessageDialog(null,cantidad);
            flujo.close();
        } catch (IOException ex) {
            System.err.println("Error al contar");
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
    
    public void añadirAsignatura(ArrayList<Asignatura> asignaturas){
        crearArchivo();
        if(setAsignatura(numeroRegistros, asignaturas)){
//            JOptionPane.showMessageDialog(null,"","Mensaje",1);
            numeroRegistros++;
        }
    }
    
    public boolean setAsignatura(int i, ArrayList<Asignatura> asignaturas) {
        boolean verificador = false;
            if (i >= 0 && i <= numeroRegistros) {
            if (asignaturas.get(i).getTamaño() > tamañoRegistro) {
                System.err.println("Tamaño de registro asignatura excedido");
            } else {
                try {
                    for (int j = 0; j < 5; j++) {
                        flujo.seek(i * tamañoRegistro);
                        flujo.writeUTF(asignaturas.get(j).getCodigo());
                        flujo.writeUTF(asignaturas.get(j).getNombre());
                        flujo.writeInt(asignaturas.get(j).getCreditos());
                        flujo.writeInt(asignaturas.get(j).getCiclo());
                        flujo.writeBoolean(asignaturas.get(j).isEstado());
                    }

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
    
    public ArrayList<Asignatura> getAsignatura(int i) {
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        crearArchivo();
        if (i >= 0 && i <= getNumeroRegistros()) {
            try {
                flujo.seek(i * tamañoRegistro);
                for (int j = 0; j < 5; j++) {
                   asignaturas.add(new Asignatura(flujo.readUTF(), flujo.readUTF(), flujo.readInt(), flujo.readInt(),flujo.readBoolean()));
                }
            } catch (Exception e) {
                System.err.println("Error al retornar asignatura");
            }

        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        cerrarFlujo();
        return asignaturas;
    }
    
    public ArrayList<ArrayListAsignatura> getAsignaturas(){
        ArrayList<ArrayListAsignatura> asignaturas = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < getNumeroRegistros(); i++) {
                     asignaturas.add(new ArrayListAsignatura(getAsignatura(i)));
                }   
        } catch (Exception e) {
            System.err.println("Error en el metodo getAsignaturas");
        }
        cerrarFlujo();
        return asignaturas;
    }

}
