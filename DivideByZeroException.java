import javax.swing.JOptionPane;

/*
 * DivideByZeroException catches a divide by zero exception
 */

class DivideByZeroException extends ArithmeticException {

  DivideByZeroException() {
    JOptionPane window = new JOptionPane();
    JOptionPane.showMessageDialog(window, "Division by zero is impossible.");
  }
}