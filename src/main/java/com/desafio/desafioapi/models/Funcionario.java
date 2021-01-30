package com.desafio.desafioapi.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
    @ApiModelProperty(value = "Código do funcionário")
    @Id
    @GeneratedValue(generator = "sq_funcionario", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq_funcionario", sequenceName = "sq_funcionario", allocationSize = 1)
    @Column(name = "id_funcionario", updatable = false, nullable = false)
    private long idFuncionario;

    @ApiModelProperty(value = "Nome do funcionário")
    @Column(name = "nm_funcionario")
    private String nmFuncionario;

    @ApiModelProperty(value = "Descrição do funcionário")
    @Column(name = "ds_descricao")
    private String dsDescricao;

    @ApiModelProperty(value = "CPF")
    @Column(name = "nr_cpf", unique = true)
    private String nrCpf;

    @ApiModelProperty(value = "Descrição do endereço")
    @Column(name = "ds_endereco")
    private String dsEndereco;

    @ApiModelProperty(value = "CEP")
    @Column(name = "nr_cep")
    private String nrCep;

    @ApiModelProperty(value = "Cidade")
    @Column(name = "ds_cidade")
    private String dsCidade;

    @ApiModelProperty(value = "Bairro")
    @Column(name = "ds_bairro")
    private String dsBairro;

    @ApiModelProperty(value = "Complemento")
    @Column(name = "ds_complemento")
    private String dsComplemento;

    @ApiModelProperty(value = "Número Casa/Apartamento")
    @Column(name = "nr_numero")
    private String nrNumero;

    @ApiModelProperty(value = "Celular (Contato)")
    @Column(name = "nr_celular")
    private String nrCelular;

    @ApiModelProperty(value = "Função")
    @Column(name = "ds_funcao")
    private String dsFuncao;

    @ApiModelProperty(value = "Departamento")
    @Column(name = "ds_departamento")
    private String dsDepartamento;

    @ApiModelProperty(value = "Departamento")
    @Column(name = "in_ativo", nullable = false, length = 1, columnDefinition = "varchar(1) default 'S'")
    private String inAtivo;

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

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getDsCidade() {
        return dsCidade;
    }

    public void setDsCidade(String dsCidade) {
        this.dsCidade = dsCidade;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public String getNrNumero() {
        return nrNumero;
    }

    public void setNrNumero(String nrNumero) {
        this.nrNumero = nrNumero;
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    public String getDsFuncao() {
        return dsFuncao;
    }

    public void setDsFuncao(String dsFuncao) {
        this.dsFuncao = dsFuncao;
    }

    public String getDsDepartamento() {
        return dsDepartamento;
    }

    public void setDsDepartamento(String dsDepartamento) {
        this.dsDepartamento = dsDepartamento;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }
}
