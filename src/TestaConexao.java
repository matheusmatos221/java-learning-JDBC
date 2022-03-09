import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        // Cria conexao com BD
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        // Fecha conexão do Banco de Dados
        connection.close();
        System.out.println("Conexão com BD fechada");


    }
}
