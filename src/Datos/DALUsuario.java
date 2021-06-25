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


public class DALUsuario {

    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static int tamañoRegistro = 240;
    private static final String ARCHIVO = "usuarios.txt";  
    
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
    
    public void añadirUsuario(Usuario usuario){
        crearArchivo();
        if(setUsuario(numeroRegistros, usuario)){
//            JOptionPane.showMessageDialog(null,"Usuario Añadida","Mensaje",1);
            numeroRegistros++;
        }
    }
    
    public boolean setUsuario(int i, Usuario usuario) {
        boolean verificador = false;
        if (i >= 0 && i <= numeroRegistros) {
            if (usuario.getTamaño() > tamañoRegistro) {
                System.err.println("Tamaño de registro usuario excedido");
                
            } else {
                try {
                    flujo.seek(i * tamañoRegistro);
                    flujo.writeUTF(usuario.getAlumno().getCodigo());
                    flujo.writeUTF(usuario.getAlumno().getApellidos());
                    flujo.writeUTF(usuario.getAlumno().getNombre());
                    flujo.writeUTF(usuario.getAlumno().getDireccion());
                    flujo.writeUTF(usuario.getAlumno().getDni());
                    flujo.writeUTF(usuario.getUsuario());
                    flujo.writeUTF(usuario.getContraseña());
                    flujo.writeBoolean(usuario.getAlumno().isActivo());
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
    
    public Usuario getUsuario(int i) {
        Usuario usuario = null;
        crearArchivo();
        if (i >= 0 && i <= getNumeroRegistros()) {
            try {
                flujo.seek(i * tamañoRegistro);
                String codigo =flujo.readUTF();
                String apellidos = flujo.readUTF();
                String nombre = flujo.readUTF();
                String direccion = flujo.readUTF();
                String dni = flujo.readUTF();
                String usuari = flujo.readUTF();
                String contra = flujo.readUTF();
                boolean estado = flujo.readBoolean();
                Estudiante alumno = new Estudiante(codigo, apellidos, nombre, direccion, dni, estado);
                usuario = new Usuario(alumno,usuari,contra);
            } catch (Exception e) {
                System.err.println("Error al retornar usuario");
            }

        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        cerrarFlujo();
        return usuario;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < getNumeroRegistros(); i++) {
                usuarios.add(getUsuario(i));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodo getUsuarios");
        }
        cerrarFlujo();
        return usuarios;
    }
    
}
