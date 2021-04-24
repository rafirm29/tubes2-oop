package src;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import src.Enums.*;
import src.Enums.Species.SPECIES;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // INITIATE PLAYER
        PlayerEngimon xenojiva = new PlayerEngimon("Xeno ji'va", SPECIES.Dewa);
        Player p1 = new Player(xenojiva);
        p1.getActiveEngimon().getInfo();

        // INITIATE PETA
        Peta P = new Peta();
        P.makePeta("src/peta.txt");

        // INITIATE SCANNER
        Scanner scanner = new Scanner(System.in);
        
        int turn = 0;
        while (true) {
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
                default:
                    break;
            }
            turn++;
        }
    }
}
