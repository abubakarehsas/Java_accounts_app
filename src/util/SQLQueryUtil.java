/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ehsas khan
 */
public class SQLQueryUtil {

    private java.sql.Connection connection;
    private Statement statement;

    public void connect(boolean autoCommit) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // System.out.println("Driver Loaded");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/account_exchange",
                    "root", "");
            connection.setAutoCommit(autoCommit);
            //System.out.println("coonection Established");

            statement = connection.createStatement();
            //System.out.println("Statment Created");

        } catch (Throwable th) {
            th.printStackTrace();
            JOptionPane.showMessageDialog(null, "The Software is not conected to data base \n Please open XAMP Control Panel then start Apache and MySQL ");
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public void commit() {
        try {
            if (!(connection == null || connection.isClosed())) {
                connection.commit();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (!(connection == null || connection.isClosed())) {
                connection.rollback();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
