package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.util.*;
import java.io.File;
import java.lang.*;

import src.Enums.Elements.ELMT;
import src.Enums.Skills.SkillName;
import src.Interfaces.Move;

public class SaveLoad {
    private Player playerstate;

    public SaveLoad(Player p){
        this.playerstate = p;
    }
    public void save(String filename){
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(String.valueOf(this.playerstate.invEngimon.getCapacity())+" "+String.valueOf(this.playerstate.invSkill.getCapacity())+"\n");
        writer.write(this.playerstate.activeEngimon.getName()+" "+Utils.speciesToString(this.playerstate.activeEngimon.getSpecies())+" "+String.valueOf(this.playerstate.activeEngimon.getExp())+" "+String.valueOf(this.playerstate.activeEngimon.getCumExp())+" "+String.valueOf(this.playerstate.activeEngimon.getLevel())+" "+String.valueOf(this.playerstate.activeEngimon.getLife())+" "+this.playerstate.activeEngimon.getParentName(0)+" "+Utils.speciesToString(this.playerstate.activeEngimon.getParentSpecies(0))+" "+this.playerstate.activeEngimon.getParentName(1)+" "+Utils.speciesToString(this.playerstate.activeEngimon.getParentSpecies(1))+" "+String.valueOf(this.playerstate.activeEngimon.getSkills().size())+" ");
        for (int i=0; i<=this.playerstate.activeEngimon.getSkills().size(); i++){
            writer.write(this.playerstate.activeEngimon.getSkills().get(i).getName()+" "+String.valueof(this.playerstate.activeEngimon.getSkills().get(i).getMastery())+" ");
        }
        writer.write("\n");
        for (int i=0; i <= this.playerstate.invEngimon.getCapacity(); i++){
            writer.write(this.playerstate.invEngimon.getList().get(i).getName()+" "+Utils.speciesToString(this.playerstate.invEngimon.getList().get(i).getSpecies())+" "+String.valueOf(this.playerstate.invEngimon.getList().get(i).getExp())+" "+String.valueOf(this.playerstate.invEngimon.getList().get(i).getCumExp())+" "+String.valueOf(this.playerstate.invEngimon.getList().get(i).getLevel())+" "+String.valueOf(this.playerstate.invEngimon.getList().get(i).getLife())+" "+ this.playerstate.invEngimon.getList().get(i).getParentName(0)+" "+this.playerstate.invEngimon.getList().get(i).getParentName(1)+" ");
            for (int j=0; j<=this.playerstate.invEngimon.getList().get(i).getSkills().size(); j++){
                writer.write(this.playerstate.invEngimon.getList().get(i).getSkills().get(j).getName()+" "+String.valueof(this.playerstate.invEngimon.getList().get(i).getSkills().get(j).getMastery())+" ");
            }
            writer.write("\n");
        }
        for (int i=0; i <= this.playerstate.invSkill.getCapacity(); i++){
            writer.write(this.playerstate.invSkill.getList().get(i).getName()+" "+String.valueof(this.playerstate.invSkill.getList().get(i).getMastery())+" ");
        }
        writer.write("\n");
        writer.write(String.valueOf(this.playerstate.x)+" "+Stringwriter.write(String.valueOf(this.playerstate.y)+" "+Stringwriter.write(String.valueOf(this.playerstate.aex)+" "+Stringwriter.write(String.valueOf(this.playerstate.aey));
        writer.close();
    }

    public void load(String filename){
        FileInputStream fstream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        strLine = br.readLine();
        String[] token = strLine.split(" ");
        int totaleng = Integer.valueOf(token[0]);
        int totalskill = Integer.valueOf(token[1]);
        int k =1;
        while ((strLine = br.readLine()) != null){
            String[] tokens = strLine.split(" ");
            if (k <= totaleng){
                PlayerEngimon pe = new PlayerEngimon(tokens[0], Utils.StringtoSpecies(tokens[1]));
                pe.setLevel(Integer.valueOf(tokens[4]));
                pe.setExp(Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
                pe.setLife(Integer.valueOf(tokens[5]));
                PlayerEngimon p1 = new PlayerEngimon(tokens[6],Utils.StringtoSpecies(tokens[7]));
                PlayerEngimon p2 = new PlayerEngimon(tokens[8], Utils.StringtoSpecies(tokens[9]));
                pe.setParents(p1, p2);
                for (int i=0;i<= Integer.valueOf(tokens[10]);i++){
                    SkillName a = SkillName.toSkillName(tokens[10+1]);
                    Skill s = new Skill(a);
                    pe.addSkill(s);
                }
                p1.addToInventory(pe);
                k += 1;
            }
            else if (k>totaleng && k <= totaleng+totalskill){
                SkillName b = SkillName.toSkillName(tokens[0]);
                Skill a = new Skill(b)
                a.setMastery(Integer.valueOf(tokens[1]));
                p1.addToInventory(a);
            }
            else{
                p1.setPosition(Integer.valueOf(tokens[0]),Integer.valueOf(tokens[1]),Integer.valueOf(tokens[2]),tInteger.valueOf(tokens[3]))
            }
    }
}
}