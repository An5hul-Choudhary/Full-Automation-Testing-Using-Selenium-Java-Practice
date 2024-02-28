import java.sql.*;

public class jdbcConnection {
    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "3306";

        Connection connection = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/qadbt","root","1234");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Employeeinfo where name = 'ram';");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("location"));
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getInt("age"));
        }

    }
}
