/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Movil;

/**
 *
 * @author rick
 */
public class CoreGUI extends javax.swing.JFrame {

    /**
     * Creates new form CoreGUI
     */
    public CoreGUI() {
        initComponents();
        mostrarRecorrido();
        mostrarParadas();
        
        ImageIcon tmpIcon, thumbnail;
        File f = new File("Interfaz exe.jpg");
        
        if (f == null) { 
        thumbnail = null; 
        } else { 
            tmpIcon = new ImageIcon(f.getPath()); 
        if(tmpIcon.getIconWidth() > 90) { 

        thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(90, -1, Image.SCALE_DEFAULT)); 

        } else { 
        thumbnail = tmpIcon; 
        } 
        } 
        
        this.jLabel1.setIcon(thumbnail);
        this.jPanel1.repaint();
        
        this.setLocationRelativeTo(null);
        
    }

    public void mostrarRecorrido()
    {   
        new Runnable() {
        @Override
        public void run() {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("RUTA");df.addColumn("SERVICIO");df.addColumn("RECORRIDO (segundos)");
                for (Movil movile : transmetro.Transmetro.moviles) {
                    String[] campos = {movile.getRuta(),String.valueOf(movile.getServicio()),movile.recorrido()};
                    df.addRow(campos);
                }
            recorrido_buses.setModel(df);
            }
        }.run();
    }
    
    public void mostrarParadas()
    {
        new Runnable() {
        @Override
        public void run() {
            int r=0;
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("RUTA");df.addColumn("Número de paradas");
            Movil ant=null;
                for (Movil movile : transmetro.Transmetro.moviles) {
                    if (ant==null)ant=movile;
                    if(ant.getRuta().equals(movile.getRuta())){++r;continue;}
                    String[] campos = {ant.getRuta(),String.valueOf(r)};
                    ant=movile;
                    df.addRow(campos);
                }
            metricas2.setModel(df);
            }
        }.run();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneles_general = new javax.swing.JTabbedPane();
        general = new javax.swing.JPanel();
        map = (javax.swing.JPanel)new maploader.NavegadorPrueba("web_resources/prueba_maps.html");
        general_buses = new javax.swing.JScrollPane();
        recorrido_buses = new javax.swing.JTable();
        tabla2 = new javax.swing.JScrollPane();
        metricas2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneles_general.setBackground(new java.awt.Color(61, 61, 61));

        general.setBackground(new java.awt.Color(51, 51, 51));

        map.setMinimumSize(new java.awt.Dimension(50, 50));
        map.setPreferredSize(new java.awt.Dimension(500, 500));

        recorrido_buses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        general_buses.setViewportView(recorrido_buses);

        metricas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla2.setViewportView(metricas2);

        javax.swing.GroupLayout generalLayout = new javax.swing.GroupLayout(general);
        general.setLayout(generalLayout);
        generalLayout.setHorizontalGroup(
            generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(general_buses, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(tabla2))
                .addGap(18, 18, 18)
                .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        generalLayout.setVerticalGroup(
            generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalLayout.createSequentialGroup()
                        .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(generalLayout.createSequentialGroup()
                        .addComponent(general_buses, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        paneles_general.addTab("General", general);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Interfaz exe.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        paneles_general.addTab("Información General", jPanel1);

        getContentPane().add(paneles_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoreGUI().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel general;
    private javax.swing.JScrollPane general_buses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel map;
    private javax.swing.JTable metricas2;
    private javax.swing.JTabbedPane paneles_general;
    private javax.swing.JTable recorrido_buses;
    private javax.swing.JScrollPane tabla2;
    // End of variables declaration//GEN-END:variables
}
