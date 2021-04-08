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
public class EliminaVentas extends javax.swing.JFrame {

    Statement st;
    ResultSet rs;
    DefaultTableModel md, md2;
    PreparedStatement ps = null;
    GregorianCalendar gg = new GregorianCalendar();

    /**
     * Creates new form EliminaVentas
     */
    public EliminaVentas() {
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/recursos/logochico.png")).getImage());
          estructuratablaventas();//
        estructuratablaventaspagos();
              txtsucursal.setText(sucursalnombre);
         
    }
      public void estructuratablaventas() {
        jtventas.getTableHeader().setReorderingAllowed(false);

      //  setIconImage(new ImageIcon(getClass().getResource("/recursos/logochico.png")).getImage());
        String data[][] = {};
        String cabeza[] = {"FOLIO", "ARTICULO", "FECHA", "SUCURSAL", "CAJA", "CODIGO", "PRECIO NETO", "CLAVE VENTA", "HORA"};

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
        jtventas.setModel(md);
        JTableHeader th;
        th = jtventas.getTableHeader();
        th.setFont(new java.awt.Font("Italic", 0, 14));
        TableCellRenderer rendererFromHeader = jtventas.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        jtventas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jtventas.getColumnModel().getColumn(0).setPreferredWidth(50); //1
        jtventas.getColumnModel().getColumn(0).setMaxWidth(140);
        jtventas.getColumnModel().getColumn(0).setMinWidth(70);

        jtventas.getColumnModel().getColumn(1).setPreferredWidth(80); //2
        jtventas.getColumnModel().getColumn(1).setMaxWidth(200);
        jtventas.getColumnModel().getColumn(1).setMinWidth(80);

        jtventas.getColumnModel().getColumn(2).setPreferredWidth(110); //3
        jtventas.getColumnModel().getColumn(2).setMaxWidth(200);
        jtventas.getColumnModel().getColumn(2).setMinWidth(110);

        jtventas.getColumnModel().getColumn(3).setPreferredWidth(90); //4
        jtventas.getColumnModel().getColumn(3).setMaxWidth(200);
        jtventas.getColumnModel().getColumn(3).setMinWidth(90);

        jtventas.getColumnModel().getColumn(4).setPreferredWidth(80); //ARTIVULO
        jtventas.getColumnModel().getColumn(4).setMaxWidth(80);
        jtventas.getColumnModel().getColumn(4).setMinWidth(80);

        jtventas.getColumnModel().getColumn(5).setPreferredWidth(150); //NOMNBRE DE CAJE
        jtventas.getColumnModel().getColumn(5).setMaxWidth(250);
        jtventas.getColumnModel().getColumn(5).setMinWidth(150);

        jtventas.getColumnModel().getColumn(6).setPreferredWidth(120); //NOMNBRE DE CAJE
        jtventas.getColumnModel().getColumn(6).setMaxWidth(200);
        jtventas.getColumnModel().getColumn(6).setMinWidth(120);

        jtventas.getColumnModel().getColumn(7).setPreferredWidth(50); //NOMNBRE DE CAJE
        jtventas.getColumnModel().getColumn(7).setMaxWidth(50);
        jtventas.getColumnModel().getColumn(7).setMinWidth(50);

        jtventas.getColumnModel().getColumn(8).setPreferredWidth(50); //NOMNBRE DE CAJE
        jtventas.getColumnModel().getColumn(8).setMaxWidth(50);
        jtventas.getColumnModel().getColumn(8).setMinWidth(50);

        //BTNGENERAR.setEnabled(false);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL
        //  ImageIcon imgIcon = new ImageIcon(getClass().getResource("/RECURSOS/Left.png"));
        //  Image imgEscalada = imgIcon.getImage().getScaledInstance(BTNATRAS.getWidth(),
        //         BTNATRAS.getHeight(), Image.SCALE_SMOOTH);
        //    Icon iconoEscalado = new ImageIcon(imgEscalada);
        // BTNATRAS.setIcon(iconoEscalado);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL ---AQUI TERMINA
    }

