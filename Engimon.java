/**
 * Engimon
 */

import java.util.*;
import Enums.Elements;
import Enums.Species;

abstract class Engimon implements Elements, Species {

    private String name;
    private List<Engimon> parents;
    private List<Skill> skills;
    private int level;
    private int exp;
    private int cumexp;
    private SPECIES species;
    private ArrayList<ELMT> elements;
    private final int maxcumexp = 10000;

    public Engimon(String n, SPECIES s){
        this.name = n;
        this.parents = new ArrayList<Engimon>();
        this.skills = new ArrayList<Skill>();
        this.elements = new ArrayList<ELMT>();
        this.level = 1;
        this.exp = 0;
        this.cumexp = 0;
        this.species = s;
        if (s == SPECIES.Iblis) {
            this.elements.add(ELMT.FIRE);
        } else if (s == SPECIES.Ikan) {
            this.elements.add(ELMT.WATER);
        } else if (s == SPECIES.Thor) {
            this.elements.add(ELMT.ELECTRIC);
        } else if (s == SPECIES.Pembantu) {
            this.elements.add(ELMT.GROUND);
        } else if (s == SPECIES.Snowman) {
            this.elements.add(ELMT.ICE);
        } else if (s == SPECIES.Dewa) {
            this.elements.add(ELMT.FIRE);
            this.elements.add(ELMT.ELECTRIC);
        } else if (s == SPECIES.PutriDuyung) {
            this.elements.add(ELMT.WATER);
            this.elements.add(ELMT.GROUND);
        } else if (s == SPECIES.Aurora) {
            this.elements.add(ELMT.WATER);
            this.elements.add(ELMT.ICE);
        }
    }

    public int getLevel(){
        return(this.level);
    }
    public int getExp(){
        return(this.exp);
    }

    public int getCumExp(){
        return(this.cumexp);
    }

    public String getName(){
        return (this.name);
    }

    public Skill getSkill(String n) {
        for (Skill skill : this.skills){
            if(skill.getName().equals(n)){
                return (skill);
            }
        }
        return null;
    }
    public ArrayList<ELMT> getElmt() {
        return this.elements;
    }

    public SPECIES getSpecies() {
        return this.species;
    }

    public void levelUp(int e) {
        int curexp = this.exp +e;
        this.cumexp = this.cumexp+e;
        if (curexp > 100){
            this.exp = curexp -100;
        }
        else{
            this.exp = curexp;
        }
        this.level = this.cumexp/100;
    }

    public void setParents(Engimon p1, Engimon p2) {
        this.parents.add(p1);
        this.parents.add(p2);
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setLevel(int lvl) {
        this.level = lvl;
    }

    public void addSkill(Skill s) {
        this.skills.add(s);
    }
}