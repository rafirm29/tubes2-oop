import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Peta P = new Peta();
        System.out.println(P.getBaris());
        System.out.println(P.getKolom());
        P.makePeta("peta.txt");
        P.printPeta();
    }
}
