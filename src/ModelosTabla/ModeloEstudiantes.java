/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelosTabla;

import entidades.Estudiante;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloEstudiantes extends AbstractTableModel{

    private ArrayList<Estudiante> alumnos;
    private final String[] columnas = {"Codigo","Apellidos","Nombres","Direccion","N° DNI"};

    public ModeloEstudiantes(ArrayList<Estudiante> alumnos) {
        this.alumnos = alumnos;
    }
 
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return alumnos.get(rowIndex).getCodigo();
            case 1:
                return alumnos.get(rowIndex).getApellidos();
            case 2:
                return alumnos.get(rowIndex).getNombre();
            case 3:
                return alumnos.get(rowIndex).getDireccion();
            case 4:
                return alumnos.get(rowIndex).getDni();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
}
