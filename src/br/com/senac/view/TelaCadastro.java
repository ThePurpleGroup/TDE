package br.com.senac.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import br.com.senac.bean.Cliente;
import br.com.senac.bean.Endereco;
import br.com.senac.controller.ClienteController;
import br.com.senac.controller.EnderecoController;
import br.com.senac.utils.Mask;

public class TelaCadastro extends JFrame {

    public JButton btnAdicionar;
    public JButton btnAtualizar;
    public JButton btnExcluir;
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
    public Cliente atualCliente;
    public Endereco atualEndereco;

    public void preencheCadastro(Cliente clienteSelecionado, Endereco enderecoSelecionado) {
        this.atualCliente = clienteSelecionado;
        this.atualEndereco = enderecoSelecionado;

        mascaraCampos();

        textNome.setText(clienteSelecionado.getNome());
        textCPF.setValue(clienteSelecionado.getCpf());
        textRg.setText(clienteSelecionado.getRg());
        textOrgaoExpeditor.setText(clienteSelecionado.getOrgao());
        textData.setValue(clienteSelecionado.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        textNomeRua.setText(enderecoSelecionado.getNome());
        textTipoRua.setText(enderecoSelecionado.getLogradouro());
        textCEP.setValue(enderecoSelecionado.getCep());
        textBairro.setText(enderecoSelecionado.getBairro());
        textCidade.setText(enderecoSelecionado.getCidade());
        textComplemento.setText(enderecoSelecionado.getComplemento());
        textEstado.setText(enderecoSelecionado.getEstado());
        textNumeroRua.setText(enderecoSelecionado.getNumero());

    }

    public void mascaraCampos() {
        Mask textMask = new Mask();
        try {
            new JFormattedTextField(textMask.maskCpf(textCPF));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            new JFormattedTextField(textMask.maskData(textData));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            new JFormattedTextField(textMask.maskCep(textCEP));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Cliente montaCliente() {
        Cliente c = new Cliente();
        c.setNome(this.textNome.getText());
        c.setCpf(this.textCPF.getText());
        c.setRg(this.textRg.getText());
        c.setOrgao(this.textOrgaoExpeditor.getText());
        c.setDataNascimento(this.textData.getText());
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
        this.setLocation(436, 135);
        this.setContentPane(this.panelCadastro);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        mascaraCampos();


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
                    dispose();

                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro! Cliente não Cadastrado!");
                }
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
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

                    en.setId(atualEndereco.getId());
                    c.setId(atualCliente.getId());

                    EnderecoController enderecoController = new EnderecoController();
                    ClienteController clienteController = new ClienteController();

                    enderecoController.update(en);
                    clienteController.update(c);

                    limpaTela();
                    dispose();

                    JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro! Cliente não Atualizado!");
                }
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Sim", "Não"};
                int conf = JOptionPane.showOptionDialog(null, "Deseja realmente excluir esse registro?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (conf == JOptionPane.YES_OPTION) {
                    EnderecoController enderecoController = new EnderecoController();
                    ClienteController clienteController = new ClienteController();

                    clienteController.delete(atualCliente);
                    enderecoController.delete(atualEndereco);


                    limpaTela();

                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
                }
            }
        });


    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelCadastro = new JPanel();
        panelCadastro.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(18, 3, new Insets(20, 10, 20, 10), -1, -1));
        panelCadastro.setBackground(new Color(-1));
        panelCadastro.setForeground(new Color(-10994318));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-10994318));
        Font label1Font = this.$$$getFont$$$("Montserrat", Font.BOLD, 12, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Cliente");
        panelCadastro.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-10994318));
        Font label2Font = this.$$$getFont$$$("Montserrat", Font.BOLD, 12, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Endereço");
        panelCadastro.add(label2, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-10994318));
        Font label3Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Nome:");
        panelCadastro.add(label3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setBackground(new Color(-10994318));
        Font label4Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("RG:");
        panelCadastro.add(label4, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setBackground(new Color(-10994318));
        Font label5Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("CPF:");
        panelCadastro.add(label5, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setBackground(new Color(-10994318));
        Font label6Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setText("Data de Nascimento:");
        panelCadastro.add(label6, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setBackground(new Color(-10994318));
        Font label7Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setText("Orgão Expeditor:");
        panelCadastro.add(label7, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setBackground(new Color(-10994318));
        Font label8Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setText("Nome Rua:");
        panelCadastro.add(label8, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setBackground(new Color(-10994318));
        Font label9Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label9.getFont());
        if (label9Font != null) label9.setFont(label9Font);
        label9.setText("Número:");
        panelCadastro.add(label9, new com.intellij.uiDesigner.core.GridConstraints(10, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setBackground(new Color(-10994318));
        Font label10Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label10.getFont());
        if (label10Font != null) label10.setFont(label10Font);
        label10.setText("Complemento:");
        panelCadastro.add(label10, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setBackground(new Color(-10994318));
        Font label11Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label11.getFont());
        if (label11Font != null) label11.setFont(label11Font);
        label11.setText("Bairro:");
        panelCadastro.add(label11, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setBackground(new Color(-10994318));
        Font label12Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label12.getFont());
        if (label12Font != null) label12.setFont(label12Font);
        label12.setText("CEP:");
        panelCadastro.add(label12, new com.intellij.uiDesigner.core.GridConstraints(12, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setBackground(new Color(-10994318));
        Font label13Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label13.getFont());
        if (label13Font != null) label13.setFont(label13Font);
        label13.setText("Cidade:");
        panelCadastro.add(label13, new com.intellij.uiDesigner.core.GridConstraints(14, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setBackground(new Color(-10994318));
        Font label14Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label14.getFont());
        if (label14Font != null) label14.setFont(label14Font);
        label14.setText("Estado:");
        panelCadastro.add(label14, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnAtualizar = new JButton();
        btnAtualizar.setBackground(new Color(-1));
        Font btnAtualizarFont = this.$$$getFont$$$("Montserrat", Font.BOLD, 12, btnAtualizar.getFont());
        if (btnAtualizarFont != null) btnAtualizar.setFont(btnAtualizarFont);
        btnAtualizar.setForeground(new Color(-10994318));
        btnAtualizar.setText("Atualizar");
        panelCadastro.add(btnAtualizar, new com.intellij.uiDesigner.core.GridConstraints(17, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnExcluir = new JButton();
        btnExcluir.setBackground(new Color(-1));
        Font btnExcluirFont = this.$$$getFont$$$("Montserrat", Font.BOLD, 12, btnExcluir.getFont());
        if (btnExcluirFont != null) btnExcluir.setFont(btnExcluirFont);
        btnExcluir.setForeground(new Color(-10994318));
        btnExcluir.setText("Excluir");
        panelCadastro.add(btnExcluir, new com.intellij.uiDesigner.core.GridConstraints(17, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnAdicionar = new JButton();
        btnAdicionar.setBackground(new Color(-1));
        Font btnAdicionarFont = this.$$$getFont$$$("Montserrat", Font.BOLD, 12, btnAdicionar.getFont());
        if (btnAdicionarFont != null) btnAdicionar.setFont(btnAdicionarFont);
        btnAdicionar.setForeground(new Color(-10994318));
        btnAdicionar.setText("Adicionar");
        panelCadastro.add(btnAdicionar, new com.intellij.uiDesigner.core.GridConstraints(17, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setBackground(new Color(-10994318));
        Font label15Font = this.$$$getFont$$$("Montserrat", Font.PLAIN, 10, label15.getFont());
        if (label15Font != null) label15.setFont(label15Font);
        label15.setText("Tipo:");
        panelCadastro.add(label15, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textNome = new JTextField();
        panelCadastro.add(textNome, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textRg = new JTextField();
        panelCadastro.add(textRg, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textOrgaoExpeditor = new JTextField();
        panelCadastro.add(textOrgaoExpeditor, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textNomeRua = new JTextField();
        textNomeRua.setText("");
        panelCadastro.add(textNomeRua, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textTipoRua = new JTextField();
        textTipoRua.setText("");
        panelCadastro.add(textTipoRua, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textNumeroRua = new JTextField();
        textNumeroRua.setText("");
        panelCadastro.add(textNumeroRua, new com.intellij.uiDesigner.core.GridConstraints(11, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textComplemento = new JTextField();
        textComplemento.setText("");
        panelCadastro.add(textComplemento, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textBairro = new JTextField();
        textBairro.setText("");
        panelCadastro.add(textBairro, new com.intellij.uiDesigner.core.GridConstraints(13, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textCidade = new JTextField();
        textCidade.setText("");
        panelCadastro.add(textCidade, new com.intellij.uiDesigner.core.GridConstraints(15, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textEstado = new JTextField();
        textEstado.setText("");
        panelCadastro.add(textEstado, new com.intellij.uiDesigner.core.GridConstraints(15, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelCadastro.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10), null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelCadastro.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panelCadastro.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(16, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 40), null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panelCadastro.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10), null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panelCadastro.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10), null, null, 0, false));
        textCPF = new JFormattedTextField();
        panelCadastro.add(textCPF, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textData = new JFormattedTextField();
        panelCadastro.add(textData, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textCEP = new JFormattedTextField();
        panelCadastro.add(textCEP, new com.intellij.uiDesigner.core.GridConstraints(13, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelCadastro;
    }
}
