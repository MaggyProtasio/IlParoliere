import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame {
    private JPanel panelMain;
    private JButton startButton;
    private JLabel image;
    private JTextField nomeBox;
    private JPanel panelNome;
    JFrame frameStartPage;

    //costruttore
    public StartPage(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPage m = new MenuPage();
                m.setVisible(true);
                dispose();
            }
        });
    }

    //costruttore
    public static void main(String[] args) {
        StartPage s = new StartPage();
        s.setResizable(false);
        s.setContentPane(s.panelMain);
        s.setTitle("Start");
        s.setSize(760,510);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
