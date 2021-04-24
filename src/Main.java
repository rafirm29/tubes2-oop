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
        P.printPeta();
    }
}
