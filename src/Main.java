package src;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import src.Enums.*;
import src.Enums.Skills.SkillName;
import src.Enums.Species.SPECIES;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main {
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

        // INITIATE PETA
        Peta P = new Peta();
        P.makePeta("src/peta.txt");

        // INITIATE SCANNER
        Scanner scanner = new Scanner(System.in);

        // INITIATE GUI
        JFrame frame = new JFrame("Grid");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(P.getKolom() * 50, P.getBaris() * 50);

        JPanel panel = new JPanel();
        JPanel panelEngimon = new JPanel();
        panel.setLayout(new GridLayout(P.getBaris(), P.getKolom(), 1, 1));
        
        int turn = 0;
        boolean gameOn = true;
        boolean init = true;

        while (gameOn) {
            // Update and show peta
            P.spawnEngimons(turn, p1);
            P.addExpWildEngimons(turn);
            P.moveWildEngimons(turn);
            P.updatePeta(p1);
            System.out.println("Jumlah wild grass " + P.countEngGrass());
            System.out.println("Jumlah wild Mount " + P.countEngMountains());
            System.out.println("Jumlah wild Sea " + P.countEngSea());
            System.out.println("Jumlah wild tundra " + P.countEngTundra());
            P.printPeta();

            // Print on GUI
            panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            for (int i = 0; i < P.getBaris(); i++) {
                for (int j = 0; j < P.getKolom(); j++) {
                    String symbol = Character.toString(P.peta[i][j].getSymbol());
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
                    } else if (symbol.equals("N")) { // Pembantu
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/pembanturendah.jpg");
                        } else {
                            img = new ImageIcon("src/img/pembantutinggi.png");
                        }
                    } else if (symbol.equals("F")) { // Ikan
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/ikanrendah.png");
                        } else {
                            img = new ImageIcon("src/img/ikantinggi.png");
                        }
                    } else if (symbol.equals("U")) { // Putri duyung
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/mermaidrendah.png");
                        } else {
                            img = new ImageIcon("src/img/mermaidtinggi.jpg");
                        }
                    } else if (symbol.equals("I")) { // Iblis
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/iblisrendah.jpg");
                        } else {
                            img = new ImageIcon("src/img/iblistinggi.jpg");
                        }
                    } else if (symbol.equals("T")) { // Thor
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/thorrendah.jpg");
                        } else {
                            img = new ImageIcon("src/img/thortinggi.jpg");
                        }
                    } else if (symbol.equals("S")) { // Snowman
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/snowmanrendah.jpg");
                        } else {
                            img = new ImageIcon("src/img/snowmantinggi.jpg");
                        }
                    } else if (symbol.equals("D")) { // Dewa
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/zeusrendah.jpg");
                        } else {
                            img = new ImageIcon("src/img/zeustinggi.jpg");
                        }
                    } else if (symbol.equals("A")) { // Aurora
                        if (P.getEnemyNear(i, j).getLevel() <= p1.getActiveEngimon().getLevel()) {
                            img = new ImageIcon("src/img/aurorarendah.jpg");
                        } else {
                            img = new ImageIcon("src/img/auroratinggi.png");
                        }
                    } else {
                        img = new ImageIcon("");
                    }
                    
                    JLabel l = new JLabel(Character.toString(P.peta[i][j].getSymbol()));
                    l.setIcon(img);
                    System.out.print(Character.toString(P.peta[i][j].getSymbol()));
                    panel.add(l);
                }
                System.out.println("");
            }
            if (init) {
                frame.add(panel);
                init = false;
                // System.out.println("init");
            } else {
                frame.revalidate();
                frame.repaint();
                // System.out.println("validate");
            }

            // Insert command
            String input = scanner.nextLine();

            switch (input) {
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
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("tidak bisa keluar map");
                    }
                    break;
                case "showEngimons":
                    p1.viewEngimon();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                    break;
                case "showSkills":
                    p1.viewSkills();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                    break;
                case "changeName":
                    p1.changeName();
                    break;
                case "useSkill":
                    p1.useSkillItem();
                    break;
                case "help":
                    p1.help();
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                    break;
                case "swap":
                    p1.swapEngimon();
                    break;
                case "currentEngimon":
                    p1.getActiveEngimon().getInfo();
                    break;
                case "interact":
                    p1.getActiveEngimon().interact();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                    break;
                case "battle":
                    try {
                        if (p1.x != 0 && P.peta[p1.x-1][p1.y].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x-1, p1.y));
                            if (win) {
                                System.out.println("You win");
                                P.removeWildEngimon(P.getEnemyNear(p1.x-1, p1.y));
                            } else {
                                System.out.println("You lose");
                            }
                            TimeUnit.SECONDS.sleep(2);
                        } else if (p1.y != P.getKolom() - 1 && P.peta[p1.x][p1.y+1].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x, p1.y+1));
                            if (win) {
                                System.out.println("You win");
                                P.removeWildEngimon(P.getEnemyNear(p1.x, p1.y+1));
                            } else {
                                System.out.println("You lose");
                            }
                            TimeUnit.SECONDS.sleep(2);
                        } else if (p1.x != P.getBaris() - 1 && P.peta[p1.x+1][p1.y].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x+1, p1.y));
                            if (win) {
                                System.out.println("You win");
                                P.removeWildEngimon(P.getEnemyNear(p1.x+1, p1.y));
                            } else {
                                System.out.println("You lose");
                            }
                            TimeUnit.SECONDS.sleep(2);
                        } else if (p1.y != 0 && P.peta[p1.x][p1.y-1].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x, p1.y-1));
                            if (win) {
                                System.out.println("You win");
                                P.removeWildEngimon(P.getEnemyNear(p1.x, p1.y-1));
                            } else {
                                System.out.println("You lose");
                            }
                            TimeUnit.SECONDS.sleep(2);
                        } else {
                            System.out.println("No enemies nearby!");
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "breeding":
                    p1.breeding();
                    break;
                case "dropItem":
                    p1.dropItemHandler();
                    break;
                case "dropEngimon":
                    p1.dropEngimonHandler();
                    break;
                case "save":
                    SaveLoad save = new SaveLoad(p1);
                    try {
                        save.save("src/save.txt");
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "exit":
                    gameOn = false;
                    System.out.println("Goodbye!");
                    scanner.close();
                    break;
                // CHEATS
                case "motherlode":
                    for (PlayerEngimon e : p1.invEngimon.getList()) {
                        e.levelUp(100);
                    }
                    break;
                case "blessing":
                    p1.addToInventory(new SkillItem(SkillName.DIVINE_DEPARTURE));
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

            turn++;
        }
    }
}
