package src;
import java.util.ArrayList;

import org.w3c.dom.css.ElementCSSInlineStyle;

import src.Enums.Elements.ELMT;
import src.Enums.Species.SPECIES;

public class Utils {
    public static double getElmtAdvantage(Engimon e1, Engimon e2) {
        double adv = 0;
        ArrayList<ELMT> el1 = e1.getElmt();    // element list 1
        ArrayList<ELMT> el2 = e2.getElmt();    // element list 2
        
        
        for (ELMT elmt1 : el1) {
            for (ELMT elmt2 : el2) {
                // Value of 0
                if ((elmt1 == ELMT.FIRE && elmt2 == ELMT.WATER)
                    || (elmt1 == ELMT.WATER && elmt2 == ELMT.ELECTRIC)
                    || (elmt1 == ELMT.ELECTRIC && elmt2 == ELMT.GROUND)
                    || (elmt1 == ELMT.GROUND && elmt2 == ELMT.ICE)
                    || (elmt1 == ELMT.ICE && elmt2 == ELMT.FIRE)) {
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
                else if ((elmt1 == elmt2)
                            || (elmt1 == ELMT.FIRE && elmt2 == ELMT.ELECTRIC)
                            || (elmt1 == ELMT.WATER && elmt2 == ELMT.GROUND)
                            || (elmt1 == ELMT.WATER && elmt2 == ELMT.ICE)
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
                else if ((elmt1 == ELMT.FIRE && elmt2 == ELMT.ICE)
                    || (elmt1 == ELMT.WATER && elmt2 == ELMT.FIRE)
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
