import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProcessorSQL {

  Connection connection;

  public ProcessorSQL(Connection connection) {
    this.connection = connection;
  }

  public void printDataBase() {
    String sql = "SELECT * FROM user_data;";
    processSQL(sql);
  }

  public void printAccountDataUsingUsername(String usernameToSearch) {
    String sql = "SELECT * FROM user_data where username = '" + usernameToSearch + "';";
    processSQL(sql);
  }

  public void changeSurnameOnUsername(String username, String newSurname) {
    String sql = "UPDATE user_data SET surname = '" + newSurname + "' WHERE username = '" + username + "';";
    Statement statement = null;
    try {
      statement = connection.createStatement();
      statement.execute(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }

  }

  private void printResultSet(ResultSet resultSet) throws SQLException {
    while (resultSet.next()) {
      System.out.println(resultSet.getString("id") + "\t" +
                         resultSet.getString("username") + "\t" +
                         resultSet.getString("email") + "\t" +
                         resultSet.getString("surname") + "\t" +
                         resultSet.getString("name"));
    }
  }

  private void processSQL(String sql) {
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      printResultSet(resultSet);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      closeFinally(statement, resultSet);
    }
  }

  private void closeFinally(Statement statement, ResultSet resultSet) {
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
