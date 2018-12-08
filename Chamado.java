package br.com.pim.helplog.model;

public class Chamado {
    public int idchamado;
    public int idcliente;
    public int idFuncionario;
    public String data;
    public String prazo;
    public String status;
    public String tipo;
    public String conponente;
    public String descricao;
    public Equipamento equipamento;


    public Chamado() {
    }

    public Chamado(int idchamado) {
        this.idchamado = idchamado;
    }

    public Chamado(int idchamado, int idcliente, int idFuncionario, String status, String tipo, String conponente, String descricao, Equipamento equipamento , String data,
                   String prazo) {
        this.idchamado = idchamado;
        this.idcliente = idcliente;
        this.idFuncionario = idFuncionario;
        this.status = status;
        this.tipo = tipo;
        this.conponente = conponente;
        this.descricao = descricao;
        this.equipamento = equipamento;
        this.data= data;
        this.prazo= prazo;
    }
    public Chamado( int idcliente, int idFuncionario, String status, String tipo, String conponente, String descricao, Equipamento equipamento , String data,
                    String prazo) {

        this.idcliente = idcliente;
        this.idFuncionario = idFuncionario;
        this.status = status;
        this.tipo = tipo;
        this.conponente = conponente;
        this.descricao = descricao;
        this.equipamento = equipamento;
        this.data= data;
        this.prazo= prazo;
    }

    public int getIdchamado() {
        return idchamado;
    }

    public void setIdchamado(int idchamado) {
        this.idchamado = idchamado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConponente() {
        return conponente;
    }

    public void setConponente(String conponente) {
        this.conponente = conponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
