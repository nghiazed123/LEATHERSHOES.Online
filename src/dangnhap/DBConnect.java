/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangnhap;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class DBConnect {
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "DuAn1_SD19308_NHOM2";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "minhhieu199";

    public static Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustservercertificate=true;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Ket noi thanh cong");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Lỗi kết nối"+e);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
