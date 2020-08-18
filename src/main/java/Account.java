import java.util.Objects;

public class Account {

  private int id;
  private String username;
  private String email;
  private String name;
  private String surname;

  public Account() {
    this.id = -1;
    this.username = "username";
    this.email = "email";
    this.name = "name";
    this.surname = "surname";
  }

  public Account(int id, String username, String email, String name, String surname) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.name = name;
    this.surname = surname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override public int hashCode() {
    return Objects.hash(getId(), getUsername(), getEmail(), getName(), getSurname());
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account)o;
    return getId() == account.getId() &&
           getUsername().equals(account.getUsername()) &&
           getEmail().equals(account.getEmail()) &&
           getName().equals(account.getName()) &&
           getSurname().equals(account.getSurname());
  }

  @Override public String toString() {
    return "Account{" +
           "id=" + id +
           ", username='" + username + '\'' +
           ", email='" + email + '\'' +
           ", name='" + name + '\'' +
           ", surname='" + surname + '\'' +
           '}';
  }

}
