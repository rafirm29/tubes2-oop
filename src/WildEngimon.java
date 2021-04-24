package src;
public class WildEngimon extends Engimon {
    private int x;
    private int y;
    private char symbol;
    
    public WildEngimon(String name, SPECIES s, int x, int y, int level) {
        super(name, s);
        this.x = x;
        this.y = y;
        this.symbol = Utils.speciesToString(this.getSpecies()).charAt(0);
        this.setLevel(level);
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

    
}
