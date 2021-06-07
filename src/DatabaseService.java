import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {
    Connection connection;

    public DatabaseService(String dbname, String dbuser, String dbpassword) throws SQLException {
        String url = "jdbc:postgresql://165.227.121.144:5432/" + dbname + "?user=" + dbuser + "&password=" + dbpassword;
        this.connection = DriverManager.getConnection(url);
    }

    public void register(User u) {
        try {
            String s1 = "INSERT INTO USER(name, password) VALUES(" + u.getName() + ",'" + u.getPassword() + "')";

            Statement s = this.connection.createStatement();
            int i = s.executeUpdate(s1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
