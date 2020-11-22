import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainGUI {

  private JTextField expressionField;
  private JTextField resultField = new JTextField("", 20);

  public static void main(String[] args) {
    MainGUI gui = new MainGUI();
    gui.prepareGUI();
  }

  private void prepareGUI() {
    JFrame mainFrame = new JFrame("Three Address Generator");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel window = (JPanel) mainFrame.getContentPane();
    mainFrame.setLayout(null);

    JLabel promptLabel = new JLabel("Enter Postfix Expression");
    promptLabel.setBounds(25, 5, promptLabel.getPreferredSize().width,
        promptLabel.getPreferredSize().height);
    window.add(promptLabel);

    JLabel resultLabel = new JLabel("Infix Expression");
    resultLabel.setBounds(50, 100, resultLabel.getPreferredSize().width,
        resultLabel.getPreferredSize().height);
    window.add(resultLabel);

    expressionField = new JTextField("", 20);
    expressionField.setBounds(175, 5, expressionField.getPreferredSize().width,
        expressionField.getPreferredSize().height);
    window.add(expressionField);

    resultField.setBounds(175, 100, resultField.getPreferredSize().width,
        resultField.getPreferredSize().height);
    window.add(resultField);

    JButton constructButton = new JButton("Construct Tree");
    constructButton.setBounds(175, 50, constructButton.getPreferredSize().width,
        constructButton.getPreferredSize().height);

    constructButton.addActionListener((ActionEvent e) ->
        constructButtonAction());
    window.add(constructButton);
    window.getRootPane().setDefaultButton(constructButton);

    mainFrame.setSize(500, 175);
    mainFrame.setVisible(true);
  }

  private void constructButtonAction() {
    TreeConstruction expressionTree = new TreeConstruction();
    expressionTree.create(expressionField.getText());
    resultField.setText("" + expressionTree.infix());
  }
}