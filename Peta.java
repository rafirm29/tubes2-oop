import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Peta {
    private int baris;
    private int kolom;
    // private ArrayList<WildEngimon> wildEngimons;
    public Tile[][] peta;

    public int getBaris() { return this.baris;}
    public int getKolom() { return this.kolom;}

    public Peta() throws FileNotFoundException {
        int baris = 0;
        int kolom = 0;
        File file = new File("peta.txt");
        Scanner scan = new Scanner(file);
        String lines ="";
        StringBuilder sb = new StringBuilder();
        while (scan.hasNextLine()) {
            baris++;
            lines = scan.nextLine();
            kolom = lines.length();
        }
        this.baris = baris;
        this.kolom = kolom;
        this.peta = new Tile[baris][kolom];
        for(int i=0;i<baris;i++) {
            for(int j=0;j<kolom;j++) {
                this.peta[i][j]= new Tile();
            }
        }

    }
    public void makePeta(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        String lines ="";
        int i=0;
        String[] read = new String[baris];
        char[][] map = new char[baris][kolom];
        while(scan.hasNextLine()) {
            lines = scan.nextLine();
            read[i] = lines;
            for(int j=0; j<this.kolom; j++) {
                map[i] = read[i].toCharArray();
            }
            i++;
        }
        for(i=0;i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                this.peta[i][j].setX(i);
                this.peta[i][j].setY(j);
                this.peta[i][j].setTerrain(map[i][j]);
                this.peta[i][j].setSymbol(map[i][j]);
            }
        }
    }

    /**
     * Mengupdate kondisi peta
     * setiap pergantian turn
     */
    public void updatePeta() {
        // for (WildEngimon eng : wildEngimons) {
        //     int x = eng.getX();
        //     int y = eng.getY();
        //     peta[x][y].setEngimon('E');
        // }
    }

    public void printPeta() {
        for(int i=0; i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                System.out.print(this.peta[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public void spawnEngimons() {
        
    }
}