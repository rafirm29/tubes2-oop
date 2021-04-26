import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Game{
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton;
    JTextArea mainTextArea;
    Graphics g;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    public static void main(String[] args){
        new Game();
    }

    public Game(){
        window =  new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel =  new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel =  new JLabel("TUBES");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.white);
        titleNamePanel.add(titleNameLabel);
        

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setFont(normalFont);
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButtonPanel.add(startButton);
        startButton.addActionListener(tsHandler);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void inGame(){

        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        mainTextPanel =  new JPanel();
        mainTextPanel.setFocusable(true);
        mainTextPanel.requestFocus();
        mainTextPanel.setBackground(Color.blue);
        mainTextPanel.setBounds(100, 100, 600, 600);
        Image test = new ImageIcon("directory gambar").getImage();
        g.drawImage(test, 200, 200, null);
        con.add(mainTextPanel);
        // mainTextArea = new JTextArea("Petanya nanti diload disini");
        // mainTextArea.setBounds(100, 100, 600, 250);
        // mainTextArea.setBackground(Color.black);
        // mainTextArea.setForeground(Color.white);
        // mainTextArea.setFont(normalFont);
        // mainTextArea.setLineWrap(true);
        // mainTextPanel.add(mainTextArea);
        
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            inGame();
        }
    }
}