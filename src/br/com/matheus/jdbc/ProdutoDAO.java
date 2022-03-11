package br.com.matheus.jdbc;

import java.sql.*;

import br.com.matheus.jdbc.modelo.Produto;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?);";

        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());

            pstm.execute();

            try(ResultSet rst = pstm.getGeneratedKeys()){
                while (rst.next()){
                    produto.setId(rst.getInt(1));
                }
            }

        }
    }
}
