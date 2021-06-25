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
public class DALAsignatura {

    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static final int tamañoRegistro = 90;
    private static final String ARCHIVO = "asignaturas.txt";  
    
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
    
    public void añadirAsignatura(Asignatura asignatura){
        crearArchivo();
        if(setAsignatura(numeroRegistros, asignatura)){
            JOptionPane.showMessageDialog(null,"Asignaturas Añadidas","Mensaje",1);
            numeroRegistros++;
        }
    }
    
    public boolean setAsignatura(int i, Asignatura asignatura) {
        boolean verificador = false;
        if (i >= 0 && i <= numeroRegistros) {
            if (asignatura.getTamaño() > tamañoRegistro) {
                System.err.println("Tamaño de registro asignatura excedido");
                
            } else {
                try {
                    flujo.seek(i * tamañoRegistro);
                    flujo.writeUTF(asignatura.getCodigo());
                    flujo.writeUTF(asignatura.getNombre());
                    flujo.writeInt(asignatura.getCreditos());
                    flujo.writeInt(asignatura.getCiclo());
                    flujo.writeBoolean(asignatura.isEstado());
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
    
    public Asignatura getAsignatura(int i) {
        Asignatura asignatura = null;
        crearArchivo();
        if (i >= 0 && i <= getNumeroRegistros()) {
            try {
                flujo.seek(i * tamañoRegistro);
                asignatura = new Asignatura(flujo.readUTF(), flujo.readUTF(), flujo.readInt(), flujo.readInt(),flujo.readBoolean());
            } catch (Exception e) {
                System.err.println("Error al retornar asignatura");
            }

        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        cerrarFlujo();
        return asignatura;
    }
    
    public ArrayList<Asignatura> getAsignaturas(){
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < getNumeroRegistros(); i++) {
                asignaturas.add(getAsignatura(i));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodo getAsignaturas");
        }
        cerrarFlujo();
        return asignaturas;
    }

}

