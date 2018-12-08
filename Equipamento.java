package br.com.pim.helplog.model;

public class  Equipamento {
    int id;
    String tipo;
    String modelo;
    String marca;
    int idCliente;

    public Equipamento(int id, String tipo, String modelo, String marca, int idCliente) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.idCliente = idCliente;
    }
    public Equipamento( String tipo, String modelo, String marca, int idCliente) {

        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.idCliente = idCliente;
    }

    public Equipamento(int id) {
        this.id = id;
    }

    public Equipamento() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }



}
