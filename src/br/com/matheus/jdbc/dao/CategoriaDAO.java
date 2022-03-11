package br.com.matheus.jdbc.dao;

import br.com.matheus.jdbc.modelo.Categoria;
import br.com.matheus.jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection){
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<Categoria>();

        System.out.println("Executando a Query de listar categoria");
        String sql = "SELECT ID, NOME FROM CATEGORIA;";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Categoria categoria =
                            new Categoria(rst.getInt(1), rst.getString(2));
                    categorias.add(categoria);
                }

            }
        }
        return categorias;
    }

    public List<Categoria> listarComProdutos() throws SQLException{
        Categoria ultimaCategoria = null;
        List<Categoria> categorias = new ArrayList<Categoria>();

        System.out.println("Executando a Query de listar categoria\n");
        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN" +
                " PRODUTO P ON C.ID = P.CATEGORIA_ID;";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    if(ultimaCategoria == null || !ultimaCategoria.getNome().equals(rst.getString(2))) {
                        Categoria categoria =
                                new Categoria(rst.getInt(1), rst.getString(2));

                        ultimaCategoria = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto =
                            new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultimaCategoria.adicionar(produto);
                }

            }
        }
        return categorias;
    }

}
