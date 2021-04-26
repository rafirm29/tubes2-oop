package src;

import java.security.SecureRandom;
import java.util.*;

import src.Enums.Skills.SkillName;
import src.Interfaces.Move;

public class WildEngimon extends Engimon implements Move {
    private int x;
    private int y;
    private char symbol;
    ArrayList<Character> terrain;

    public WildEngimon(String name, SPECIES s, int x, int y, int level) {
        super(name, s);
        this.x = x;
        this.y = y;
        if (s == SPECIES.Ikan) {
            this.symbol = 'F';
        } else if(s == SPECIES.PutriDuyung) {
            this.symbol = 'U';
        } else if(s == SPECIES.Pembantu) {
            this.symbol = 'N';
        } else {
            this.symbol = Utils.speciesToString(s).charAt(0);
        }
        this.terrain = new ArrayList<Character>();
        this.setLevel(level);

        SecureRandom rand = new SecureRandom();
        int r;

        int rare = rand.nextInt(20);
        if (rare == 0) {
            this.addSkill(new Skill(SkillName.DIVINE_DEPARTURE));    
        }

        if (s == SPECIES.Iblis) {
            this.terrain.add('^'); //mount
            r = rand.nextInt(2);
            if (r == 0) {
                this.addSkill(new Skill(SkillName.SHINKA_SHIRANUI));
            } else {
                this.addSkill(new Skill(SkillName.RED_HAWK));
            }
        } else if (s == SPECIES.Ikan) {
            this.terrain.add('o'); // sea
            r = rand.nextInt(2);
            if (r == 0) {
                this.addSkill(new Skill(SkillName.FISH_MAN_KARATE_OGI_BURAIKAN));
            } else {
                this.addSkill(new Skill(SkillName.SEA_CURRENT_LIFTER));
            }
        } else if (s == SPECIES.Thor) {
            this.terrain.add('-'); // grass
            r = rand.nextInt(2);
            if (r == 0) {
                this.addSkill(new Skill(SkillName.KINGDOM_COME));
            } else {
                this.addSkill(new Skill(SkillName.MAMARAGAN));
            }
        } else if (s == SPECIES.Pembantu) {
            this.terrain.add('-'); // grass
            r = rand.nextInt(2);
            if (r == 0) {
                this.addSkill(new Skill(SkillName.DESERT_ENCIERRO));
            } else {
                this.addSkill(new Skill(SkillName.GROUND_SECCO));
            }
        } else if (s == SPECIES.Snowman) {
            this.terrain.add('*'); // tundra
            r = rand.nextInt(2);
            if (r == 0) {
                this.addSkill(new Skill(SkillName.PERMAFROST));
            } else {
                this.addSkill(new Skill(SkillName.ICE_TIME));
            }
            
        } else if (s == SPECIES.Dewa) {
            this.terrain.add('-'); // grass
            this.terrain.add('^'); // mount
            r = rand.nextInt(4);
            this.addSkill(new Skill(SkillName.RAGNARAKA));
            if (r == 0) {
                this.addSkill(new Skill(SkillName.SHINKA_SHIRANUI));
            } else if (r == 1) {
                this.addSkill(new Skill(SkillName.RED_HAWK));
            } else if (r == 2) {
                this.addSkill(new Skill(SkillName.KINGDOM_COME));
            } else {
                this.addSkill(new Skill(SkillName.MAMARAGAN));
            }
        } else if (s == SPECIES.PutriDuyung) {
            this.terrain.add('o'); // sea
            this.terrain.add('-'); // grass
            r = rand.nextInt(4);
            this.addSkill(new Skill(SkillName.SPEAR_OF_ELBAF));
            if (r == 0) {
                this.addSkill(new Skill(SkillName.FISH_MAN_KARATE_OGI_BURAIKAN));
            } else if (r == 1) {
                this.addSkill(new Skill(SkillName.SEA_CURRENT_LIFTER));
            } else if (r == 2) {
                this.addSkill(new Skill(SkillName.DESERT_ENCIERRO));
            } else {
                this.addSkill(new Skill(SkillName.GROUND_SECCO));
            }
        } else if (s == SPECIES.Aurora) {
            this.terrain.add('o'); //sea
            this.terrain.add('*'); // tundra
            r = rand.nextInt(4);
            this.addSkill(new Skill(SkillName.SHIMA_YURASHI));
            if (r == 0) {
                this.addSkill(new Skill(SkillName.FISH_MAN_KARATE_OGI_BURAIKAN));
            } else if (r == 1) {
                this.addSkill(new Skill(SkillName.SEA_CURRENT_LIFTER));
            } else if (r == 2) {
                this.addSkill(new Skill(SkillName.PERMAFROST));
            } else {
                this.addSkill(new Skill(SkillName.ICE_TIME));
            }
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public void up() {
        this.x -= 1;
    }

    @Override
    public void right() {
        // TODO Auto-generated method stub
        this.y += 1;
    }

    @Override
    public void down() {
        // TODO Auto-generated method stub
        this.x += 1;
    }

    @Override
    public void left() {
        // TODO Auto-generated method stub
        this.y -= 1;
    }
}

// Iblis, -> fire -> mountains (I)
// Ikan, -> water -> sea (F)
// Thor, -> electric-> grassland (T)
// Pembantu, -> ground -> grassland (p)
// Snowman,  -> ice -> tundra (S)
// Dewa, -> fire/electric -> grassland/mountains (D)
// PutriDuyung, -> water/ground -> sea/grassland (U)
// Aurora -> water/ice -> sea/tundra (A)
