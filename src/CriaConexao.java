import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
    public Connection recuperarConexao() throws SQLException {
        // Conecta no Banco de Dados
        System.out.println("----------------------------");
        System.out.println("Tentando conectar com BD");
        System.out.println("----------------------------");
        return DriverManager.getConnection("" +
                        "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                "root", "password");
    }
}
