package br.com.senac.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String orgao;
    private LocalDate dataNascimento;
    private Long idEndereco;

    public Cliente() {
    }


    public Cliente(Long id, String nome, String cpf, String rg, String orgao, LocalDate dataNascimento, Long idEndereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.orgao = orgao;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;
    }
    public Cliente(Long id, String nome, String cpf, String rg, String orgao, String dataNascimento, Long idEndereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.orgao = orgao;
        this.setDataNascimento(dataNascimento);
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

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")); }

    public Long getIdEndereco() { return idEndereco; }

    public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco; }

    @Override
    public String toString() {
        return "Cliente{}";
    }
}
