package tarea01azm;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @author Alexandre Zerva Moreno
 */
public class Entrenamientos extends javax.swing.JFrame {

    //Variables que establecen la posicion del ratón.
    private int MouseX, MouseY;

    public Entrenamientos() {
        initComponents();
        //Establemos la pantalla del programa/formulario en el medio de la pantalla.
        this.setLocationRelativeTo(this);
        rsscalelabel.RSScaleLabel.setScaleLabel(imagenLogo, "src/resources/logo.png");
        setIconImage(getIconImage());
    }

    /**
     * Agregamos nuestra imagen de logo del programa
     *
     * @return
     */
    @Override
    public Image getIconImage() {
        Image image = Toolkit.getDefaultToolkit().getImage(ClassLoader
                .getSystemResource("resources/logo.png"));
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        TituloLabel = new javax.swing.JLabel();
        btnNuevoEntrenamiento = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        LogoPanel = new javax.swing.JPanel();
        gymLabel = new javax.swing.JLabel();
        empresaNombre = new javax.swing.JLabel();
        imagenLogo = new javax.swing.JLabel();
        menuEntrenamientosBarra = new javax.swing.JMenuBar();
        menuEntrenamientos = new javax.swing.JMenu();
        item_entrenamientos = new javax.swing.JMenuItem();
        item_salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 204));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(51, 204, 255));
        PanelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloLabel.setBackground(new java.awt.Color(3, 64, 120));
        TituloLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        TituloLabel.setForeground(new java.awt.Color(0, 31, 84));
        TituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloLabel.setText("Entrenamientos");
        PanelPrincipal.add(TituloLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, -1));

        btnNuevoEntrenamiento.setBackground(new java.awt.Color(0, 31, 84));
        btnNuevoEntrenamiento.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnNuevoEntrenamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoEntrenamiento.setText("Nuevo Entrenamiento");
        btnNuevoEntrenamiento.setToolTipText("");
        btnNuevoEntrenamiento.setBorder(null);
        btnNuevoEntrenamiento.setBorderPainted(false);
        btnNuevoEntrenamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoEntrenamiento.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N
        btnNuevoEntrenamiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoEntrenamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoEntrenamientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoEntrenamientoMouseExited(evt);
            }
        });
        btnNuevoEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEntrenamientoActionPerformed(evt);
            }
        });
        PanelPrincipal.add(btnNuevoEntrenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 270, 40));

        btnExit.setBackground(new java.awt.Color(0, 31, 84));
        btnExit.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Salir");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        PanelPrincipal.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 120, 40));

        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 580, 500));

        LogoPanel.setBackground(new java.awt.Color(0, 31, 84));
        LogoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gymLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        gymLabel.setForeground(new java.awt.Color(255, 255, 255));
        gymLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gymLabel.setText("Gimnasio ");
        LogoPanel.add(gymLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 230, 80));

        empresaNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        empresaNombre.setForeground(new java.awt.Color(255, 255, 255));
        empresaNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empresaNombre.setText("Al - Andalus");
        LogoPanel.add(empresaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 300, 60));

        imagenLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LogoPanel.add(imagenLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 280, 400));

        getContentPane().add(LogoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 500));

        menuEntrenamientosBarra.setBackground(new java.awt.Color(0, 31, 84));
        menuEntrenamientosBarra.setBorder(null);
        menuEntrenamientosBarra.setForeground(new java.awt.Color(0, 31, 84));
        menuEntrenamientosBarra.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        menuEntrenamientos.setBackground(new java.awt.Color(51, 204, 255));
        menuEntrenamientos.setBorder(null);
        menuEntrenamientos.setText("Entrenamientos");

        item_entrenamientos.setText("Entrenamientos");
        item_entrenamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_entrenamientosActionPerformed(evt);
            }
        });
        menuEntrenamientos.add(item_entrenamientos);

        item_salir.setText("Salir");
        item_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_salirActionPerformed(evt);
            }
        });
        menuEntrenamientos.add(item_salir);

        menuEntrenamientosBarra.add(menuEntrenamientos);

        setJMenuBar(menuEntrenamientosBarra);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        //Establecemos las coordenadas del mouse en las variables
        MouseX = evt.getX();
        MouseY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - MouseX, y - MouseY);
    }//GEN-LAST:event_formMouseDragged

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Salimos del programa
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNuevoEntrenamientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEntrenamientoMouseEntered
        // TODO add your handling code here:
        btnNuevoEntrenamiento.setBackground(new Color(38, 100, 86));
    }//GEN-LAST:event_btnNuevoEntrenamientoMouseEntered

    private void btnNuevoEntrenamientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEntrenamientoMouseExited
        // TODO add your handling code here:
        btnNuevoEntrenamiento.setBackground(new Color(0, 31, 84));
    }//GEN-LAST:event_btnNuevoEntrenamientoMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
        btnExit.setBackground(new Color(183, 31, 90));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // TODO add your handling code here:
        btnExit.setBackground(new Color(0, 31, 84));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnNuevoEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEntrenamientoActionPerformed
        // TODO add your handling code here:
        tipoEntrenamiento = new TipoEntrenamiento(this, true);
        tipoEntrenamiento.setVisible(true);
    }//GEN-LAST:event_btnNuevoEntrenamientoActionPerformed

    private void item_entrenamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_entrenamientosActionPerformed
        // TODO add your handling code here:
        tipoEntrenamiento = new TipoEntrenamiento(this, true);
        tipoEntrenamiento.setVisible(true);
    }//GEN-LAST:event_item_entrenamientosActionPerformed

    private void item_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_item_salirActionPerformed

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
            java.util.logging.Logger.getLogger(Entrenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Entrenamientos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogoPanel;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNuevoEntrenamiento;
    private javax.swing.JLabel empresaNombre;
    private javax.swing.JLabel gymLabel;
    private javax.swing.JLabel imagenLogo;
    private javax.swing.JMenuItem item_entrenamientos;
    private javax.swing.JMenuItem item_salir;
    private javax.swing.JMenu menuEntrenamientos;
    private javax.swing.JMenuBar menuEntrenamientosBarra;
    // End of variables declaration//GEN-END:variables

    private JDialog tipoEntrenamiento;
    private JFrame entrenamiento;
}
