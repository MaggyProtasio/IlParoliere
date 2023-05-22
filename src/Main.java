import javax.sound.sampled.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Copyright (c) 2023, Anastasiya Kozemko, Alice Minuzzo, Brend Margarette Protasio
 * All rights reserved.
 *
 * This file is part of the WordCraft project.
 */

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException,LineUnavailableException {
        //creazione dizionario e variabili
        Dizionario diz = new Dizionario();
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        Utente giocatore = new Utente("sdf");

        Partita partita = new Partita(giocatore);
        //inizia gioco con GUI
        StartPage s = new StartPage();

        //per audio background ----------------------------------------------
        try {
            File file = new File("src/audio/musicMainLowVolume.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start(); // Start playing the audio

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}