    public void estructuratablaventaspagos() {
        jtventaspagos.getTableHeader().setReorderingAllowed(false);

        String data[][] = {};
        String cabeza[] = {"FECHA", "SUCURSAL", "CAJA", "CLAVE PAGO", "FOLIO", "IMPORTE"};

       md2 = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column != 6) {
                    return false;
                } else {
                    return true;
                }
            }
        };  
        jtventaspagos.setModel(md2);
        JTableHeader th;
        th = jtventaspagos.getTableHeader();
        th.setFont(new java.awt.Font("Italic", 0, 14));
        TableCellRenderer rendererFromHeader = jtventaspagos.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        jtventaspagos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jtventaspagos.getColumnModel().getColumn(0).setPreferredWidth(200); //CAJA
        jtventaspagos.getColumnModel().getColumn(0).setMaxWidth(200);
        jtventaspagos.getColumnModel().getColumn(0).setMinWidth(200);

        jtventaspagos.getColumnModel().getColumn(1).setPreferredWidth(100); //FOLIO
        jtventaspagos.getColumnModel().getColumn(1).setMaxWidth(200);
        jtventaspagos.getColumnModel().getColumn(1).setMinWidth(100);

        jtventaspagos.getColumnModel().getColumn(2).setPreferredWidth(100); //COD
        jtventaspagos.getColumnModel().getColumn(2).setMaxWidth(120);
        jtventaspagos.getColumnModel().getColumn(2).setMinWidth(100);

        jtventaspagos.getColumnModel().getColumn(3).setPreferredWidth(80); //PRECIO
        jtventaspagos.getColumnModel().getColumn(3).setMaxWidth(100);
        jtventaspagos.getColumnModel().getColumn(3).setMinWidth(80);

        jtventaspagos.getColumnModel().getColumn(4).setPreferredWidth(80); //ARTIVULO
        jtventaspagos.getColumnModel().getColumn(4).setMaxWidth(80);
        jtventaspagos.getColumnModel().getColumn(4).setMinWidth(100);

        jtventaspagos.getColumnModel().getColumn(5).setPreferredWidth(200); //NOMNBRE DE CAJE
        jtventaspagos.getColumnModel().getColumn(5).setMaxWidth(250);
        jtventaspagos.getColumnModel().getColumn(5).setMinWidth(200);

        //BTNGENERAR.setEnabled(false);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL
        //  ImageIcon imgIcon = new ImageIcon(getClass().getResource("/RECURSOS/Left.png"));
        //  Image imgEscalada = imgIcon.getImage().getScaledInstance(BTNATRAS.getWidth(),
        //         BTNATRAS.getHeight(), Image.SCALE_SMOOTH);
        //    Icon iconoEscalado = new ImageIcon(imgEscalada);
        // BTNATRAS.setIcon(iconoEscalado);
        ///************ESCALABLIDAD DE ICONO DE IMAGEN EN BOGTONO O LABEL ---AQUI TERMINA
    }

    public void eliminaventas() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String f1 = sdf.format(txtfecha1.getDate());

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            Statement st = conexion.createStatement();
            String query = "delete from ventas where fecha= '" + f1 + "' and sucursal='" + tienda + "' and caja='" + spcaja.getValue() + "'";

            ps = conexion.prepareStatement(query);
            int n = ps.executeUpdate();
            if (n > 0) {
                /// JOptionPane.showMessageDialog(null, "¡Se eliminaron las ventas  : " +f1);
                st.close();
                //historialeliminado();              
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminaventaspagos() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String f1 = sdf.format(txtfecha1.getDate());
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            Statement st = conexion.createStatement();
            String query = " delete from ventaspagos where fecha='" + f1 + "' and sucursal='" + tienda + "' and caja='" + spcaja.getValue() + "'";
            ps = conexion.prepareStatement(query);
            int n = ps.executeUpdate();
            if (n > 0) {
               JOptionPane.showMessageDialog(null, "¡Se eliminarons  las ventas : " + f1);
                st.close();
                //historialeliminado();              
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargavistaventas() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String pruebafecha = sdf.format(txtfecha1.getDate());
        // System.out.println("prueba fecha" + pruebafecha + "  tienda>" + tienda);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            st = conexion.createStatement();
            System.out.println("CAJA="+spcaja);
            rs = st.executeQuery("select * from ventas  where fecha='" + pruebafecha + "' and sucursal='" + tienda + "' and caja='"+spcaja.getValue()+"' ");
           // System.out.println("select * from ventas  where fecha='" + pruebafecha + "' and sucursal='" + tienda + "' and '"+spcaja.getValue()+"' );
            md = (DefaultTableModel) jtventas.getModel();
            md.setRowCount(0);
            try {

                while (rs.next()) {
                    Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), "$" + rs.getString(7), rs.getString(8), rs.getString(9)};
                    md.addRow(fila);
                }
                int cont = md.getRowCount();
                if (cont == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron registros en la tabla ventas con fecha de " + pruebafecha +" y caja "+spcaja.getValue());
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

    public void cargavistapreviaventaspagos() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String pruebafecha = sdf.format(txtfecha1.getDate());

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
            st = conexion.createStatement();

            rs = st.executeQuery("select fecha,sucursal,caja,clavepago,folio, importe  from ventaspagos where fecha='" + pruebafecha + "' and sucursal='" + tienda + "' and CAJA='"+spcaja.getValue()+"' ");
            md = (DefaultTableModel) jtventaspagos.getModel();
            md.setRowCount(0);
            try {

                while (rs.next()) {
                    Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), "$" + rs.getString(6)};
                    md.addRow(fila);
                }
                int cont = md.getRowCount();
                if (cont == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron registros en ventaspagos con la fecha de: " + pruebafecha+" y caja"+spcaja.getValue());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtfecha1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnvisualizar = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        txtsucursal = new javax.swing.JLabel();
        spcaja = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtventas = new javax.swing.JTable();
        btncambiarventas = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtventaspagos = new javax.swing.JTable();
        regresar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elimina Ventas");
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
        jPanel1.add(txtfecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha de venta:");
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
        jPanel1.add(spcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 50, 30));

        jLabel1.setText("Caja:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 16, 50, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 760, 50));

        jtventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 750, 110));

        btncambiarventas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncambiarventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btncambiarventas.setText("Eliminar Ventas");
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

        jtventaspagos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtventaspagos);

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

        jLabel2.setText("           ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, -1, -1));

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
            cargavistaventas();
            cargavistapreviaventaspagos();
        } else {
            JOptionPane.showMessageDialog(null, "¡Selecciona una fecha para cambiar!");
        }
    }//GEN-LAST:event_btnvisualizarActionPerformed

    private void btncambiarventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiarventasActionPerformed
        Date date = txtfecha1.getDate();
        if (date != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String f1 = sdf.format(txtfecha1.getDate());
            if (JOptionPane.showConfirmDialog(null, " Estas seguro de eliminar las ventas de " + f1 + " ????!!!", " ATENCION!!! ",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                eliminaventas();
                eliminaventaspagos();
            } else {
                //  System.out.println("no hacer nada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Selecciona una fecha para cambiar!");
        }
    }//GEN-LAST:event_btncambiarventasActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminaVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btncambiarventas;
    private javax.swing.JToggleButton btnvisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtventas;
    private javax.swing.JTable jtventaspagos;
    private javax.swing.JToggleButton regresar;
    private javax.swing.JSpinner spcaja;
    private com.toedter.calendar.JDateChooser txtfecha1;
    private javax.swing.JLabel txtsucursal;
    // End of variables declaration//GEN-END:variables
}
