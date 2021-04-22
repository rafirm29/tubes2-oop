import Enums.Elements.ELMT;
import Enums.Species.SPECIES;

public class Utils {
    public static void getElmtAdvantage(Engimon e1, Engimon e2) {
        /*
        Value of 0
        Fire Water
        Water Electric
        Electric Ground
        Ground Ice
        Ice Fire

        Value of 0.5
        Fire Ground
        Ice Electric

        Value of 1
        Fire Fire
        Fire Electric
        Water Water
        Water Ground
        Water Ice
        Electric Fire
        Electric Electric
        Ground Water
        Ground Ground
        Ice Water
        Ice Ice

        Value of 1.5
        Electric Ice
        Ground Fire

        Value of 2
        Fire Ice
        Water Fire
        Electric Water
        Ground Electric
        Ice Ground
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
