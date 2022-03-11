import br.com.matheus.jdbc.ConnectionFactory;
import br.com.matheus.jdbc.PersistenciaProduto;
import br.com.matheus.jdbc.modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao()){
            PersistenciaProduto persistenciaProduto = new PersistenciaProduto(connection);
            persistenciaProduto.salvarProduto(comoda);
            // Lista = persistenciaProduto.listar();
        }
    }
}
