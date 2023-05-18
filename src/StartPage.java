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
        this.setResizable(false);
        this.setContentPane(this.panelMain);
        this.setTitle("Start");
        this.setSize(760,510);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //crea utente base del nome inserito
                Utente giocatore = new Utente(nomeBox.getText());
                //lo passa giocatore cosi si può memorizzare il nome
                MenuPage m = new MenuPage(giocatore);
                m.setVisible(true);
                dispose();
            }
        });
    }


}
