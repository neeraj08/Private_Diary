package diary;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author neeraj
 */
public class PasswordFrame extends JFrame{
    JTextField input;
    public PasswordFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(220,150);
        input=new JTextField();
        input.setSize(new Dimension(100, 40));
        input.setText("Enter password");
        add(input);
    }
    public String getPassword()
    {
        return input.getText();
    }
}
