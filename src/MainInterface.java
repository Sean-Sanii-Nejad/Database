import javax.swing.*;
import java.io.IOException;

public class MainInterface {

    private final JFrame jframe = new JFrame();

    public MainInterface(){
        jframe.setTitle("Database");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 450);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }








    public static void main(String[] args) throws IOException {
        Main main = new Main();
    }
}
