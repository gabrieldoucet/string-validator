package stringValidator; /**
 * Created by Gabriel on 09/08/2017.
 */

import java.util.*;

public class CharList extends ArrayList<Character> {

  public CharList() {
    super();
  }

  public void push(char elt) {
    this.add(elt);
  }

  public void pop(char currentChar) {
    int size = this.size();
    char previousChar = this.get(size - 1);
    if ((currentChar == ')' && previousChar == '(') || (currentChar == ']' && previousChar == '[')) {
      this.remove(size - 1);
    }
  }

  public String toString() {
    String str = "list: <";
    for (int i = 0; i < this.size(); i++) {
      str += this.get(i);
    }
    str += "/>";
    return str;
  }
}
