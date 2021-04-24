import java.util.ArrayList;
import Enums.SkillName;
import Enums.Elements;

public abstract class Skill implements Info, Elements {

    private final SkillName name;
    private final double base_power;
    private int mastery;
    protected ArrayList<String> elements;

    public<T extends Number> Skill(String name, T base_power) {
        this.name = name;
        this.base_power = base_power.doubleValue();
        this.mastery = 1;
        this.elements = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public double getBasePower() {
        return this.base_power;
    }

    public int getMastery() {
        return this.mastery;
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public double getTotalPower() {
        return this.base_power * this.mastery;
    }

    public void addMastery() {
        if (this.mastery <= 3) this.mastery++;
    }

    abstract public void getInfo();
}
