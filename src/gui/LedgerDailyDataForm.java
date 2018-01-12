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
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import services.AccountServices;

/**
 *
 * @author ehsas
 */
public class LedgerDailyDataForm extends javax.swing.JInternalFrame {

    private AccountServices accountServices;
    private Vector<AccountHolder> vectorAccountHolder;

    String credit;
    String debit;
    String closing;
    String date;
    
    int myCredit = 0,myDebit = 0;

    public LedgerDailyDataForm() {
        initComponents();

//        commonServices = new CommonServices();
        accountServices = new AccountServices();

        this.getContentPane().setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

        vectorAccountHolder = new Vector<AccountHolder>();
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        lblMobileNum = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblClosing = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblCredit = new javax.swing.JLabel();
        lblDebit = new javax.swing.JLabel();
        lblClosingVal = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        btnSaveProduct1 = new javax.swing.JButton();
        btnSaveProduct2 = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblMobileNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMobileNum.setText("Total Credit");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("Date");

        lblClosing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosing.setText("Total Balance Closing");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddress.setText("Total Debit");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDate.setText("********");

        lblCredit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCredit.setText("********");

        lblDebit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDebit.setText("********");

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

        btnSaveProduct2.setBackground(new java.awt.Color(153, 0, 0));
        btnSaveProduct2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSaveProduct2.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProduct2.setText("Show");
        btnSaveProduct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProduct2ActionPerformed(evt);
            }
        });
        btnSaveProduct2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveProduct2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMobileNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblClosing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDebit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblClosingVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobileNum, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClosingVal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClosing, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void convetDate() {
        
        Calendar selectedDate = dateChooserCombo1.getSelectedDate();
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);
        int month = selectedDate.get(Calendar.MONTH) + 1;
        int year = selectedDate.get(Calendar.YEAR);
        
        date = ""+year + "-" + month + "-" + day;
        
         //System.out.println("date is "+year + "-" + month + "-" + day);
    }
  
    private void btnSaveProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProduct1ActionPerformed
     
        convetDate();
        
        vectorAccountHolder = accountServices.getVectorAccountHolderAllDetByDate(date);
        int myClosing = 0,myCredit = 0,myDebit = 0;
        
        for (int i = 0; i < vectorAccountHolder.size(); i++) {
            
            myCredit = myCredit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getCredit());
            myDebit = myDebit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getDebit());
            
            
        }
        
        myClosing = myCredit - myDebit;
        
        lblClosingVal.setText(myClosing+"");
        lblCredit.setText(myCredit+"");
        lblDebit.setText(myDebit+"");
        lblDate.setText(date);
            
                 Component source = (Component) evt.getSource();
                    MainForm1 frame = (MainForm1) SwingUtilities.windowForComponent(source);
                    frame.changeBtnColor();
                    frame.ShowBtnTwo();
                    frame.btnTwoBg();
                    frame.setTextBtnTwo("All Detail Daily");
                    frame.hideMyForms();
                    frame.hideBtnThree();
                    frame.showDailyLedgerDetails(lblCredit.getText(), lblDebit.getText(), lblClosingVal.getText(), date);
            
        
    }//GEN-LAST:event_btnSaveProduct1ActionPerformed

    private void btnSaveProduct1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProduct1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveProduct1KeyPressed

    private void btnSaveProduct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProduct2ActionPerformed

        convetDate();
        
        vectorAccountHolder = accountServices.getVectorAccountHolderAllDetByDate(date);
        int myClosing = 0,myCredit = 0,myDebit = 0;
        
        for (int i = 0; i < vectorAccountHolder.size(); i++) {
            
            myCredit = myCredit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getCredit());
            myDebit = myDebit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getDebit());
            
            System.out.println("credit is "+myCredit);
            System.out.println("Debit is "+myDebit);
            
        }
        
        myClosing = myCredit - myDebit;
        
        lblClosingVal.setText(myClosing+"");
        lblCredit.setText(myCredit+"");
        lblDebit.setText(myDebit+"");
        lblDate.setText(date);
    }//GEN-LAST:event_btnSaveProduct2ActionPerformed

    private void btnSaveProduct2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProduct2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveProduct2KeyPressed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveProduct1;
    private javax.swing.JButton btnSaveProduct2;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblClosing;
    private javax.swing.JLabel lblClosingVal;
    private javax.swing.JLabel lblCredit;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDebit;
    private javax.swing.JLabel lblMobileNum;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
