import java.util.ArrayList;

public abstract class Skill implements Info, ElementSpecies {

    private final String name;
    private final double base_power;
    private int mastery;
    protected ArrayList<String> elements;

    public Skill() {
        this.name = null;
        this.base_power = 0;
        this.mastery = 0;
        this.elements = new ArrayList<>();
    }

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



    abstract public void getInfo();
}
