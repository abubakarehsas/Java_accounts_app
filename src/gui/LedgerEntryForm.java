/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.AccountHolder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import services.AccountServices;
import services.ProductServices;

/**
 *
 * @author ehsas
 */
public class LedgerEntryForm extends javax.swing.JInternalFrame {

    private AccountServices accountServices;
//    private CommonServices commonServices;
    private Vector<AccountHolder> vectorAccountHolder;

    String name;
    String credit;
    String debit;
    String detail;
    String accountHolderId;
    String date;
    
    int myCredit = 0,myDebit = 0;

    boolean myStatus1 = false;
    boolean myStatus2 = false;
    boolean myStatus3 = false;
    boolean myStatus4 = false;
    boolean myStatus5 = false;
    boolean myStatus6 = false;
    boolean myStatus7 = false;
    boolean myStatus8 = false;

    public LedgerEntryForm() {
        initComponents();

//        commonServices = new CommonServices();
        accountServices = new AccountServices();

        this.getContentPane().setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

        vectorAccountHolder = accountServices.getVectorAccountHolder();
        DefaultComboBoxModel modelRollNumber = new DefaultComboBoxModel(vectorAccountHolder);
        cmbAccountHolderName.setModel(modelRollNumber);
        /////////////////////////////////////////////

        showData();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        txtName = new javax.swing.JTextField();
        btnSaveProduct = new javax.swing.JButton();
        txtCredit = new javax.swing.JFormattedTextField();
        txtDebit = new javax.swing.JFormattedTextField();
        cmbAccountHolderName = new javax.swing.JComboBox<String>();
        lblMobileNum = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblClosing = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblNameVal = new javax.swing.JLabel();
        lblMobileNumVal = new javax.swing.JLabel();
        lblAddressVal = new javax.swing.JLabel();
        lblClosingVal = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        btnSaveProduct1 = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtDetail.setColumns(20);
        txtDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDetail.setForeground(new java.awt.Color(204, 204, 204));
        txtDetail.setRows(5);
        txtDetail.setText("Detail");
        txtDetail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDetailFocusLost(evt);
            }
        });
        txtDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDetailMouseClicked(evt);
            }
        });
        txtDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDetailKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDetail);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setText("Search Account Holder Name");
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        btnSaveProduct.setBackground(new java.awt.Color(153, 0, 0));
        btnSaveProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSaveProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProduct.setText("Save");
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

        txtCredit.setForeground(new java.awt.Color(204, 204, 204));
        txtCredit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCredit.setText("Credit");
        txtCredit.setCaretColor(new java.awt.Color(204, 204, 204));
        txtCredit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCredit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCreditFocusLost(evt);
            }
        });
        txtCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCreditMouseClicked(evt);
            }
        });
        txtCredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditKeyTyped(evt);
            }
        });

        txtDebit.setForeground(new java.awt.Color(204, 204, 204));
        txtDebit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtDebit.setText("Debit");
        txtDebit.setCaretColor(new java.awt.Color(204, 204, 204));
        txtDebit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDebit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDebitFocusLost(evt);
            }
        });
        txtDebit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDebitMouseClicked(evt);
            }
        });
        txtDebit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebitKeyTyped(evt);
            }
        });

        cmbAccountHolderName.setEditable(true);
        cmbAccountHolderName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbAccountHolderName.setForeground(new java.awt.Color(204, 204, 204));
        cmbAccountHolderName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Account Holder Name" }));
        cmbAccountHolderName.setBorder(null);
        cmbAccountHolderName.setFocusable(false);
        cmbAccountHolderName.setOpaque(false);
        cmbAccountHolderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAccountHolderNameActionPerformed(evt);
            }
        });

        lblMobileNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMobileNum.setText("Mobile No.");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("Name");

        lblClosing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosing.setText("Closing");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddress.setText("Address");

        lblNameVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNameVal.setText("********");

        lblMobileNumVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMobileNumVal.setText("********");

        lblAddressVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddressVal.setText("********");

        lblClosingVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosingVal.setText("********");

        btnSaveProduct1.setBackground(new java.awt.Color(153, 0, 0));
        btnSaveProduct1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSaveProduct1.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProduct1.setText("Show All Data");
        btnSaveProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProduct1ActionPerformed(evt);
            }
        });
        btnSaveProduct1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveProduct1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbAccountHolderName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblClosing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(lblMobileNum))
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameVal, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(lblMobileNumVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddressVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClosingVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSaveProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNameVal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAccountHolderName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobileNumVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobileNum, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAddressVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClosingVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClosing, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSaveProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked

    }//GEN-LAST:event_txtNameMouseClicked

    public void convetDate() {
        
        Calendar selectedDate = dateChooserCombo1.getSelectedDate();
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);
        int month = selectedDate.get(Calendar.MONTH) + 1;
        int year = selectedDate.get(Calendar.YEAR);
        
        date = ""+year + "-" + month + "-" + day;
        
         //System.out.println("date is "+year + "-" + month + "-" + day);
    }
    
    public void saveLedgerData() {
        name = txtName.getText();
        credit = txtCredit.getText();
        debit = txtDebit.getText();
        detail = txtDetail.getText();

        if (detail.equals("") || detail.equals("Detail")) {

            JOptionPane.showMessageDialog(txtCredit, "Please enter Detail");
        } else if (credit.equals("") || credit.equals("Credit")) {
            if (debit.equals("") || debit.equals("Debit")) {
                JOptionPane.showMessageDialog(txtCredit, "Please enter credit OR debit");
            } else {
                
                credit = "0";
                
               
                saveData();
            }
        }else if (debit.equals("") || debit.equals("Debit")) {
            if (credit.equals("") || credit.equals("Credit")) {
                JOptionPane.showMessageDialog(txtCredit, "Please enter credit OR debit");
            } else {
                
                debit = "0";
               
                saveData();
            }
        } else {
            
            saveData();
        }
    }

    public void saveData() {
        URL url = getClass().getResource("rolling.gif");
        ImageIcon icon = new ImageIcon(url);
        JLabel lblAnimation = new JLabel(icon);
        JLabel lblWait = new JLabel();
        lblWait.setText("Please wait,Saving data ...........");
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
                
                convetDate();
                
                myCredit = Integer.parseInt(credit);
                myDebit = Integer.parseInt(debit);

                boolean status = accountServices.addAccountLedgerDetail(date, myCredit, myDebit,detail,accountHolderId);

                if (status == true) {
                    JOptionPane.showMessageDialog(txtDetail, "Data saved sucessfully");
                    txtName.setText("Search Account Holder Name");
                    txtName.setForeground(new Color(165, 165, 165));
                    txtCredit.setText("Credit");
                    txtCredit.setForeground(new Color(165, 165, 165));
                    txtDebit.setText("Debit");
                    txtDebit.setForeground(new Color(165, 165, 165));
                    txtDetail.setText("Detail");
                    txtDetail.setForeground(new Color(165, 165, 165));

                    showData();
                    
                } else {
                    JOptionPane.showMessageDialog(txtDetail, "Data not saved");
                }

                return null;

            }
        };

        worker.execute();
    }


    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed

        saveLedgerData();
    
    }//GEN-LAST:event_btnSaveProductActionPerformed


    private void txtCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCreditMouseClicked

    }//GEN-LAST:event_txtCreditMouseClicked

    private void txtDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDetailMouseClicked

    }//GEN-LAST:event_txtDetailMouseClicked

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
            txtName.setText("Search Account Holder Name");
            txtName.setForeground(new Color(153, 153, 153));
            myStatus1 = false;
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtCreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditKeyTyped
        if (myStatus3 == false) {
            txtCredit.setText("");
            myStatus3 = true;
        } else {
        }

        txtCredit.setForeground(Color.BLACK);

    }//GEN-LAST:event_txtCreditKeyTyped

    private void txtCreditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCreditFocusLost

        if (txtCredit.getText().equals("")) {
            txtCredit.setText("Credit");
            txtCredit.setForeground(new Color(153, 153, 153));
            myStatus3 = false;
        }
    }//GEN-LAST:event_txtCreditFocusLost

    private void txtDetailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetailKeyTyped

        if (myStatus8 == false) {
            txtDetail.setText("");
            myStatus8 = true;
        } else {
        }

        txtDetail.setForeground(Color.BLACK);

    }//GEN-LAST:event_txtDetailKeyTyped

    private void txtDetailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetailFocusLost

        if (txtDetail.getText().equals("")) {
            txtDetail.setText("Detail");
            txtDetail.setForeground(new Color(153, 153, 153));
            myStatus8 = false;
        }
    }//GEN-LAST:event_txtDetailFocusLost

    private void btnSaveProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProductKeyPressed

        saveLedgerData();

    }//GEN-LAST:event_btnSaveProductKeyPressed

    private void txtDebitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDebitFocusLost

        if (txtDetail.getText().equals("")) {
            txtDetail.setText("Debit");
            txtDetail.setForeground(new Color(153, 153, 153));
            myStatus2 = false;
        }
    }//GEN-LAST:event_txtDebitFocusLost

    private void txtDebitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDebitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebitMouseClicked

    private void txtDebitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebitKeyTyped
       if (myStatus2 == false) {
            txtDebit.setText("");
            myStatus2 = true;
        } else {
        }

        txtDebit.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtDebitKeyTyped

    void showData() {

        AccountHolder accountHolder = (AccountHolder) cmbAccountHolderName.getSelectedItem();

        accountHolderId = accountHolder.getAccountHolderId();
        String accountHolderName = accountHolder.getName();
        String accountHolderMobileNum = accountHolder.getMobileNum();
        String accountHolderAdddress = accountHolder.getAddress();
        
      int closing =  accountServices.getClosing(accountHolderId);

        lblNameVal.setText(accountHolderName);
        lblMobileNumVal.setText(accountHolderMobileNum);
        lblAddressVal.setText(accountHolderAdddress);
        lblClosingVal.setText(closing+"");
    }

    private void cmbAccountHolderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAccountHolderNameActionPerformed
        showData();
    }//GEN-LAST:event_cmbAccountHolderNameActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        searchAccountHolder();
    }//GEN-LAST:event_txtNameKeyReleased

    private void btnSaveProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProduct1ActionPerformed
      
        
        if (accountHolderId.equals("0")) {
            
            JOptionPane.showMessageDialog(btnSaveProduct1, "Please Select AccountHolder");
            
        } else {
            
                 Component source = (Component) evt.getSource();
                    MainForm1 frame = (MainForm1) SwingUtilities.windowForComponent(source);
                    frame.changeBtnColor();
                    frame.ShowBtnTwo();
                    frame.btnTwoBg();
                    frame.hideMyForms();
                    frame.hideBtnThree();
                    frame.showSingleAccHolderDetails(accountHolderId);
            
        }
    }//GEN-LAST:event_btnSaveProduct1ActionPerformed

    private void btnSaveProduct1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProduct1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveProduct1KeyPressed
    public void searchAccountHolder() {
        String nameOrMobile = txtName.getText();

        vectorAccountHolder = accountServices.getVectorAccountHolder(nameOrMobile);
        DefaultComboBoxModel modelRollNumber = new DefaultComboBoxModel(vectorAccountHolder);
        cmbAccountHolderName.setModel(modelRollNumber);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnSaveProduct1;
    private javax.swing.JComboBox<String> cmbAccountHolderName;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressVal;
    private javax.swing.JLabel lblClosing;
    private javax.swing.JLabel lblClosingVal;
    private javax.swing.JLabel lblMobileNum;
    private javax.swing.JLabel lblMobileNumVal;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameVal;
    private javax.swing.JFormattedTextField txtCredit;
    private javax.swing.JFormattedTextField txtDebit;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
