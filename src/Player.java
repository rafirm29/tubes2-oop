package src;

import src.Interfaces.Move;

public class Player implements Move {
    PlayerEngimon activeEngimon;
    Inventory<PlayerEngimon> invEngimon;
    Inventory<SkillItem> invSkill;
    final int invCapacity;
    int x;
    int y;
    int aex;    // active engimon coordinate
    int aey;    // active engimon coordinate

    public Player(PlayerEngimon firstEngimon) {
        this.activeEngimon = firstEngimon;
        this.invEngimon = new Inventory<PlayerEngimon>(5);
        this.invEngimon.add(this.activeEngimon);

        invSkill = new Inventory<SkillItem>(5);
        this.invCapacity = 20;
        this.x = 0;
        this.y = 1;
        this.aex = 0;
        this.aey = 0;
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
    public void up() {
        this.aex = this.x;
        this.aey = this.y;
        this.x -= 1;
    }

    @Override
    public void right() {
        // TODO Auto-generated method stub
        this.aex = this.x;
        this.aey = this.y;
        this.y += 1;
    }

    @Override
    public void down() {
        // TODO Auto-generated method stub
        this.aex = this.x;
        this.aey = this.y;
        this.x += 1;
    }

    @Override
    public void left() {
        // TODO Auto-generated method stub
        this.aex = this.x;
        this.aey = this.y;
        this.y -= 1;
    }
}
