package br.com.matheus.jdbc;

import br.com.matheus.jdbc.dao.CategoriaDAO;
import br.com.matheus.jdbc.dao.ProdutoDAO;
import br.com.matheus.jdbc.modelo.Categoria;
import br.com.matheus.jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().recuperarConexao()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listar();
            listaDeCategorias.forEach(ct -> {
                System.out.println(ct.getNome());

                try {
                    for(Produto produto: new ProdutoDAO(connection).buscar(ct)){
                        System.out.println(ct.getNome() + " - " + produto.getNome());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });


        }
    }
}
