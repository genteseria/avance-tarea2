/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelosTabla;

import entidades.Asignatura;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloAsignatura extends AbstractTableModel{
    private ArrayList<Asignatura> asignaturas;
    private final String[] columnas = {"Codigo","Asignatura","Creditos","Ciclo"};

    public ModeloAsignatura(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
 
    @Override
    public int getRowCount() {
        return asignaturas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return asignaturas.get(rowIndex).getCodigo();
            case 1:
                return asignaturas.get(rowIndex).getNombre();
            case 2:
                return asignaturas.get(rowIndex).getCreditos();
            case 3:
                return asignaturas.get(rowIndex).getCiclo();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }


}
