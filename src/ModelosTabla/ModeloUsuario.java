/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelosTabla;

import entidades.Usuario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloUsuario extends AbstractTableModel {

    private ArrayList<Usuario> usuarios;
    private final String[] columnas = {"Codigo","Apellidos","Nombres","Usuario","Contraseña"};

    public ModeloUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
 
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return usuarios.get(rowIndex).getAlumno().getCodigo();
            case 1:
                return usuarios.get(rowIndex).getAlumno().getApellidos();
            case 2:
                return usuarios.get(rowIndex).getAlumno().getNombre();
            case 3:
                return usuarios.get(rowIndex).getUsuario();
            case 4:
                return usuarios.get(rowIndex).getContraseña();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
}
