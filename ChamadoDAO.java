package br.com.pim.helplog.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.pim.helplog.model.Chamado;
import br.com.pim.helplog.model.Cliente;
import br.com.pim.helplog.model.Equipamento;

public class ChamadoDAO {
    Connection conexao = null;
    ConexaoDAO con = new ConexaoDAO();

    //REVER PARÂMENTROS DO METÓDO SUPER
    public ChamadoDAO(Chamado chamado) {
        super();
    }

    public ChamadoDAO() {

    }

    //idchamado
    public ChamadoDAO(int idchamado) {
        super();
    }


    public ArrayList<Chamado> listarChamado() {

        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        ArrayList<Chamado> chamadoLista = new ArrayList<>();

        //Obejetos que serão adiocionado ao array.
        EquipamentoDAO equipDao = new EquipamentoDAO();
        Chamado chama = new Chamado();
        Equipamento equip = new Equipamento();


        //Instrução SQL.
        String sql = "SELECT * FROM Chamado";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                int idchamado = rs.getInt("idchamado");
                int idcliente = rs.getInt("idcliente");
                int idFuncionario= rs.getInt("idFuncionario");
                String status = rs.getString("status");
                String tipo= rs.getString("tipo");
                String conponente= rs.getString("conponente");
                String descricao= rs.getString("descricao");
                String data = rs.getString("data");
                String prazo = rs.getString("prazo");


                equip = equipDao.listarEquipamentoId(idcliente);


                chama = new Chamado (idchamado,idcliente,idFuncionario,
                        status,tipo,conponente,descricao,equip,data,prazo);

                chamadoLista.add(chama);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }



        return chamadoLista;
    }//FIM ListarChamado


    public Chamado listarChamadoId(int idchama) {

        //Inicializa o array para armazenar as tuplas que retornarão do BD.
        Chamado chamadoLista = new Chamado();

        //Obejetos que serão adiocionado ao array.
        EquipamentoDAO equipDao = new EquipamentoDAO();
        Chamado chama = new Chamado();
        Equipamento equip = new Equipamento();


        //Instrução SQL.
        String sql = "SELECT * FROM Chamado WHERE IdChamado = "+idchama+"";

        //Obejeto para executar instruções SQL.
        Statement stat = null;

        //Retorno da instrução SQL executada pelo Statement.
        ResultSet rs = null;

        try {
            stat = con.conexao.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                int idchamado = rs.getInt("idchamado");
                int idcliente = rs.getInt("idcliente");
                int idFuncionario= rs.getInt("idFuncionario");
                String status = rs.getString("status");
                String tipo= rs.getString("tipo");
                String conponente= rs.getString("conponente");
                String descricao= rs.getString("descricao");
                String data = rs.getString("data");
                String prazo = rs.getString("prazo");


                equip = equipDao.listarEquipamentoId(idcliente);


                chama = new Chamado (idchamado,idcliente,idFuncionario,
                        status,tipo,conponente,descricao,equip,data,prazo);
                chamadoLista=chama;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }



        return chamadoLista;
    }//FIM LstarChamado por ID


    public Boolean inclui(Chamado chamado) {

    /* int idchamado;
    int idcliente;
    int idFuncionario;
    String status;
    String tipo;
    String conponente;
    String descricao;
    Equipamento equipamento;*/

        EquipamentoDAO equiDao = new EquipamentoDAO();
        EquipamentoDAO equiDaoid = new EquipamentoDAO();
        String sql;
        /*String sql = "INSERT INTO Chamado VALUES ('"+ chamado.getIdcliente()+ "','" + chamado.getIdFuncionario()+ "','" + chamado.getStatus()+
             "','" +chamado.getTipo() + "','" + chamado.getConponente() + "','" + chamado.getDescricao() + "','"+ chamado.getIdEquipamento() +"');";*/

        Statement stat = null;
        try{

            equiDao.incluir(chamado.getEquipamento() ,chamado.getIdcliente());
            equiDaoid.listarEquipamentoId(chamado.getIdcliente());

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql = "INSERT INTO Chamado VALUES ('"+ chamado.getIdcliente()+ "','" + chamado.getIdFuncionario()+ "','" + chamado.getStatus()+
                    "','" +chamado.getTipo() + "','" + chamado.getConponente() + "','" + chamado.getDescricao() + "','" +equiDaoid.getId() + "','" +
                    chamado.getData()+"','" + chamado.getPrazo() +"');"
            );


            JOptionPane.showMessageDialog(null, "Chamado adicionado com sucesso! ");

        }catch (SQLException ex){
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true ;
    }//FIM Incluir


    public Boolean alterar (Chamado chamado) {

     /* int idchamado;
        int idcliente;
        int idFuncionario;
        String status;
        String tipo;
        String conponente;
        String descricao;
        Equipamento equipamento;*/
        EquipamentoDAO equipDao = new EquipamentoDAO();

        String sql = "UPDATE Chamado\n"
                + "SET status = '" + chamado.getStatus() + "',tipo = '" + chamado.getTipo() + "',conponente = '" + chamado.getConponente() + "'"
                + "',descricao = '" + chamado.getDescricao() + "'"+ "',equipamento = '" + chamado.getEquipamento() + "'"+ chamado.getData() + "'"+ chamado.getPrazo()+ "'"
                + "WHERE idchamado = " + chamado.getIdchamado() + ";";

        Statement stat = null;

        try {

            equipDao.alterarEquipamento(chamado.getEquipamento(),chamado.getIdcliente());

            stat = con.conexao.createStatement();
            stat.executeUpdate(sql);

            if (stat.executeUpdate(sql) > 0) {
                JOptionPane.showMessageDialog(null, "Chamado alterado com sucesso! ");
            } else {
                JOptionPane.showMessageDialog(null, "Erro na atualização, altere alguma informação!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }




        return true;
    }//FIM ALTERA
    public void remove(Chamado chamado) {

        EquipamentoDAO equipDao = new EquipamentoDAO(chamado.getIdcliente());

        String sql = "DELETE FROM Chamado WHERE IDCLIENTE = " + chamado.getIdcliente()+ ";";

        Statement stat = null;

        try {

            stat = con.conexao.createStatement();

            equipDao.remove(equipDao);
            stat.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso! ");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//FIM REMOVER

}
