/*
 * DivisionOperator divides two operands and returns a String with the division symbol and the word Div
 */

public class DivisionOperator extends Operator {

  public int evaluate(int a, int b) throws DivideByZeroException {
    return a / b;
  }

  public String toString() {
    return "/";
  }

  public String toInstruction() {
    return "Div";
  }
}