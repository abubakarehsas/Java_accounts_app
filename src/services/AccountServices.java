/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.AccountDetail;
import entity.AccountHolder;
import entity.TotalAccountDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author ehsas
 */
public class AccountServices {

    String userId = "1";

    public boolean addAccountHolderDetail(String name, String mobileNum, String address) {
        boolean status = false;

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query;
        try {
            query = "select count(*) as count FROM `account_holder` WHERE `mobile_num`='" + mobileNum + "'";
            rs = sql.executeQuery(query);
            rs.next();
            int count = rs.getInt("count");

            if (count == 1) {

                JOptionPane.showMessageDialog(null, "The record already exist");

            } else {

                query = "INSERT INTO `account_holder`(`name`, `mobile_num`, `address`, `status`) VALUES ('" + name + "','" + mobileNum + "','" + address + "','1');";

                sql.executeUpdate(query);
                sql.commit();

                status = true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean updateAccountHolderDetail(String accountHolderId, String name, String mobileNum, String address) {
        boolean status = false;

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query;
        try {

            query = "UPDATE `account_holder` SET `name`= '" + name + "',`mobile_num`= '" + mobileNum + "',`address`='" + address + "' WHERE `account_holder_id` = '" + accountHolderId + "';";
            sql.executeUpdate(query);
            sql.commit();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean deleteAccountHolderDetail(String accountHolderId) {
        boolean status = false;

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query;
        try {

            query = "UPDATE `account_holder` SET `status` = '0' WHERE `account_holder_id` = '" + accountHolderId + "';";

            sql.executeUpdate(query);
            sql.commit();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<AccountHolder> getAccountHolderAllDetail() {
        List<AccountHolder> list = new ArrayList<AccountHolder>();
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        AccountHolder accountHolder;

        String query = "SELECT * FROM `account_holder` WHERE `status`=1 order by name";

        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                list.add(accountHolder);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return list;
    }

    public Vector<AccountHolder> getVectorAccountHolder() {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<AccountHolder> vectorAccountHolder = new Vector<>();
        ResultSet rs;
        AccountHolder accountHolder;

        String query = "SELECT * FROM `account_holder` order by name asc;";
        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                vectorAccountHolder.add(accountHolder);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorAccountHolder;

    }

    /////////////////////////////////////
    public Vector<AccountDetail> getVectorAccountDetail(String accountHolderId) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<AccountDetail> vectorAccountDetail = new Vector<>();
        ResultSet rs;
        AccountDetail accountDetail;

        String query = "SELECT * FROM `account_details` WHERE `account_holder_id` = '" + accountHolderId + "' AND `status` = 1 order by `date` desc";
        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountDetail = new AccountDetail();
                accountDetail.setId(rs.getString("account_detail_id"));
                accountDetail.setCredit(rs.getString("credit"));
                accountDetail.setDebit(rs.getString("debit"));
                accountDetail.setClosing(rs.getString("closing"));
                accountDetail.setDetail(rs.getString("detail"));
                accountDetail.setDate(rs.getString("date"));

                vectorAccountDetail.add(accountDetail);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorAccountDetail;

    }

    ////////////////////////////////////
    public Vector<AccountHolder> getVectorAccountHolder(String nameOrMobile) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<AccountHolder> vectorAccountHolder = new Vector<>();
        ResultSet rs;
        AccountHolder accountHolder;

        String query = "SELECT * FROM `account_holder` WHERE `name` like('" + nameOrMobile + "%') order by name asc;";
        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                vectorAccountHolder.add(accountHolder);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorAccountHolder;

    }
    // get closing of single account holder

    public Integer getClosing(String accountHolderId) {
        int closing = 0;
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query;
        try {
            query = "SELECT `total_closing` FROM `total_detail_view` WHERE `account_holder_id` = '" + accountHolderId + "';";
            rs = sql.executeQuery(query);
            rs.next();

            try {
                closing = rs.getInt("total_closing");
            } catch (Exception e) {
                closing = 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return closing;
    }

    public boolean addAccountLedgerDetail(String date, int credit, int debit, String detail, String accountHolderId) {
        boolean status = false;
        // String closing = "0";

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query;
        try {
            query = "SELECT `closing` FROM `account_details` WHERE `account_detail_id` = (SELECT MAX(`account_detail_id`) FROM `account_details` WHERE `account_holder_id` = '" + accountHolderId + "')";
            rs = sql.executeQuery(query);
            rs.next();
            int closing = 0;
            try {
                closing = rs.getInt("closing");
            } catch (Exception e) {
            }

            closing = (closing + credit) - debit;

            query = "INSERT INTO `account_details`(`debit`, `credit`, `closing`, `date`, `account_holder_id`, `detail`, `status`, `user_id`) VALUES ('" + debit + "','" + credit + "','" + closing + "','" + date + "','" + accountHolderId + "','" + detail + "','1','" + userId + "');";

            sql.executeUpdate(query);
            sql.commit();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //////////////////////////////////////
    public boolean updateAccountLedgerDetail(String date, int credit, int debit, String detail, String accountDetailId) {
        boolean status = false;
        int myaccountDetailId = Integer.parseInt(accountDetailId);
        myaccountDetailId = myaccountDetailId - 1;

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query, query_acc_holder;
        try {
            query_acc_holder = "SELECT `account_holder_id` FROM `account_details` WHERE `account_detail_id`='" + accountDetailId + "'";
            rs = sql.executeQuery(query_acc_holder);
            rs.next();
            int accHolderId = 0;
            try {
                accHolderId = rs.getInt("account_holder_id");
            } catch (Exception e) {
            }

            query = "SELECT `closing` FROM `account_details` WHERE `account_detail_id` = (SELECT `account_detail_id` FROM `account_details` WHERE `account_holder_id` = '" + accHolderId + "' AND account_detail_id = '" + myaccountDetailId + "')";
            rs = sql.executeQuery(query);
            rs.next();
            int closing = 0;
            try {
                closing = rs.getInt("closing");
            } catch (Exception e) {
            }

            closing = (closing + credit) - debit;

            query = "UPDATE `account_details` SET debit='" + debit + "',`credit`='" + credit + "',`closing`='" + closing + "',`date` = '" + date + "',`detail`='" + detail + "',`user_id`='" + userId + "' WHERE `account_detail_id` = '" + accountDetailId + "';";

            sql.executeUpdate(query);
            sql.commit();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //////////////////////////////////////
    public boolean deleteAccountLedgerDetail(String accountDetailId) {
        boolean status = false;

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        ResultSet rs;
        String query;
        try {

            query = "UPDATE `account_details` SET `status`= 0 WHERE `account_detail_id` = '" + accountDetailId + "';";

            sql.executeUpdate(query);
            sql.commit();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    ////////////////////////////////////
    public Vector<AccountHolder> getVectorAccountHolderAllDetByDate(String date) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<AccountHolder> vectorAccountHolder = new Vector<>();
        ResultSet rs;
        AccountHolder accountHolder;
        AccountDetail accountDetail;
        //SELECT * FROM `all_detail_view` WHERE `date` between '2017-12-29' and '2017-12-30'

        String query = "SELECT * FROM `all_detail_view_new` WHERE `date`= '" + date + "' AND status = 1 order by name asc";
        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                accountDetail = new AccountDetail();
                accountDetail.setId(rs.getString("account_detail_id"));
                accountDetail.setCredit(rs.getString("credit"));
                accountDetail.setDebit(rs.getString("debit"));
                accountDetail.setClosing(rs.getString("closing"));
                accountDetail.setDetail(rs.getString("detail"));
                accountDetail.setDate(rs.getString("date"));

                accountHolder.setAccountDetail(accountDetail);

                vectorAccountHolder.add(accountHolder);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorAccountHolder;

    }

    public Vector<AccountHolder> getVectorAccountHolderAllDetBtwDate(String fromDate, String toDate) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<AccountHolder> vectorAccountHolder = new Vector<>();
        ResultSet rs;
        AccountHolder accountHolder;
        AccountDetail accountDetail;
        //SELECT * FROM `all_detail_view` WHERE `date` between '2017-12-29' and '2017-12-30'

        String query = "SELECT * FROM `all_detail_view_new` WHERE `date` between '" + fromDate + "' and '" + toDate + "' AND status = 1 order by date asc";
        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                accountDetail = new AccountDetail();
                accountDetail.setId(rs.getString("account_detail_id"));
                accountDetail.setCredit(rs.getString("credit"));
                accountDetail.setDebit(rs.getString("debit"));
                accountDetail.setClosing(rs.getString("closing"));
                accountDetail.setDetail(rs.getString("detail"));
                accountDetail.setDate(rs.getString("date"));

                accountHolder.setAccountDetail(accountDetail);

                vectorAccountHolder.add(accountHolder);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorAccountHolder;

    }

             ////////////////////////////////////
    public Vector<AccountHolder> getAll() {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<AccountHolder> vectorAccountHolder = new Vector<>();
        ResultSet rs;
        AccountHolder accountHolder;
        TotalAccountDetail accountDetail;
        //SELECT * FROM `all_detail_view` WHERE `date` between '2017-12-29' and '2017-12-30'

        String query = "SELECT * FROM `total_detail_view` WHERE status = 1 order by name asc";
        try {

            rs = sql.executeQuery(query);

            while (rs.next()) {
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                accountDetail = new TotalAccountDetail();
                accountDetail.setTotalCredit(rs.getString("total_credit"));
                accountDetail.setTotalDebit(rs.getString("total_debit"));
                accountDetail.setTotalClosing(rs.getString("total_closing"));

                accountHolder.setTotalAccountDetail(accountDetail);

                vectorAccountHolder.add(accountHolder);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorAccountHolder;

    }
    
                ////////////////////////////////////
    public AccountHolder getAllById(String accountHolderId) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        ResultSet rs;
        AccountHolder accountHolder = null;
        TotalAccountDetail accountDetail;
        //SELECT * FROM `all_detail_view` WHERE `date` between '2017-12-29' and '2017-12-30'

        String query = "SELECT * FROM `total_detail_view` WHERE account_holder_id='"+accountHolderId+"' AND status = 1";
        try {

            rs = sql.executeQuery(query);

           rs.next();
                accountHolder = new AccountHolder();
                accountHolder.setAccountHolderId(rs.getString("account_holder_id"));
                accountHolder.setName(rs.getString("name"));
                accountHolder.setMobileNum(rs.getString("mobile_num"));
                accountHolder.setAddress(rs.getString("address"));

                accountDetail = new TotalAccountDetail();
                accountDetail.setTotalCredit(rs.getString("total_credit"));
                accountDetail.setTotalDebit(rs.getString("total_debit"));
                accountDetail.setTotalClosing(rs.getString("total_closing"));

                accountHolder.setTotalAccountDetail(accountDetail);

  

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return accountHolder;

    }
}
