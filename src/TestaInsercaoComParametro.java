import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "MOUSE";
        String descricao = "MOUSE SEM FIO";

        // Cria conexao com banco de dados a partir da factory
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement stm =
                connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?);",
                        Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, nome);
        stm.setString(2, descricao);
        stm.execute();
        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.printf("O ID criado foi: %d %n", id);
        }
        rst.close();
    }
}
