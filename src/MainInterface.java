import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        // Table Information
        String[] columnNames = {"Firstname", "Surname", "Username", "Password"};
        String[][] data = {{"Sean", "Sanii Nejad", "username", "password"}};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        userTable.setBounds(25,100,250, 300);
        userTable.setModel(model);

        String sql = "SELECT * FROM users";
        PreparedStatement statement = getConnection().prepareStatement(sql);
    }

    public static void main(String[] args) throws IOException, SQLException {
        MainInterface main = new MainInterface();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?", "root", "test");
    }
}
