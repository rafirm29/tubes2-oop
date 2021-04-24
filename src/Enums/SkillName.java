package src.Enums;

import java.util.ArrayList;

public enum SkillName implements Elements {
    GOMU_GOMU_NO_RED_HAWK(0, new ELMT[]{}),
    SHINKA_SHIRANUI(0, new ELMT[]{}),
    SEA_CURRENT_LIFTER(0, new ELMT[]{}),
    FISH_MAN_KARATE_OGI_BURAIKAN(0, new ELMT[]{}),
    MAMARAGAN(0, new ELMT[]{}),
    KINGDOM_COME(0, new ELMT[]{}),
    GROUND_SECCO(0, new ELMT[]{}),
    DESERT_ENCIERRO( 0, new ELMT[]{}),
    ICE_TIME(0, new ELMT[]{}),
    PERMAFROST( 0, new ELMT[]{}),
    ;

    private double base_power;
    private ArrayList<ELMT> elements;

    public double getBasePower() {
        return base_power;
    }
    public ArrayList<ELMT> getElements() {
        return this.elements;
    }

    <T extends Number> SkillName(T base_power, ELMT[] elements) {
        this.base_power = base_power.doubleValue();
        this.elements = new ArrayList<>();
        for (ELMT element : elements) {
            this.elements.add(element);
        }
    }

    @Override
    public String toString() {
        switch(this) {
            case GOMU_GOMU_NO_RED_HAWK: return "Gomu Gomu no Red Hawk";
            case SHINKA_SHIRANUI: return "Shinka: Shiranui";
            case SEA_CURRENT_LIFTER: return "Sea Current Lifter";
            case FISH_MAN_KARATE_OGI_BURAIKAN: return "Fish-Man Karate Ogi: Buraikan";
            case MAMARAGAN: return "Mamaragan";
            case KINGDOM_COME: return "Kingdom Come";
            case GROUND_SECCO: return "Ground Secco";
            case DESERT_ENCIERRO: return "Desert Encierro";
            case ICE_TIME: return "Ice Time";
            case PERMAFROST: return "Permafrost";
            default: throw new IllegalArgumentException();
        }
    }
}