package br.com.pim.helplog.dal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.pim.helplog.model.Equipamento;
//import model.usuario.Chamado;
import br.com.pim.helplog.model.Equipamento;

public class EquipamentoDAO extends Equipamento {


    public EquipamentoDAO(Equipamento equipamento) {
        super(equipamento.getId(),equipamento.getTipo(),equipamento.getModelo(),equipamento.getMarca(),equipamento.getIdCliente());
    }

    public EquipamentoDAO(int id) {
        super(id);
    }

    public EquipamentoDAO() {
    }

    Connection conexao = null;
    ConexaoDAO con = new ConexaoDAO();

    //Listar
    public ArrayList<Equipamento> listarEquipamento() {

        ArrayList<Equipamento> equipaLista = new ArrayList<>();

        Equipamento equipa = new Equipamento();

        String sql = "SELECT * FROM Equipamento ;";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {


                //Equipamento
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int idcliente = rs.getInt("idcliente");

                equipa = new Equipamento(id,tipo,modelo,marca,idcliente );

                equipaLista.add(equipa);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return equipaLista;
    }//FIM listar Equipamento


    //Listar por ID
    public Equipamento listarEquipamentoId( int idclie) {

        Equipamento equipa = new Equipamento();

        String sql = "SELECT * FROM Equipamento where Idcliente = "+idclie+";";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {


                //Equipamento
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int idcliente = rs.getInt("idcliente");

                equipa = new Equipamento(id,tipo,modelo,marca,idcliente );

            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return equipa;
    }//FIM listar Equipamento por id

    public Boolean incluir( Equipamento equipamento,int idcliente) {
        /* int id;
           String tipo;
           String modelo;
           String marca;*/

        String sql = "insert into Equipamento values ('"+ equipamento.getTipo()+"',"+ equipamento.getModelo()+ "," + "'"+equipamento.getMarca()+"'"+idcliente+");";

        Statement stat = null;
        ResultSet rs = null;

        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);


        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }//FIM Incluir


    public Boolean alterarEquipamento (Equipamento equipamento,int idcliente) {

        /*  int id;
            String tipo;
            String modelo;
            String marca;*/

        String sql = "UPDATE equipamento\n"
                + "SET tipo = '" + equipamento.getTipo()+ "',modelo = '" + equipamento.getModelo()+ "',marca = '" + equipamento.getMarca()+ "'"
                + "WHERE IDCLIENTE = " + equipamento.getIdCliente() + ";";

        Statement stat = null;


        try {

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }//FIM ALTERAR

    public void remove(Equipamento equipamento) {

        String sql = "DELETE FROM Chamado WHERE IDCLIENTE = " + equipamento.getIdCliente()+ ";";

        Statement stat = null;

        try {

            stat = con.conexao.createStatement();


            stat.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso! ");

        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//FIM REMOVER

}//FIM EquipamentoDao

