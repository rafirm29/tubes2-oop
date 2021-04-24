public class Player implements Move {
    PlayerEngimon activeEngimon;
    Inventory<PlayerEngimon> invEngimon;
    Inventory<SkillItem> invSkill;
    final int invCapacity;
    int x;
    int y;

    public Player(PlayerEngimon firstEngimon) {
        this.activeEngimon = firstEngimon;
        this.invEngimon = new Inventory<PlayerEngimon>(5);
        this.invEngimon.add(this.activeEngimon);

        invSkill = new Inventory<SkillItem>(5);
        this.invCapacity = 20;
        this.x = 0;
        this.y = 1;
    }

    public void addToInventory(PlayerEngimon e) {
        this.invEngimon.add(e);
    }

    public void addToInventory(SkillItem si) {
        this.invSkill.add(si);
    }

    public PlayerEngimon getActiveEngimon() {
        return this.activeEngimon;
    }

    public void showInventoryEngimon() {
        this.invEngimon.info();
    }

    public void showInventorySkill() {
        this.invSkill.info();
    }

    public void swapEngimon() {
        // need getter for list in inventory
        System.out.println("Choose Engimon to swap");
        this.invEngimon.info();
        int selected;
        while (true) {
            try {
                selected = System.in.read();
                // need getter for total items in inventory
                assert selected >= 1 && selected <= 5; // invEngimon.capacity();
                break;
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // need getter for Engimon in inventory
        switch (selected) {
        case 1:
            // TODO: complete the switch block respective to Engimon in inventory
            break;

        default:
            break;
        }
    }

    public void useSkillItem() {
        // need getter for list in inventory
        System.out.println("Select skill to teach to Engimon");
        this.invSkill.info();
        int selected;
        while (true) {
            try {
                selected = System.in.read();
                break;
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        switch (selected) {
        case 1:
            // TODO: complete switch case and need use method from Skill.java
            break;

        default:
            break;
        }
    }

    public void releaseItem(PlayerEngimon e) {
        invEngimon.remove(e);
        System.out.format("Goodbye, %s!%n", e.getName());
    }

    public void releaseItem(SkillItem si, int n) {
        invSkill.remove(si);
        // TODO: remove only the total count of si if it is not remove entire count of
        // si
    }

    public void battle(Engimon enemy) {

    }

    public void breeding() {
        // TODO: need getter for list in inventory
    }

    @Override
    public void up(Peta p) {
        // TODO: learn how to use Peta, still confused

    }

    @Override
    public void right(Peta p) {
        // TODO: learn how to use Peta, still confused

    }

    @Override
    public void down(Peta p) {
        // TODO: learn how to use Peta, still confused

    }

    @Override
    public void left(Peta p) {
        // TODO: learn how to use Peta, still confused

    }
}
