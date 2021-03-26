import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainInterface {

    private final JFrame jframe = new JFrame();
    private final JPanel jpanel = new JPanel(new GridLayout());

    public MainInterface(){
        jframe.setTitle("Database");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 450);
        jframe.setResizable(false);
        jframe.add(jpanel);
        jframe.setVisible(true);

        jpanel.setBounds(0,0, 400, 450);

    }








    public static void main(String[] args) throws IOException {
        Main main = new Main();
    }
}
