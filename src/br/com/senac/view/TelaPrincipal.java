package br.com.senac.view;

import br.com.senac.bean.Cliente;
import br.com.senac.bean.Endereco;
import br.com.senac.dao.ClienteDAO;
import br.com.senac.dao.EnderecoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.time.format.DateTimeFormatter;

public class TelaPrincipal extends JFrame {

    private JButton btnNovo;
    private JPanel panelPrincipal;
    private JTable tableCliente;
    private JScrollPane jScrollPanel;
    private JButton buttonSelect;

    public void preencherTabela() {

        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Id", "Nome", "Data de Nascimento"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ClienteDAO clienteDAO = new ClienteDAO();
        for (Object o : clienteDAO.select()) {

            Cliente cliente = (Cliente) o;
            model.addRow(new Object[]{
                    Math.toIntExact(cliente.getId()),
                    cliente.getNome(),
                    cliente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),

            });
        }
        tableCliente.setModel(model);
        jScrollPanel.setViewportView(tableCliente);

    }

    public TelaPrincipal() {

        super("purple Desktop");
        this.setContentPane(this.panelPrincipal);
        this.setLocation(341,45);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        preencherTabela();

        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.setVisible(true);
            }
        });

        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();
                ClienteDAO clienteDAO = new ClienteDAO();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                int i = Integer.parseInt(tableCliente.getValueAt(tableCliente.getSelectedRow(), 0).toString());
                Cliente cliente = (Cliente) clienteDAO.select(i);
                ;
                Endereco endereco = (Endereco) enderecoDAO.select(Math.toIntExact(cliente.getIdEndereco()));
                telaCadastro.preencheCadastro(cliente, endereco);
                telaCadastro.setVisible(true);
            }
        });

        tableCliente.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                ClienteDAO cdao = new ClienteDAO();

                super.componentAdded(e);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                super.componentRemoved(e);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
