import java.sql.Connection;

public class Main {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  public static void main(String[] args) {
    Connection connection = PostgresJDBCUtil.getConnection(DB_URL, USER, PASS);
    if (connection == null) {
      System.out.println("Connection was not established");
      System.exit(0);
    }
  }

}
