import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainInterface implements ActionListener {

    // JFrame and JPanel Objects
    private final JFrame jframe = new JFrame();
    private final JPanel headerPanel = new JPanel(new FlowLayout());
    private final JPanel tablePanel = new JPanel(new BorderLayout());

    // JButton Objects
    private final JButton insertButton = new JButton();
    private final JButton deleteButton = new JButton();

    // JTable Objects
    private final JTable userTable = new JTable();

    // JLabel Objects
    private final JLabel usernameLabel = new JLabel();

    // User
    String userLogged = "";

    public MainInterface(String userLogged) throws SQLException {
        this.userLogged = userLogged;
        // Frame Information
        jframe.setTitle("Database");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 425);
        jframe.setResizable(false);
        jframe.add(headerPanel);
        jframe.add(tablePanel);
        jframe.setVisible(true);

        // Panel Information
        headerPanel.setBounds(0,350,400,100);
        headerPanel.add(insertButton);
        headerPanel.add(deleteButton);
        headerPanel.add(usernameLabel);
        tablePanel.setBounds(0,0, 400, 350);
        tablePanel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        // Button Information
        insertButton.setBounds(25,15,100,25);
        insertButton.setText("Insert");
        deleteButton.setBounds(130,15,100,25);
        deleteButton.setText("Delete");

        // Label Information
        usernameLabel.setText("Welcome: " +userLogged);

        // ActionListeners
        insertButton.addActionListener(this);

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
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

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

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?", "root", "test");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insertButton){
            new InsertInterface(this);
        }
    }

    public void updateInterface(){
        tablePanel.revalidate();
        tablePanel.repaint();
    }
}



