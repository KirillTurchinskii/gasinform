public class Main {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  public static void main(String[] args) {
    ProgramLogic programLogic = new ProgramLogic(DB_URL, USER, PASS);
    if (args.length == 2 && args[0].equals("search")) {
      System.out.println("search mode");
      Account account = programLogic.getAccountDataByUsername(args[1]);
      System.out.println(account);
    } else if (args.length == 3 && args[0].equals("update")) {
      System.out.println("update mode");
      int surnameUpdate = programLogic.runSurnameUpdate(args[1], args[2]);
      if (surnameUpdate > 0) {
        Account account = programLogic.getAccountDataByUsername(args[1]);
        System.out.println(account);
      }
    } else {
      System.out.println("No such variant");
    }
  }

}
