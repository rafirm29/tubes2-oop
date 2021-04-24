package src;
import java.util.ArrayList;

import src.Interfaces.Info;

public class PlayerEngimon extends Engimon implements Info {
    private int life;

    public PlayerEngimon(String n, SPECIES s) {
        super(n, s);
        this.life = 3;
    }
    
    public int getLife() {
        return this.life;
    }

    public void interact() {

    }

    @Override
    public String toString() {
        String name = this.getName();
        String elmt = "";
        String lvl = "Lv." + String.valueOf(this.getLevel());

        ArrayList<ELMT> elmts = this.getElmt();
        for (ELMT el : elmts) {
            elmt += Utils.elmtToString(el);
        }
        return (name + "/" + elmt + "/" + lvl);
    }

    @Override
    public void getInfo() {
        System.out.println("Name\t\t: " + this.getName());
        System.out.println("Life(s)\t\t: " + this.getLife());
        // Parent name :
        System.out.println("Species\t\t: " + Utils.speciesToString(this.getSpecies()));
        // Skill :

        ArrayList<ELMT> elmts = this.getElmt();
        System.out.print("Elements\t: ");
        for (ELMT el : elmts) {
            System.out.print(Utils.elmtToString(el) + " ");
        }
        System.out.println("");

        System.out.println("Level\t\t: " + this.getLevel());
        System.out.println("Experience\t: " + this.getExp());
        System.out.println("Cumulative Exp\t: " + this.getCumExp());
    }
}
