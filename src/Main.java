import javax.sound.sampled.*;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.io.IOException;

/**
 * Copyright (c) 2023, Anastasiya Kozemko, Alice Minuzzo, Brend Margarette Protasio
 * All rights reserved.
 *
 * This file is part of the WordCraft project.
 */

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException,LineUnavailableException {
        //inizia gioco
        StartPage s = new StartPage();

        //per audio background
        try {
            File file = new File("src/audio/musicMainLowVolume.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();       //inizia audio
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}