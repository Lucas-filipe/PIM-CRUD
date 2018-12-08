package br.com.pim.helplog.dal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.pim.helplog.model.EnderecoCliente;

public class EnderecoDAO extends EnderecoCliente{
    int id;
    Connection conexao = null;
    ConexaoDAO con = new ConexaoDAO();

    //REVER PARÂMETROS DO MÉTODO SUPER
    public EnderecoDAO(EnderecoCliente endereco) {
        super();

    }


    public EnderecoDAO(){

    }
    public EnderecoDAO(int id){
        this.id=id;
    }

    public EnderecoCliente listarEndereco() {


        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        EnderecoCliente endereco = new EnderecoCliente();

        //Obejeto NIvel que será adiocionado ao array.

        EnderecoCliente end = null;


        //Instrução SQL.
        String sql = "SELECT * FROM Endereco";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {


                //endereço
                int idEndereco = rs.getInt("idEndereco");
                String rua=rs.getString("rua");
                int numero =rs.getInt("numero");
                String cidade = rs.getString("cidade");
                String bairro=rs.getString("bairro");
                String cep =rs.getString("cep");
                int complemento = rs.getInt("complemento");
                int ID_CLIENTE = rs.getInt("ID_CLIENTE");


                end = new EnderecoCliente(idEndereco,rua,numero,cidade,bairro,cep,complemento);



                endereco= end ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return endereco;
    }


    public EnderecoDAO listarEnderecoId(int idclie) {


        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        EnderecoDAO endereco = new EnderecoDAO();

        //Obejeto NIvel que será adiocionado ao array.

        EnderecoDAO end = null;


        //Instrução SQL.
        String sql = "SELECT * FROM Endereco where IDEndereco = "+idclie+";";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {


                //endereço
                int idEndereco = rs.getInt("idEndereco");
                String rua=rs.getString("rua");
                int numero =rs.getInt("numero");
                String cidade = rs.getString("cidade");
                String bairro=rs.getString("bairro");
                String cep =rs.getString("cep");
                int complemento = rs.getInt("complemento");



                // IMPORTANTE end = new EnderecoCliente(idEndereco,rua,numero,cidade,bairro,cep,complemento);



                endereco= end ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return endereco;
    }


    public EnderecoCliente inclui(EnderecoDAO endereco, int idCliente) {

   /*  int idEndereco;
       String rua;
       int numero;
       String cidade;
       String bairro;
       String cep;
       int complemento;*/

        String sql = "insert into ENDERECO values ('"+ endereco.getRua() +"',"+ endereco.getNumero() +","
                + "'são "+endereco.getCidade()+"','"+endereco.getBairro()+"','"+endereco.getCep()+"',"+endereco.getComplemento()+","+idCliente+");";
        /*sql += "INSERT INTO Cliente";
        sql += "(rua,numero,cidade,bairro,cep,complemento,ID_CLIENTE ";
        sql += ") ";
        sql += "VALUES ";*/
        /*sql += "('"+ endereco.getRua() +"',"+ endereco.getNumero() +",'"+endereco.getCidade()+"','"+endereco.getBairro()+"','"+endereco.getCep()+"','";
        sql += endereco.getComplemento()+"',"+idCliente;
        sql += ");";*/

        Statement stat = null;
        ResultSet rs = null;

        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);


        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }


    public EnderecoCliente altera(EnderecoDAO endereco , int id) {
          /*  int idEndereco;
       String rua;
       int numero;
       String cidade;
       String bairro;
       String cep;
       int complemento;*/

        String sql = "UPDATE ENDERECO\n"
                + " SET RUA = '" + endereco.getRua()+ "',NUMERO = " + endereco.getNumero() + ",CIDADE = '" + endereco.getCidade() +
                "',BAIRRO = '" + endereco.getBairro() + "', CEP = '" + endereco.getCep() + "' , COMPLEMENTO = '" + endereco.getComplemento() + "'" +
                "WHERE IDENDERECO = " + id + ";";
        /*sql += "UPDATE ENDERECO SET RUA = 'tadel',NUMERO = 140,CIDADE = 'SÃO',BAIRRO = 'dddd', CEP = '22222' , COMPLEMENTO = '12' WHERE IDENDERECO = 1;";
        sql += "SET Rua = '" + endereco.getRua()  + "', ";
        sql += "Numero = " + endereco.getNumero() + " ";
        sql += "Cidade = '" + endereco.getCidade() + "' ";
        sql += "Bairro = '" + endereco.getBairro() + "' ";
        sql += "Cep = '" + endereco.getCep() + "' ";
        sql += "Complemento = " + endereco.getComplemento() + " ";
        sql += "WHERE IdEndereco = " + endereco.getIdEndereco() + "";*/

        Statement stat = null;

        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    public void remove(EnderecoDAO endereco) {

        String sql = "";
        sql += "DELETE FROM Endereco ";
        sql += "WHERE IDEndereco = " + this.id + "";

        Statement stat = null;

        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Tipo de nível removido com sucesso! ");

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
