/*
* Operator class is an abstract class that implements the operators for the expression tree
*/

public abstract class Operator {

  abstract public int evaluate(int a, int b);

  abstract public String toInstruction();
}
