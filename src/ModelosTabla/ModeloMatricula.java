/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelosTabla;

import entidades.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloMatricula extends AbstractTableModel{
    
    private ArrayList<Matricula> matriculas;
    private ArrayList<ArrayListAsignatura> listAsign;
    private final String[] columnas = {"Periodo","Apellidos","Nombres","Asignatura 01"
            ,"Asignatura 02","Asignatura 03","Asignatura 04","Asignatura 05"};

    public ModeloMatricula(ArrayList<Matricula> matriculas,ArrayList<ArrayListAsignatura> listAsign) {
        this.matriculas = matriculas;
        this.listAsign = listAsign;
    }
 
    @Override
    public int getRowCount() {
        return matriculas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return (matriculas.get(rowIndex).getPerido().getAño() +" "+ matriculas.get(rowIndex).getPerido().getSemestre());
            case 1:
                return matriculas.get(rowIndex).getAlumno().getApellidos();
            case 2:
                return matriculas.get(rowIndex).getAlumno().getNombre();
            case 3:
                return matriculas.get(rowIndex).getFecha();
            case 4:
                return listAsign.get(rowIndex).getAsignaturas().get(0).getNombre();
            case 5 :
                return listAsign.get(rowIndex).getAsignaturas().get(1).getNombre();
            case 6:
                return listAsign.get(rowIndex).getAsignaturas().get(2).getNombre();
            case 7 :
                return listAsign.get(rowIndex).getAsignaturas().get(3).getNombre();
            case 8:
                return listAsign.get(rowIndex).getAsignaturas().get(4).getNombre();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
