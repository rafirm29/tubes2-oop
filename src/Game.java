import java.awt.color.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startbutton, mainTextPanel;
    JLabel titlenameLabel,startbuttonlabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN,30);
    Font normal = new Font("Times New Roman", Font.PLAIN, 20);
    JTextArea mainTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args){
        new Game();
    }
    public Game(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con =  window.getContentPane();

        titleNamePanel =  new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titlenameLabel =  new JLabel("Willy Wangky and the Engimon Factory");
        titlenameLabel.setForeground(Color.white);
        titlenameLabel.setFont(titleFont);

        startbutton =  new JPanel();
        startbutton.setBounds(300,400,200,100);
        startbutton.setBackground(Color.black);
        startbuttonlabel = new JLabel("Start");
        startbuttonlabel.setBackground(Color.black);
        startbuttonlabel.setForeground(Color.white);
        startbuttonlabel.setFont(normal);
        startbuttonlabel.addActionListener(tsHandler);

        titleNamePanel.add(titlenameLabel);
        startbutton.add(startbuttonlabel);

        con.add(titleNamePanel);
        con.add(startbutton);
    }

    public void inGame(){
        titleNamePanel.setVisible(false);
        startbutton.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.blue);
        con.add(mainTextPanel);

        mainTextArea  =  new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normal);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            inGame();
        }
    }
}
