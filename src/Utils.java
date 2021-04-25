package src;

import java.util.ArrayList;

import org.w3c.dom.css.ElementCSSInlineStyle;

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
    public static double getElmtAdvantage(Engimon e1, Engimon e2) {
        double adv = 0;
        ArrayList<ELMT> el1 = e1.getElmt(); // element list 1
        ArrayList<ELMT> el2 = e2.getElmt(); // element list 2

        for (ELMT elmt1 : el1) {
            for (ELMT elmt2 : el2) {
                // Value of 0
                if ((elmt1 == ELMT.FIRE && elmt2 == ELMT.WATER) || (elmt1 == ELMT.WATER && elmt2 == ELMT.ELECTRIC)
                        || (elmt1 == ELMT.ELECTRIC && elmt2 == ELMT.GROUND)
                        || (elmt1 == ELMT.GROUND && elmt2 == ELMT.ICE) || (elmt1 == ELMT.ICE && elmt2 == ELMT.FIRE)) {
                    adv = 0;
                }

                // Value of 0.5
                else if ((elmt1 == ELMT.FIRE && elmt2 == ELMT.GROUND)
                        || (elmt1 == ELMT.ICE && elmt2 == ELMT.ELECTRIC)) {
                    if (adv < 0.5) {
                        adv = 0.5;
                    }
                }

                // Value of 1
                else if ((elmt1 == elmt2) || (elmt1 == ELMT.FIRE && elmt2 == ELMT.ELECTRIC)
                        || (elmt1 == ELMT.WATER && elmt2 == ELMT.GROUND) || (elmt1 == ELMT.WATER && elmt2 == ELMT.ICE)
                        || (elmt1 == ELMT.ELECTRIC && elmt2 == ELMT.FIRE)
                        || (elmt1 == ELMT.GROUND && elmt2 == ELMT.WATER)
                        || (elmt1 == ELMT.ICE && elmt2 == ELMT.WATER)) {
                    if (adv < 1) {
                        adv = 1;
                    }
                }

                // Value of 1.5
                else if ((elmt1 == ELMT.GROUND && elmt2 == ELMT.FIRE)
                        || (elmt1 == ELMT.ELECTRIC && elmt2 == ELMT.ICE)) {
                    if (adv < 0.5) {
                        adv = 0.5;
                    }
                }

                // Value of 2
                else if ((elmt1 == ELMT.FIRE && elmt2 == ELMT.ICE) || (elmt1 == ELMT.WATER && elmt2 == ELMT.FIRE)
                        || (elmt1 == ELMT.ELECTRIC && elmt2 == ELMT.WATER)
                        || (elmt1 == ELMT.GROUND && elmt2 == ELMT.ELECTRIC)
                        || (elmt1 == ELMT.ICE && elmt2 == ELMT.GROUND)) {
                    if (adv < 2) {
                        adv = 2;
                    }
                }
            }
        }

        return adv;
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
            return "Ice";
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
