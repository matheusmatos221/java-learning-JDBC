import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "MOUSE";
        String descricao = "MOUSE SEM FIO";

        // Cria conexao com banco de dados a partir da factory
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES ('" + nome + "', '"+ descricao +"');";
        System.out.println(sql);
        // Statement (declaraçao de consulta SQL)
        Statement statement = connection.createStatement();

        boolean resultado = statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = statement.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.printf("O ID criado foi: %d %n", id);
        }

        System.out.printf("SQL STATEMENT RESULT: %5b %n", resultado);

    }
}
