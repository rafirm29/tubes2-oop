public class WildEngimon extends Engimon {
    private int x;
    private int y;
    
    public WildEngimon(String name, SPECIES s, int x, int y) {
        super(name, s);
        this.x = x;
        this.y = y;
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
}
