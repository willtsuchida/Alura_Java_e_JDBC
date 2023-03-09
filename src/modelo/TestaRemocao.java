package modelo;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperaConexao();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");

        stm.setInt(1, 2);
        stm.execute();

        Integer linhasModificadas = stm.getUpdateCount();

        System.out.println("Qtde de linhas modificadas: " + linhasModificadas);
    }
}
