package loja.virtual.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "";
        String descricao = "";

        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexao();

        PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        stm.setString(1, nome);
        stm.setString(2, descricao);
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
