package br.com.matheus.jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        // Cria conexao com BD
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        System.out.println("----------------------------");
        System.out.println("Executando QUERY");
        System.out.println("----------------------------");
        PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO;");
        stm.execute();

        ResultSet resultSet = stm.getResultSet();

        while (resultSet.next()){
            Integer id = resultSet.getInt("ID");
            System.out.printf("ID: %35d %n", id);
            String nome = resultSet.getString("NOME");
            System.out.printf("NOME: %35s %n", nome);
            String descricao = resultSet.getString("DESCRICAO");
            System.out.printf("DESCRICAO: %35s %n", descricao);
            System.out.println();

            System.out.println("------------");
        }

        // Fecha conexão do Banco de Dados
        stm.close();
        connection.close();
        System.out.println("Conexão com BD fechada");
    }
}
