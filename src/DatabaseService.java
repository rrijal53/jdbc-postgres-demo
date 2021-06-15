import pojo.*;

import java.sql.*;
import java.util.*;

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

    public User login(String userName, String password) {
        User u = null;
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from TEST where username=? and password=?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet r = stmt.executeQuery();

            while (r.next()) {
                u = new User(r.getString("username"), r.getString("email"), "", "", 1);
                break;
            }

            return u;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }


    public List<Category> getCategories() {
        String query = "SELECT * FROM categories";
        List<Category> categoryList = new ArrayList<>();

        try {
            Statement s = this.connection.createStatement();
            ResultSet resultSet = s.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("category");
                String image = resultSet.getString("image");
                Category category = new Category(id, name, image);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public boolean insertProduct(Product p) {
        String ps = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
        //  String ps="INSERT INTO PRODUCT VALUES(" +p.getId() +",'" +p.getName()+ "',?,?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(ps);
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setString(2, p.getName());
            preparedStatement.setDouble(3, p.getPrice());
            preparedStatement.setString(4, p.getDescription());
            return preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
