package br.com.senac.dao;

import br.com.senac.bean.Cliente;
import br.com.senac.utils.Conection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO {

    @Override
    public void insert(Object o) {
        Cliente c = (Cliente) o;
        String sql = "insert into cliente (nome,cpf,rg,orgao,data_nascimento,id_endereco) values (?,?,?,?,?,?)";
        String sqlEnd = "select max(id) from endereco";

        try {
            PreparedStatement end = Conection.getConexao().prepareStatement(sqlEnd);
            ResultSet endRs = end.executeQuery();
            endRs.next();
            c.setIdEndereco(endRs.getLong("max"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getRg());
            ps.setString(4, c.getOrgao());
            ps.setDate(5, Date.valueOf(c.getDataNascimento()));
            ps.setLong(6, c.getIdEndereco());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        Cliente c = (Cliente) o;
        String sql = "update cliente set nome=?,cpf=?,rg=?,orgao=?,data_nascimento=? where id=?";
        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getRg());
            ps.setString(4, c.getOrgao());
            ps.setDate(5, Date.valueOf(c.getDataNascimento()));
            ps.setLong(6, c.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {
        Cliente c = (Cliente) o;
        String sql = "delete from cliente where id=?";

        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setLong(1, c.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object select(int i) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where id=?";
        try {
            PreparedStatement ps = Conection.getConexao().prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setOrgao(rs.getString("orgao"));
                c.setDataNascimento(rs.getDate("data_nascimento"));
                c.setIdEndereco(rs.getLong("id_endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        String sql = "select * from cliente";
        PreparedStatement ps;
        try {
            ps = Conection.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setOrgao(rs.getString("orgao"));
                c.setDataNascimento(rs.getDate("data_nascimento"));
                c.setIdEndereco(rs.getLong("id_endereco"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
