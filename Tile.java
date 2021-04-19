
class Tile {
    private int x;
    private int y;
    private char terrain;
    private char symbol;
    private char spawn;

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(char x) {
        this.x = x;
    }
    public void setY(char y) {
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

    public char getSpawn() {
        return this.spawn;
    }
    public void setspawn(char sp) {
        this.spawn = sp;
    }

    public boolean isOccupied() {
        return false;
    }

}