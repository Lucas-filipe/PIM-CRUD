package br.com.pim.helplog.model;

public class Cliente {
    public int idCliente;
    public String cpf;
    public String nome;
    public String email;
    public EnderecoCliente endereco;
    public ContatoCliente telefone;




    public Cliente() {
    }



    public Cliente(int idCliente, String nome, String email, String cpf, EnderecoCliente endereco, ContatoCliente telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    public Cliente( String nome, String email, String cpf, EnderecoCliente endereco, ContatoCliente telefone) {

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(int id) {
        this.idCliente = id;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoCliente getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCliente endereco) {
        this.endereco = endereco;
    }

    public ContatoCliente getTelefone() {
        return telefone;
    }

    public void setTelefone(ContatoCliente telefone) {
        this.telefone = telefone;
    }


    public String getRuaEndereco() {
        return endereco.getRua();
    }
    public int getNumeroEndereco() {
        return endereco.getNumero();
    }
    public String getCidadeEndereco() {
        return endereco.getCidade();
    }
    public String getBairroEndereco() {
        return endereco.getBairro();
    }
    public String getCepEndereco() {
        return endereco.getCep();
    }
    public int getComplementoEndereco() {
        return endereco.getComplemento();
    }

    public int getNumeTele() {
       return telefone.getNumero();
    }
    public int getDdTele() {
        return telefone.getDd();
    }
    public String getOperadoraTele() {
        return telefone.getOperadora();
    }

/*

    public static void main(String[] args) {
        Gson gson = new Gson();
        Cliente lucas = new Cliente();

        lucas.setLogin("root");
        lucas.setSenha("root");
        lucas.validaDados();
        System.out.println(gson.toJson(lucas));

    }

    private void validaDados() {
        if (getLogin().trim().equals("") || getSenha().trim().equals("")) {
            System.out.println("Prencha todos os campos");
           System.exit(0);
        } else if (!getLogin().trim().equals("root") || !getSenha().trim().equals("root")) {
            System.out.println("Nome ou senha inválidos");
            System.exit(0);
        }
    }*/
}