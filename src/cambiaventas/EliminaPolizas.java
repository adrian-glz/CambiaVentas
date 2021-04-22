/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiaventas;

import static cambiaventas.Main.IPSUCURSAL;
import static cambiaventas.Main.sucursalnombre;
import static cambiaventas.Main.tienda;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author agonzalez
 */
public class EliminaPolizas extends javax.swing.JFrame {
 
    Statement st;
    ResultSet rs;
    DefaultTableModel md, md2;
    PreparedStatement ps = null;
    GregorianCalendar gg = new GregorianCalendar();

    public EliminaPolizas() {
        initComponents();
        estructuratablapolizas();
        estructuratablapolizasinfo();
        txtsucursal.setText(sucursalnombre);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logochico.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtfecha1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnvisualizar = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        txtsucursal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpolizas = new javax.swing.JTable();
        btncambiarventas = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpolizasinformacion = new javax.swing.JTable();
        regresar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elimina Poliza");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfecha1.setDateFormatString("yyyy/MM/dd");
        txtfecha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfecha1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfecha1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfecha1KeyTyped(evt);
            }
        });
        jPanel1.add(txtfecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 220, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha de poliza:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        btnvisualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ver.png"))); // NOI18N
        btnvisualizar.setText("Mostrar");
        btnvisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnvisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Conectado a:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 30));

        txtsucursal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsucursal.setForeground(new java.awt.Color(0, 51, 204));
        txtsucursal.setText(" ");
        jPanel1.add(txtsucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 760, 50));

        jtpolizas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtpolizas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 750, 110));

        btncambiarventas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncambiarventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btncambiarventas.setText("Eliminar Polizas");
        btncambiarventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiarventasActionPerformed(evt);
            }
        });
        getContentPane().add(btncambiarventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 220, 60));

        jLabel3.setText("VentasPagos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel6.setText("Ventas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jtpolizasinformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtpolizasinformacion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 750, 100));

        regresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/volver.png"))); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 230, 60));

        jLabel2.setText("        ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfecha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtfecha1.requestFocus();
        }
    }//GEN-LAST:event_txtfecha1KeyPressed

    private void txtfecha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha1KeyReleased

    }//GEN-LAST:event_txtfecha1KeyReleased

    private void txtfecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfecha1KeyTyped

    private void btnvisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarActionPerformed
        Date date = txtfecha1.getDate();
        if (date != null) {
            cargavistapreviapolizas();
            cargavistapreviapolizasinformacion();
        } else {
            JOptionPane.showMessageDialog(null, "¡Selecciona una fecha para cambiar!");
        }
    }//GEN-LAST:event_btnvisualizarActionPerformed

    private void btncambiarventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiarventasActionPerformed
        Date date = txtfecha1.getDate();
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String f1 = sdf.format(txtfecha1.getDate());
            if (JOptionPane.showConfirmDialog(null, " Estas seguro de eliminar la poliza de " + f1 + " ????!!!", " ATENCION!!! ",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                eliminapolizas();
               
            } else {
                // System.out.println("no hacer nada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Selecciona una fecha para cambiar!");
        }
    }//GEN-LAST:event_btncambiarventasActionPerformed
    public void cargavistapreviapolizas() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String pruebafecha = sdf.format(txtfecha1.getDate());
        // System.out.println("prueba fecha" + pruebafecha + "  tienda>" + tienda);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            st = conexion.createStatement();

            rs = st.executeQuery("select * from polizas  where fecha='" + pruebafecha + "' and sucursal='" + tienda + "'  ");
            md = (DefaultTableModel) jtpolizas.getModel();
            md.setRowCount(0);
            try {

                while (rs.next()) {
                    Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), "$" + rs.getString(7), rs.getString(8), rs.getString(9)};
                    md.addRow(fila);
                }
                int cont = md.getRowCount();
                if (cont == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron registros en la tabla de polizas con fecha de " + pruebafecha);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargavistapreviapolizasinformacion() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String pruebafecha = sdf.format(txtfecha1.getDate());

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            st = conexion.createStatement();

            rs = st.executeQuery("select * from    polizasinformacion where fecha='" + pruebafecha + "' and sucursal='" + tienda + "'  ");
            md = (DefaultTableModel) jtpolizasinformacion.getModel();
            md.setRowCount(0);
            try {

                while (rs.next()) {
                    Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
                    md.addRow(fila);
                }
                int cont = md.getRowCount();
                if (cont == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron registros en polizasinformacion con la fecha de: " + pruebafecha);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed
    public void eliminapolizas() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String f1 = sdf.format(txtfecha1.getDate());

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            Statement st = conexion.createStatement();
            String query = "delete from polizas where fecha= '" + f1 + "'";

            ps = conexion.prepareStatement(query);
            int n = ps.executeUpdate();
            if (n > 0) {
                eliminapolizasinformacion();
              // JOptionPane.showMessageDialog(null, "¡Se eliminaron las polizas  : " +f1);
                st.close();
                //historialeliminado();              
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void estructuratablapolizas() {
        jtpolizas.getTableHeader().setReorderingAllowed(false);

        String data[][] = {};
        String cabeza[] = {"Sucursal", "Fecha", "Poliza", "Cuenta", "Linea", "Descripcion", "Debe", "Haber", "Estatus"};

        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column != 9) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        jtpolizas.setModel(md);
        JTableHeader th;
        th = jtpolizas.getTableHeader();
        th.setFont(new java.awt.Font("Italic", 0, 14));
        TableCellRenderer rendererFromHeader = jtpolizas.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        jtpolizas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jtpolizas.getColumnModel().getColumn(0).setPreferredWidth(50); //1
        jtpolizas.getColumnModel().getColumn(0).setMaxWidth(140);
        jtpolizas.getColumnModel().getColumn(0).setMinWidth(70);

        jtpolizas.getColumnModel().getColumn(1).setPreferredWidth(80); //2
        jtpolizas.getColumnModel().getColumn(1).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(1).setMinWidth(80);

        jtpolizas.getColumnModel().getColumn(2).setPreferredWidth(110); //3
        jtpolizas.getColumnModel().getColumn(2).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(2).setMinWidth(110);

        jtpolizas.getColumnModel().getColumn(3).setPreferredWidth(90); //4
        jtpolizas.getColumnModel().getColumn(3).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(3).setMinWidth(90);

        jtpolizas.getColumnModel().getColumn(4).setPreferredWidth(80); //ARTIVULO
        jtpolizas.getColumnModel().getColumn(4).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(4).setMinWidth(80);

        jtpolizas.getColumnModel().getColumn(5).setPreferredWidth(150); //NOMNBRE DE CAJE
        jtpolizas.getColumnModel().getColumn(5).setMaxWidth(250);
        jtpolizas.getColumnModel().getColumn(5).setMinWidth(150);

        jtpolizas.getColumnModel().getColumn(6).setPreferredWidth(120); //NOMNBRE DE CAJE
        jtpolizas.getColumnModel().getColumn(6).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(6).setMinWidth(120);

        jtpolizas.getColumnModel().getColumn(7).setPreferredWidth(50); //NOMNBRE DE CAJE
        jtpolizas.getColumnModel().getColumn(7).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(7).setMinWidth(50);

        jtpolizas.getColumnModel().getColumn(8).setPreferredWidth(50); //NOMNBRE DE CAJE
        jtpolizas.getColumnModel().getColumn(8).setMaxWidth(200);
        jtpolizas.getColumnModel().getColumn(8).setMinWidth(50);

        //BTNGENERAR.setEnabled(false);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL
        //  ImageIcon imgIcon = new ImageIcon(getClass().getResource("/RECURSOS/Left.png"));
        //  Image imgEscalada = imgIcon.getImage().getScaledInstance(BTNATRAS.getWidth(),
        //         BTNATRAS.getHeight(), Image.SCALE_SMOOTH);
        //    Icon iconoEscalado = new ImageIcon(imgEscalada);
        // BTNATRAS.setIcon(iconoEscalado);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL ---AQUI TERMINA
    }

    public void estructuratablapolizasinfo() {
        jtpolizasinformacion.getTableHeader().setReorderingAllowed(false);

        String data[][] = {};
        String cabeza[] = {"Sucursal", "Fecha", "Poliza", "Nomina", "morralla", "faltantes", "Sobrantes", "pesos1", "pesos2"};

        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column != 9) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        jtpolizasinformacion.setModel(md);
        JTableHeader th;
        th = jtpolizasinformacion.getTableHeader();
        th.setFont(new java.awt.Font("Italic", 0, 14));
        TableCellRenderer rendererFromHeader = jtpolizasinformacion.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        jtpolizasinformacion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jtpolizasinformacion.getColumnModel().getColumn(0).setPreferredWidth(50); //1
        jtpolizasinformacion.getColumnModel().getColumn(0).setMaxWidth(140);
        jtpolizasinformacion.getColumnModel().getColumn(0).setMinWidth(70);

        jtpolizasinformacion.getColumnModel().getColumn(1).setPreferredWidth(80); //2
        jtpolizasinformacion.getColumnModel().getColumn(1).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(1).setMinWidth(80);

        jtpolizasinformacion.getColumnModel().getColumn(2).setPreferredWidth(110); //3
        jtpolizasinformacion.getColumnModel().getColumn(2).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(2).setMinWidth(110);

        jtpolizasinformacion.getColumnModel().getColumn(3).setPreferredWidth(90); //4
        jtpolizasinformacion.getColumnModel().getColumn(3).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(3).setMinWidth(90);

        jtpolizasinformacion.getColumnModel().getColumn(4).setPreferredWidth(80); //ARTIVULO
        jtpolizasinformacion.getColumnModel().getColumn(4).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(4).setMinWidth(80);

        jtpolizasinformacion.getColumnModel().getColumn(5).setPreferredWidth(150); //NOMNBRE DE CAJE
        jtpolizasinformacion.getColumnModel().getColumn(5).setMaxWidth(250);
        jtpolizasinformacion.getColumnModel().getColumn(5).setMinWidth(150);

        jtpolizasinformacion.getColumnModel().getColumn(6).setPreferredWidth(120); //NOMNBRE DE CAJE
        jtpolizasinformacion.getColumnModel().getColumn(6).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(6).setMinWidth(120);

        jtpolizasinformacion.getColumnModel().getColumn(7).setPreferredWidth(50); //NOMNBRE DE CAJE
        jtpolizasinformacion.getColumnModel().getColumn(7).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(7).setMinWidth(50);

        jtpolizasinformacion.getColumnModel().getColumn(8).setPreferredWidth(50); //NOMNBRE DE CAJE
        jtpolizasinformacion.getColumnModel().getColumn(8).setMaxWidth(200);
        jtpolizasinformacion.getColumnModel().getColumn(8).setMinWidth(50);

        //BTNGENERAR.setEnabled(false);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL
        //  ImageIcon imgIcon = new ImageIcon(getClass().getResource("/RECURSOS/Left.png"));
        //  Image imgEscalada = imgIcon.getImage().getScaledInstance(BTNATRAS.getWidth(),
        //         BTNATRAS.getHeight(), Image.SCALE_SMOOTH);
        //    Icon iconoEscalado = new ImageIcon(imgEscalada);
        // BTNATRAS.setIcon(iconoEscalado);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL ---AQUI TERMINA
    }

    public void eliminapolizasinformacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String f1 = sdf.format(txtfecha1.getDate());
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            Statement st = conexion.createStatement();
            String query = " delete from polizasinformacion where fecha='" + f1 + "'  ";
            ps = conexion.prepareStatement(query);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Se elimino  las polizas : " + f1);
                st.close();
                //historialeliminado();              
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(EliminaPolizas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminaPolizas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminaPolizas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminaPolizas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminaPolizas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btncambiarventas;
    private javax.swing.JToggleButton btnvisualizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtpolizas;
    private javax.swing.JTable jtpolizasinformacion;
    private javax.swing.JToggleButton regresar;
    private com.toedter.calendar.JDateChooser txtfecha1;
    private javax.swing.JLabel txtsucursal;
    // End of variables declaration//GEN-END:variables
}
