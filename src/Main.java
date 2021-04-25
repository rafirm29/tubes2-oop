package src;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import src.Enums.*;
import src.Enums.Skills.SkillName;
import src.Enums.Species.SPECIES;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // INITIATE ENGIMONS
        PlayerEngimon xenojiva = new PlayerEngimon("Xeno ji'va", SPECIES.Dewa);
        PlayerEngimon lmaobox = new PlayerEngimon("LMAO BOX", SPECIES.Aurora);

        // INITIATE SKILLITEMS
        SkillItem redhawk_item = new SkillItem(SkillName.RED_HAWK);
        SkillItem mamaragan_item = new SkillItem(SkillName.MAMARAGAN);

        // INITIATE PLAYER
        
        Player p1 = new Player(xenojiva);
        p1.getActiveEngimon().getInfo();
        p1.addToInventory(lmaobox);
        p1.addToInventory(redhawk_item);
        p1.addToInventory(mamaragan_item);

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
                case "inventoryengimon":
                    p1.viewEngimon();
                    break;
                case "inventoryskill":
                    p1.showInventorySkill();
                    break;
                case "changename":
                    p1.changeName();
                    break;
                case "useskill":
                    p1.useSkillItem();
                    break;
                case "help":
                    p1.help();
                    break;
                case "swap":
                    p1.swapEngimon();
                    break;
                case "interact":
                    p1.getActiveEngimon().interact();
                    break;
                case "battle":
                    try {
                        if (p1.x != 0 && P.peta[p1.x-1][p1.y].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x-1, p1.y));
                            if (win) {
                                System.out.println("You win");
                            } else {
                                System.out.println("You lose");
                            }  
                        } else if (p1.y != P.getKolom() - 1 && P.peta[p1.x][p1.y+1].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x, p1.y+1));
                            if (win) {
                                System.out.println("You win");
                            } else {
                                System.out.println("You lose");
                            }
                        } else if (p1.x != P.getBaris() - 1 && P.peta[p1.x+1][p1.y].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x+1, p1.y));
                            if (win) {
                                System.out.println("You win");
                            } else {
                                System.out.println("You lose");
                            }
                        } else if (p1.y != 0 && P.peta[p1.x][p1.y-1].isOccupied) {
                            boolean win = p1.battle(P.getEnemyNear(p1.x, p1.y-1));
                            if (win) {
                                System.out.println("You win");
                            } else {
                                System.out.println("You lose");
                            }
                        } else {
                            System.out.println("No enemies nearby!");
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
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
