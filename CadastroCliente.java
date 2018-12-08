package br.com.pim.helplog.controllers;

import  br.com.pim.helplog.dal.ClienteDAO;
import java.util.ArrayList;

import br.com.pim.helplog.dal.ClienteDAO;
import br.com.pim.helplog.model.Cliente;

public class CadastroCliente {

    public ArrayList<Cliente> acoes(String acao, Cliente cliente) {
        ClienteDAO cliDAO = new ClienteDAO(cliente);

        switch (acao) {

            case "listarTodos":
                return cliDAO.listar();

            case "incluir":
                cliDAO.inclui(cliente);
                break;

            case "alterar":
                cliDAO.altera(cliente);
                break;

            case "remover":
                cliDAO.remove(cliente);
                break;
        }
        return null;
    }

}
