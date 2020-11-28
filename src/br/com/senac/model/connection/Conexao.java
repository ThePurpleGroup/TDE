package br.com.senac.model.connection;

import java.awt.Component;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    public static java.sql.Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tde", "postgres", "aluno");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            Component janela = null;
            JOptionPane.showMessageDialog(janela, ex.getMessage(), "Erro na Conexão", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
