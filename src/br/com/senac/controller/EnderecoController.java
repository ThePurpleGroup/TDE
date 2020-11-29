package br.com.senac.controller;

import br.com.senac.bean.Endereco;
import br.com.senac.dao.EnderecoDAO;

import java.util.List;

public class EnderecoController {

    public void insert(Endereco en) {
        EnderecoDAO dao = new EnderecoDAO();
        dao.insert(en);
    }

    public void update(Endereco en) {
        EnderecoDAO dao = new EnderecoDAO();
        dao.update(en);
    }

    public void delete(Endereco en) {
        EnderecoDAO dao = new EnderecoDAO();
        dao.delete(en);
    }

    public Endereco select(int i) {
        EnderecoDAO dao = new EnderecoDAO();
        Endereco en = (Endereco) dao.select();
        return en;
    }

    public List select() {
        EnderecoDAO dao = new EnderecoDAO();
        List en = dao.select();
        return en;
    }
}
