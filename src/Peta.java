package src;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.security.SecureRandom;

import src.Enums.Species.SPECIES;
public class Peta {
    private int baris;
    private int kolom;
    private ArrayList<WildEngimon> wildEngimons;
    // private ArrayList<WildEngimon> wildEngimons;
    public Tile[][] peta;

    public int getBaris() { return this.baris;}
    public int getKolom() { return this.kolom;}

    public Peta() throws FileNotFoundException {
        int baris = 0;
        int kolom = 0;
        File file = new File("src/peta.txt");
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
        this.wildEngimons = new ArrayList<WildEngimon>();
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
    public void updatePeta(Player p) {
        // perbaru map jadi terrain semua
        for (int i=0; i<baris ; i++) {
            for (int j=0; j<kolom ; j++) {
                char sym = peta[i][j].getTerrain();
                this.peta[i][j].setSymbol(sym);
            }
        }
        // update posisi player pada peta
        this.peta[p.x][p.y].setSymbol('P');
        this.peta[p.x][p.y].isOccupiedplayer = true;
        this.peta[p.aex][p.aey].setSymbol('X');
        this.peta[p.aex][p.aey].isOccupiedplayer = true;
        // masukkan wildEngimons pada peta
        for (WildEngimon eng : wildEngimons) {
            int x = eng.getX();
            int y = eng.getY();
            char engSym = eng.getSymbol();
            this.peta[x][y].setSymbol(engSym);
        }
    }

    public void printPeta() {
        for(int i=0; i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                System.out.print(this.peta[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public int countEngMountains(){
        int count = 0;
        for(int i=0; i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                if(peta[i][j].isOccupied) {
                    if(peta[i][j].getTerrain() == '^') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int countEngGrass(){
        int count = 0;
        for(int i=0; i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                if(peta[i][j].isOccupied) {
                    if(peta[i][j].getTerrain() == '-') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int countEngSea(){
        int count = 0;
        for(int i=0; i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                if(peta[i][j].isOccupied) {
                    if(peta[i][j].getTerrain() == 'o') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int countEngTundra(){
        int count = 0;
        for(int i=0; i<this.baris;i++) {
            for(int j=0;j<this.kolom;j++) {
                if(peta[i][j].isOccupied) {
                    if(peta[i][j].getTerrain() == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
//Iblis, Ikan, Thor, Pembantu, Snowman, Dewa, PutriDuyung, Aurora
    public void spawnEngimons(int turn, Player p) {
        
            int countgrass = this.countEngGrass();
            int countsea = this.countEngSea();
            int countmount = this.countEngMountains();
            int counttund = this.countEngTundra();
            if (turn % 8 == 0 && countgrass < 3) { 
                if(!peta[4][4].isOccupied && !peta[4][4].isOccupiedplayer)
                this.wildEngimons.add(new WildEngimon("Enemy", SPECIES.Pembantu, 4, 4, p.getActiveEngimon().getLevel()));
                this.setOccupier(4, 4);
            } else if (turn % 8 == 2 && countsea < 3 ) {
                if(!peta[4][9].isOccupied && !peta[4][9].isOccupiedplayer)
                this.wildEngimons.add(new WildEngimon("Enemy", SPECIES.Ikan, 4, 9, p.getActiveEngimon().getLevel()));
                this.setOccupier(4, 9);
            } else if (turn % 8 == 4 && countmount < 3 ) {
                if(!peta[9][4].isOccupied && !peta[9][4].isOccupiedplayer)
                this.wildEngimons.add(new WildEngimon("Enemy", SPECIES.Thor, 9, 4, p.getActiveEngimon().getLevel()));
                this.setOccupier(9, 4);
            } else if (turn % 8 == 6 && counttund < 3 ) {
                if(!peta[9][9].isOccupied && !peta[9][9].isOccupiedplayer)
                this.wildEngimons.add(new WildEngimon("Enemy", SPECIES.Snowman, 9, 9, p.getActiveEngimon().getLevel()));
                this.setOccupier(9, 9);
            } 
        
    }


    public void moveWildEngimons(int turn) {
        if (turn % 4 == 0) {
            SecureRandom rand = new SecureRandom();
            for (WildEngimon eng : wildEngimons) {
                int a = rand.nextInt(4);
                switch (a) {
                    case 0:
                        try {
                            if (!peta[eng.getX()-1][eng.getY()].isOccupied
                            && !peta[eng.getX()-1][eng.getY()].isOccupiedplayer
                            && (eng.terrain.countains(peta[eng.getX()-1][eng.getY()].getTerrain()))) {
                            this.removeOccupier(eng.getX(), eng.getY());
                            eng.up();
                            this.setOccupier(eng.getX(), eng.getY());
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("wild engimon nabrak");
                        }
                        
                        break;
                    case 1:
                        try {
                            if (!peta[eng.getX()+1][eng.getY()].isOccupied
                            && !peta[eng.getX()+1][eng.getY()].isOccupiedplayer
                            && (eng.terrain.countains(peta[eng.getX()-1][eng.getY()].getTerrain()))) {
                                this.removeOccupier(eng.getX(), eng.getY());
                                eng.down();
                                this.setOccupier(eng.getX(), eng.getY());
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("wild engimon nabrak");
                        }
                        break;
                    case 2:
                        try {
                            if (!peta[eng.getX()][eng.getY()-1].isOccupied
                            && !peta[eng.getX()][eng.getY()-1].isOccupiedplayer
                            && (eng.terrain.countains(peta[eng.getX()-1][eng.getY()].getTerrain()))) {
                            this.removeOccupier(eng.getX(), eng.getY());
                            eng.left();
                            this.setOccupier(eng.getX(), eng.getY());
                        }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("wild engimon nabrak");
                        }  
                        break;
                    case 3:
                        try {
                            if (!peta[eng.getX()][eng.getY()+1].isOccupied
                            && !peta[eng.getX()][eng.getY()+1].isOccupiedplayer
                            && (eng.terrain.countains(peta[eng.getX()-1][eng.getY()].getTerrain()))) {
                            this.removeOccupier(eng.getX(), eng.getY());
                            eng.right();
                            this.setOccupier(eng.getX(), eng.getY());
                        }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("wild engimon nabrak");
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void setOccupier(int x, int y) {
        this.peta[x][y].isOccupied = true;
    }

    public void removeOccupier(int x, int y) {
        this.peta[x][y].isOccupied = false;
    }

    public void setOccupierplayer(int x, int y) {
        this.peta[x][y].isOccupiedplayer = true;
    }

    public void removeOccupierplayer(int x, int y) {
        this.peta[x][y].isOccupiedplayer = false;
    }
}
