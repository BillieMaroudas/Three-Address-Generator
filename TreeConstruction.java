import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/*
 *  TreeConstruction tokenizes the given expression and constructs the tree that represents that expression.
 *  With this tree converts the postfix expression to infix
 *  and generates a file containing the three address format instructions.
 */

 public class TreeConstruction {

  private Node node;
  private Stack<Node> nodeStack;
  private String string;

  TreeConstruction() {
    nodeStack = new Stack<>();
    string = "";
  }

  public void create(String expression) {
    if (expression.isEmpty()) {
      showMessageDialog(null, "Enter a Postfix Expression.", "No Input",
          INFORMATION_MESSAGE);
      throw new RuntimeException("Blank Input");
    }

    int operatorCount = 0;

    for (int i = 0; i < expression.length(); i++) {
      char character = expression.charAt(i);

      if (isOperator(character)) {
        Operator operator = createOperator(character);
        Node b = nodeStack.pop();
        Node a = nodeStack.pop();
        nodeStack.push(new OperatorNode(operator, a, b));
        updateAssembly(operator, a, b, operatorCount);
        operatorCount++;
      } else if (!Character.isWhitespace(character)) {
        if (Character.isDigit(character)) {
          nodeStack.push(new OperandNode(Integer.parseInt(Character.toString(character))));
        } else {
          showMessageDialog(null, "You entered an invalid character " + character,
              "InvalidCharacter",
              ERROR_MESSAGE);
          throw new RuntimeException("Invalid Character");
        }
      }
    }
    node = nodeStack.lastElement();
    writeToFile(string);
  }

  private boolean isOperator(char character) {
    return character == '+' || character == '-' || character == '*' || character == '/';
  }

  private Operator createOperator(char character) {
    switch (character) {
      case '+':
        return new AdditionOperator();
      case '-':
        return new SubtractionOperator();
      case '*':
        return new MultiplicationOperator();
    }
    return new DivisionOperator();
  }

  public String infix() {
    if (node == null) {
      return "";
    }
    return node.inOrderWalk();
  }

  private void updateAssembly(Operator operator, Node a, Node b,
      int operatorCount) {
    string += operator.toInstruction() + " R" + operatorCount + " ";

    if (a instanceof OperandNode) {
      string += a.inOrderWalk() + " ";
      if (b instanceof OperandNode) {
        string += b.inOrderWalk() + " \n";
      } else {
        string += "R" + (operatorCount - 1) + " \n";
      }
    } else if (a instanceof OperatorNode) {
      operatorCount += (operatorCount <= 2) ? 1 : 0;
      string += "R" + (operatorCount - 2) + " ";

      if (b instanceof OperatorNode) {
        string += "R" + (operatorCount - 1) + " \n";
      } else {
        string += b.inOrderWalk() + " \n";
      }
    }
  }

  private void writeToFile(String content) {
    try (FileWriter writeInstruction = new FileWriter("ThreeAddress.txt", true)) {
      writeInstruction.write(content);
      writeInstruction.append(System.lineSeparator());            

    } catch (IOException e) {
      // TODO: Throw exception dialog...
    }
  }

}