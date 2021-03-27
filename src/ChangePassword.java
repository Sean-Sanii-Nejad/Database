import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword implements ActionListener {

    // JFrame and JPanel Objects
    private final JFrame jframe = new JFrame();
    private final JPanel panelChangePassword = new JPanel();

    // JLabel Objects
    private final JLabel labelNewPassword = new JLabel();
    private final JLabel labelNewPasswordAgain = new JLabel();

    // JTextField Objects
    private final JTextField textFieldNewPassword = new JTextField();
    private final JTextField textFieldNewPasswordAgain = new JTextField();

    // JButton Objects
    private final JButton buttonChangePassword = new JButton();

    public ChangePassword(){
        // Frame Information
        jframe.setTitle("Change Password");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setSize(400, 215);
        jframe.setResizable(false);
        jframe.add(panelChangePassword);

        // Panel Information
        panelChangePassword.setLayout(null);
        panelChangePassword.setBounds(0,0,400,215);
        panelChangePassword.add(labelNewPassword);
        panelChangePassword.add(labelNewPasswordAgain);
        panelChangePassword.add(textFieldNewPassword);
        panelChangePassword.add(textFieldNewPasswordAgain);
        panelChangePassword.add(buttonChangePassword);

        // Label Information
        labelNewPassword.setText("Please enter your username");
        labelNewPassword.setBounds(15,15,250,25);
        labelNewPasswordAgain.setText("Please enter your email address");
        labelNewPasswordAgain.setBounds(15,70,250,25);

        // TextField Information
        textFieldNewPassword.setBounds(15,40, 340, 25);
        textFieldNewPasswordAgain.setBounds(15,95, 340, 25);

        // Button Information
        buttonChangePassword.setText("Recover Password");
        buttonChangePassword.setBounds(95, 130, 200, 30);
    }

    public static void main(String[] args){
        ChangePassword main = new ChangePassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
