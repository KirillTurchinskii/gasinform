import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramLogicTest {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  private static ProgramLogic programLogic = new ProgramLogic(DB_URL, USER, PASS);

  @Test
  public void getAccountDataByUsername() {
    Account expected = new Account(1,
                                   "ivantop",
                                   "ivan@gmail.com",
                                   "Ivan",
                                   "Vasilev");

    Account actual = programLogic.getAccountDataByUsername("ivantop");
    assertEquals(expected, actual);
  }

  @Test
  public void runSurnameUpdate() {
    int expected = 1;
    Account account = new Account(2,
                                  "Astager",
                                  "sergio@gmail.com",
                                  "Sergey",
                                  "Astafiev");

    String old = account.getSurname();
    int surnameUpdate = programLogic.runSurnameUpdate("Astager", "Astafef");
    assertEquals(1, surnameUpdate);
    assertEquals("Astafef", programLogic.getAccountDataByUsername("Astager").getSurname());
    programLogic.runSurnameUpdate("Astager", "Astafiev");

  }

}