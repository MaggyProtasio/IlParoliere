import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage extends JFrame {
    private JButton retryButton; // manda alla pagina di menu
    private JButton exitButton; //manda alla home
    private JPanel labelPunti;
    private JPanel panelMain;
    private JLabel paroleTrovate;
    private JLabel parolaMigliore;
    private JLabel puntiTotali;

    //costruttore
    public ResultPage(Partita p, Utente g){
        setContentPane(panelMain);
        setTitle("WordCraft - Results");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //modifica label punteggio
        String punti = Integer.toString(p.getPuntiTotali());
        puntiTotali.setText(punti);
        //modifica label parole trovate
        String numParole = Integer.toString(p.getParolaNum());
        paroleTrovate.setText(numParole);
        p.controllaParolaMigliore();
        //modifica label parola migliore
        parolaMigliore.setText(p.getParolaMigliore());

        //ActionListener per far funzionare il bottone "Retry"
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //chiude la pagina result
                MenuPage menu = new MenuPage(g);
                menu.setVisible(true);
            }
        });

        //ActionListener per far funzionare il bottone "Exit"
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //chiude la pagina result
                StartPage start = new StartPage();
                start.setVisible(true);
            }
        });
    }
    private void createUIComponents() {

    }
}
