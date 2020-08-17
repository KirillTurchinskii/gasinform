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
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        System.out.println(resultSet.getString("id") + "\t" +
                           resultSet.getString("username") + "\t" +
                           resultSet.getString("email") + "\t" +
                           resultSet.getString("surname") + "\t" +
                           resultSet.getString("name"));
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
      try {
        if (resultSet != null) {
          resultSet.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

  public void printAccountDataUsingUsername(String usernameToSearch) {
    String sql = "SELECT * FROM user_data where username = '" + usernameToSearch + "';";
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        System.out.println(resultSet.getString("username") + "\t" +
                           resultSet.getString("email") + "\t" +
                           resultSet.getString("surname") + "\t" +
                           resultSet.getString("name"));
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
      try {
        if (resultSet != null) {
          resultSet.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
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

}
