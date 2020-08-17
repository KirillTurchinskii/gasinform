import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.InputReaderUtils;
import utils.PostgresJDBCUtils;

public class Main {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  public static void main(String[] args) {
    Connection connection = PostgresJDBCUtils.getConnection(DB_URL, USER, PASS);
    if (connection == null) {
      System.out.println("Connection was not established");
      System.exit(0);
    }
    System.out.println("Input username to search data");
    String usernameToSearch = InputReaderUtils.nextString();
    String sql = "SELECT * FROM user_data where username = '" + usernameToSearch + "';";
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        System.out.println(resultSet.getString("username") + "\t" +
                           resultSet.getString("email") + "\t" +
                           resultSet.getString("surname") + "\t" +
                           resultSet.getString("name"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
