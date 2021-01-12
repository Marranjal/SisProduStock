/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.util;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abelardo
 */
public class Conexao {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/restbd00";
    private static String utilizador = "root";
    private static String senha = "root";

    public static Connection getConnection() throws Exception {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, utilizador, senha);
        } catch (ClassNotFoundException notFoundException) {
            throw new Exception(notFoundException.getMessage());
        } catch (SQLException sQLException) {
            throw new Exception(sQLException.getMessage());
        }
    }

    public static void closeConnection(Connection conn,
            Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt)
            throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn)
            throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn,
            Statement stmt, ResultSet rs)
            throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
