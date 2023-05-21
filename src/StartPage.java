import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class StartPage extends JFrame {
    private JPanel panelMain;
    private JButton startButton;
    private JLabel image;
    private JTextField nomeBox;
    private JPanel panelNome;
    JFrame frameStartPage;

    //costruttore
    public StartPage(){
        //icona
        ImageIcon icon = new ImageIcon("src/img/Logo.png");
        this.setIconImage(icon.getImage());
        //set the properties of the frame
        this.setResizable(false);
        this.setContentPane(this.panelMain);
        this.setTitle("WordCraft");
        this.setSize(760,510);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                buttonSound();

                //crea utente base del nome inserito
                Utente giocatore = new Utente(nomeBox.getText());

                //lo passa giocatore cosi si può memorizzare il nome
                MenuPage m = new MenuPage(giocatore);
                m.setVisible(true);
                dispose();
            }
        });

        //se preme enter tasto
        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            buttonSound();
            //crea utente base del nome inserito
            Utente giocatore = new Utente(nomeBox.getText());

            //lo passa giocatore cosi si può memorizzare il nome
            MenuPage m = new MenuPage(giocatore);
            m.setVisible(true);
            dispose();
            }
        };

        nomeBox.addActionListener(enterAction);
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
}
