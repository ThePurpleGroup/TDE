package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.senac.model.bean.Cliente;
import br.com.senac.model.connection.Conexao;

import javax.swing.*;

public class ClientesDAO {

    public void salvar(Cliente c) {

        try (Connection con = Conexao.getConnection()){
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO cliente (nome, cpf, rg, orgao,"
                    + "data_nascimento, id_endereco) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getCpf());
            pstmt.setString(3, c.getRg());
            pstmt.setString(4, c.getOrgao());
            pstmt.setDate(5, Date.valueOf(c.getDateNascimento()));
            pstmt.setLong(6, c.getId_endereco());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        }
    }
}
