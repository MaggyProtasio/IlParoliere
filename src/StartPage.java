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
        //intialize();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(startButton, "Hello " + nomeBox.getText() );
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

    private void intialize(){
        frameStartPage = new JFrame();
        frameStartPage.setBounds(100, 100, 795, 395);
        frameStartPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMain = new JPanel(); // initialize panel1
        frameStartPage.getContentPane().add(panelMain); // add panel1 to the content pane
        panelMain.setLayout(null); // set the layout manager of panel1 to null
    }



}
