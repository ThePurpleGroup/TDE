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

    public void preencheCadastro(Cliente clienteSelecionado, Endereco  enderecoSelecionado){
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

    public void mascaraCampos(){
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
        this.setLocation(436,135);
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

                    JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso!");
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

                    JOptionPane.showMessageDialog(null,"Cliente Atualizado com Sucesso!");
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
                if(conf == JOptionPane.YES_OPTION){
                    EnderecoController enderecoController = new EnderecoController();
                    ClienteController clienteController = new ClienteController();

                    clienteController.delete(atualCliente);
                    enderecoController.delete(atualEndereco);


                    limpaTela();

                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
                }
            }
        });


    }
}
