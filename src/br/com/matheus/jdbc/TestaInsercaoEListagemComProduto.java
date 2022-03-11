package br.com.matheus.jdbc;

import br.com.matheus.jdbc.dao.ProdutoDAO;
import br.com.matheus.jdbc.modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProduto(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.forEach(System.out::println);
        }
    }
}
