package src.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

public interface Skills {

    enum SkillName implements Elements {
        GOMU_GOMU_NO_RED_HAWK           (0, new ELMT[]{}),
        SHINKA_SHIRANUI                 (0, new ELMT[]{}),
        SEA_CURRENT_LIFTER              (0, new ELMT[]{}),
        FISH_MAN_KARATE_OGI_BURAIKAN    (0, new ELMT[]{}),
        MAMARAGAN                       (0, new ELMT[]{}),
        KINGDOM_COME                    (0, new ELMT[]{}),
        GROUND_SECCO                    (0, new ELMT[]{}),
        DESERT_ENCIERRO                 (0, new ELMT[]{}),
        ICE_TIME                        (0, new ELMT[]{}),
        PERMAFROST                      (0, new ELMT[]{}),
        ;

        private final double base_power;
        private final ArrayList<ELMT> elements;

        public double getBasePower() {
            return base_power;
        }

        public ArrayList<ELMT> getElements() {
            return this.elements;
        }

        <T extends Number> SkillName(T base_power, ELMT[] elements) {
            this.base_power = base_power.doubleValue();
            this.elements = Arrays.stream(elements)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        @Override
        public String toString() {
            return switch (this) {
                case GOMU_GOMU_NO_RED_HAWK: yield "Gomu Gomu no Red Hawk";
                case SHINKA_SHIRANUI: yield "Shinka: Shiranui";
                case SEA_CURRENT_LIFTER: yield "Sea Current Lifter";
                case FISH_MAN_KARATE_OGI_BURAIKAN: yield "Fish-Man Karate Ogi: Buraikan";
                case MAMARAGAN: yield "Mamaragan";
                case KINGDOM_COME: yield "Kingdom Come";
                case GROUND_SECCO: yield "Ground Secco";
                case DESERT_ENCIERRO: yield "Desert Encierro";
                case ICE_TIME: yield "Ice Time";
                case PERMAFROST: yield "Permafrost";
            };
        }
    }
}