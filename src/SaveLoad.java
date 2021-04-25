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
import src.Interfaces.Move;

public class SaveLoad {
    private Player playerstate;

    public SaveLoad(Player p){
        this.playerstate = p;
    }
    public void save(String filename){
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(this.playerstate.activeEngimon.getName()+" "+Utils.speciesToString(this.playerstate.activeEngimon.getSpecies())+" "+String.valueOf(this.playerstate.activeEngimon.getExp())+" "+String.valueOf(this.playerstate.activeEngimon.getCumExp())+" "+String.valueOf(this.playerstate.activeEngimon.getLevel())+" "+String.valueOf(this.playerstate.activeEngimon.getLife())+" "+this.playerstate.activeEngimon.getParentName(0)+" "+Utils.speciesToString(this.playerstate.activeEngimon.getParentSpecies(0))+" "+this.playerstate.activeEngimon.getParentName(1)+" "+Utils.speciesToString(this.playerstate.activeEngimon.getParentSpecies(1))+" ");
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
        writer.close();
    }

    public void load(String filename){
        FileInputStream fstream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null){
            String[] tokens = strLine.split(" ");
            PlayerEngimon xenojiva = new PlayerEngimon(tokens[0], Utils.StringtoSpecies(tokens[1]));
            xenojiva.setLevel(Integer.valueOf(tokens[4]));
            xenojiva.setExp(Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
            xenojiva.setLife(Integer.valueOf(tokens[5]));
            PlayerEngimon p1 = new PlayerEngimon(tokens[6],Utils.StringtoSpecies(tokens[7]));
            PlayerEngimon p2 = new PlayerEngimon(tokens[8], Utils.StringtoSpecies(tokens[9]));
            xenojiva.setParents(p1, p2);
        }
    }
}