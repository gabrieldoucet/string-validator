package test;

import org.junit.Test;
import stringValidator.Parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestRunner {

  @Test
  public void testParser() {
    // Assert statements;
    assertTrue("Empty string is valid", Parser.check(""));
    assertTrue("() is valid", Parser.check("()"));
    assertFalse("(( is not valid", Parser.check("(("));
    assertFalse("(] is not valid", Parser.check("(]"));
    assertFalse("([ is not valid", Parser.check("(["));
    assertFalse("[) is not valid", Parser.check("[)"));
    assertFalse("[( is not valid", Parser.check("[("));
    assertTrue("[] is valid", Parser.check("[]"));
    assertFalse("[[ is not valid", Parser.check("[["));
    assertFalse(")) is not valid", Parser.check("))"));
    assertFalse(")( is not valid", Parser.check(")("));
    assertFalse(")] is not valid", Parser.check(")]"));
    assertFalse(")[ is not valid", Parser.check(")["));
    assertFalse("]) is not valid", Parser.check("])"));
    assertFalse("]( is not valid", Parser.check("]("));
    assertFalse("]] is not valid", Parser.check("]]"));
    assertFalse("][ is no valid", Parser.check("]["));
    assertTrue("([]((()[])))[] is valid", Parser.check("([]((()[])))[]"));
  }
}