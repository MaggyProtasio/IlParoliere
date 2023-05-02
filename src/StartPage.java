import javax.swing.*;

import java.awt.EventQueue;

public class StartPage {
    private JPanel panel1;
    private JButton startButton;
    private JLabel image;
    JFrame frameStartPage;

    //run application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartPage window = new StartPage();
                    window.frameStartPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //costruttore
    public StartPage(){
        intialize();
    }

    private void intialize(){
        frameStartPage = new JFrame();
        frameStartPage.setResizable(false);
        frameStartPage.setBounds(100, 100, 795, 395);
        frameStartPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel(); // initialize panel1
        frameStartPage.getContentPane().add(panel1); // add panel1 to the content pane
        panel1.setLayout(null); // set the layout manager of panel1 to null
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


}
