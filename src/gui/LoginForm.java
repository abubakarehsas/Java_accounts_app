/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import com.sun.java.swing.Painter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;

import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Painter;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import services.UserServices;

/**
 *
 * @author ehsas
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    private UserServices userServices;
    boolean userNameStatus = false;
    boolean passStatus = false;

    public LoginForm() {
        setUndecorated(true);

        initComponents();
        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimemsion.width / 2 - this.getSize().width / 2, dimemsion.height / 2 - this.getSize().height / 2);

        try {
            this.setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        } catch (Exception ex) {

        }
        Preferences prefs = Preferences.userNodeForPackage(services.UserServices.class);
        String defaultValue = "ehsas";
        String uName = prefs.get("userName", defaultValue);
        String pass = prefs.get("password", defaultValue);

        userServices = new UserServices();
        String status = userServices.logInUser(uName, pass);

        if (status.equals("1")) {
//            MainForm mainForm = new MainForm();
//            mainForm.setVisible(true);
            MainForm1 mainForm = new MainForm1();
            mainForm.setVisible(true);
            //this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    public void changFormIcone() {
        try {
            java.awt.Image image;
            URL url = getClass().getResource("/logo.png");
            ImageIcon imgIcon = new ImageIcon(url);
            image = imgIcon.getImage();

            this.setIconImage(image);

        } catch (Exception e) {
        }

    }
    
    public void loginUser () {
        String userName = txtUserName.getText();
        String passwird = new String(txtPassword.getPassword());

        if (userName.equals("") || passwird.equals("") || userName.equals("User Name") || passwird.equals("password")) {
            JOptionPane.showMessageDialog(null, "Please enter your user name and password");

        } else {

           // URL url = getClass().getResource("rolling.gif");
            URL url = getClass().getResource("loading.gif");
            ImageIcon icon = new ImageIcon(url);
            JLabel lblAnimation = new JLabel(icon);
            JLabel lblWait = new JLabel();
            lblWait.setText("Please wait for login...........");
            lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblWait.setForeground(new Color(191, 39, 38));
            JPanel panel;
            panel = new JPanel(new BorderLayout(5, 5));
            panel.setBackground(Color.WHITE);
            panel.add(lblWait, BorderLayout.PAGE_START);
            panel.add(lblAnimation, BorderLayout.CENTER);

            panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

            final JDialog dialog = new JDialog();
            dialog.getContentPane().add(panel);
            dialog.setResizable(false);
            dialog.pack();
            dialog.setSize(500, 180);
            dialog.setLocationRelativeTo(null);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.setAlwaysOnTop(false);
            dialog.setVisible(true);

            SwingWorker worker = new SwingWorker() {

                @Override
                protected void done() {
                    // Close the dialog
                    dialog.dispose();
                }

                @Override
                protected void process(List chunks) {
                // Here you can process the result of "doInBackGround()"
                    // Set a variable in the dialog or etc.
                }

                @Override
                protected Object doInBackground() throws Exception {

//                    userServices = new UserServices();
//                    String status = userServices.logInUser(userName, passwird);
//
//                    if (status.equals("1")) {
                        MainForm1 mainForm = new MainForm1();

                        mainForm.setVisible(true);
                        dispose();
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "User name and password is incorrect");
//                    }

                    return null;
                }
            };

            worker.execute();
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

        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblSignIn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(659, 407));
        setMinimumSize(new java.awt.Dimension(659, 407));
        setPreferredSize(new java.awt.Dimension(659, 407));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserName.setBackground(new java.awt.Color(153, 153, 153));
        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setText("User Name");
        txtUserName.setBorder(null);
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameKeyTyped(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 170, 20));

        txtPassword.setBackground(new java.awt.Color(153, 153, 153));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("password");
        txtPassword.setBorder(null);
        txtPassword.setNextFocusableComponent(lblSignIn);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 170, 20));

        lblSignIn.setBackground(new java.awt.Color(192, 41, 40));
        lblSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSignInMousePressed(evt);
            }
        });
        lblSignIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblSignInKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblSignInKeyTyped(evt);
            }
        });
        getContentPane().add(lblSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 60, 20));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 20, 20));

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 20, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSignInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSignInKeyPressed
        loginUser();
    }//GEN-LAST:event_lblSignInKeyPressed

    private void lblSignInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSignInKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSignInKeyTyped

    private void lblSignInMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMousePressed

        loginUser();

    }//GEN-LAST:event_lblSignInMousePressed

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
//        txtUserName.setText("");
//        txtUserName.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
//        txtPassword.setText("");
//        txtPassword.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
       loginUser();
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
       loginUser();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        
         if (txtUserName.getText().equals("")) {
                    txtUserName.setText("User Name");
                    txtUserName.setForeground(new Color(153, 153, 153));
                    userNameStatus = false;
                }
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyTyped
        if (userNameStatus == false) {
                    txtUserName.setText("");
                    userNameStatus = true;
                } else {
                }
                
            txtUserName.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtUserNameKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        if (passStatus == false) {
                    txtPassword.setText("");
                    passStatus = true;
                } else {
                }
                
            txtPassword.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
         if (txtPassword.getText().equals("")) {
                    txtPassword.setText("txtPassword");
                    txtPassword.setForeground(new Color(153, 153, 153));
                    passStatus = false;
                }
    }//GEN-LAST:event_txtPasswordFocusLost

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

            UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarThumb[Enabled].backgroundPainter",
                    new FillPainter(new Color(255, 255, 255)));
            UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarThumb[MouseOver].backgroundPainter",
                    new FillPainter(new Color(192, 41, 40)));
            UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarTrack[Enabled].backgroundPainter",
                    new FillPainter(new Color(255, 255, 255)));
            UIManager.getLookAndFeelDefaults().put("ScrollBar:\"ScrollBar.button\".size", 20);

//            UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
//            UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.WHITE));
//            UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LoginForm().setVisible(true);
                new LoginForm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

class FillPainter implements Painter<JComponent> {

    private final Color color;

    public FillPainter(Color c) {
        color = c;
    }

    @Override
    public void paint(Graphics2D g, JComponent object, int width, int height) {
        g.setColor(color);
        g.fillRect(0, 0, width - 1, height - 1);
    }
}
