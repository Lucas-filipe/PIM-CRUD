package br.com.pim.helplog.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    Connection conexao = null;
    private final String servidor = "localhost";
    private final String porta = "3306";
    private final String SGBD = "mysql";
    private final String dataBase = "PIM";
    private final String tipoConexao = "jdbc";
    private final String usuarioDB = "root";
    private final String senhaDB = "root";

    //Modelo de url = "jdbc:mysql://localhost:3306/PIM";
    public ConexaoDAO() {
        this.conecta();
    }

    /**
     * <b>conecta</b>
     * Método responsável por realizar a conexão no BD.
     */
    private void conecta() {
        try {
            this.conexao = DriverManager.getConnection(
                    this.tipoConexao + ":" + this.SGBD + "://" + this.servidor + ":" + this.porta + "/" + this.dataBase,
                    this.usuarioDB,
                    this.senhaDB
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public Connection getConexao() {
        return conexao;
    }

}
