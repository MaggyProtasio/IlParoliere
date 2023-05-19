import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MainprovaTimer {
    JFrame window; //esempio di stampa timer
    JLabel counterLabel;
    Font font1 = new Font("Arial",Font.PLAIN,70);

    //timer di javaswing
    Timer timer;
    String ddSecondi, ddMinuti; //riferiti per i decimali
    DecimalFormat dFormat = new DecimalFormat("00"); //mi serve per fare 00
    int secondi,minuti;

    public MainprovaTimer(){

        //per window dove stampa timer
        window = new JFrame();
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        //inizializzazione jlabel
        counterLabel = new JLabel();//dentro ci metti il text
        counterLabel.setBounds(300,230,200,100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);  //per centrare
        counterLabel.setFont(font1);

        window.add(counterLabel);
        window.setVisible(true);

        //per defualt
        counterLabel.setText("05:00"); //metti minuti necessari
        secondi = 0;
        minuti = 5; //metti anche qui, 5 esempio
        timer();
        //faccio partire timer, per stop - timer.stop()
        timer.start();
    }

    public void timer(){
        //argomento ha la velocita update del timer [1000 = 1sec]
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //scrivi che cosa succede quando timer updata (ogni sec)
                secondi--;

                //converto 1 in 01, secondi in forma decimale
                ddSecondi = dFormat.format(secondi);
                ddMinuti = dFormat.format(minuti);
                //per mostrare timer su window - crescente
                counterLabel.setText(ddMinuti + ":" + ddSecondi);

                if(secondi == -1){ //-1 perche è tricky, non mettiamo 60 su orologio ma 59
                    secondi = 59;
                    minuti--;

                    ddSecondi = dFormat.format(secondi);
                    ddMinuti = dFormat.format(minuti);
                    counterLabel.setText(ddMinuti + ":" + ddSecondi);
                }

                //tempo scaduto!
                if(minuti == 0 && secondi == 0){
                    timer.stop();
                }
            }
        });

    }
}
