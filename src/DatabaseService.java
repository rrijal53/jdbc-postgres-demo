import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//connection
//statement
//execute
public class DatabaseService {
    Connection connection;

    public DatabaseService(String dbname, String dbuser, String dbpassword) throws SQLException {
        String url = "jdbc:postgresql://165.227.121.144:5432/" + dbname + "?user=" + dbuser + "&password=" + dbpassword;
        this.connection = DriverManager.getConnection(url);

    }


    public boolean register(User u) {
        try {
            String s1 = "INSERT INTO TEST(username, password) VALUES('" + u.getName() + "','" + u.getPassword() + "')";

            Statement s = this.connection.createStatement();
            int i = s.executeUpdate(s1);
            return i > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
