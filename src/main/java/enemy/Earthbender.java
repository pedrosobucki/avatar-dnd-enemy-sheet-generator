package enemy;

import helper.StatCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Earthbender extends Bender {

    public Earthbender(int level){
        this.level=level;
        enemyName = "Earthbender";
        hitDice=8;
        naturalArmor=StatCalculator.setNaturalArmor(level, ARMOR_BONUS_B);

        //abilities
        ArrayList<Integer> abilities = StatCalculator.rollAbilities();
        str=abilities.get(4);
        dex=abilities.get(0);
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
        fortitude=StatCalculator.setSave(level, con, ADVANTAGE);
        reflex=StatCalculator.setSave(level, dex, DISADVANTAGE);
        will=StatCalculator.setSave(level, wis, ADVANTAGE);

        //set seeds
        establishLevelSeeds();

        //skills
        skills.get(EXTRA1).setExtra("Earthbending", Skill.WIS);
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
                skills.get(i).setAttributes("Geography", randomRank, true);
                skillPoints-=randomRank;
            }else if(i==CLIMB || i==CONCENTRATION || i==GATHER_INFORMATION || i==INTIMIDATE || i==JUMP || i==LISTEN || i==SPOT){
                randomRank=StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes(randomRank, true);
                skillPoints-=randomRank;
            }else if(i==EXTRA1 || i==CRAFT1 || i==CRAFT2 || i==CRAFT3 || i==KNOWLEDGE3 || i==KNOWLEDGE4 || i==KNOWLEDGE5 || i==PERFORM1 || i==PERFORM2 || i==PERFORM3 || i==PROFESSION1 || i==PROFESSION2|| i==EXTRA2|| i==EXTRA3){
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
        lvl1.add("Earth Blast 1d6");
        lvl1.add("Move a Rock");
        lvl1.add("Deflect Attack");
        lvl1.add("Dust");
        lvl1.add("Earth Wall");
        lvl1.add("Tilt");
        lvl1.add("Column");

        //level 5
        lvl5.add("Earth Blast 2d6");
        lvl5.add("Armor");
        lvl5.add("Steady Stance");
        lvl5.add("Create Rubble");

        //level 10
        lvl10.add("Earth Blast 3d6");
        lvl10.add("Tremorsense");
        lvl10.add("Compact");
        lvl10.add("Golem");

        //level 15
        lvl15.add("Earth Blast 4d6");
        lvl15.add("Earthen Stride");
        lvl15.add("Catapult");
        lvl15.add("Excavate");
        lvl15.add("Earthquake");
        lvl15.add("Immobilize");
        lvl15.add("Rift");

        //level 20
        lvl20.add("Earth Blast 5d6");

        setSeeds();
    }
}
