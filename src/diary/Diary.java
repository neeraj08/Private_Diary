package diary;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Diary {
    static JFrame frame;
    static PasswordFrame pwdFrame;
    static JFrame note;
    public static void main(String[] args) throws InterruptedException, IOException {
        frame=new JFrame();
        frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        pwdFrame=new PasswordFrame();
        pwdFrame.setVisible(true);
        String password="asd";
        while(!password.equals(pwdFrame.getPassword()))
        {
            Thread.sleep(200);
//            System.out.println(pwdFrame.getPassword()+" entered");
        }
        System.out.println("Correct password entered");
        pwdFrame.setVisible(false);
        note=new Note();
        note.setVisible(true);
    }
}