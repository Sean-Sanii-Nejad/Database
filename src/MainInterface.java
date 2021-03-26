import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.Area;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainInterface {

    // JFrame and JPanel Objects
    private final JFrame jframe = new JFrame();
    private final JPanel headerPanel = new JPanel(new FlowLayout());
    private final JPanel tablePanel = new JPanel(new BorderLayout());

    // JButton Objects
    private final JButton insertButton = new JButton();
    private final JButton deleteButton = new JButton();

    // JTable Objects
    private final JTable userTable = new JTable();

    public MainInterface() throws SQLException {
        // Frame Information
        jframe.setTitle("Database");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 450);
        jframe.setResizable(false);
        jframe.add(headerPanel);
        jframe.add(tablePanel);
        jframe.setVisible(true);

        // Panel Information
        headerPanel.setBounds(0,350,400,100);
        headerPanel.add(insertButton);
        headerPanel.add(deleteButton);
        tablePanel.setBounds(0,0, 400, 350);
        tablePanel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        // Button Information
        insertButton.setBounds(25,15,100,25);
        insertButton.setText("Insert");
        deleteButton.setBounds(130,15,100,25);
        deleteButton.setText("Delete");

        // SQL Inforamtion
        ArrayList<User> arrayList = new ArrayList();
        String sql = "SELECT * FROM users";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        User user;
        while(result.next()){
            user = new User(result.getString("FirstName"), result.getString("SecondName"), result.getString("Username"), result.getString("Password"));
            arrayList.add(user);
        }

        // Table Information
        String[] columnNames = {"Firstname", "Surname", "Username", "Password"};

        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        Object[] row = new Object[4];
        for(int i = 0; i < arrayList.size(); i++){
            row[0] = arrayList.get(i).getFirstName();
            row[1] = arrayList.get(i).getSecondName();
            row[2] = arrayList.get(i).getUsername();
            row[3] = arrayList.get(i).getPassword();
            model.addRow(row);
        }

        userTable.setBounds(25,100,250, 300);
        userTable.setModel(model);

    }

    public static void main(String[] args) throws IOException, SQLException {
        MainInterface main = new MainInterface();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?", "root", "test");
    }
}

class User {
    private String firstName;
    private String secondName;
    private String username;
    private String password;

    public User(String firstName, String secondName, String username, String password){
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getSecondName(){
        return secondName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
