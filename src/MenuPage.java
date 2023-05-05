import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame {
    private JPanel panelMain;
    private JLabel image;
    private JPanel panelOut;
    private JButton classicoBtn;
    private JButton timerBtn;

    public MenuPage(){
        // Set the properties of the frame
        setContentPane(panelMain);
        setTitle("Menu Page");
        setSize(760,560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        classicoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassicoGame g = new ClassicoGame();
                g.setVisible(true);
                dispose();
            }
        });
    }

}
