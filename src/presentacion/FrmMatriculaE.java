/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Datos.*;
import ModelosTabla.*;
import entidades.*;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP
 */
public class FrmMatriculaE extends javax.swing.JFrame {

    /**
     * Creates new form FrmMatriculaE
     */
    public FrmMatriculaE() {
        initComponents();
        asignaturas = flujos.getAsignaturas();      
    }
    
        public FrmMatriculaE(Estudiante alumno) {
        initComponents();
        asignaturas = flujos.getAsignaturas(); 
        this.alumno  = alumno;
    }

    public void cambiar(){
        try {
            String sele = String.valueOf(jcBPeriodo.getSelectedItem());
        if(sele.equals("Nivelacion")){
            txtFiltroAsignatura.setText(null);
            JOptionPane.showMessageDialog(null,"Nivelacion");
        }else if(sele.equals("2021-I")){
            txtFiltroAsignatura.setText(null);
            ArrayList<Asignatura> asignatu = new ArrayList<>();
            for (int i = 0; i < asignaturas.size(); i++) {
                if(asignaturas.get(i).getCiclo()==1){
                    asignatu.add(asignaturas.get(i));
                } 
            }
            tma = new ModeloAsignatura(asignatu);
            tablaCursosDisponibles.setModel(tma);
            
        }else if(sele.equals("2021-II")){
            txtFiltroAsignatura.setText(null);
            ArrayList<Asignatura> asignatu = new ArrayList<>();
            for (int i = 0; i < asignaturas.size(); i++) {
                if(asignaturas.get(i).getCiclo()==2){
                    asignatu.add(asignaturas.get(i));
                } 
            }
            tma = new ModeloAsignatura(asignatu);
            tablaCursosDisponibles.setModel(tma);
        }
        } catch (Exception e) {
        }
        
    }
    
