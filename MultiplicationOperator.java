/*
 * MultiplicationOperator multiplies two operands and returns a String with the multiplication symbol and the word Mul
 */

public class MultiplicationOperator extends Operator {

  public int evaluate(int a, int b) {
    return a * b;
  }

  public String toString() {
    return "*";
  }

  public String toInstruction() {
    return "Mul";
  }

}
