import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.border.LineBorder;
import java.awt.geom.RoundRectangle2D;

/**
 * Copyright (c) 2023, Anastasiya Kozemko, Alice Minuzzo, Brend Margarette Protasio
 * All rights reserved.
 *
 * This file is part of the WordCraft project.
 */

public class EasyMode extends JFrame {
    private JPanel panelMain;
    private JLabel image;
    private JTextField parolaInput;
    private JButton sendBtn;
    private JPanel PanelMatrice;
    private JPanel panelCronologia;
    private JButton exitBtn;
    private JLabel nomeBox;
    private JButton Lettera1;
    private JButton Lettera2;
    private JButton Lettera3;
    private JButton Lettera4;
    private JButton Lettera5;
    private JButton Lettera6;
    private JButton Lettera7;
    private JButton Lettera8;
    private JButton Lettera9;
    private JButton Lettera10;
    private JButton Lettera11;
    private JButton Lettera12;
    private JButton Lettera13;
    private JButton Lettera14;
    private JButton Lettera15;
    private JButton Lettera16;
    private JButton Lettera17;
    private JButton Lettera18;
    private JButton Lettera19;
    private JButton Lettera20;
    private JButton Lettera21;
    private JButton Lettera22;
    private JButton Lettera23;
    private JButton Lettera24;
    private JButton Lettera25;
    private JButton Lettera26;
    private JButton Lettera27;
    private JButton Lettera28;
    private JButton Lettera29;
    private JButton Lettera30;
    private JButton Lettera31;
    private JButton Lettera32;
    private JButton Lettera33;
    private JButton Lettera34;
    private JButton Lettera35;
    private JButton Lettera36;
    private JButton Lettera37;
    private JButton Lettera38;
    private JButton Lettera39;
    private JButton Lettera40;
    private JButton Lettera41;
    private JButton Lettera42;
    private JButton Lettera43;
    private JButton Lettera44;
    private JButton Lettera45;
    private JButton Lettera46;
    private JButton Lettera47;
    private JButton Lettera48;
    private JButton Lettera49;
    private JButton Lettera50;
    private JButton Lettera51;
    private JButton Lettera52;
    private JButton Lettera53;
    private JButton Lettera54;
    private JButton Lettera55;
    private JButton Lettera56;
    private JButton Lettera57;
    private JButton Lettera58;
    private JButton Lettera59;
    private JButton Lettera60;
    private JButton Lettera61;
    private JButton Lettera62;
    private JButton Lettera63;
    private JButton Lettera64;
    private JButton Lettera65;
    private JButton Lettera66;
    private JButton Lettera67;
    private JButton Lettera68;
    private JButton Lettera69;
    private JButton Lettera70;
    private JButton Lettera71;
    private JButton Lettera72;
    private JButton Lettera73;
    private JButton Lettera74;
    private JButton Lettera75;
    private JButton Lettera76;
    private JButton Lettera77;
    private JButton Lettera78;
    private JButton Lettera79;
    private JButton Lettera80;
    private JButton Lettera81;
    private JButton Lettera82;
    private JButton Lettera83;
    private JButton Lettera84;
    private JButton Lettera85;
    private JButton Lettera86;
    private JButton Lettera87;
    private JButton Lettera88;
    private JButton Lettera89;
    private JButton Lettera90;
    private JButton Lettera91;
    private JButton Lettera92;
    private JButton Lettera93;
    private JButton Lettera94;
    private JButton Lettera95;
    private JButton Lettera96;
    private JButton Lettera97;
    private JButton Lettera98;
    private JButton Lettera99;
    private JButton Lettera100;
    private JPanel panelParoleTrovate;
    private JLabel labelParoleTrovate;
    private JLabel labelPunti;
    private JLabel labelTimer;
    private JLabel sampleLabel;

    public boolean stopTimer = false;       //per fermare timer quando giocatore esce dal gioco

