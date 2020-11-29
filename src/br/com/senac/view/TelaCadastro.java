package br.com.senac.view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import br.com.senac.utils.Mask;

public class TelaCadastro extends JFrame {

    private JButton btnAdicionar;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JTextField textNome;
    private JTextField textRg;
    private JTextField textOrgaoExpeditor;
    private JTextField textNomeRua;
    private JTextField textTipoRua;
    private JTextField textNumeroRua;
    private JTextField textComplemento;
    private JTextField textBairro;
    private JTextField textCidade;
    private JTextField textEstado;
    private JPanel panelCadastro;
    private JFormattedTextField textCPF;
    private JFormattedTextField textData;
    private JFormattedTextField textCEP;

    public TelaCadastro() {

        super("purple Desktop cadastro");
        this.setContentPane(this.panelCadastro);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        Mask textMask = new Mask();

        try {
            textCPF = new JFormattedTextField(textMask.maskCpf(textCPF));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            textData = new JFormattedTextField(textMask.maskData(textData));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            textCEP = new JFormattedTextField(textMask.maskCep(textCEP));
        } catch (ParseException e) {
            e.printStackTrace();
        }




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
