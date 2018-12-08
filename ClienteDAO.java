package br.com.pim.helplog.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.pim.helplog.model.Cliente;
import br.com.pim.helplog.model.EnderecoCliente;
import br.com.pim.helplog.model.ContatoCliente;


public class ClienteDAO {

    Connection conexao = null;


    //VERIFICAR PARÂMETROS DO SUPER
    public ClienteDAO(Cliente cliente) {
        super();

    }

    ConexaoDAO con = new ConexaoDAO();

    public ClienteDAO() {

    }

    public ArrayList<Cliente> listar() {

        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        ArrayList<Cliente> clienteLista = new ArrayList<>();

        //Obejeto NIvel que será adiocionado ao array.
        EnderecoDAO endDao = new EnderecoDAO();
        TelefoneDAO teleDao = new TelefoneDAO();
        Cliente cli = null;
        EnderecoCliente end = null;
        ContatoCliente tele = null;

        //Instrução SQL.
        String sql = "SELECT * FROM Cliente";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {

                //Cliente
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");

                // IMPORTANTE   end = endDao.listarEnderecoId(id);
                tele = teleDao.listarTelefoneId(id);

                cli = new Cliente(id, nome, email, cpf, end, tele);

                clienteLista.add(cli);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return clienteLista;
    }

    public Cliente listarCli(int idclie) {

        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        Cliente clienteLista = new Cliente();

        //Obejeto NIvel que será adiocionado ao array.
        EnderecoDAO endDao = new EnderecoDAO();
        TelefoneDAO teleDao = new TelefoneDAO();
        Cliente cli = null;
        EnderecoCliente end = null;
        ContatoCliente tele = null;

        //Instrução SQL.
        String sql = "SELECT * FROM Cliente where IDCLIENTE = " + idclie + ";";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {

                //Cliente
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");

                //IMPORTANTE end = endDao.listarEnderecoId(idclie);
                tele = teleDao.listarTelefoneId(idclie);

                cli = new Cliente(id, nome, email, cpf, end, tele);

                clienteLista = (cli);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return clienteLista;
    }

    private Boolean verificaCpf(String cpf) {

        //Instrução SQL.
        String sql = "SELECT CPF ";
        sql += "FROM Cliente ";
        sql += "WHERE cpf = '" + cpf + "'";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);
            int linhasRetornadas = 0;

            while (rs.next()) {
                linhasRetornadas++;
            }

            if (linhasRetornadas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return true;
    }

    public Boolean inclui(Cliente cliente) {

        /* int idCliente;
      String nome;
      String email;
      String cpf;
      Endereco endereco;
      Telefone telefone;*/
        EnderecoDAO endDao = new EnderecoDAO(cliente.getEndereco());

        TelefoneDAO teleDao = new TelefoneDAO(cliente.getTelefone());

        String sql = "insert into CLIENTE Values ('" + cliente.getNome() + "','" + cliente.getCpf() + "','" + cliente.getEmail() + "');";
        /*sql += "INSERT INTO Cliente";
        sql += "(nome,cpf,email ";
        sql += "cpf) ";
        sql += "VALUES ";
        sql += "("+cliente.getNome() +","+cliente.getEmail()+",";
        sql += "+cliente.getCpf()+";
        sql += ");";*/

        Statement stat = null;
        // ResultSet rs = null;

        try {
            boolean status = this.verificaCpf(cliente.getCpf());

            if (status) {
                JOptionPane.showMessageDialog(null, "Já existe um Cliente com essa dados");
                return false;
            }

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

            int id = this.getIdCliente();
            endDao.inclui(endDao, id);
            teleDao.inclui(teleDao, id);

            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso! ");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Boolean altera(Cliente cliente) {

        /* int idCliente;
      String nome;
      String email;
      String cpf;
      Endereco endereco;
      Telefone telefone;*/
        EnderecoDAO endDao = new EnderecoDAO(cliente.getEndereco());

        TelefoneDAO teleDao = new TelefoneDAO(cliente.getTelefone());

        String sql = "UPDATE CLIENTE\n"
                + "SET NOME = '" + cliente.getNome() + "',CPF = '" + cliente.getCpf() + "',EMAIL = '" + cliente.getEmail() + "'"
                + "WHERE IDCLIENTE = " + cliente.getIdCliente() + ";";
        /* sql += "UPDATE Cliente ";
        sql += "SET IdEndereco = " + endDao.getIdEndereco() + ", ";
        sql += "IdTelefone = " + teleDao.getIdTelefone() + " ";
        sql += "Nome = '" + cliente.getNome() + "' ";
        sql += "Email =' " + cliente.getEmail() + "' ";
        sql += "Cpf = '" + cliente.getCpf() + "' ";
        sql += "WHERE IdCliente = " + cliente.getIdCliente() + "";*/

        Statement stat = null;

        try {
            /* boolean status = this.verificaCpf(cliente.getCpf());

            if (status) {
                JOptionPane.showMessageDialog(null, "Já existe um Cliente com essa dados!");
                return false;
            }*/

            endDao.altera(endDao, cliente.getIdCliente());
            teleDao.altera(teleDao, cliente.getIdCliente());

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

            if (stat.executeUpdate(sql) > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso! ");
            } else {
                JOptionPane.showMessageDialog(null, "Erro na atualização, altere alguma informação!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public void remove(Cliente cliente) {

        EnderecoDAO endDao = new EnderecoDAO(cliente.getIdCliente());

        TelefoneDAO teleDao = new TelefoneDAO(cliente.getIdCliente());

        String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE = " + cliente.getIdCliente() + ";";
        /*sql += "DELETE FROM Cliente ";
        sql += "WHERE IdCliente = " + cliente.getIdCliente() + "";*/

        Statement stat = null;

        try {

            stat = con.conexao.createStatement();

            endDao.remove(endDao);
            teleDao.remove(teleDao);

            stat.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso! ");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //MÉTODO PARA PEGAR O ULTIMO ID ADICIONADO NO BANCO DE DADOS

    public int getIdCliente() {
        int idCli = 0;
        String sql = "Select Top 1 * from CLIENTE Order by IDCLIENTE Desc ";

        java.sql.Statement stat = null;

        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("idCliente");
                idCli = id;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção!\nErro: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex);
        }
        return idCli;

    }

}
