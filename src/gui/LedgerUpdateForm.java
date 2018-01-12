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
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import services.AccountServices;

/**
 *
 * @author ehsas
 */
public class LedgerUpdateForm extends javax.swing.JInternalFrame {

    private AccountServices accountServices;
//    private CommonServices commonServices;
    private Vector<AccountHolder> vectorAccountHolder;

    String name;
    String credit;
    String debit;
    String detail;
    String accountHolderId;
    String date;

    int myCredit = 0, myDebit = 0;
    boolean dateStatus = false;

    boolean myStatus1 = false;
    boolean myStatus2 = false;
    boolean myStatus3 = false;
    boolean myStatus4 = false;
    boolean myStatus5 = false;
    boolean myStatus6 = false;
    boolean myStatus7 = false;
    boolean myStatus8 = false;

    public LedgerUpdateForm() {
        initComponents();

//        commonServices = new CommonServices();
        accountServices = new AccountServices();

        this.getContentPane().setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

       // showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        txtCredit = new javax.swing.JFormattedTextField();
        txtDebit = new javax.swing.JFormattedTextField();
        lblMobileNum = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblClosing = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblNameVal = new javax.swing.JLabel();
        lblMobileNumVal = new javax.swing.JLabel();
        lblAddressVal = new javax.swing.JLabel();
        lblDateVal = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        lblName1 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblClosing1 = new javax.swing.JLabel();
        lblClosingVal = new javax.swing.JLabel();
        lblClosing2 = new javax.swing.JLabel();

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

        btnUpdate.setBackground(new java.awt.Color(153, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        btnUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnUpdateKeyPressed(evt);
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

        lblMobileNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMobileNum.setText("Mobile No.");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("Debit");

        lblClosing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosing.setText("Date New");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddress.setText("Address");

        lblNameVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNameVal.setText("********");

        lblMobileNumVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMobileNumVal.setText("********");

        lblAddressVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddressVal.setText("********");

        lblDateVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDateVal.setText("********");

        lblName1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName1.setText("Name");

        lblName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName2.setText("Credit");

        lblClosing1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosing1.setText("Closing");

        lblClosingVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosingVal.setText("********");

        lblClosing2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosing2.setText("Date Old");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblClosing1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblClosing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(lblClosingVal, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDebit, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblMobileNum)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClosing2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMobileNumVal, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lblAddressVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDateVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameVal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMobileNumVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMobileNum, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblClosingVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClosing1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblClosing, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddressVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClosing2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void convetDate() {

        Calendar selectedDate = dateChooserCombo1.getSelectedDate();
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);
        int month = selectedDate.get(Calendar.MONTH) + 1;
        int year = selectedDate.get(Calendar.YEAR);

        date = "" + year + "-" + month + "-" + day;

        //System.out.println("date is "+year + "-" + month + "-" + day);
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Click YES if you want to update date?", "Option", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {

            dateStatus = true;
                                //updateLedgerData();

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

                //updateData();
                    URL url = getClass().getResource("rolling.gif");
                    ImageIcon icon = new ImageIcon(url);
                    JLabel lblAnimation = new JLabel(icon);
                    JLabel lblWait = new JLabel();
                    lblWait.setText("Please wait,Updating data ...........");
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

                            if (dateStatus == false) {
                                date = lblDateVal.getText();
                            }

                            boolean status = accountServices.updateAccountLedgerDetail(date, myCredit, myDebit, detail, accountHolderId);

                            if (status == true) {

                                Component source = (Component) evt.getSource();
                            MainForm1 frame = (MainForm1) SwingUtilities.windowForComponent(source);
                            frame.changeBtnColor();
                            frame.btnTwoBg();
                            frame.ShowBtnTwo();
                            frame.hideMyForms();
                            frame.hideBtnThree();
                            frame.showSingleAccHolderDetails(accountHolderId);


                            } else {
                                JOptionPane.showMessageDialog(txtDetail, "Data not updated");
                            }

                            return null;

                        }
                    };

                    worker.execute();

                }
            } else if (debit.equals("") || debit.equals("Debit")) {
                if (credit.equals("") || credit.equals("Credit")) {
                    JOptionPane.showMessageDialog(txtCredit, "Please enter credit OR debit");
                } else {

                    debit = "0";

              //  updateData();
                    URL url = getClass().getResource("rolling.gif");
                    ImageIcon icon = new ImageIcon(url);
                    JLabel lblAnimation = new JLabel(icon);
                    JLabel lblWait = new JLabel();
                    lblWait.setText("Please wait,Updating data ...........");
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

                            if (dateStatus == false) {
                                date = lblDateVal.getText();
                            }

                            boolean status = accountServices.updateAccountLedgerDetail(date, myCredit, myDebit, detail, accountHolderId);

                            if (status == true) {

                               Component source = (Component) evt.getSource();
                            MainForm1 frame = (MainForm1) SwingUtilities.windowForComponent(source);
                            frame.changeBtnColor();
                            frame.btnTwoBg();
                            frame.ShowBtnTwo();
                            frame.hideMyForms();
                            frame.hideBtnThree();
                            frame.showSingleAccHolderDetails(accountHolderId);


                            } else {
                                JOptionPane.showMessageDialog(txtDetail, "Data not updated");
                            }

                            return null;

                        }
                    };

                    worker.execute();

                }
            } else {

            //updateData();
                URL url = getClass().getResource("rolling.gif");
                ImageIcon icon = new ImageIcon(url);
                JLabel lblAnimation = new JLabel(icon);
                JLabel lblWait = new JLabel();
                lblWait.setText("Please wait,Updating data ...........");
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

                        if (dateStatus == false) {
                            date = lblDateVal.getText();
                        }

                        boolean status = accountServices.updateAccountLedgerDetail(date, myCredit, myDebit, detail, accountHolderId);

                        if (status == true) {

                            Component source = (Component) evt.getSource();
                            MainForm1 frame = (MainForm1) SwingUtilities.windowForComponent(source);
                            frame.changeBtnColor();
                            frame.btnTwoBg();
                            frame.ShowBtnTwo();
                            frame.hideMyForms();
                            frame.hideBtnThree();
                            frame.showSingleAccHolderDetails(accountHolderId);

                        } else {
                            JOptionPane.showMessageDialog(txtDetail, "Data not updated");
                        }

                        return null;

                    }
                };

                worker.execute();

            }

        }


    }//GEN-LAST:event_btnUpdateActionPerformed


    private void txtCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCreditMouseClicked

    }//GEN-LAST:event_txtCreditMouseClicked

    private void txtDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDetailMouseClicked

    }//GEN-LAST:event_txtDetailMouseClicked

    private void txtCreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditKeyTyped
        if (myStatus3 == false) {
            //txtCredit.setText("");
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
          //  txtDetail.setText("");
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

    private void btnUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnUpdateKeyPressed

       // updateLedgerData();

    }//GEN-LAST:event_btnUpdateKeyPressed

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
            //txtDebit.setText("");
            myStatus2 = true;
        } else {
        }

        txtDebit.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtDebitKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressVal;
    private javax.swing.JLabel lblClosing;
    private javax.swing.JLabel lblClosing1;
    private javax.swing.JLabel lblClosing2;
    private javax.swing.JLabel lblClosingVal;
    private javax.swing.JLabel lblDateVal;
    private javax.swing.JLabel lblMobileNum;
    private javax.swing.JLabel lblMobileNumVal;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblNameVal;
    private javax.swing.JFormattedTextField txtCredit;
    private javax.swing.JFormattedTextField txtDebit;
    private javax.swing.JTextArea txtDetail;
    // End of variables declaration//GEN-END:variables

    void displayInfo(String myId1, String mycredit1, String mydebit1, String myclosing1, String mydate1, String mydetail1, String name, String mobileNum, String address) {
        txtCredit.setText(mycredit1);
        txtCredit.setForeground(Color.BLACK);
        txtDebit.setText(mydebit1);
        txtDebit.setForeground(Color.BLACK);
        lblClosingVal.setText(myclosing1);
        txtDetail.setText(mydetail1);
        txtDetail.setForeground(Color.BLACK);
        dateChooserCombo1.setText(mydate1);

        lblNameVal.setText(name);
        lblAddressVal.setText(address);
        lblMobileNumVal.setText(mobileNum);
        lblDateVal.setText(mydate1);

        accountHolderId = myId1;

    }
}
