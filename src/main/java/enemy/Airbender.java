package enemy;

import helper.StatCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Airbender extends Bender {

    public Airbender(int level){
        this.level=level;
        enemyName = "Airbender";
        hitDice=8;
        naturalArmor=StatCalculator.setNaturalArmor(level, ARMOR_BONUS_A);

        //abilities
        ArrayList<Integer> abilities = StatCalculator.rollAbilities();
        str=abilities.get(0);
        dex=abilities.get(4);
        con=abilities.get(1);
        inte=abilities.get(2);
        wis=abilities.get(5)+level/8;
        cha=abilities.get(3);

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
        skills.get(EXTRA1).setExtra("Airbending", Skill.WIS);
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
            }else if(i==BALANCE || i==CLIMB || i==CONCENTRATION || i==ESCAPE_ARTIST || i==HANDLE_ANIMAL || i==JUMP || i==RIDE || i==SWIM || i==TUMBLE){
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
    public void establishLevelSeeds() {
        //level 1
        lvl1.add("Air Blast 1d6");
        lvl1.add("Wind Shaping");
        lvl1.add("Body of Air");
        lvl1.add("Deflect Attack");
        lvl1.add("Particles");
        lvl1.add("Run as the Wind");
        lvl1.add("Palm Bow");
        lvl1.add("Air Thrust");

        //level5
        lvl5.add("Air Blast 2d6");
        lvl5.add("Air Burst");
        lvl5.add("Sustained Gusts");
        lvl5.add("Airbender's Leap");
        lvl5.add("Sound Waves");
        lvl5.add("Flowing air Strike");

        //level 10
        lvl10.add("Air Blast 3d6");
        lvl10.add("Levitate");
        lvl10.add("Air Scythe");
        lvl10.add("Deep Breath");

        //level 15
        lvl15.add("Air Blast 4d6");
        lvl15.add("The Four Winds");
        lvl15.add("Stormwinds");
        lvl15.add("Air Shield");
        lvl15.add("Tornado");

        //level 20
        lvl20.add("Air Blast 5d6");

        //sets seeds
        setSeeds();
    }
}
