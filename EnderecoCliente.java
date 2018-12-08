package br.com.pim.helplog.model;

public class EnderecoCliente {

    private int idEndereco;
    private String rua;
    private int numero;
    private String cidade;
    private String bairro;
    private String cep;
    private int complemento;


    public EnderecoCliente() {
    }


    //CONSTRUTORES
    public EnderecoCliente(int idEndereco,String rua, int numero, String cidade, String bairro, String cep, int complemento) {
        this.idEndereco=idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;

    }
    public EnderecoCliente(String rua, int numero, String cidade, String bairro, String cep, int complemento) {

        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }


    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }
}
