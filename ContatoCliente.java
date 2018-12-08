package br.com.pim.helplog.model;

public class ContatoCliente {

    private int idTelefone;
    private int dd;
    private int numero;
    private String operadora;


    public ContatoCliente() {
    }



    public ContatoCliente(int idTelefone,int dd, int numero, String operadora) {
        this.idTelefone=idTelefone;
        this.dd = dd;
        this.numero = numero;
        this.operadora = operadora;

    }
    public ContatoCliente(int dd, int numero, String operadora) {

        this.dd = dd;
        this.numero = numero;
        this.operadora = operadora;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
}
