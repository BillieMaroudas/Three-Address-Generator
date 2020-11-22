/*
 * AdditionOperator adds two operands and returns a String with the add symbol and the word Add
 */
 

public class AdditionOperator extends Operator {

  public int evaluate(int a, int b) {
    return a + b;
  }

  public String toString() {
    return "+";
  }

  public String toInstruction() {
    return "Add";
  }
}
