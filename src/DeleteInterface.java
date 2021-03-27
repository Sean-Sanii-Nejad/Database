import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteInterface implements ActionListener {
    private MainInterface context;

    // JFrame and JPanel Objects
    private final JFrame jframe = new JFrame();
    private final JPanel panel = new JPanel(new FlowLayout());

    // JTextField Objects
    private final JComboBox<String> username = new JComboBox();

    // JButton Objects
    private final JButton deleteButton = new JButton();

    DeleteInterface(MainInterface context) throws SQLException {
        this.context = context;
        // Frame Information
        jframe.setTitle("Delete Account");
        jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jframe.setSize(315, 75);
        jframe.setResizable(false);
        jframe.add(panel);
        jframe.setVisible(true);

        // Panel Information
        panel.add(username);
        panel.add(deleteButton);
        panel.setBounds(0,0,315,75);

        username.setBounds(75,5,150,25);
        deleteButton.setText("Delete");
        deleteButton.addActionListener(this);

        ArrayList<User> arrayList = new ArrayList();
        String sql = "SELECT username FROM users";
        PreparedStatement statement = Model.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            username.addItem(result.getString(1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deleteButton){
            try {
                ArrayList<User> arrayList = new ArrayList();
                String sql = "DELETE FROM users WHERE username =?;";
                PreparedStatement statement = Model.getConnection().prepareStatement(sql);
                statement.setString(1, username.getSelectedItem().toString());
                statement.executeUpdate();
                context.setTable();
            } catch(SQLException error){
                error.printStackTrace();
            }
        }
    }
}
