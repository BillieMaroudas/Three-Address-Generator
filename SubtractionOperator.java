/*
 * Class SubtractionOperator subtracts two operands and returns a String with the subtract symbol and the word sub
 */

public class SubtractionOperator extends Operator {

  public int evaluate(int a, int b) {
    return Math.abs(a - b);
  }

  public String toString() {
    return "-";
  }

  public String toInstruction() {
    return "Sub";
  }
}
