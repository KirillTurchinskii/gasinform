import java.sql.Connection;

import utils.PostgresJDBCUtils;

public class Main {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  public static void main(String[] args) {
    Connection userDataConnection = PostgresJDBCUtils.getConnection(DB_URL, USER, PASS);
    if (userDataConnection == null) {
      System.out.println("Connection was not established");
    } else {
      ProgramLogic programLogic = new ProgramLogic();
      programLogic.run(userDataConnection);
    }

  }

}
