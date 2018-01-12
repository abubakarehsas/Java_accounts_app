/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.AccountHolder;
import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import services.AccountServices;

/**
 *
 * @author ehsas
 */
public class LedgerDataBtnDatesForm extends javax.swing.JInternalFrame {

    private AccountServices accountServices;
    private Vector<AccountHolder> vectorAccountHolder;

    String credit;
    String debit;
    String closing;
    String fromDate,toDate;
    
    int myCredit = 0,myDebit = 0;

    public LedgerDataBtnDatesForm() {
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
        lblToDateVal = new javax.swing.JLabel();
        lblCredit = new javax.swing.JLabel();
        lblDebit = new javax.swing.JLabel();
        lblClosingVal = new javax.swing.JLabel();
        cmbfromDate = new datechooser.beans.DateChooserCombo();
        btnSaveProduct1 = new javax.swing.JButton();
        btnSaveProduct2 = new javax.swing.JButton();
        cmbToDate = new datechooser.beans.DateChooserCombo();
        lblName1 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();
        lblFromDateVal = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblMobileNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMobileNum.setText("Total Credit");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("To Date");

        lblClosing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClosing.setText("Total Balance Closing");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddress.setText("Total Debit");

        lblToDateVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblToDateVal.setText("********");

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

        lblName1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName1.setText("To");

        lblName2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName2.setText("From");

        lblName3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName3.setText("From Date");

        lblFromDateVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFromDateVal.setText("********");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(lblFromDateVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblMobileNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblClosing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDebit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClosingVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblToDateVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSaveProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbfromDate, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(cmbToDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbfromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFromDateVal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblToDateVal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void convetFromDate() {
        
        Calendar selectedDate = cmbfromDate.getSelectedDate();
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);
        int month = selectedDate.get(Calendar.MONTH) + 1;
        int year = selectedDate.get(Calendar.YEAR);
        
        fromDate = ""+year + "-" + month + "-" + day;
        
        Calendar selectedToDate = cmbToDate.getSelectedDate();
        int dayTo = selectedToDate.get(Calendar.DAY_OF_MONTH);
        int monthTo = selectedToDate.get(Calendar.MONTH) + 1;
        int yearTo = selectedToDate.get(Calendar.YEAR);
        
        toDate = ""+yearTo + "-" + monthTo + "-" + dayTo;
        
         //System.out.println("date is "+year + "-" + month + "-" + day);
    }
  
    private void btnSaveProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProduct1ActionPerformed
     
        convetFromDate();
        
        vectorAccountHolder = accountServices.getVectorAccountHolderAllDetBtwDate(fromDate, toDate);
        int myClosing = 0,myCredit = 0,myDebit = 0;
        
        for (int i = 0; i < vectorAccountHolder.size(); i++) {
            
            myCredit = myCredit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getCredit());
            myDebit = myDebit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getDebit());
           
            
        }
        
        myClosing = myCredit - myDebit;
        
        lblClosingVal.setText(myClosing+"");
        lblCredit.setText(myCredit+"");
        lblDebit.setText(myDebit+"");
        lblFromDateVal.setText(fromDate);
        lblToDateVal.setText(toDate);
            
                 Component source = (Component) evt.getSource();
                    MainForm1 frame = (MainForm1) SwingUtilities.windowForComponent(source);
                    frame.changeBtnColor();
                    frame.ShowBtnTwo();
                    frame.btnTwoBg();
                    frame.setTextBtnTwo("All Detail Between Dates");
                    frame.hideMyForms();
                    frame.hideBtnThree();
                    frame.showLedgerDetailsBtnDates(lblCredit.getText(), lblDebit.getText(), myClosing, fromDate,toDate);
            
        
    }//GEN-LAST:event_btnSaveProduct1ActionPerformed

    private void btnSaveProduct1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProduct1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveProduct1KeyPressed

    private void btnSaveProduct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProduct2ActionPerformed

        convetFromDate();
        
        vectorAccountHolder = accountServices.getVectorAccountHolderAllDetBtwDate(fromDate, toDate);
        int myClosing = 0,myCredit = 0,myDebit = 0;
        
        for (int i = 0; i < vectorAccountHolder.size(); i++) {
            
            myCredit = myCredit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getCredit());
            myDebit = myDebit + Integer.parseInt(vectorAccountHolder.get(i).getAccountDetail().getDebit());
           
            
        }
        
        myClosing = myCredit - myDebit;
        
        lblClosingVal.setText(myClosing+"");
        lblCredit.setText(myCredit+"");
        lblDebit.setText(myDebit+"");
        lblFromDateVal.setText(fromDate);
        lblToDateVal.setText(toDate);
    }//GEN-LAST:event_btnSaveProduct2ActionPerformed

    private void btnSaveProduct2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveProduct2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveProduct2KeyPressed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveProduct1;
    private javax.swing.JButton btnSaveProduct2;
    private datechooser.beans.DateChooserCombo cmbToDate;
    private datechooser.beans.DateChooserCombo cmbfromDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblClosing;
    private javax.swing.JLabel lblClosingVal;
    private javax.swing.JLabel lblCredit;
    private javax.swing.JLabel lblDebit;
    private javax.swing.JLabel lblFromDateVal;
    private javax.swing.JLabel lblMobileNum;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblToDateVal;
    // End of variables declaration//GEN-END:variables
}
