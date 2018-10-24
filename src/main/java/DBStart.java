import java.sql.*;

public class DBStart  {

    public static void main(String[] args) {
        String dbUser = "postgres";
        String dbPassword = "admin";
        String connectionUrl = "jdbc:postgresql://localhost:5432/users";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  user_l");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
