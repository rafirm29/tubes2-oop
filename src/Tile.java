package src;

class Tile {
    private int x;
    private int y;
    private char terrain;
    private char symbol;
    public boolean isOccupied;
    public boolean isOccupiedplayer;

    public Tile() {
        this.x=0;
        this.y=0;
        this.terrain='-';
        this.symbol='-';
        this.isOccupied = false;
        this.isOccupiedplayer = false;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public char getTerrain() {
        return this.terrain;
    }

    public void setTerrain(char terr) {
        this.terrain = terr;
    }

    public char getSymbol() {
        return this.symbol;
    }
    public void setSymbol(char sym) {
        this.symbol = sym;
    }

    

}