/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiaventas;

import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author agonzalez
 */
public class Main extends javax.swing.JFrame {
public static String IPSUCURSAL="";
public static String sucursalnombre="";
public static String tienda="";
     


    public Main() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logochico.png")).getImage());
        btncontinuar.setEnabled(false);
        btnavanzado.setEnabled(false);
        btnconectar.transferFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncapturar3 = new javax.swing.JButton();
        jctiendas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnconectar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblconexions = new javax.swing.JLabel();
        lblconexion = new javax.swing.JLabel();
        btndesconectar = new javax.swing.JButton();
        btncontinuar = new javax.swing.JToggleButton();
        btnavanzado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccion Menu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncapturar3.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        btncapturar3.setForeground(new java.awt.Color(51, 51, 51));
        btncapturar3.setText("Sistema cambia ventas");
        btncapturar3.setContentAreaFilled(false);
        btncapturar3.setFocusPainted(false);
        btncapturar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapturar3ActionPerformed(evt);
            }
        });
        getContentPane().add(btncapturar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 280, 50));

        jctiendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jctiendas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "29 WALMART", "26  AMAZON LOGISTICA", "27 AMAZON ON SITE", "28 LINIO", "23 SOUNDS MX" }));
        jctiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jctiendasActionPerformed(evt);
            }
        });
        getContentPane().add(jctiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 250, 37));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Trabajar en:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 80, 37));

        btnconectar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnconectar.setText("Conectar");
        btnconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconectarActionPerformed(evt);
            }
        });
        getContentPane().add(btnconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 130, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logochico.png"))); // NOI18N
        jLabel3.setInheritsPopupMenu(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 190, 190));

        jLabel2.setText("Corona 1.0");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 80, -1));

        lblconexions.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblconexions.setText("Estatus :");
        getContentPane().add(lblconexions, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 60, 20));

        lblconexion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblconexion.setForeground(new java.awt.Color(255, 51, 51));
        lblconexion.setText("Desconectado");
        getContentPane().add(lblconexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 130, 20));

        btndesconectar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btndesconectar.setText("Desconectar");
        btndesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesconectarActionPerformed(evt);
            }
        });
        getContentPane().add(btndesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 120, 30));

        btncontinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/derecha.png"))); // NOI18N
        btncontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btncontinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 60, 40));

        btnavanzado.setText(" ");
        btnavanzado.setBorder(null);
        btnavanzado.setBorderPainted(false);
        btnavanzado.setContentAreaFilled(false);
        btnavanzado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnavanzado.setDefaultCapable(false);
        btnavanzado.setFocusPainted(false);
        btnavanzado.setVerifyInputWhenFocusTarget(false);
        btnavanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnavanzadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnavanzado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 240, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncapturar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapturar3ActionPerformed

    }//GEN-LAST:event_btncapturar3ActionPerformed

    private void btnconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconectarActionPerformed
       
        String expresionenpantalla = jctiendas.getSelectedItem().toString();
        String expresionfiltrada = jctiendas.getSelectedItem().toString().replaceAll("[^1-2-3-4-5-6-7-8-9]", "");

        int opc = Integer.parseInt(expresionfiltrada);
        conexion p = new conexion();
        switch (opc) {
                        case 26:
				IPSUCURSAL = "192.168.1.96:64493/CML;";    
                                sucursalnombre="AMAZON LOGISTICA";
                                tienda="26";
				break;
			case 27:
				IPSUCURSAL = "192.168.1.97:61998/CML;"; 
                                sucursalnombre="AMAZON ON SITE";
                                tienda="27";
				break;
			case 28:
				IPSUCURSAL = "192.168.1.98:49684/CML;";
                                sucursalnombre="LINIO"; 
                                tienda="28";
				break;
			case 29:
				IPSUCURSAL = "192.168.1.95:52261/CML;";
                                sucursalnombre="WAL MART";  
                                tienda="29";
				break;
			case 23:
				IPSUCURSAL = "192.168.1.90:58891/CML;";
                                sucursalnombre="SOUNDS MX";
                                tienda="23";
				break;
	 
            // Podemos tener cualquier número de declaraciones de casos o case
            // debajo se encuentra la declaración predeterminada, que se usa cuando ninguno de los casos es verdadero.
            // No se necesita descanso en el case default
            default:
            // Declaraciones
        }

        btncontinuar.setEnabled(true);
        btnavanzado.setEnabled(true);
        jctiendas.setEnabled(false);
        lblconexion.setText("CONECTADO");
        lblconexion.setForeground(Color.GREEN);
        btnconectar.setEnabled(false);
  
    }//GEN-LAST:event_btnconectarActionPerformed

    private void btndesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesconectarActionPerformed
       jctiendas.setEnabled(true);
        btnavanzado.setEnabled(false);
        lblconexion.setText("DESCONECTADO");
        lblconexion.setForeground(Color.red);
        btnconectar.setEnabled(true);
        IPSUCURSAL = "";
        btncontinuar.setEnabled(false);
    }//GEN-LAST:event_btndesconectarActionPerformed

    private void btncontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncontinuarActionPerformed
        CambiaVenta cv = new CambiaVenta();
        cv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncontinuarActionPerformed

    private void jctiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jctiendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jctiendasActionPerformed

    private void btnavanzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnavanzadoActionPerformed
        MenuAvanzado m = new MenuAvanzado();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnavanzadoActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnavanzado;
    private javax.swing.JButton btncapturar3;
    private javax.swing.JButton btnconectar;
    private javax.swing.JToggleButton btncontinuar;
    private javax.swing.JButton btndesconectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jctiendas;
    private javax.swing.JLabel lblconexion;
    private javax.swing.JLabel lblconexions;
    // End of variables declaration//GEN-END:variables
}
