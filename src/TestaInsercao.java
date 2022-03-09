import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {

        // Cria conexao com banco de dados a partir da factory
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        // Statement (declaraçao de consulta SQL)
        Statement statement = connection.createStatement();
        boolean resultado =
                statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio');",
                        Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = statement.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.printf("O ID criado foi: %d %n", id);
        }

        System.out.printf("SQL STATEMENT RESULT: %5b %n", resultado);
        rst.close();
    }
}
