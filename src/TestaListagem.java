import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        // Conecta no Banco de Dados
        System.out.println("----------------------------");
        System.out.println("Tentando conectar com BD");
        System.out.println("----------------------------");
        Connection connection = DriverManager.getConnection("" +
                        "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                "root", "password");
        System.out.println("----------------------------");
        System.out.println("Conexao com BD bem-sucedida!");
        System.out.println("----------------------------");


        Statement statement = connection.createStatement();
        System.out.println("----------------------------");
        System.out.println("Executando QUERY");
        System.out.println("----------------------------");
        statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO;");

        ResultSet resultSet = statement.getResultSet();

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
        connection.close();
        System.out.println("Conexão com BD fechada");
    }
}
