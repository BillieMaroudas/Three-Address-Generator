import static java.lang.String.valueOf;

/*
 * OperandNode class implements Node
*/

public class OperandNode implements Node {

  private int nodeValue;

  OperandNode (int value) {
    this.nodeValue = value;
  }

  public int evaluate() {
    return nodeValue;
  }

  public String preOrderWalk() {
    return valueOf(nodeValue);
  }

  public String inOrderWalk() {
    return valueOf(nodeValue);
  }

  public String postOrderWalk() {
    return valueOf(nodeValue);
  }
}