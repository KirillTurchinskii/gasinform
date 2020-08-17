import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresJDBCUtil {

  public static Connection getConnection(String URL, String user, String password) {
    System.out.println("Trying to connect to PostgreSQL");

    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
      e.printStackTrace();
      return null;
    }

    System.out.println("PostgreSQL JDBC Driver successfully connected");
    Connection connection;

    try {
      connection = DriverManager
                     .getConnection(URL, user, password);

    } catch (SQLException e) {
      System.out.println("Connection Failed");
      e.printStackTrace();
      return null;
    }

    if (connection != null) {
      System.out.println("You successfully connected to database now");
    } else {
      System.out.println("Failed to make connection to database");
    }
    return connection;
  }

}
