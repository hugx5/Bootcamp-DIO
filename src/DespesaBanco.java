import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    private Connection connection;

    public DespesaDAO() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:despesas.db");

        // cria tabela se não existir
        String sql = "CREATE TABLE IF NOT EXISTS despesas (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	valor real NOT NULL,\n"
                + "	categoria text NOT NULL,\n"
                + "	data text NOT NULL\n"
                + ");";
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public void insert(Despesa despesa) throws SQLException {
        String sql = "INSERT INTO despesas(valor, categoria, data) VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, despesa.getValor());
        statement.setString(2, despesa.getCategoria());
        statement.setString(3, despesa.getData().toString());
        statement.executeUpdate();
    }

    public List<Despesa> getAll() throws SQLException {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesas";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            double valor = resultSet.getDouble("valor");
            String categoria = resultSet.getString("categoria");
            String dataStr = resultSet.getString("data");
            Despesa despesa = new Despesa(valor, categoria, LocalDate.parse(dataStr));
            despesa.setId(id);
            despesas.add(despesa);
        }
        return despesas;
    }

    // outros métodos (update, delete, etc.) aqui
}