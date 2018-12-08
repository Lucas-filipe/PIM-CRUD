package br.com.pim.helplog.controllers;

import br.com.pim.helplog.dal.ChamadoDAO;
import br.com.pim.helplog.model.Chamado;
import br.com.pim.helplog.dal.ClienteDAO;
import java.util.ArrayList;
import br.com.pim.helplog.model.Cliente;

public class CadastroChamado {
    public ArrayList<Chamado> acoes(String acao, Chamado chamado) {
        ChamadoDAO chamadoDAO = new ChamadoDAO(chamado);

        switch (acao) {

            case "listarTodos":
                return chamadoDAO.listarChamado();

            case "incluir":
                chamadoDAO.inclui(chamado);
                break;

            case "alterar":
                chamadoDAO.alterar(chamado);
                break;

            case "remover":
                chamadoDAO.remove(chamado);
                break;
        }
        return null;
    }


}
