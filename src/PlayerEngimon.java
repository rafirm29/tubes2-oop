package src;
import java.util.ArrayList;
import java.util.List;

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

    public void removeLife() {
        this.life--;
    }

    public void interact() {
        /**
         * TODO
         * TODO
         * TODO
         */
        String msg;
        String header = "[" + this.getName() + "]";
        if (this.getSpecies() == SPECIES.Iblis) {
            msg = "Jangan salat skip puasa";
        } else if (this.getSpecies() == SPECIES.Ikan) {
            msg = "Glubu glubu";
        } else if (this.getSpecies() == SPECIES.Thor) {
            msg = "You are not worthy.";
        } else if (this.getSpecies() == SPECIES.Pembantu) {
            msg = "Punteennn";
        } else if (this.getSpecies() == SPECIES.Snowman) {
            msg = "Do you wanna build a snowman???";
        } else if (this.getSpecies() == SPECIES.Dewa) {
            msg = "Pekalongan gaming";
        } else if (this.getSpecies() == SPECIES.PutriDuyung) {
            msg = "Ariel peterwoman";
        } else if (this.getSpecies() == SPECIES.Aurora) {
            msg = "Borealis dies natalis alis alis";
        } else {
            msg = "How did it get here";
        }
        System.out.println(header + " " + msg);
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
        System.out.print("Parents name\t: ");
        if (this.getParents().isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println(this.getParentName(0) + " (" + Utils.speciesToString(this.getParentSpecies(0)) + ")"
                                + " & " 
                                + this.getParentName(1) + " (" + Utils.speciesToString(this.getParentSpecies(1)) + ")");
        }
        // Parent name :
        System.out.println("Species\t\t: " + Utils.speciesToString(this.getSpecies()));
        System.out.println("Skill(s)\t:");
        List<Skill> skillist = this.getSkills();
        for (Skill skill : skillist) {
            System.out.print("\t- ");
            System.out.println(skill);
        }

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
