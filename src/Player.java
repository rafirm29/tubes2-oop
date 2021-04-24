package src;

import java.util.ArrayList;
import src.Interfaces.Move;

public class Player implements Move {
    PlayerEngimon activeEngimon;
    Inventory<PlayerEngimon> invEngimon;
    Inventory<SkillItem> invSkill;
    final int invCapacity;
    int x;
    int y;
    int aex; // active engimon coordinate
    int aey; // active engimon coordinate

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
        System.out.println("Choose Engimon to swap");
        this.invEngimon.info();
        if (invEngimon.getCapacity() > 1) {
            System.out.format("[1-%d]:", invEngimon.getCapacity());
        } else {
            System.out.println("1: ");
        }

        // getting input from player
        int selected;
        while (true) {
            try {
                selected = System.in.read();
                assert selected >= 1 && selected <= invEngimon.getCapacity();
                break;
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // swapping active engimon
        List<PlayerEngimon> engimons = invEngimon.getList();
        this.activeEngimon = engimons.get(selected - 1);
        System.out.format("%s is now set to active Engimon%n", activeEngimon.getName());
    }

    public void useSkillItem() {
        // getting input skillitem from player
        System.out.println("Select skill to teach to Engimon");
        if (invEngimon.getCapacity() > 1) {
            System.out.format("[1-%d]:", invEngimon.getCapacity());
        } else {
            System.out.println("1: ");
        }
        this.invSkill.info();
        int selected;
        while (true) {
            try {
                selected = System.in.read();
                assert selected >= 1 && selected <= invSkill.getCapacity();
                break;
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }

        // getting input for Engimon to teach
        SkillItem s = invSkill.getList().get(selected - 1);
        System.out.println("Choose Engimon to teach");
        this.invEngimon.info();
        if (invEngimon.getCapacity() > 1) {
            System.out.format("[1-%d]:", invEngimon.getCapacity());
        } else {
            System.out.print("1: ");
        }
        while (true) {
            try {
                selected = System.in.read();
                assert selected >= 1 && selected <= invEngimon.getCapacity();
                break;
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }

        // teaching skill to Engimon
        Engimon e = invEngimon.getList().get(selected - 1);
        ArrayList<ELMT> e_elmts = e.getElmt();
        boolean teachable = e_elmts.stream().anyMatch(i -> {
            return s.getElements().contains(i);
        });
        if (teachable) {
            e.addSkill(s);
            s.learn();
        } else {
            System.out.println("Skill is not teachable to Engimon!");
        }
    }

    public void releaseItem(PlayerEngimon e) {
        invEngimon.remove(e);
        System.out.format("Goodbye, %s!%n", e.getName());
    }

    public void releaseItem(SkillItem si, int n) {
        si.drop(n);
    }

    public void battle(Engimon enemy) {
        // TODO: complete this method
    }

    public void breeding() {
        // TODO: complete this method
    }

    public void viewEngimon() {
        System.out.println("Choose Engimon to view info");
        this.invEngimon.info();
        if (invEngimon.getCapacity() > 1) {
            System.out.format("[1-%d]:", invEngimon.getCapacity());
        } else {
            System.out.print("1: ");
        }
        int selected;
        while (true) {
            try {
                selected = System.in.read();
                assert selected >= 1 && selected <= invEngimon.getCapacity();
                break;
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        invEngimon.getList().get(selected - 1).info();
    }

    @Override
    public void up() {
        this.aex = this.x;
        this.aey = this.y;
        this.x -= 1;
    }

    @Override
    public void right() {
        this.aex = this.x;
        this.aey = this.y;
        this.y += 1;
    }

    @Override
    public void down() {
        this.aex = this.x;
        this.aey = this.y;
        this.x += 1;
    }

    @Override
    public void left() {
        this.aex = this.x;
        this.aey = this.y;
        this.y -= 1;
    }
}
