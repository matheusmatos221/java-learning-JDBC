package br.com.matheus.jdbc.dao;

import br.com.matheus.jdbc.modelo.Categoria;

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

}
