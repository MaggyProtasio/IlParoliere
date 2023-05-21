import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuPage extends JFrame {
    private JPanel panelMain;
    private JLabel image;
    private JPanel panelOut;
    private JButton easyModeBtn;
    private JButton specialBtn;
    private JButton hardModeBtn;
    private JButton backBtn;

    public MenuPage(Utente giocatore){
        // Set the properties of the frame
        setContentPane(panelMain);
        setTitle("WordCraft");
        setSize(800,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        easyModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
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
                buttonSound();
                StartPage start = new StartPage();
                start.setVisible(true);
                dispose();
            }
        });
        hardModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                //crea partita
                Partita partita = new Partita(giocatore);
                HardMode g = new  HardMode(giocatore, partita);
                g.setVisible(true);
                dispose();
            }
        });
        specialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                //crea partita
                Partita partita = new Partita(giocatore);
                SpecialMode g = new  SpecialMode(giocatore, partita);
                g.setVisible(true);
                dispose();
            }
        });
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
