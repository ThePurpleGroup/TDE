package br.com.senac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro {

    private JButton btnAdicionar;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JTextField textNome;
    private JTextField textCpf;
    private JTextField textRg;
    private JTextField textOrgaoExpeditor;
    private JTextField textDatanascimento;
    private JTextField textNomeRua;
    private JTextField textTipoRua;
    private JTextField textNumeroRua;
    private JTextField textComplemento;
    private JTextField textBairro;
    private JTextField textCep;
    private JTextField textCidade;
    private JTextField textEstado;

    public TelaCadastro() {

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
