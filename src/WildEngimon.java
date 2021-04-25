package src;

import java.util.*;
import src.Interfaces.Move;

public class WildEngimon extends Engimon implements Move {
    private int x;
    private int y;
    private char symbol;
    ArrayList<Character> terrain;

    public WildEngimon(String name, SPECIES s, int x, int y, int level) {
        super(name, s);
        this.x = x;
        this.y = y;
        if (s == SPECIES.Ikan) {
            this.symbol = 'F';
        } else if(s == SPECIES.PutriDuyung) {
            this.symbol = 'U';
        } else {
            this.symbol = Utils.speciesToString(this.getSpecies()).charAt(0);
        }
        this.terrain = new ArrayList<Character>();
        this.setLevel(level);
        if (s == SPECIES.Iblis) {
            this.terrain.add('^'); //mount
        } else if (s == SPECIES.Ikan) {
            this.terrain.add('o'); // sea
        } else if (s == SPECIES.Thor) {
            this.terrain.add('-'); // grass
        } else if (s == SPECIES.Pembantu) {
            this.terrain.add('-'); // grass
        } else if (s == SPECIES.Snowman) {
            this.terrain.add('*'); // tundra
        } else if (s == SPECIES.Dewa) {
            this.terrain.add('-'); // grass
            this.terrain.add('^'); // mount
        } else if (s == SPECIES.PutriDuyung) {
            this.terrain.add('o'); // sea
            this.terrain.add('-'); // grass
        } else if (s == SPECIES.Aurora) {
            this.terrain.add('o'); //sea
            this.terrain.add('*'); // tundra
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public void up() {
        this.x -= 1;
    }

    @Override
    public void right() {
        // TODO Auto-generated method stub
        this.y += 1;
    }

    @Override
    public void down() {
        // TODO Auto-generated method stub
        this.x += 1;
    }

    @Override
    public void left() {
        // TODO Auto-generated method stub
        this.y -= 1;
    }
}

// Iblis, -> fire -> mountains (I)
// Ikan, -> water -> sea (F)
// Thor, -> electric-> grassland (T)
// Pembantu, -> ground -> grassland (p)
// Snowman,  -> ice -> tundra (S)
// Dewa, -> fire/electric -> grassland/mountains (D)
// PutriDuyung, -> water/ground -> sea/grassland (U)
// Aurora -> water/ice -> sea/tundra (A)
