public class Player {
    Engimon activeEngimon;
    Inventory<Engimon> invEngimon;
    Inventory<SkillItem> invSkill;
    int x;
    int y;

    public Player(Engimon firstEngimon) {
        this.activeEngimon = firstEngimon;
        invEngimon = new Inventory<Engimon>();
        invSkill = new Inventory<SkillItem>();
        this.x = 0;
        this.y = 1;
    }

    public Engimon getActiveEngimon() {

    }

    public void showInventoryEngimon() {

    }

    public void showInventorySkill() {

    }

    public void swapEngimon() {

    }

    public void useSkillItem() {

    }

    public void releaseItem(Engimon e) {

    }

    public void releaseItem(SkillItem si, int n) {

    }

    public void battle(Engimon enemy) {

    }

    public void breeding() {
        
    }
}
