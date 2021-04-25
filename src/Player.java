package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import src.Enums.Elements.ELMT;
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
        }

        // getting input from player
        int selected;
        Scanner reader = new Scanner(System.in);
        while (true) {
            try {
                if (reader.hasNextInt()) {
                    selected = reader.nextInt();
                    if (selected < 1 || selected > invEngimon.getCapacity()) {
                        throw new InputMismatchException();
                    }
                    break;
                } else {
                    System.out.println("Input invalid!");
                    reader.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // reader.close();
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
        }
        this.invSkill.info();
        int selected;
        Scanner reader = new Scanner(System.in);
        while (true) {
            try {
                if (reader.hasNextInt()) {
                    selected = reader.nextInt();
                    if (selected < 1 || selected > invSkill.getCapacity()) {
                        throw new InputMismatchException();
                    }
                    break;
                } else {
                    System.out.println("Input invalid!");
                    reader.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }

        // getting input for Engimon to teach
        SkillItem si = invSkill.getList().get(selected - 1);
        System.out.println("Skill description:");
        si.getInfo();
        System.out.println("Choose Engimon to teach");
        this.invEngimon.info();
        if (invEngimon.getCapacity() > 1) {
            System.out.format("[1-%d]:", invEngimon.getCapacity());
        }
        Scanner reader2 = new Scanner(System.in);
        while (true) {
            try {
                if (reader2.hasNextInt()) {
                    selected = reader2.nextInt();
                    if (selected < 1 || selected > invEngimon.getCapacity()) {
                        throw new InputMismatchException();
                    }
                    break;
                } else {
                    System.out.println("Input invalid!");
                    reader2.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // reader.close();

        // teaching skill to Engimon
        Engimon e = invEngimon.getList().get(selected - 1);
        ArrayList<ELMT> e_elmts = e.getElmt();
        boolean teachable = e_elmts.stream().anyMatch(i -> {
            return si.getElements().contains(i);
        });
        if (teachable) {
            try {
                e.addSkill(si.learn());
            } catch (Exception ex) {
                System.out.println("You don't have enough!");
            }
        } else {
            System.out.println("Skill is not teachable to Engimon!");
        }
    }

    public void releaseItem(PlayerEngimon e) {
        invEngimon.remove(e);
        System.out.format("Goodbye, %s!%n", e.getName());
    }

    public void releaseItem(SkillItem si, int n) {
        try {
            si.drop(n);    
        } catch (Exception e) {
            System.out.println("You don't have enough!");
        }
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
        }
        int selected;
        Scanner reader = new Scanner(System.in);
        while (true) {
            try {
                if (reader.hasNextInt()) {
                    selected = reader.nextInt();
                    if (selected < 1 || selected > invEngimon.getCapacity()) {
                        throw new InputMismatchException();
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Input invalid!");
                    reader.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // reader.close();
        invEngimon.getList().get(selected - 1).getInfo();
    }

    public void changeName() {
        System.out.println("Choose Engimon to change name");
        this.invEngimon.info();
        if (invEngimon.getCapacity() > 1) {
            System.out.format("[1-%d]:", invEngimon.getCapacity());
        }
        int selected;
        Scanner reader = new Scanner(System.in);
        while (true) {
            try {
                if (reader.hasNextInt()) {
                    selected = reader.nextInt();
                    if (selected < 1 || selected > invEngimon.getCapacity()) {
                        throw new InputMismatchException();
                    }
                    break;
                } else {
                    System.out.println("Input invalid!");
                    reader.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        PlayerEngimon p = invEngimon.getList().get(selected - 1);
        System.out.format("Write %s new name: ", p.getName());
        String new_name;
        Scanner reader2 = new Scanner(System.in);
        while (true) {
            try {
                if (reader2.hasNextLine()) {
                    new_name = reader2.nextLine();
                    break;
                } else {
                    System.out.println("Input invalid!");
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // reader.close();
        p.setName(new_name);
    }

    public void help() {
        System.out.println("Command yang tersedia adalah:");
        System.out.println("- w, a, s, d\t\t// bergerak pada peta");
        System.out.println("- showSkills\t\t// melihat inventory skill");
        System.out.println("- showEngimons\t\t// melihat inventory Engimon");
        System.out.println("- viewEngimon\t\t// melihat data lengkap suatu Engimon");
        System.out.println("- swap\t\t// mengubah active Engimon");
        System.out.println("- useSkill\t\t// menggunakan Skill item dari inventory");
        System.out.println("- breed\t\t// melakukan breeding");
        System.out.println("- battle\t\t// melakukan battle");
        System.out.println("- dropItem\t\t// membuang n amount Skill item dari inventory");
        System.out.println("- changeName\t\t// mengganti nama suatu Engimon");       
    }

    // method ini digunakan untuk menghandle command dropItem
    private void dropItemHandler() {
        System.out.println("Select Skill to drop");
        this.invSkill.info();
        if (invSkill.getCapacity() > 1) {
            System.out.format("[1-%d]: ", invSkill.getCapacity());
        }
        int selected;
        Scanner reader = new Scanner(System.in);
        while (true) {
            try {
                if (reader.hasNextInt()) {
                    selected = reader.nextInt();
                    if (selected < 1 || selected > invSkill.getCapacity()) {
                        throw new InputMismatchException();
                    }
                    break;
                } else {
                    System.out.println("Input invalid!");
                    reader.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        SkillItem si = invSkill.getList().get(selected - 1);
        System.out.println("Choose n amount to drop");
        if (invSkill.getCapacity() > 1) {
            System.out.format("[1-%d]:", invSkill.getCapacity());
        } else {
            System.out.format("You only have 1 amount of %s:", si.getName());
        }
        int n;
        Scanner reader2 = new Scanner(System.in);
        while (true) {
            try {
                if (reader2.hasNextInt()) {
                    n = reader2.nextInt();
                    if (n < 1 || n > si.getCount()) {
                        throw new InputMismatchException();
                    }
                    break;
                } else {
                    System.out.println("Input invalid!");
                    reader2.next();
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        // reader.close();
        releaseItem(si, n);
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
