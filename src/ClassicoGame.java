import javax.swing.*;

public class ClassicoGame extends JFrame {
    private JPanel panelMain;
    private JLabel image;
    private JTextField parolaInserito;
    private JButton inviaBtn;
    private JPanel PanelMatrice;
    private JPanel panelCronologia;
    private JButton lett1;
    private JButton lett2;
    private JButton aButton3;
    private JButton aButton4;
    private JButton aButton5;
    private JButton aButton6;
    private JButton aButton7;
    private JButton aButton8;
    private JButton aButton9;
    private JButton aButton10;
    private JButton aButton11;
    private JButton aButton12;
    private JButton aButton13;
    private JButton aButton14;
    private JButton aButton15;
    private JButton aButton16;
    private JButton aButton17;
    private JButton aButton18;
    private JButton aButton19;
    private JButton aButton;
    private JButton aButton20;
    private JButton aButton21;
    private JButton aButton22;
    private JButton aButton23;
    private JButton aButton24;
    private JButton aButton25;
    private JButton aButton26;
    private JButton aButton27;
    private JButton aButton28;
    private JButton aButton29;
    private JButton aButton30;
    private JButton aButton31;
    private JButton aButton32;
    private JButton aButton33;
    private JButton aButton34;
    private JButton aButton35;
    private JButton exitBtn;
    private JLabel nomeBox;

    public ClassicoGame(Utente giocatore){
        // Set the properties of the frame
        setContentPane(panelMain);
        setTitle("Menu Page");
        setSize(1300,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nomeBox.setText("Player: " + giocatore.getNickname());
    }
}
