package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderUtils {

  private InputReaderUtils() {
  }

  public static String nextString() {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String inputString = "";
    try {
      inputString = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return inputString;
  }

  public static int nextInt() {
    int value = 0;
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String string = "";
    try {
      string = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      value = Integer.parseInt(string);
    } catch (NumberFormatException e) {
      System.out.println("Wrong number format");
      System.out.println("Input val = 0 now");
      e.printStackTrace();
    }
    return value;
  }

}
