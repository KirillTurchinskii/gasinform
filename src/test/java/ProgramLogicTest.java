import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramLogicTest {

  static final String DB_URL = System.getenv("DB_URL");
  static final String USER = System.getenv("DB_USER");
  static final String PASS = System.getenv("DB_PASSWORD");

  private static ProgramLogic programLogic = new ProgramLogic(DB_URL, USER, PASS);

  @Test
  public void getAccountDataByActualUsername() {
    Account expected = new Account(1,
                                   "ivantop",
                                   "ivan@gmail.com",
                                   "Ivan",
                                   "Vasilev");

    Account actual = programLogic.getAccountDataByUsername("ivantop");
    assertEquals(expected, actual);
  }

  @Test
  public void getAccountDataByFalseUsername() {
    Account expected = new Account(-1,
                                   "username",
                                   "email",
                                   "name",
                                   "surname");

    Account actual = programLogic.getAccountDataByUsername("");
    assertEquals(expected, actual);
  }

  @Test
  public void runSurnameUpdateWithActualUsername() {
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

  @Test
  public void runSurnameUpdateWithFalseUsername() {
    int expected = 0;

    int surnameUpdate = programLogic.runSurnameUpdate("kfkkrjfrkjfr", "Astafef");
    assertEquals(expected, surnameUpdate);

  }

}