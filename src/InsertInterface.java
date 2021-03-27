import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class InsertInterface implements ActionListener {

    private MainInterface context;

    // JFrame and JPanel Objects
    private final JFrame jframe = new JFrame();
    private final JPanel panel = new JPanel(new FlowLayout());

    // JTextField Objects
    private final JTextField firstName = new JTextField();
    private final JTextField secondName = new JTextField();
    private final JTextField username = new JTextField();
    private final JTextField password = new JTextField();

    // JLabel Objects
    private final JLabel firstNameLabel = new JLabel();
    private final JLabel secondNameLabel = new JLabel();
    private final JLabel usernameLabel = new JLabel();
    private final JLabel passwordLabel = new JLabel();

    // JButton Objects
    private final JButton insertButton = new JButton();

    InsertInterface(MainInterface context){
        this.context = context;
        // Frame Information
        jframe.setTitle("Insert Data");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(315, 200);
        jframe.setResizable(false);
        jframe.add(panel);
        jframe.setVisible(true);

        // Panel Information
        panel.setBounds(0,0,315,250);
        panel.setLayout(null);
        panel.add(firstName);
        panel.add(secondName);
        panel.add(username);
        panel.add(password);
        panel.add(firstNameLabel);
        panel.add(secondNameLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(insertButton);

        // TextField Information
        firstName.setBounds(100,10,200,25);
        secondName.setBounds(100,40,200,25);
        username.setBounds(100,70,200,25);
        password.setBounds(100,100,200,25);

        // Label Information
        firstNameLabel.setText("Forename");
        firstNameLabel.setBounds(10,10,100,25);
        secondNameLabel.setText("Surname");
        secondNameLabel.setBounds(10,40,100,25);
        usernameLabel.setText("Username");
        usernameLabel.setBounds(10,70,100,25);
        passwordLabel.setText("Password");
        passwordLabel.setBounds(10,100,100,25);

        // Button Information
        insertButton.setBounds(120,130,75,25);
        insertButton.setText("Enter");

        // ActionListeners
        insertButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insertButton){
            try {
                ArrayList<User> arrayList = new ArrayList();
                String sql = "INSERT INTO users VALUES (?,?,?,?);";
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setString(1, firstName.getText());
                statement.setString(2, secondName.getText());
                statement.setString(3, username.getText());
                statement.setString(4, password.getText());
                statement.executeUpdate();
                context.setTable();
            } catch(SQLException error){
                error.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?", "root", "test");
    }
}
