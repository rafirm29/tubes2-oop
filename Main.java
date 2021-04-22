import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Enums.*;
import Enums.Species.SPECIES;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PlayerEngimon xenojiva = new PlayerEngimon("Xeno ji'va", SPECIES.Dewa);
        Player p1 = new Player(xenojiva);
        p1.getActiveEngimon().getInfo();

        Peta P = new Peta();
        System.out.println(P.getBaris());
        System.out.println(P.getKolom());
        P.makePeta("peta.txt");
        P.printPeta();
    }
}
