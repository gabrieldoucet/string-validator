package stringValidator; /**
 * Created by Gabriel on 09/08/2017.
 */

import stringValidator.CharList;

import java.util.*;

public class Parser {

  private static CharList charList = new CharList();

  public static void main(String[] args) {
    boolean confirm = false;
    String userInput = "";
    while (!confirm) {
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter a combination of (, ), [ et ] to check: ");
      userInput = in.nextLine();
      System.out.printf("You entered: %s\n", userInput);
      System.out.print("Confirm [y/n]? (n) ");
      String yesNo = in.nextLine();
      if (yesNo.equals("")) {
        yesNo = "n";
      }
      confirm = yesNo.equals("y");
    }
    System.out.println(check(userInput) ? "Valid input!" : "Invalid input");
  }

  public static boolean validateOuters(char first, char last) {
    return (first == '[' && last == ']') || (first == '(' && last == ')');
  }

  public static boolean parseString(String str) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char currentChar = charArray[i];
//            System.out.println(currentChar + " " + charList.toString());
      if (currentChar == '(' || currentChar == '[') {
        charList.push(currentChar);
      } else {
        charList.pop(currentChar);
      }
    }
    return charList.isEmpty();
  }

  public static boolean check(String str) {
//        System.out.println("Check: " + str);
    if (str.isEmpty()) {
      return true;
    } else if (str.length() == 1) {
      return false;
    } else {
      char[] charArray = str.toCharArray();
      boolean validOuters = validateOuters(charArray[0], charArray[str.length() - 1]);
      if (str.length() == 2) {
        return validOuters;
      } else {
        char[] middleStr = Arrays.copyOfRange(charArray, 1, charArray.length - 1);
        if (validOuters) {
//                    System.out.println("Valid outers");
          return check(new String(middleStr));
        } else {
          return parseString(str);
        }
      }
    }
  }
}