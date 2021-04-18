/**
 * Engimon
 */

 import java.util.*;

abstract class Engimon implements Info {
    private String name;
    private List<Engimon> parents;
    private List<Skill> skills;
    private int level;
    private int exp;
    private int cumexp;
    private String species;
    private final int maxcumexp = 10000;

    public Engimon(String n, String s){
        this.name = n;
        this.parents = new ArrayList<Engimon>();
        this.skills = new ArrayList<Skill>();
        this.level = 0;
        this.exp = 0;
        this.cumexp = 0;
        this.species = s;
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
    public Skill getSkill(String n){
        for (Skill skill : this.skills){
            if(skill.getName().contains(n)){
                return (skill);
            }
            else{
                System.out.println("Tidak ada skill tersebut");
            }
        }
    }
    public String getElmt();
    public String getSpecies(){
        return this.species;
    }

    public void LevelUp(int e){
        int curexp = this.exp +e;
        this.cumexp = this.cumexp+e;
        if (curexp > 100){
            this.exp = curexp -100;
        }
        else{
            this.exp = curexp
        }
        this.level = this.cumexp/100;
    }
    public void SetParents(String p1,String p2){
        this.parents.add(p1);
        this.parents.add(p2);
    }
    public void SetName(String n){
        this.name = n;
    }
    public void SetLevel(int lvl){
        this.level = lvl;
    }
    public void AddSkill(Skill s){
        this.skills.add(s);
    }
}