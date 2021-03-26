package cambiaventas;

import static cambiaventas.Main.IPSUCURSAL;
import static cambiaventas.Main.sucursalnombre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author agonzalez
 */
public class MenuAvanzado extends javax.swing.JFrame {

    /**
     * Creates new form MenuAvanzado
     */
    public MenuAvanzado() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logochico.png")).getImage());
        txtsucursal.setText("" + sucursalnombre);
        txtsucursal.setForeground(Color.blue);
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        txtsucursal = new javax.swing.JLabel();
        btncargaperiodo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bnteliminafolios = new javax.swing.JButton();
        btneliminarpoliza = new javax.swing.JButton();
        btnoficinas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Avanzado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Conectado a:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 30));

        txtsucursal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsucursal.setForeground(new java.awt.Color(0, 51, 204));
        txtsucursal.setText(" ");
        getContentPane().add(txtsucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, 30));

        btncargaperiodo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btncargaperiodo.setText("Correr carga periodo dos meses (tienda actual)");
        btncargaperiodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargaperiodoActionPerformed(evt);
            }
        });
        getContentPane().add(btncargaperiodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 370, 50));

        jLabel1.setText("     ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 20, 20));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 370, 40));

        bnteliminafolios.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bnteliminafolios.setText("Eliminar folios ");
        bnteliminafolios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnteliminafoliosActionPerformed(evt);
            }
        });
        getContentPane().add(bnteliminafolios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, 50));

        btneliminarpoliza.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btneliminarpoliza.setText("Eliminar Poliza");
        btneliminarpoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarpolizaActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminarpoliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 370, 50));

        btnoficinas.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnoficinas.setText("Actualiza existencias 1.80");
        btnoficinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoficinasActionPerformed(evt);
            }
        });
        getContentPane().add(btnoficinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 370, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btncargaperiodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargaperiodoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "vas a actualizar las existencias de " + sucursalnombre + " estas seguro de continuar? \n (Estas no se reflejaran en oficinas hasta que actualize la informacion en 1.80 )", " ATENCION!!! ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                cargaperiododosmeses();
        } else {

        }
    }//GEN-LAST:event_btncargaperiodoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bnteliminafoliosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnteliminafoliosActionPerformed

        EliminaVentas ev = new EliminaVentas();
        ev.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_bnteliminafoliosActionPerformed

    private void btneliminarpolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarpolizaActionPerformed

        EliminaPolizas ev = new EliminaPolizas();
        ev.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btneliminarpolizaActionPerformed

    private void btnoficinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoficinasActionPerformed
     cargaperiododosmesesoficinas();
    }//GEN-LAST:event_btnoficinasActionPerformed
    
        public void cargaperiododosmeses() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Ejecutando Periodo dos meses. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        
                int nren;
                ///////////PROGRESSSBARRRR
                try {
                    //    System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery("cml.dbo.spp_CargaPeriodosDosMeses");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //    System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        JOptionPane.showMessageDialog(null, "Se ha corrido Carga periodo dos meses correctamente,continuara con listacodigos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigostmp();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
        //<PROGRESSBAR

    }

    public void listacodigostmp() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando listacodigostpm. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        
                int nren;
                ///////////PROGRESSSBARRRR
                try {
                    // System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosTmp");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //   System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        //     JOptionPane.showMessageDialog(null, "Se ha corrido listacodigos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacredito();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacredito() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando listacredito. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        

                int nren;

                ///////////PROGRESSSBARRRR
                //System.out.println("808" + IPSUCURSAL);
                try {
                    //System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosCredito ");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //  System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        //   JOptionPane.showMessageDialog(null, "Se ha corrido lista credito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigoapartados();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacodigoapartados() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando lista codigo apartados. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        

                int nren;

                ///////////PROGRESSSBARRRR
                try {
                    // System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosApartados");
                    //  System.out.println("810");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        // System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        // JOptionPane.showMessageDialog(null, "Se ha corrido lista codigos apartados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigosusadoscompra();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacodigosusadoscompra() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando lista CodigosUsadosCompraTmp. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        

                int nren;

                //System.out.println("808" + IPSUCURSAL);
                try {
                    //System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosUsadosCompraTmp"
                    );

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //   System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        // JOptionPane.showMessageDialog(null, "Se ha corrido lista codigos usados compra", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigosusadosventa();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;
                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacodigosusadosventa() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando lista codigosusadosventa. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        
                int nren;

                ///////////PROGRESSSBARRRR
                //  System.out.println("808" + IPSUCURSAL);
                try {
                    //System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IPSUCURSAL + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery("cml.dbo.spp_ListaCodigosUsadosVentaTmp");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //  System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        JOptionPane.showMessageDialog(null, "Se ha finalizado el proceso", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }
                nren = 0;
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
        //<PROGRESSBAR
    }
//oficinas 1.80
    public void cargaperiododosmesesoficinas() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Ejecutando Periodo dos meses. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        
                int nren;
                ///////////PROGRESSSBARRRR
                try {
                    //    System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80.:55024/CML;" + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery("cml.dbo.spp_CargaPeriodosDosMeses");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //    System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        JOptionPane.showMessageDialog(null, "Se ha corrido Carga periodo dos meses correctamente,continuara con listacodigos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigostmpoficinas();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
        //<PROGRESSBAR

    }

    public void listacodigostmpoficinas() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando listacodigostpm. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        
                int nren;
                ///////////PROGRESSSBARRRR
                try {
                    // System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024/CML;" + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosTmp");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //   System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        //     JOptionPane.showMessageDialog(null, "Se ha corrido listacodigos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacreditooficinas();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacreditooficinas() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando listacredito. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        

                int nren;

                ///////////PROGRESSSBARRRR
                //System.out.println("808" + IPSUCURSAL);
                try {
                    //System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024/CML;" + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosCredito ");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //  System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        //   JOptionPane.showMessageDialog(null, "Se ha corrido lista credito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigoapartadosoficinas();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacodigoapartadosoficinas() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando lista codigo apartados. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        

                int nren;

                ///////////PROGRESSSBARRRR
                try {
                    // System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024/CML;" + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosApartados");
                    //  System.out.println("810");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        // System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        // JOptionPane.showMessageDialog(null, "Se ha corrido lista codigos apartados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigosusadoscompraoficinas();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;

                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacodigosusadoscompraoficinas() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando lista CodigosUsadosCompraTmp. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        

                int nren;

                //System.out.println("808" + IPSUCURSAL);
                try {
                    //System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024/CML;" + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery(" cml.dbo.spp_ListaCodigosUsadosCompraTmp" );

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //   System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        // JOptionPane.showMessageDialog(null, "Se ha corrido lista codigos usados compra", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        listacodigosusadosventaoficinas();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }

                nren = 0;
                ///////////////////////
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
//<PROGRESSBAR

    }

    public void listacodigosusadosventaoficinas() {
        //**************PROGRESSS BAR
        String cval;
        int nval;

        final JDialog dialog = new JDialog(Frame.getFrames()[0], "Sistema de actualiza ventas", true);
        Thread runnable_progress = new Thread() {
            public void run() {
                JTextArea msgLabel;
                JProgressBar progressBar;
                final int MAXIMUM = 100;
                JPanel panel;
                progressBar = new JProgressBar(0, MAXIMUM);
                progressBar.setIndeterminate(true);
                msgLabel = new JTextArea("Procesando lista codigosusadosventa. Por favor espere...");
                msgLabel.setEditable(false);
                panel = new JPanel(new BorderLayout(5, 5));
                panel.add(msgLabel, BorderLayout.PAGE_START);
                panel.add(progressBar, BorderLayout.CENTER);
                panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
                dialog.getContentPane().add(panel);
                dialog.setResizable(false);
                dialog.pack();
                dialog.setSize(500, dialog.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.setAlwaysOnTop(false);
                msgLabel.setBackground(panel.getBackground());
                ///////////////////////        
                int nren;

                ///////////PROGRESSSBARRRR
                //  System.out.println("808" + IPSUCURSAL);
                try {
                    //System.out.println("809");
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024/CML;" + "", "usounds", "madljda");
                    Statement st = conexion.createStatement();

                    ResultSet rs = st.executeQuery("cml.dbo.spp_ListaCodigosUsadosVentaTmp");

                    int c = 0;
                    while (!(rs.isAfterLast())) {
                        //  System.out.println("##" + rs.next() + " >" + c);
                        c = c + 1;
                    }

                } catch (HeadlessException | NumberFormatException | SQLException e) {
                    String respuesta = "The executeQuery method must return a result set.";
                    if (respuesta.equals(e.getMessage())) {
                        progressBar.setIndeterminate(false);///PROGRESSBAR
                        dialog.dispose();//PROGRESSBAR
                        JOptionPane.showMessageDialog(null, "Se ha finalizado el proceso", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR!!!!!!!" + e.getMessage());
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuAvanzado.class.getName()).log(Level.SEVERE, null, ex);
                }
                nren = 0;
            }
        };
        ///PROGRESSBAR>
        runnable_progress.start();
        dialog.setVisible(true);
        //<PROGRESSBAR
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
            java.util.logging.Logger.getLogger(MenuAvanzado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAvanzado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAvanzado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAvanzado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAvanzado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnteliminafolios;
    private javax.swing.JButton btncargaperiodo;
    private javax.swing.JButton btneliminarpoliza;
    private javax.swing.JButton btnoficinas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel txtsucursal;
    // End of variables declaration//GEN-END:variables
}
