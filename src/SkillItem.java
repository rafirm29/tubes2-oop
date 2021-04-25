package src;
import src.Interfaces.Info;

import java.util.ArrayList;

public class SkillItem extends Skill implements Info {

    private int count;

    public SkillItem(SkillName skill) {
        super(skill);
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public boolean isSameSkillItem(SkillName other) {
        return this.name == other;
    }
    public boolean isSameSkillItem(SkillItem other) {
        return this.name == other.name;
    }

    public boolean compatibleWith(ELMT check) {
        return this.elements.contains(check);
    }
    public<T extends Engimon> boolean compatibleWith(T engimon) {
        ArrayList<ELMT> engimon_elements = engimon.getElmt();
        for (ELMT elements : engimon_elements) {
            if (this.elements.contains(elements)) {
                return true;
            }
        }
        return false;
    }

    public void add(int inc) {
        this.count += inc;
    }
    public void drop(int dec) throws Exception {
        if (this.count < dec) {
            throw new Exception();
        }
        this.count -= dec;
    }
    public Skill learn() throws Exception {
        if (this.count <= 0) {
            throw new Exception();
        }
        this.count--;
        return new Skill(this.name);
    }

    @Override
    public void getInfo() {
        // TODO Auto-generated method stub
        System.out.println("Nama skill: " +this.name);
        System.out.println("Base power: " +this.base_power);
        System.out.println("Elemen yang bisa mempelajari skill ini:");
        for (int i = 0; i < this.elements.size(); i++) {
            System.out.println((i+1)+ ". " +this.elements.get(i));
        }
    }

    @Override
    public String toString() {
        String name = this.getName().toString();
        int count = this.getCount();
        return (name + " (x" + count + ")");
    }
}
