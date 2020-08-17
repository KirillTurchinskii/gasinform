import java.sql.Connection;

import utils.InputReaderUtils;

public class ProgramLogic {

  public void run(Connection userDataConnection) {
    ProgramLogic programLogic = new ProgramLogic();
    ProcessorSQL processorSQL = new ProcessorSQL(userDataConnection);
    processorSQL.printDataBase();
    System.out.println("Input '0' to Search by username or '1' to Change surname of certain username");
    int mod = InputReaderUtils.nextInt();
    switch (mod) {
      case 0:
        programLogic.findDataUsingUsername(processorSQL);
        break;
      case 1:
        programLogic.changeSurname(processorSQL);
        processorSQL.printDataBase();
        break;
      default:
        System.out.println("There is no such mod");
        break;
    }
  }

  private void changeSurname(ProcessorSQL processorSQL) {
    System.out.println("Update table");
    System.out.println("Pick account username for changing");
    String username = InputReaderUtils.nextString();
    System.out.println("Enter new account surname");
    String newSurname = InputReaderUtils.nextString();
    processorSQL.changeSurnameOnUsername(username, newSurname);
  }

  private void findDataUsingUsername(ProcessorSQL processorSQL) {
    System.out.println("Input username to search data");
    String usernameToSearch = InputReaderUtils.nextString();
    processorSQL.printAccountDataUsingUsername(usernameToSearch);
  }

}
