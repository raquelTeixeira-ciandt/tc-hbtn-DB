import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionSQLite {

    private static Connection connection;
    private static String DB_NOME = "sqlite_database_2022.db";

    public static void main(String[] args) {
        initConnection();
    }

    private static void initConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", DB_NOME));
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            Logger.getLogger(ConnectionSQLite.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            Logger.getLogger(ConnectionSQLite.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}