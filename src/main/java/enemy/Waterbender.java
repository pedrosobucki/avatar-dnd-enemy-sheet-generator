package enemy;

import helper.StatCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Waterbender extends Bender {

    public Waterbender(int level){
        this.level=level;
        enemyName = "Waterbender";
        hitDice=8;
        naturalArmor=StatCalculator.setNaturalArmor(level, ARMOR_BONUS_B);

        //abilities
        ArrayList<Integer> abilities = StatCalculator.rollAbilities();
        str=abilities.get(0);
        dex=abilities.get(4);
        con=abilities.get(3);
        inte=abilities.get(2);
        wis=abilities.get(5)+level/8;
        cha=abilities.get(1);

        //total skill points
        skillPoints=StatCalculator.setSkillPoints(level, inte);

        //stats
        hp=StatCalculator.rollHp(level, con, hitDice);
        ac=StatCalculator.setArmorClass(dex, naturalArmor);
        bab=StatCalculator.setBaseAttackBonus(level, BAB_BENDER);
        initiative=dex;
        grapple=bab+str;

        //saves
        fortitude=StatCalculator.setSave(level, con, DISADVANTAGE);
        reflex=StatCalculator.setSave(level, dex, ADVANTAGE);
        will=StatCalculator.setSave(level, wis, ADVANTAGE);

        //set seeds
        establishLevelSeeds();

        //skills
        skills.get(EXTRA1).setExtra("Waterbending", Skill.WIS);
        //this rank attribute makes sure a bender's bending level is never too low
        skillPoints-=level;
        skills.get(EXTRA1).setAttributes(level, true);
        fillNativeSkills();
        fillNonNativeSkills(nonNativeSkills);
    }

    @Override
    protected void fillNativeSkills(){
        int randomRank;
        for(int i=0;i<skills.size() && skillPoints>0;i++){
            if(i==KNOWLEDGE1){
                randomRank=StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes("Bending", randomRank, true);
                skillPoints-=randomRank;
            }else if(i==KNOWLEDGE2){
                randomRank=StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes("Religion", randomRank, true);
                skillPoints-=randomRank;
            }else if(i==KNOWLEDGE3){
                randomRank=StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes("History", randomRank, true);
                skillPoints-=randomRank;
            }else if(i==CLIMB || i==CONCENTRATION || i==DIPLOMACY || i==HANDLE_ANIMAL || i==HEAL || i==JUMP || i==LISTEN || i==SENSE_MOTIVE || i==SPOT || i==SURVIVAL || i==SWIM || i==USE_ROPE){
                randomRank=StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes(randomRank, true);
                skillPoints-=randomRank;
            }else if(i==EXTRA1 || i==CRAFT1 || i==CRAFT2 || i==CRAFT3 || i==KNOWLEDGE4 || i==KNOWLEDGE5 || i==PERFORM1 || i==PERFORM2 || i==PERFORM3 || i==PROFESSION1 || i==PROFESSION2|| i==EXTRA2|| i==EXTRA3){
                //operation is already done outside the method
            }else{
                nonNativeSkills.add(i);
            }
        }
    }

    //seeds
    @Override
    protected void establishLevelSeeds() {
        //level 1
        lvl1.add("Water Blast 1d6");
        lvl1.add("Manipulate");
        lvl1.add("Melt/Freeze");
        lvl1.add("Mist");
        lvl1.add("Water Whip");
        lvl1.add("Tentacle");
        lvl1.add("Ice Shards");

        //level 5
        lvl5.add("Water Blast 2d6");
        lvl5.add("Healing Water");
        lvl5.add("Water Shield");
        lvl5.add("Steady Stance");

        //level 10
        lvl10.add("Water Blast 3d6");
        lvl10.add("Rise with the Tides");
        lvl10.add("Pressure");
        lvl10.add("Propel");
        lvl10.add("Wave");
        lvl10.add("Armor");

        //level 15
        lvl15.add("Water Blast 4d6");
        lvl15.add("Golem");
        lvl15.add("Feel the Flow");
        lvl15.add("Bend Plants");
        lvl15.add("Blizard");

        //level 20
        lvl20.add("Water Blast 5d6");

        setSeeds();
    }
}
