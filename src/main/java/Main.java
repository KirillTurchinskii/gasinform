import java.sql.Connection;

import utils.InputReaderUtils;
import utils.PostgresJDBCUtils;

public class Main {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  public static void main(String[] args) {
    Connection userDataConnection = PostgresJDBCUtils.getConnection(DB_URL, USER, PASS);
    if (userDataConnection == null) {
      System.out.println("Connection was not established");
      System.exit(0);
    }
    ProcessorSQL processorSQL = new ProcessorSQL(userDataConnection);
    processorSQL.printDataBase();

    System.out.println("Input username to search data");
    String usernameToSearch = InputReaderUtils.nextString();
    processorSQL.printAccountDataUsingUsername(usernameToSearch);

    System.out.println("Update table");
    System.out.println("Pick account username for changing");
    String username = InputReaderUtils.nextString();
    System.out.println("Enter new account surname");
    String newSurname = InputReaderUtils.nextString();
    processorSQL.changeSurnameOnUsername(username, newSurname);

    processorSQL.printDataBase();
  }

}
