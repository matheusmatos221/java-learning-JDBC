import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        // Conecta no Banco de Dados
        System.out.println("Tentando conectar com BD");
        Connection connection = DriverManager.getConnection("" +
                "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                "root", "password");

        // Fecha conexão do Banco de Dados
        connection.close();
        System.out.println("Conexão com BD fechada");


    }
}
