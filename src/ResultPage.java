import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.*;
import java.io.File;

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
        //icona
        ImageIcon icon = new ImageIcon("src/img/Logo.png");
        this.setIconImage(icon.getImage());
        //suono
        playSound();
        //set the properties of the frame
        setContentPane(panelMain);
        setTitle("WordCraft - Results");
        setSize(800,600);
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
                buttonSound();
                dispose(); //chiude la pagina result
                MenuPage menu = new MenuPage(g);
                menu.setVisible(true);
            }
        });

        //ActionListener per far funzionare il bottone "Exit"
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                dispose(); //chiude la pagina result
                StartPage start = new StartPage();
                start.setVisible(true);
            }
        });
    }
    public void playSound(){
        File file = new File("src/audio/fineGioco.wav");
        AudioInputStream audiostream = null;
        try {
            audiostream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        try {
            clip.open(audiostream);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        clip.start(); //per far inizare l'audio
    }
    public void buttonSound(){
        File file = new File("src/audio/buttonPress.wav");
        AudioInputStream audiostream = null;
        try {
            audiostream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        try {
            clip.open(audiostream);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        clip.start(); //per far inizare l'audio
    }
    private void createUIComponents() {
    }
}
