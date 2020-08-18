import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.PostgresJDBCUtils;

public class ProgramLogic {

  final String url;
  final String user;
  final String password;

  public ProgramLogic(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public Account getAccountDataByUsername(String username) {
    Statement statement = null;
    ResultSet resultSet = null;
    Account account = new Account();
    try (Connection connection = PostgresJDBCUtils.getConnection(url, user, password)) {
      String sql = "SELECT * FROM user_data where username = '" + username + "';";
      if (connection != null) {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
          account = new Account(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("email"),
                                resultSet.getString("surname"),
                                resultSet.getString("name"));
        }

      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      closeFinally(statement, resultSet);
    }
    return account;
  }

  public int runSurnameUpdate(String username, String newSurname) {
    Statement statement = null;
    int updatedNum = 0;
    try (Connection connection = PostgresJDBCUtils.getConnection(url, user, password)) {
      String sql = "UPDATE user_data SET surname = '" + newSurname + "' WHERE username = '" + username + "';";
      if (connection != null) {
        statement = connection.createStatement();
        updatedNum = statement.executeUpdate(sql);
      }
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
    return updatedNum;
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
