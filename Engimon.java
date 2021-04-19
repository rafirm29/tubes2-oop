/**
 * Engimon
 */

import java.util.*;

abstract class Engimon implements Info, ElementSpecies {

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
        this.level = 0;
        this.exp = 0;
        this.cumexp = 0;
        this.species = s;
        if (s == SPECIES.Iblis) {
            this.elements.add(ELMT.Fire);
        } else if (s == SPECIES.Ikan) {
            this.elements.add(ELMT.Water);
        }
        /**
         * TO DO (CONTINUE)
         */
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
            else{
                System.out.println("Tidak ada skill tersebut");
            }
        }
    }
    public ArrayList<ELMT> getElmt() {
        return elements;
    }

    public String getSpecies() {
        return this.species;
    }

    public void LevelUp(int e) {
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

    public void SetParents(Engimon p1,EngimonString p2) {
        this.parents.add(p1);
        this.parents.add(p2);
    }

    public void SetName(String n) {
        this.name = n;
    }

    public void SetLevel(int lvl) {
        this.level = lvl;
    }

    public void AddSkill(Skill s) {
        this.skills.add(s);
    }
}