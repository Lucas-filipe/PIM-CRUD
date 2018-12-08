package br.com.pim.helplog.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.pim.helplog.model.ContatoCliente;

public class TelefoneDAO extends ContatoCliente{

    ConexaoDAO con = new ConexaoDAO();
    Connection conexao = null;
    int id;


    //VERIFICAR PARÂMETRO SUPER**********
    public TelefoneDAO(ContatoCliente telefone) {
        super();
    }
    public TelefoneDAO(){
    }

    public TelefoneDAO(int id){
        this.id=id;
    }



    public ContatoCliente listarTelefone() {


        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        ContatoCliente telefone = new ContatoCliente();

        //Obejeto NIvel que será adiocionado ao array.

        ContatoCliente tel = null;


        //Instrução SQL.
        String sql = "SELECT * FROM Telefone";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {




                int idTelefone= rs.getInt("idTelefone");
                int dd= rs.getInt("dd");
                int numero= rs.getInt("numero");
                String operadora= rs.getString("operadora");




                tel = new ContatoCliente(idTelefone,dd,numero,operadora);



                telefone= tel ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return telefone;
    }

    public ContatoCliente listarTelefoneId(int idclie) {


        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        ContatoCliente telefone = new ContatoCliente();

        //Obejeto NIvel que será adiocionado ao array.

        ContatoCliente tel = null;


        //Instrução SQL.
        String sql = "SELECT * FROM Telefone where IDTelefone = "+idclie+";";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {




                int idTelefone= rs.getInt("idTelefone");
                int dd= rs.getInt("dd");
                int numero= rs.getInt("numero");
                String operadora= rs.getString("operadora");




                tel = new ContatoCliente(idTelefone,dd,numero,operadora);



                telefone= tel ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return telefone;
    }


    public ContatoCliente inclui(TelefoneDAO telefone, int idCliente ) {

   /*   int idTelefone;
        int dd;
        int numero;
        String operadora;*/

        String sql = "insert into TELEFONE values ("+ telefone.getDd() +",'"+ telefone.getNumero()
                +"','"+telefone.getOperadora()+"',"+idCliente+");";
        /*sql += "INSERT INTO Cliente";
        sql += "(dd,numero,operadora,ID_CLIENTE)";
        sql += "VALUES ";
        sql += "("+ telefone.getDd() +","+ telefone.getNumero() +",'";
        sql += "telefone.getOperadora()+"',"+idCliente+";
        sql += "');";*/

        Statement stat = null;
        ResultSet rs = null;

        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);


        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }


    public ContatoCliente altera(TelefoneDAO telefone, int id) {
         /* int idTelefone;
            int dd;
            int numero;
            String operadora;*/

        String sql = "UPDATE TELEFONE \n"
                + " SET DD = " + telefone.getDd()  + ",NUMERO = " + telefone.getNumero() + ",OPERADORA = '" + telefone.getOperadora() + "'" +
                "WHERE IDTELEFONE= " + id + ";";
        /*sql += "UPDATE Telefone ";
        sql += "SET Dd = '" + telefone.getDd()  + "', ";
        sql += "Numero = " + telefone.getNumero() + " ";
        sql += "Operadora = '" + telefone.getOperadora() + "' ";
        sql += "WHERE getIdTelefone = " + telefone.getIdTelefone() + "";*/

        Statement stat = null;

        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void remove(TelefoneDAO telefone) {

        String sql = "";
        sql += "DELETE FROM Telefone ";
        sql += "WHERE IDTelefone = " + this.id + "";

        Statement stat = null;

        try {


            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Tipo de nível removido com sucesso! ");

        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
