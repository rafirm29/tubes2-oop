package src.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

public interface Skills {

    enum SkillName implements Elements {
        RED_HAWK                        (6.25, new ELMT[]{ELMT.FIRE}),
        SHINKA_SHIRANUI                 (12.5, new ELMT[]{ELMT.FIRE}),
        SEA_CURRENT_LIFTER              (7.5, new ELMT[]{ELMT.WATER}),
        FISH_MAN_KARATE_OGI_BURAIKAN    (12.5, new ELMT[]{ELMT.WATER}),
        MAMARAGAN                       (6.25, new ELMT[]{ELMT.ELECTRIC}),
        KINGDOM_COME                    (15, new ELMT[]{ELMT.ELECTRIC}),
        GROUND_SECCO                    (7.5, new ELMT[]{ELMT.GROUND}),
        DESERT_ENCIERRO                 (11.25, new ELMT[]{ELMT.GROUND}),
        ICE_TIME                        (6.25, new ELMT[]{ELMT.ICE}),
        PERMAFROST                      (13.75, new ELMT[]{ELMT.ICE}),
        RAGNARAKA                       (40, new ELMT[]{ELMT.FIRE, ELMT.ELECTRIC, ELMT.GROUND}),
        SPEAR_OF_ELBAF                  (30, new ELMT[]{ELMT.WATER, ELMT.ELECTRIC, ELMT.ICE, ELMT.FIRE}),
        SHIMA_YURASHI                   (50, new ELMT[]{ELMT.GROUND, ELMT.ICE, ELMT.WATER}),
        DIVINE_DEPARTURE                (100, new ELMT[]{ELMT.FIRE, ELMT.WATER, ELMT.ELECTRIC, ELMT.GROUND, ELMT.ICE})
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
            switch (this) {
                case RED_HAWK: return "Gomu Gomu no Red Hawk";
                case SHINKA_SHIRANUI: return "Shinka: Shiranui";
                case SEA_CURRENT_LIFTER: return "Sea Current Lifter";
                case FISH_MAN_KARATE_OGI_BURAIKAN: return "Fish-Man Karate Ogi: Buraikan";
                case MAMARAGAN: return "Mamaragan";
                case KINGDOM_COME: return "Kingdom Come";
                case GROUND_SECCO: return "Ground Secco";
                case DESERT_ENCIERRO: return "Desert Encierro";
                case ICE_TIME: return "Ice Time";
                case PERMAFROST: return "Permafrost";
                case RAGNARAKA: return "Conquest of Three Worlds: Ragnaraka";
                case SPEAR_OF_ELBAF: return "Spear of Elbaf";
                case SHIMA_YURASHI: return "The Man Who Shakes the World";
                case DIVINE_DEPARTURE: return "Divine Departure";
                default: assert false; return null;
            }
        }

        public static SkillName toSkillName(String skill_name) {
            switch (skill_name) {
                case "Gomu Gomu no Red Hawk": return RED_HAWK;
                case "Shinka: Shiranui": return SHINKA_SHIRANUI;
                case "Sea Current Lifter": return SEA_CURRENT_LIFTER;
                case "Fish-Man Karate Ogi: Buraikan": return FISH_MAN_KARATE_OGI_BURAIKAN;
                case "Mamaragan": return MAMARAGAN;
                case "Kingdom Come": return KINGDOM_COME;
                case "Ground Secco": return GROUND_SECCO;
                case "Desert Encierro": return DESERT_ENCIERRO;
                case "Ice Time": return ICE_TIME;
                case "Permafrost": return PERMAFROST;
                case "Conquest of Three Worlds: Ragnaraka": return RAGNARAKA;
                case "Spear of Elbaf": return SPEAR_OF_ELBAF;
                case "The Man Who Shakes the World": return SHIMA_YURASHI;
                case "Divine Departure": return DIVINE_DEPARTURE;
                default: assert false; return null;
            }
        }
    }
}