package br.com.senac.view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;

import br.com.senac.bean.Cliente;
import br.com.senac.bean.Endereco;
import br.com.senac.controller.ClienteController;
import br.com.senac.controller.EnderecoController;
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

    public Cliente montaCliente() {
        Cliente c = new Cliente();
        Endereco en = new Endereco();
        c.setNome(this.textNome.getText());
        c.setCpf(this.textCPF.getText());
        c.setRg(this.textRg.getText());
        c.setOrgao(this.textOrgaoExpeditor.getText());
        c.setDataNascimento(Date.valueOf(this.textData.getText()));
        c.setIdEndereco(en.getId());
        return c;
    }

    public Endereco montaEndereco() {
        Endereco en = new Endereco();
        en.setNome(this.textNomeRua.getText());
        en.setLogradouro(this.textTipoRua.getText());
        en.setNumero(this.textNumeroRua.getText());
        en.setComplemento(this.textComplemento.getText());
        en.setBairro(this.textBairro.getText());
        en.setCep(this.textCEP.getText());
        en.setCidade(this.textCidade.getText());
        en.setEstado(this.textEstado.getText());
        return en;
    }

    public void limpaTela() {
        for (int i = 0; i < panelCadastro.getComponentCount(); i++) {
            Component c = panelCadastro.getComponent(i);
            if (c instanceof JTextField) {
                JTextField campo = (JTextField) c;
                campo.setText(null);
            }
            if (c instanceof JFormattedTextField) {
                JFormattedTextField campo = (JFormattedTextField) c;
                campo.setText(null);
            }
        }
    }

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
                if (textNome.getText() != null && !textNome.getText().equals("") &&
                        textCPF.getText() != null && !textCPF.getText().equals("") &&
                        textRg.getText() != null && !textRg.getText().equals("") &&
                        textOrgaoExpeditor.getText() != null && !textOrgaoExpeditor.getText().equals("") &&
                        textData.getText() != null && !textData.getText().equals("") &&
                        textNomeRua.getText() != null && !textNomeRua.getText().equals("") &&

                        textTipoRua.getText() != null && !textTipoRua.getText().equals("") &&
                        !textNumeroRua.getText().equals("") &&
                        textComplemento.getText() != null && !textComplemento.getText().equals("") &&
                        textBairro.getText() != null && !textBairro.getText().equals("") &&
                        textCEP.getText() != null && !textCEP.getText().equals("") &&
                        textCidade.getText() != null && !textCidade.getText().equals("") &&
                        textEstado.getText() != null && !textEstado.getText().equals("")) {

                    Endereco en = montaEndereco();
                    Cliente c = montaCliente();

                    EnderecoController enderecoController = new EnderecoController();
                    ClienteController clienteController = new ClienteController();

                    enderecoController.insert(en);
                    clienteController.insert(c);

                    limpaTela();

                    JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro! Cliente não Cadastrado!");
                }

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
