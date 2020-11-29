package br.com.senac.bean;


import java.sql.Date;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String orgao;
    private Date dataNascimento;
    private Long idEndereco;

    public Cliente() {
    }


    public Cliente(Long id, String nome, String cpf, String rg, String orgao, Date dataNascimento, Long idEndereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.orgao = orgao;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;
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

    public Date getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public Long getIdEndereco() { return idEndereco; }

    public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco; }

    @Override
    public String toString() {
        return "Cliente{}";
    }
}
