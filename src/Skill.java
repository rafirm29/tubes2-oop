package src;
import java.util.ArrayList;
import src.Enums.Skills;
import src.Interfaces.Info;
import src.Enums.Elements;

public class Skill implements Skills, Elements, Info {

    protected final SkillName name;
    protected final double base_power;
    private int mastery;
    protected ArrayList<ELMT> elements;

    public Skill(SkillName name) {
        this.name = name;
        this.base_power = name.getBasePower();
        this.mastery = 1;
        this.elements = name.getElements();
    }

    public SkillName getName() {
        return this.name;
    }
    public double getBasePower() {
        return this.base_power;
    }
    public int getMastery() {
        return this.mastery;
    }
    public ArrayList<ELMT> getElements() {
        return this.elements;
    }

    public boolean isSameSkill(SkillName other) {
        return this.name == other;
    }
    public boolean isSameSkill(Skill other) {
        return this.name == other.name;
    }

    public double getTotalPower() {
        return this.base_power * this.mastery;
    }
    public void incrementMastery() {
        if (this.mastery <= 3) this.mastery++;
        assert this.mastery <=3;
    }

    @Override
    public void getInfo() {
        System.out.println("Nama skill: " +this.name);
        System.out.println("Base power: " +this.base_power);
        System.out.println("Mastery :" +this.mastery);
    }
}
