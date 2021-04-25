package src.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

public interface Skills {

    enum SkillName implements Elements {
        RED_HAWK                        (0, new ELMT[]{ELMT.FIRE}),
        SHINKA_SHIRANUI                 (0, new ELMT[]{ELMT.FIRE}),
        SEA_CURRENT_LIFTER              (0, new ELMT[]{ELMT.WATER}),
        FISH_MAN_KARATE_OGI_BURAIKAN    (0, new ELMT[]{ELMT.WATER}),
        MAMARAGAN                       (0, new ELMT[]{ELMT.ELECTRIC}),
        KINGDOM_COME                    (0, new ELMT[]{ELMT.ELECTRIC}),
        GROUND_SECCO                    (0, new ELMT[]{ELMT.GROUND}),
        DESERT_ENCIERRO                 (0, new ELMT[]{ELMT.GROUND}),
        ICE_TIME                        (0, new ELMT[]{ELMT.ICE}),
        PERMAFROST                      (0, new ELMT[]{ELMT.ICE}),
        RAGNARAKA                       (0, new ELMT[]{}),
        SPEAR_OF_ELBAF                  (0, new ELMT[]{}),
        SHIMA_YURASHI                   (0, new ELMT[]{}),
        DIVINE_DEPARTURE                (0, new ELMT[]{})
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
            if (this == RED_HAWK) {
                return "Gomu Gomu no Red Hawk";
            } else {
                return "Mamaragan";
            }

            // return switch (this) {
            //     case RED_HAWK: yield "Gomu Gomu no Red Hawk";
            //     case SHINKA_SHIRANUI: yield "Shinka: Shiranui";
            //     case SEA_CURRENT_LIFTER: yield "Sea Current Lifter";
            //     case FISH_MAN_KARATE_OGI_BURAIKAN: yield "Fish-Man Karate Ogi: Buraikan";
            //     case MAMARAGAN: yield "Mamaragan";
            //     case KINGDOM_COME: yield "Kingdom Come";
            //     case GROUND_SECCO: yield "Ground Secco";
            //     case DESERT_ENCIERRO: yield "Desert Encierro";
            //     case ICE_TIME: yield "Ice Time";
            //     case PERMAFROST: yield "Permafrost";
            //     case RAGNARAKA: yield "Conquest of Three Worlds: Ragnaraka";
            //     case SPEAR_OF_ELBAF: yield "Spear of Elbaf";
            //     case SHIMA_YURASHI: yield "The Man Who Shakes the World";
            //     case DIVINE_DEPARTURE: yield "Divine Departure";
            // };
        }
    }
}