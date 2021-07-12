package helper;

import enemy.Enemy;

import java.util.ArrayList;
import java.util.Collections;

public class StatCalculator {

    //method to roll the abilities initial scores
    public static ArrayList<Integer> rollAbilities(){
        ArrayList<Integer> abilities = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            abilities.add(abilityRoll());
        }
        Collections.sort(abilities);
        return abilities;
    }

    //method to roll HP
    public static int rollHp(int level, int constitution, int hitDice){
        int hp=hitDice+constitution;
        for (int i=0;i<level-1;i++){
            //hp+=constitution+(int) (Math.random( )*hitDice + 1);  //random HP
            hp+=constitution+(hitDice/2);   //average HP
        }
        return hp;
    }

    //method to set natural armor
    public static int setNaturalArmor(int level, int armorBonus){
        int naturalArmor;

        if(level<=2){
            naturalArmor=2;
        }else if(level<=5){
            naturalArmor=3;
        }else if(level<=8){
            naturalArmor=4;
        }else if(level<=11){
            naturalArmor=5;
        }else if(level<=14){
            naturalArmor=6;
        }else if(level<=17){
            naturalArmor=7;
        }else{
            naturalArmor=8;
        }
        return naturalArmor+armorBonus;
    }

    //method to set total skill points
    public static int setSkillPoints(int level, int intelligence){
        int skillPoints=(4*(4+intelligence))+((level-1)*(4+intelligence));
        return skillPoints;
    }

    //method to set armor class
    public static int setArmorClass(int dexterity, int naturalArmor){
        int armorClass=10+dexterity+naturalArmor;
        return armorClass;
    }

    //set base attack bonus
    public static int setBaseAttackBonus(int level, int babBonus){
        int bab;
        if(level<=4){
            bab=level-1;
        }else if(level<=8){
            bab=level-2;
        }else if(level<=12){
            bab=level-3;
        }else if(level<=16){
            bab=level-4;
        }else{
            bab=level-5;
        }
        return bab+babBonus;
    }

    //set save
    public static int setSave(int level, int statModifier, int saveType){
        int save=0;
        if(saveType==Enemy.DISADVANTAGE){
            save+=level/3;
        }else{
            save=2+(level/2);
        }
        return save+statModifier;
    }

    //method to get random rank for class skills
    public static int classSkillRank(int level){
        int skillRank = (int)(Math.random( )*(level+1));
        return skillRank;
    }

    //method to get random rank for skills which are not class native
    public static int notClassSkillRank(int level){
        int skillRank = (int)(Math.floor(Math.random( )*(level/2+1)));
        return skillRank;
    }

    //method to roll 4d6 and calculate modifier from the 3 highest rolls
    private static int abilityRoll(){
        int modifier = 0;
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for(int i=0;i<4;i++){
            int score = (int) (Math.random( )*6 + 1);
            rolls.add(score);
        }
        Collections.sort(rolls);
        modifier=rolls.get(1)+rolls.get(2)+rolls.get(3);
        if(modifier<=11){
            modifier=0;
        }else if(modifier>=12 && modifier<=13){
            modifier=1;
        }else if(modifier>=14 && modifier<=15){
            modifier=2;
        }else if(modifier>=16 && modifier<=17){
            modifier=3;
        }else{
            modifier=4;
        }
        return modifier;
    }

    //testing method
    public static void main(String[] args){
        //rollHp(8, 2, 8);
        //abilityRoll();
        //System.out.println(classSkillRank(2));
        //System.out.println(notClassSkillRank(2));
    }
}
