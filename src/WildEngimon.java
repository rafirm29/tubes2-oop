package src;

import src.Interfaces.Move;

public class WildEngimon extends Engimon implements Move {
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
