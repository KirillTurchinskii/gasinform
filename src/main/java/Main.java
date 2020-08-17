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
    } else {
      run(userDataConnection);
    }

  }

  private static void run(Connection userDataConnection) {
    ProcessorSQL processorSQL = new ProcessorSQL(userDataConnection);
    processorSQL.printDataBase();
    System.out.println("Input '0' to Search by username or '1' to Change surname of certain username");
    int mod = InputReaderUtils.nextInt();
    switch (mod) {
      case 0:
        findDataUsingUsername(processorSQL);
        break;
      case 1:
        changeSurname(processorSQL);
        processorSQL.printDataBase();
        break;
      default:
        System.out.println("There is no such mod");
        break;
    }
  }

  private static void changeSurname(ProcessorSQL processorSQL) {
    System.out.println("Update table");
    System.out.println("Pick account username for changing");
    String username = InputReaderUtils.nextString();
    System.out.println("Enter new account surname");
    String newSurname = InputReaderUtils.nextString();
    processorSQL.changeSurnameOnUsername(username, newSurname);
  }

  private static void findDataUsingUsername(ProcessorSQL processorSQL) {
    System.out.println("Input username to search data");
    String usernameToSearch = InputReaderUtils.nextString();
    processorSQL.printAccountDataUsingUsername(usernameToSearch);
  }

}
