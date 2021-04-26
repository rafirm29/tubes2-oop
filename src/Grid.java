package src;

import src.Enums.Skills.SkillName;
import src.Enums.Species.SPECIES;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class Grid {
    public static void main(String[] args) throws FileNotFoundException {
        // INITIATE ENGIMONS
        PlayerEngimon xenojiva = new PlayerEngimon("Xeno ji'va", SPECIES.Dewa);
        xenojiva.addSkill(new Skill(SkillName.DIVINE_DEPARTURE));
        xenojiva.setLevel(5);
        PlayerEngimon lmaobox = new PlayerEngimon("LMAO BOX", SPECIES.Aurora);
        lmaobox.setLevel(5);

        // INITIATE SKILLITEMS
        SkillItem redhawk_item = new SkillItem(SkillName.RED_HAWK);
        SkillItem mamaragan_item = new SkillItem(SkillName.MAMARAGAN);
        SkillItem mamaragan_item2 = new SkillItem(SkillName.MAMARAGAN);

        // INITIATE PLAYER
        
        Player p1 = new Player(xenojiva);
        p1.getActiveEngimon().getInfo();
        p1.addToInventory(lmaobox);
        p1.addToInventory(redhawk_item);
        p1.addToInventory(mamaragan_item);
        p1.addToInventory(mamaragan_item2);

        Peta P = new Peta();
        P.makePeta("src/peta.txt");
        // System.out.println(P.getBaris());
        // System.out.println(P.getKolom());

        JFrame frame = new JFrame("Grid");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(P.getKolom() * 50, P.getBaris() * 50);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(P.getBaris(), P.getKolom(), 1, 1));

        // JPanel panelInput = new JPanel();
        // JTextField CommandInput = new JTextField("", 30);
        // String getCommand = CommandInput.getText();
        // panelInput.add(CommandInput);

        Scanner scn = new Scanner(System.in);
        boolean init = true;
        boolean gameOn = true;

        while (gameOn) {
            P.updatePeta(p1);
            P.printPeta();

            panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            for (Tile[] baris : P.peta) {
                for (Tile kolom : baris) {
                    String symbol = Character.toString(kolom.getSymbol());
                    ImageIcon img;
                    if (symbol.equals("-")) {
                        img = new ImageIcon("src/img/grass.png");
                    } else if (symbol.equals("o")) {
                        img = new ImageIcon("src/img/sea.jpg");
                    } else if (symbol.equals("^")) {
                        img = new ImageIcon("src/img/tundra.jpg");
                    } else if (symbol.equals("*")) {
                        img = new ImageIcon("src/img/mountain.jpg");
                    } else if (symbol.equals("P")) {
                        img = new ImageIcon("src/img/player.jpg");
                    } else if (symbol.equals("X")) {
                        img = new ImageIcon("src/img/engimon.png");
                    } else {
                        img = new ImageIcon("");
                    }
                    
                    JLabel l = new JLabel(Character.toString(kolom.getSymbol()));
                    l.setIcon(img);
                    System.out.print(Character.toString(kolom.getSymbol()));
                    panel.add(l);
                }
                System.out.println("");
            }
            if (init) {
                frame.add(panel);
                // frame.add(panelInput);
                init = false;
                System.out.println("init");
            } else {
                frame.revalidate();
                frame.repaint();
                System.out.println("validate");
            }
            
            String input = scn.nextLine();

            switch (input) {
                case "0":
                    gameOn = false;
                    break;
                    case "w":
                    try {
                        if (!P.peta[p1.x -1][p1.y].isOccupied
                        && !P.peta[p1.x -1][p1.y].isOccupiedplayer) {
                        P.removeOccupierplayer(p1.x, p1.y);
                        P.removeOccupierplayer(p1.aex, p1.aey);
                        p1.up();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("tidak bisa keluar map");
                    }
                    break;
                case "a":
                    try {
                        if (!P.peta[p1.x][p1.y-1].isOccupied
                        && !P.peta[p1.x][p1.y-1].isOccupiedplayer) {
                        P.removeOccupierplayer(p1.x, p1.y);
                        P.removeOccupierplayer(p1.aex, p1.aey);
                        p1.left();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("tidak bisa keluar map");
                    }
                    break;
                case "s":
                    try {
                        if (!P.peta[p1.x +1][p1.y].isOccupied
                        && !P.peta[p1.x +1][p1.y].isOccupiedplayer) {
                        P.removeOccupierplayer(p1.x, p1.y);
                        P.removeOccupierplayer(p1.aex, p1.aey);
                        p1.down();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("tidak bisa keluar map");
                    }
                    break;
                case "d":
                    try {
                        if (!P.peta[p1.x][p1.y+1].isOccupied
                        && !P.peta[p1.x][p1.y+1].isOccupiedplayer) {
                        P.removeOccupierplayer(p1.x, p1.y);
                        P.removeOccupierplayer(p1.aex, p1.aey);
                        p1.right();
                        System.out.println("Moving right");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("tidak bisa keluar map");
                    }
                    break;
                default:
                    break;
            }

            // Remove panel to update
            Component[] cList = panel.getComponents();
            for (Component c : cList) {
                panel.remove(c);
            }
            panel.revalidate();
            panel.repaint();
        }
    }
}
