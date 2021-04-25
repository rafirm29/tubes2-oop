package src;

import src.Enums.Elements.ELMT;
import src.Enums.Species.SPECIES;

public class Utils {
    public static double getElmtAdvantage(ELMT e1, ELMT e2) {
        if (e1 == ELMT.FIRE && e2 == ELMT.ICE) {
            return 2;
        } else if (e1 == ELMT.FIRE && e2 == ELMT.WATER) {
            return 0;
        } else if (e1 == ELMT.FIRE && e2 == ELMT.ELECTRIC) {
            return 1;
        } else if (e1 == ELMT.FIRE && e2 == ELMT.GROUND) {
            return 0.5;
        } else if (e1 == ELMT.WATER && e2 == ELMT.FIRE) {
            return 2;
        } else if (e1 == ELMT.WATER && e2 == ELMT.ELECTRIC) {
            return 0;
        } else if (e1 == ELMT.WATER && e2 == ELMT.GROUND) {
            return 1;
        } else if (e1 == ELMT.WATER && e2 == ELMT.ICE) {
            return 1;
        } else if (e1 == ELMT.ELECTRIC && e2 == ELMT.FIRE) {
            return 1;
        } else if (e1 == ELMT.ELECTRIC && e2 == ELMT.WATER) {
            return 2;
        } else if (e1 == ELMT.ELECTRIC && e2 == ELMT.GROUND) {
            return 0;
        } else if (e1 == ELMT.ELECTRIC && e2 == ELMT.ICE) {
            return 1.5;
        } else if (e1 == ELMT.GROUND && e2 == ELMT.FIRE) {
            return 1.5;
        } else if (e1 == ELMT.GROUND && e2 == ELMT.WATER) {
            return 1;
        } else if (e1 == ELMT.GROUND && e2 == ELMT.ELECTRIC) {
            return 2;
        } else if (e1 == ELMT.GROUND && e2 == ELMT.ICE) {
            return 0;
        } else if (e1 == ELMT.ICE && e2 == ELMT.FIRE) {
            return 0;
        } else if (e1 == ELMT.ICE && e2 == ELMT.WATER) {
            return 1;
        } else if (e1 == ELMT.ICE && e2 == ELMT.ELECTRIC) {
            return 0.5;
        } else if (e1 == ELMT.ICE && e2 == ELMT.GROUND) {
            return 2;
        } else { // e1 == e2
            return 1;
        }
        /*
         * Value of 0 Fire Water Water Electric Electric Ground Ground Ice Ice Fire
         * 
         * Value of 0.5 Fire Ground Ice Electric
         * 
         * Value of 1 Fire Fire Fire Electric Water Water Water Ground Water Ice
         * Electric Fire Electric Electric Ground Water Ground Ground Ice Water Ice Ice
         * 
         * Value of 1.5 Electric Ice Ground Fire
         * 
         * Value of 2 Fire Ice Water Fire Electric Water Ground Electric Ice Ground
         */
    }

    public static String elmtToString(ELMT e) {
        if (e == ELMT.FIRE) {
            return "Fire";
        } else if (e == ELMT.WATER) {
            return "Water";
        } else if (e == ELMT.ELECTRIC) {
            return "Electric";
        } else if (e == ELMT.GROUND) {
            return "Ground";
        } else if (e == ELMT.ICE) {
            return "ICE";
        }
        return "";
    }

    public static String speciesToString(SPECIES s) {
        if (s == SPECIES.Iblis) {
            return "Iblis";
        } else if (s == SPECIES.Ikan) {
            return "Ikan";
        } else if (s == SPECIES.Thor) {
            return "Thor";
        } else if (s == SPECIES.Pembantu) {
            return "Pembantu";
        } else if (s == SPECIES.Snowman) {
            return "Snowman";
        } else if (s == SPECIES.Dewa) {
            return "Dewa";
        } else if (s == SPECIES.PutriDuyung) {
            return "Putri Duyung";
        } else if (s == SPECIES.Aurora) {
            return "Aurora";
        }
        return "";
    }
}