    //costruttore
    public EasyMode(Utente g, Partita p){
        //icona
        ImageIcon icon = new ImageIcon("src/img/Logo.png");
        this.setIconImage(icon.getImage());
        // Set the properties of the frame
        setContentPane(panelMain);
        setTitle("WordCraft - Normal mode");
        setSize(1400,780);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //scrive nome giocatore nello box
        nomeBox.setText("Player " + g.getNickname());

        //inizializza dizionario
        Dizionario diz = new Dizionario();
        diz.inizializzaWords();   //mette tutti parole comuni nell'array per usarlo dopo

        //inizializza timer
        int mintmp = 3;         //3 minuti per normal mode
        labelTimer.setText("0"+ mintmp +":00"); //metti minuti necessari
        secondi = 0;
        minuti = mintmp;        //metti anche qui, 5 esempio
        onTimer(p,g);
        //faccio partire timer, per stop - timer.stop()
        timer.start();

        //carica matrice e mette nei bottoni
        p.creaMatrice(diz.getWords());
        char[][] m = p.getMatrice();        //metto matrice qui in locale
        int buttonIndex = 1;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                String buttonName = "Lettera" + buttonIndex;
                JButton button = getButtonByName(buttonName);

                if (button != null) {
                    button.setText(String.valueOf(m[i][j]));
                }

                buttonIndex++;
            }
        }
        p.stampaMatrice();
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopTimer = true;
                MenuPage menu = new MenuPage(g);
                menu.setVisible(true);
                dispose();
            }
        });

        //quando si preme enter key si fa la stessa azione
        String listaParole =  "<html>";
        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parolaInserita = parolaInput.getText();

                //controlla se parola esiste nella matrice
                String parolaInseritaUpper = parolaInserita.toUpperCase();
                boolean trovata = p.trovaParolaMatrice(parolaInseritaUpper);
                if (trovata) {
                    System.out.println("Parola " + parolaInserita + " esiste nella matrice!");

                    //controlla se parola esiste nel dizionario
                    if (diz.trovaParoladiz(parolaInserita)) {
                        if (p.doppione(parolaInserita) == false) {
                            playCorrectWord();
                            System.out.println("Parola trovata nel dizionario!");
                            p.aggiungiPunti(parolaInserita);
                            System.out.println("Punti della parola: " + p.puntiParola(parolaInserita));
                            //aggiorna punti totali
                            labelPunti.setText(p.getPuntiTotali() + " pts");
                            p.contaParola();            //contatore
                            //mette nella lista di parole
                            String listaParole =  "<html>" + labelParoleTrovate.getText();
                            labelParoleTrovate.setText( listaParole + "<br>"+ parolaInserita);
                        } else {
                            playWrongWord();
                            System.out.println("Hai già inserito questa parola >:(");
                        }
                    } else {
                        playWrongWord();
                        System.out.println("Questa parola non esiste nel dizionario >:(");
                    }
                } else {
                    playWrongWord();
                    System.out.println("Parola " + parolaInserita + " non esiste nella matrice :(");
                }
                parolaInput.setText("");        //cancella input quando preme invio
            }
        };
        parolaInput.addActionListener(enterAction);

        //stessa funzione ma se si tocca bottone
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parolaInserita = parolaInput.getText();

                //controlla se parola esiste nella matrice
                String parolaInseritaUpper = parolaInserita.toUpperCase();
                boolean trovata = p.trovaParolaMatrice(parolaInseritaUpper);
                if (trovata) {
                    System.out.println("Parola " + parolaInserita + " esiste nella matrice!");

                    //controlla se parola esiste nel dizionario
                    if (diz.trovaParoladiz(parolaInserita)) {
                        if (p.doppione(parolaInserita) == false) {
                            playCorrectWord();
                            System.out.println("Parola trovata nel dizionario!");
                            p.aggiungiPunti(parolaInserita);
                            System.out.println("Punti della parola: " + p.puntiParola(parolaInserita));
                            //aggiorna punti totali
                            labelPunti.setText(p.getPuntiTotali() + " pts");
                            p.contaParola();            //contatore
                            //mette nella lista di parole
                            String listaParole =  "<html>" + labelParoleTrovate.getText();
                            labelParoleTrovate.setText( listaParole + "<br>"+ parolaInserita);
                        } else {
                            playWrongWord();
                            System.out.println("Hai già inserito questa parola >:(");
                        }
                    } else {
                        playWrongWord();
                        System.out.println("Questa parola non esiste nel dizionario >:(");
                    }
                } else {
                    playWrongWord();
                    System.out.println("Parola " + parolaInserita + " non esiste nella matrice :(");
                }
                parolaInput.setText("");        //cancella input quando preme invio
            }
        });
    }

    private JButton getButtonByName(String buttonName) {
        try {
            return (JButton) getClass().getDeclaredField(buttonName).get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    //timer di javaswing
    Timer timer;
    String ddSecondi, ddMinuti; //riferiti per i decimali
    DecimalFormat dFormat = new DecimalFormat("00"); //mi serve per fare 00
    int secondi,minuti;
    int mintmp = 0; //variabile per modificare il tempo in base alle modalità

    public void onTimer(Partita p, Utente g){
        //argomento ha la velocita update del timer [1000 = 1sec]
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //scrivi che cosa succede quando timer updata (ogni sec)
                secondi--;

                //converto 1 in 01, secondi in forma decimale
                ddSecondi = dFormat.format(secondi);
                ddMinuti = dFormat.format(minuti);

                //per mostrare timer su window - decrescente
                labelTimer.setText(ddMinuti + ":" + ddSecondi);

                if(secondi == -1){ //-1 perche è tricky, non mettiamo 60 su orologio ma 59
                    secondi = 59;
                    minuti--;

                    ddSecondi = dFormat.format(secondi);
                    ddMinuti = dFormat.format(minuti);
                    labelTimer.setText(ddMinuti + ":" + ddSecondi);
                }

                //tempo scaduto!
                if(minuti == 0 && secondi == 0 ){
                    timer.stop();
                    ResultPage result = new ResultPage(p,g);
                    result.setVisible(true);
                    parolaInput.disable();
                    dispose();
                }
                if(stopTimer == true){
                    timer.stop();
                }
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

    public void playWrongWord(){
        File file = new File("src/audio/wrongWord.wav");
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

    public void playCorrectWord(){
        File file = new File("src/audio/correctWord.wav");
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
