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
        String url = "jdbc:mysql://0.0.0.0:3306/" + dbname + "?user=" + dbuser + "&password=" + dbpassword;
        this.connection = DriverManager.getConnection(url);
    }


    public void register(User u) {
        try {
            String s1 = "INSERT INTO USER(name, password) VALUES('" + u.getName() + "','" + u.getPassword() + "')";

            Statement s = this.connection.createStatement();
            int i = s.executeUpdate(s1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
