import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Main extends JFrame implements ActionListener, MouseListener, KeyListener {
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

    public Main() throws IOException {
        // Frame Information
        jframe.setTitle("Database");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 450);
        jframe.setResizable(false);
        jframe.addKeyListener(this);
        jframe.add(panelLogin);
        jframe.setVisible(true);

        // Panel Information
        panelLogin.setBounds(0,0, 400, 450);
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
        textFieldPassword.setBounds(20,310,340,25);

        // Button Information
        buttonLogin.setText("Login");
        buttonLogin.setBounds(20,350, 340, 30);
        buttonLogin.addActionListener(this);

        // Image Information
        labelPicture.setBounds(110,25, 200, 200);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonLogin){
            try{
                String sql = "SELECT * FROM users WHERE username=? and password=?";
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setString(1, textFieldUsername.getText());
                statement.setString(2, textFieldPassword.getText());
                ResultSet result = statement.executeQuery();
                if(result.next()){
                    MainInterface main = new MainInterface();
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
           System.out.println("ENTER!!!");
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Connection getConnection() throws SQLException{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?", "root", "test");
    }
}
