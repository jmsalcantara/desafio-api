package com.desafio.desafioapi.models;

public class FuncionarioRequest {
    private Long idFuncionario;
    private String nmFuncionario;
    private String dsDescricao;
    private String dsDepartamento;
    private String dsFuncao;

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsDepartamento() {
        return dsDepartamento;
    }

    public void setDsDepartamento(String dsDepartamento) {
        this.dsDepartamento = dsDepartamento;
    }

    public String getDsFuncao() {
        return dsFuncao;
    }

    public void setDsFuncao(String dsFuncao) {
        this.dsFuncao = dsFuncao;
    }
}
