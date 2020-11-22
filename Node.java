/*
 * Node class is an interface
 *
 */

public interface Node {

  int evaluate();

  String preOrderWalk();

  String inOrderWalk();

  String postOrderWalk();
}