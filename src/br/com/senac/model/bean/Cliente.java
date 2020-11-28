package br.com.senac.model.bean;

import java.sql.Date;
import java.text.DateFormat;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String orgao;
    private String dateNascimento;
    private Long id_endereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String rg, String orgao, String dateNascimento, Long id_endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.orgao = orgao;
        this.dateNascimento = dateNascimento;
        this.id_endereco = id_endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getDateNascimento() {
        return dateNascimento;
    }

    public void setDateNascimento(String dateNascimento) {
        this.dateNascimento = dateNascimento;
    }

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
