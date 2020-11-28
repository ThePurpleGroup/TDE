package br.com.senac.model.bean;

import java.util.Date;

public class Cliente {

    private Long id;
    private String nome;
    private String rg;
    private String orgao;
    private Date dateNascimento;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String rg, String orgao, Date dateNascimento) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.orgao = orgao;
        this.dateNascimento = dateNascimento;
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

    public Date getDateNascimento() {
        return dateNascimento;
    }

    public void setDateNascimento(Date dateNascimento) {
        this.dateNascimento = dateNascimento;
    }
}
