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
            P.updatePeta(p1);
            P.printPeta();

            // Insert command
            String input = scanner.nextLine();

            switch (input) {
                case "w":
                    p1.up();
                    break;
                case "a":
                    p1.left();
                    break;
                case "s":
                    p1.down();
                    break;
                case "d":
                    p1.right();
                    break;
                default:
                    break;
            }
            turn++;
        }
    }
}
