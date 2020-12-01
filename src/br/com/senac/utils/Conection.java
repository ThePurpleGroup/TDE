package br.com.senac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    static String url = "jdbc:postgresql://localhost:5432/purpleDesktopDB";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "123456";
    static Connection con;

    public static Connection getConexao() throws SQLException {
        try {
            System.setProperty("jdbc.Drivers", driver);
            if (con == null) {
                con = (Connection) DriverManager.getConnection(url, usuario, senha);
            }
            return con;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}