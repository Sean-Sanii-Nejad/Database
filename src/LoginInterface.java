import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class LoginInterface extends JFrame implements ActionListener, MouseListener, KeyListener {
    // Image Object
    private BufferedImage image = ImageIO.read(new File("src/data_backup.png"));

    // JFrame & JPanel Objects
    private final JFrame jframe = new JFrame();
    private final JPanel panelLogin = new JPanel();

    // JLabel Objects
    private final JLabel labelUsername = new JLabel();
    private final JLabel labelPassword = new JLabel();
    private final JLabel labelChangePassword = new JLabel();
    private final JLabel labelPicture = new JLabel(new ImageIcon(image));

    // JTextField Objects
    private final JTextField textFieldUsername = new JTextField();
    private final JTextField textFieldPassword = new JTextField();

    // JButton Objects
    private final JButton buttonLogin = new JButton();

    public LoginInterface() throws IOException {
        // Frame Information
        jframe.setTitle("Database");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 450);
        jframe.setResizable(false);
        jframe.add(panelLogin);
        jframe.setFocusable(true);
        jframe.setVisible(true);

        // Panel Information
        panelLogin.setBounds(0,0, 400, 450);
        panelLogin.setFocusable(true);
        panelLogin.setLayout(null);
        panelLogin.add(labelUsername);
        panelLogin.add(labelPassword);
        panelLogin.add(textFieldUsername);
        panelLogin.add(textFieldPassword);
        panelLogin.add(buttonLogin);
        panelLogin.add(labelPicture);
        panelLogin.add(labelChangePassword);

        // Label Information
        labelUsername.setText("Username");
        labelUsername.setBounds(20,225,100,25);
        labelPassword.setText("Password");
        labelPassword.setBounds(20,285,100,25);
        labelChangePassword.setText("Forgot Password");
        labelChangePassword.setBounds(140, 382, 150, 25);
        labelChangePassword.setForeground(Color.BLUE);
        labelChangePassword.addMouseListener(this);

        // TextField Information
        textFieldUsername.setBounds(20,250,340,25);
        textFieldUsername.requestFocusInWindow();
        textFieldPassword.setBounds(20,310,340,25);

        // Button Information
        buttonLogin.setText("Login");
        buttonLogin.setBounds(20,350, 340, 30);

        // Image Information
        labelPicture.setBounds(110,25, 200, 200);

        // Key Listeners
        buttonLogin.addActionListener(this);
        jframe.addKeyListener(this);
        panelLogin.addKeyListener(this);
        textFieldUsername.addKeyListener(this);
        textFieldPassword.addKeyListener(this);
    }

    public static void main(String[] args) throws IOException {
        LoginInterface loginInterface = new LoginInterface();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonLogin){
            login();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == labelChangePassword){
            labelChangePassword.setForeground(Color.decode("#00cbeb"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == labelChangePassword){
            labelChangePassword.setForeground(Color.BLUE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new ChangePassword();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_ENTER){
           login();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void login(){
        try{
            ArrayList<User> arrayList = new ArrayList();
            String sql = "SELECT * FROM users WHERE username=? and password=?";
            PreparedStatement statement = Model.getConnection().prepareStatement(sql);
            statement.setString(1, textFieldUsername.getText());
            statement.setString(2, textFieldPassword.getText());
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                String sql2 = "SELECT firstName FROM users WHERE username = " + "'" + textFieldUsername.getText() + "'";
                PreparedStatement statement2 = Model.getConnection().prepareStatement(sql2);
                ResultSet result2 = statement2.executeQuery();
                User user;
                user = new User(result.getString("FirstName"), result.getString("SecondName"), result.getString("Username"), result.getString("Password"));
                new MainInterface(user.getFirstName());
                jframe.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
                textFieldPassword.setText("");
            }
        }
        catch(SQLException error){
            error.printStackTrace();
        }
    }
}
