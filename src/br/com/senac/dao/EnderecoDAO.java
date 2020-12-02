package br.com.senac.dao;

import br.com.senac.bean.Cliente;
import br.com.senac.bean.Endereco;
import br.com.senac.utils.Conection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO implements DAO {

    @Override
    public void insert(Object o) {
        Endereco en = (Endereco) o;
        String sql = "insert into endereco (nome,logradouro,numero,complemento,bairro,cep,cidade,estado) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setString(1, en.getNome());
            ps.setString(2, en.getLogradouro());
            ps.setString(3, en.getNumero());
            ps.setString(4, en.getComplemento());
            ps.setString(5, en.getBairro());
            ps.setString(6, en.getCep());
            ps.setString(7, en.getCidade());
            ps.setString(8, en.getEstado());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        Endereco en = (Endereco) o;
        String sql = "update endereco set nome=?,logradouro=?,numero=?,complemento=?,bairro=?,cep=?,cidade=?,estado=? where id=?";
        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setString(1, en.getNome());
            ps.setString(2, en.getLogradouro());
            ps.setString(3, en.getNumero());
            ps.setString(4, en.getComplemento());
            ps.setString(5, en.getBairro());
            ps.setString(6, en.getCep());
            ps.setString(7, en.getCidade());
            ps.setString(8, en.getEstado());
            ps.setLong(9, en.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {
        Endereco en = (Endereco) o;
        String sql = "delete from endereco where id=?";

        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setLong(1, en.getId());
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public Object select(int i) {
        Endereco en = new Endereco();
        String sql = "select * from endereco where id=?";
        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                en.setId(rs.getLong("id"));
                en.setNome(rs.getString("nome"));
                en.setLogradouro(rs.getString("logradouro"));
                en.setNumero(rs.getString("numero"));
                en.setComplemento(rs.getString("complemento"));
                en.setBairro(rs.getString("bairro"));
                en.setCep(rs.getString("cep"));
                en.setCidade(rs.getString("cidade"));
                en.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return en;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        String sql = "select * from endereco";
        PreparedStatement ps;
        try {
            ps = Conection.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Endereco en = new Endereco();
                en.setId(rs.getLong("id"));
                en.setNome(rs.getString("nome"));
                en.setLogradouro(rs.getString("logradouro"));
                en.setNumero(rs.getString("numero"));
                en.setComplemento(rs.getString("complemento"));
                en.setBairro(rs.getString("bairro"));
                en.setCep(rs.getString("cep"));
                en.setCidade(rs.getString("cidade"));
                en.setEstado(rs.getString("estado"));
                list.add(en);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return list;
    }
}