    public void elegirAsignatura(){
        try {
            int creditos=0;
        int creditosAnterior= Integer.parseInt(txtTotalCreditos.getText());
        int row = tablaCursosDisponibles.getSelectedRow();
        if(jcBPeriodo.getSelectedItem().toString().equals("Seleccionar Periodo")){
          JOptionPane.showMessageDialog(null,"Seleccione un Periodo","Advertencia",2);
        }else{
            String codigoAsignatura = String.valueOf(tablaCursosDisponibles.getValueAt(row, 0));  
          if (verificadorMatricula(codigoAsignatura)) {
            if (!(row == -1)) {
                //recorro un ciclo para saber la asignatura por codigo
                for (int j = 0; j < asignaturas.size(); j++) {
                    if (asignaturas.get(j).getCodigo().equals(codigoAsignatura)) {
                        //A??ado la asignatura matriculada
                        asignaturasSeleccionadas.add(asignaturas.get(j));
                        JOptionPane.showMessageDialog(null, "Asignatura Matriculada!", "Mensaje", 1);
                        //sumo los creditos
                        creditos = creditosAnterior + asignaturas.get(j).getCreditos();
                        txtTotalCreditos.setText(String.valueOf(creditos));
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla", "Mensaje", 2);
            }
        }
        }
        } catch (Exception e) {
        }
        
        
        

    }
    
    public boolean verificadorMatricula(String codigo){
                boolean verificador = true;
        try {
            for (int i = 0; i < asignaturasSeleccionadas.size(); i++) {
            if(asignaturasSeleccionadas.get(i).getCodigo().equals(codigo)){
                JOptionPane.showMessageDialog(null,"Ya esta matriculado en esta asignatura","Mensaje",2);
                verificador = false;
            }
            
        }
        } catch (Exception e) {
        }

        
        return verificador;
    }
    
    public void llenarTablaMatricula(){
        try {
            ModeloAsignatura tmaAsignatura = new ModeloAsignatura(asignaturasSeleccionadas);
        tablaMatriculados.setModel(tmaAsignatura);
        } catch (Exception e) {
        }
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursosDisponibles = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMatriculados = new javax.swing.JTable();
        jcBPeriodo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTotalCreditos = new javax.swing.JTextField();
        txtFiltroAsignatura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Subheading", 1, 18))); // NOI18N

        tablaCursosDisponibles.setBackground(new java.awt.Color(102, 102, 255));
        tablaCursosDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tablaCursosDisponibles.setForeground(new java.awt.Color(0, 0, 0));
        tablaCursosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Asignaturas", "Creditos", "Ciclo"
            }
        ));
        jScrollPane1.setViewportView(tablaCursosDisponibles);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 500, 160));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos Matriculados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Subheading", 1, 18))); // NOI18N

        tablaMatriculados.setBackground(new java.awt.Color(102, 102, 255));
        tablaMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Asignaturas", "Creditos", "Ciclo"
            }
        ));
        jScrollPane2.setViewportView(tablaMatriculados);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 500, -1));

        jcBPeriodo.setBackground(new java.awt.Color(0, 102, 255));
        jcBPeriodo.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jcBPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Periodo", "2021-I", "2021-II", "Nivelacion" }));
        jcBPeriodo.setBorder(new javax.swing.border.MatteBorder(null));
        jcBPeriodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcBPeriodoFocusGained(evt);
            }
        });
        jcBPeriodo.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jcBPeriodoMouseWheelMoved(evt);
            }
        });
        jcBPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcBPeriodoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseReleased(evt);
            }
        });
        jcBPeriodo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jcBPeriodoComponentHidden(evt);
            }
        });
        jcBPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBPeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(jcBPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 180, 30));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setText("Matricular");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 120, 50));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setText("?? Creditos :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtTotalCreditos.setEditable(false);
        txtTotalCreditos.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        txtTotalCreditos.setText("0");
        jPanel1.add(txtTotalCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 12, 40, 30));

        txtFiltroAsignatura.setBorder(null);
        txtFiltroAsignatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroAsignaturaKeyTyped(evt);
            }
        });
        jPanel1.add(txtFiltroAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 90, 20));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Filtro Asignatura :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 90, -1));

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setText("Agregar");
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 120, 50));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Matricula Asignatura ::");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(712, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
        FrmEstudiante ventana = new FrmEstudiante();
        ventana.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked
    int xx,xy;
    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed

    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
        
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point poin = MouseInfo.getPointerInfo().getLocation();
        setLocation(poin.x-xx, poin.y-xy);
        
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String sele = String.valueOf(jcBPeriodo.getSelectedItem());
        if(asignaturasSeleccionadas.size()<5){
            JOptionPane.showMessageDialog(null,"Matricularse en 5 asignaturas","Advertencia",2);
        }else if(asignaturasSeleccionadas.size()==5){
            String semestre ="";
            int A??o =0;
            if (sele.equals("Nivelacion")) {
                semestre ="Nivelacion";
                A??o = 2021;
            }else if(sele.equals("2021 I")){
                semestre ="I";
                A??o = 2021;
            }else if(sele.equals("2021 II")){
                semestre ="II";
                A??o = 2021;
            }
            PeriodoAcademico pe = new PeriodoAcademico(A??o, semestre);
            String fecha = "26/04/2021";
            flujosList.a??adirAsignatura(asignaturasSeleccionadas);
            Matricula matricula = new Matricula(pe, fecha, alumno);
            flujosMatri.a??adirMatricula(matricula);
            JOptionPane.showMessageDialog(null,"Matricula Realizada con exito","Mensaje",1);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       
    }//GEN-LAST:event_formFocusGained

    private void jcBPeriodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcBPeriodoFocusGained
        
    }//GEN-LAST:event_jcBPeriodoFocusGained

    private void jcBPeriodoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcBPeriodoComponentHidden

    }//GEN-LAST:event_jcBPeriodoComponentHidden

    private void jcBPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseClicked

    }//GEN-LAST:event_jcBPeriodoMouseClicked

    private void jcBPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseEntered
       
    }//GEN-LAST:event_jcBPeriodoMouseEntered

    private void jcBPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseExited
         
    }//GEN-LAST:event_jcBPeriodoMouseExited

    private void jcBPeriodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMousePressed
       
    }//GEN-LAST:event_jcBPeriodoMousePressed

    private void jcBPeriodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseReleased
        
    }//GEN-LAST:event_jcBPeriodoMouseReleased

    private void jcBPeriodoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseWheelMoved

    }//GEN-LAST:event_jcBPeriodoMouseWheelMoved

    private void jcBPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBPeriodoActionPerformed
        
        try {
            cambiar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jcBPeriodoActionPerformed

    private void txtFiltroAsignaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroAsignaturaKeyTyped
         try {
            if(txtFiltroAsignatura.getText().isEmpty()){
            
         }else{
              txtFiltroAsignatura.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter(txtFiltroAsignatura.getText(),1));
            }
        });
        trs = new TableRowSorter(tma);
        tablaCursosDisponibles.setRowSorter(trs);
         }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtFiltroAsignaturaKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            try {
            elegirAsignatura();
            llenarTablaMatricula();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatriculaE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcBPeriodo;
    private javax.swing.JTable tablaCursosDisponibles;
    private javax.swing.JTable tablaMatriculados;
    private javax.swing.JTextField txtFiltroAsignatura;
    private javax.swing.JTextField txtTotalCreditos;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private DALAsignatura flujos = new DALAsignatura();
    private ModeloAsignatura tma;
    private ArrayList<Asignatura> asignaturasSeleccionadas = new ArrayList<>();
    private TableRowSorter trs;
    private Estudiante alumno;
    private DALListAsignatura flujosList = new DALListAsignatura();
    private DALMatricula flujosMatri = new DALMatricula();
//    private ArrayList<ArrayListAsignatura> listAsignaturas = new ArrayList<>();
}
