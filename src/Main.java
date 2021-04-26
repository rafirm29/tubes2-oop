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
        
        int turn = 0;
        boolean gameOn = true;
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
                case "exit":
                    gameOn = false;
                    System.out.println("Goodbye!");
                    scanner.close();
                default:
                    break;
            }
            turn++;
        }
    }
}
