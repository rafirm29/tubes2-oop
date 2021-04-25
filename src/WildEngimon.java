package src;

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
        } else {
            this.symbol = Utils.speciesToString(s).charAt(0);
        }
        this.terrain = new ArrayList<Character>();
        this.setLevel(level);
        if (s == SPECIES.Iblis) {
            this.terrain.add('^'); //mount
            this.addSkill(new Skill(SkillName.SHINKA_SHIRANUI));
        } else if (s == SPECIES.Ikan) {
            this.terrain.add('o'); // sea
            this.addSkill(new Skill(SkillName.FISH_MAN_KARATE_OGI_BURAIKAN));
        } else if (s == SPECIES.Thor) {
            this.terrain.add('-'); // grass
            this.addSkill(new Skill(SkillName.KINGDOM_COME));
        } else if (s == SPECIES.Pembantu) {
            this.terrain.add('-'); // grass
            this.addSkill(new Skill(SkillName.DESERT_ENCIERRO));
        } else if (s == SPECIES.Snowman) {
            this.terrain.add('*'); // tundra
            this.addSkill(new Skill(SkillName.PERMAFROST));
        } else if (s == SPECIES.Dewa) {
            this.terrain.add('-'); // grass
            this.terrain.add('^'); // mount
            this.addSkill(new Skill(SkillName.RAGNARAKA));
        } else if (s == SPECIES.PutriDuyung) {
            this.terrain.add('o'); // sea
            this.terrain.add('-'); // grass
            this.addSkill(new Skill(SkillName.SPEAR_OF_ELBAF));
        } else if (s == SPECIES.Aurora) {
            this.terrain.add('o'); //sea
            this.terrain.add('*'); // tundra
            this.addSkill(new Skill(SkillName.SHIMA_YURASHI));
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
