package src;
import src.Interfaces.Info;

public class SkillItem extends Skill implements Info {

    private int count;

    public SkillItem(SkillName skill) {
        super(skill);
        this.count = 1;
    }

    public int getCount() {
        return count;
    }
    public boolean isSameSkillItem(SkillItem other) {
        return this.name == other.name;
    }

    public void add(int inc) {
        this.count += inc;
    }
    public void drop(int dec) {
        if (this.count < dec) {

        } else {
            this.count -= dec;
        }
    }
    public Skill learn() {
        if (this.count <= 0) {

        } else {
            this.count--;
            return new Skill(this.name);
        }
    }

    @Override
    public void getInfo() {
        // TODO Auto-generated method stub
        System.out.println("Nama skill: " +this.name);
        System.out.println("Base power: " +this.base_power);
        System.out.println("Elemen yang bisa mempelajari skill ini:");
        for (int i = 0; i <= this.elements.size(); i++) {
            System.out.println(i+ ". " +this.elements.get(i));
        }
    }
}
