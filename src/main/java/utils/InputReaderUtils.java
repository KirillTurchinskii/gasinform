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

}
