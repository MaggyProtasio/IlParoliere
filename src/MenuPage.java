import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame {
    private JPanel panelMain;
    private JLabel image;
    private JPanel panelOut;
    private JButton easyModeBtn;
    private JButton specialBtn;
    private JButton mediumModeBtn;
    private JButton hardModeBtn;
    private JButton backBtn;

    public MenuPage(Utente giocatore){
        // Set the properties of the frame
        setContentPane(panelMain);
        setTitle("Menu Page");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        easyModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //crea partita
                Partita partita = new Partita(giocatore);
                EasyMode g = new  EasyMode(giocatore, partita);
                g.setVisible(true);
                dispose();
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartPage start = new StartPage();
                start.setVisible(true);
                dispose();
            }
        });
    }

}
