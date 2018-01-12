/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import services.AccountServices;
import services.ProductServices;

/**
 *
 * @author ehsas
 */
public class AddAccount extends javax.swing.JInternalFrame {

    private AccountServices accountServices;
//    private CommonServices commonServices;


    String name;
    String mobileNum;
    String address;

    
    boolean myStatus1 = false;
    boolean myStatus2 = false;
    boolean myStatus3 = false;
    boolean myStatus4 = false;
    boolean myStatus5 = false;
    boolean myStatus6 = false;
    boolean myStatus7 = false;
    boolean myStatus8 = false;

    public AddAccount() {
        initComponents();

//        commonServices = new CommonServices();
        accountServices = new AccountServices();

//        List<Category> vectorCategories = commonServices.getCategories();
//        DefaultComboBoxModel model;
//        model = new DefaultComboBoxModel((Vector) vectorCategories);
//        cmbCategory.setModel(model);
        


//        String catId = category.getCategoryId();

//        Vector<SubCategory> vectorSubCategories = commonServices.getSubCategories(catId);
//        DefaultComboBoxModel modelSubCategories = new DefaultComboBoxModel(vectorSubCategories);
//        cmbSubCategory.setModel(modelSubCategories);
        ///////////////////////////////////////////////

        this.getContentPane().setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

       

    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtName = new javax.swing.JTextField();
        btnSaveProduct = new javax.swing.JButton();
        txtMobileNum = new javax.swing.JFormattedTextField();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(204, 204, 204));
        txtAddress.setRows(5);
        txtAddress.setText("Address");
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        txtAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAddressMouseClicked(evt);
            }
        });
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtAddress);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setText("Account Holder Name");
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        btnSaveProduct.setBackground(new java.awt.Color(153, 0, 0));
        btnSaveProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSaveProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProduct.setText("Create Account");
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });
        btnSaveProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveProductKeyPressed(evt);
            }
        });

        txtMobileNum.setForeground(new java.awt.Color(204, 204, 204));
        txtMobileNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtMobileNum.setText("Mobile Number");
        txtMobileNum.setCaretColor(new java.awt.Color(204, 204, 204));
        txtMobileNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMobileNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMobileNumFocusLost(evt);
            }
        });
        txtMobileNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMobileNumMouseClicked(evt);
            }
        });
        txtMobileNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMobileNumKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMobileNum, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMobileNum, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked

    }//GEN-LAST:event_txtNameMouseClicked

    public void registerAccount() {
         name = txtName.getText();
        mobileNum = txtMobileNum.getText();
        address = txtAddress.getText();

        if (name.equals("")|| mobileNum.equals("") ||  address.equals("") || name.equals("Account Holder Name") || address.equals("Address") || mobileNum.equals("Mobile Number")) {

            JOptionPane.showMessageDialog(txtMobileNum, "Please enter Account Holder Detail");
        } else {

            URL url = getClass().getResource("rolling.gif");
            ImageIcon icon = new ImageIcon(url);
            JLabel lblAnimation = new JLabel(icon);
            JLabel lblWait = new JLabel();
            lblWait.setText("Please wait,Creating Account ...........");
            lblWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblWait.setForeground(new Color(191, 39, 38));
            JPanel panel1;
            panel1 = new JPanel(new BorderLayout(5, 5));
            panel1.setBackground(Color.WHITE);
            panel1.add(lblWait, BorderLayout.PAGE_START);
            panel1.add(lblAnimation, BorderLayout.CENTER);

            panel1.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

            final JDialog dialog = new JDialog();
            dialog.getContentPane().add(panel1);
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

                }

                @Override
                protected Object doInBackground() throws Exception {

                  boolean status = accountServices.addAccountHolderDetail(name, mobileNum, address);

                    if (status == true) {
                        JOptionPane.showMessageDialog(txtAddress, "Account detail added sucessfully");
                        txtName.setText("Account Holder Name");
                        txtName.setForeground(new Color(165, 165, 165));
                        txtMobileNum.setText("Mobile Number");
                        txtMobileNum.setForeground(new Color(165, 165, 165));
                        txtAddress.setText("Address");
                        txtAddress.setForeground(new Color(165, 165, 165));
                    } else {
                        JOptionPane.showMessageDialog(txtAddress, "Account detail not added");
                    }
                    

                    return null;

                }
            };

            worker.execute();
        }
    }
    
    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed

        registerAccount();

       
    }//GEN-LAST:event_btnSaveProductActionPerformed

   
    private void txtMobileNumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMobileNumMouseClicked
        
    }//GEN-LAST:event_txtMobileNumMouseClicked

    private void txtAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddressMouseClicked
        
    }//GEN-LAST:event_txtAddressMouseClicked

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        
        if (myStatus1 == false) {
                    txtName.setText("");
                    myStatus1 = true;
                } else {
                }
                
            txtName.setForeground(Color.BLACK);

    }//GEN-LAST:event_txtNameKeyTyped

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
       
            if (txtName.getText().equals("")) {
                    txtName.setText("Account Holder Name");
                    txtName.setForeground(new Color(153, 153, 153));
                    myStatus1 = false;
                }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtMobileNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileNumKeyTyped
        if (myStatus3 == false) {
                    txtMobileNum.setText("");
                    myStatus3 = true;
                } else {
                }
                
            txtMobileNum.setForeground(Color.BLACK);
            
    }//GEN-LAST:event_txtMobileNumKeyTyped

    private void txtMobileNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMobileNumFocusLost
       
            if (txtMobileNum.getText().equals("")) {
                    txtMobileNum.setText("Mobile Number");
                    txtMobileNum.setForeground(new Color(153, 153, 153));
                    myStatus3 = false;
                }
    }//GEN-LAST:event_txtMobileNumFocusLost

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped
        
        if (myStatus8 == false) {
                    txtAddress.setText("");
                    myStatus8 = true;
                } else {
                }
                
            txtAddress.setForeground(Color.BLACK);
            
    }//GEN-LAST:event_txtAddressKeyTyped

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
     
            if (txtAddress.getText().equals("")) {
                    txtAddress.setText("Address");
                    txtAddress.setForeground(new Color(153, 153, 153));
                    myStatus8 = false;
                }
    }//GEN-LAST:event_txtAddressFocusLost

    private void btnSaveProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProductKeyPressed

        registerAccount();

    }//GEN-LAST:event_btnSaveProductKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JFormattedTextField txtMobileNum;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
