import br.com.matheus.jdbc.ConnectionFactory;
import br.com.matheus.jdbc.ProdutoDAO;
import br.com.matheus.jdbc.modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProduto(comoda);
            // Lista = persistenciaProduto.listar();
        }
    }
}
