package enemy;

import helper.StatCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Firebender extends Bender {

    public Firebender(int level){
        this.level=level;
        enemyName = "Firebender";
        hitDice=8;
        naturalArmor=StatCalculator.setNaturalArmor(level, ARMOR_BONUS_B);

        //abilities
        ArrayList<Integer> abilities = StatCalculator.rollAbilities();
        str=abilities.get(2);
        dex=abilities.get(4);
        con=abilities.get(3);
        inte=abilities.get(1);
        wis=abilities.get(5)+level/8;
        cha=abilities.get(0);

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
                skills.get(i).setAttributes("History", randomRank, true);
                skillPoints-=randomRank;
            }else if(i==BALANCE || i==CLIMB || i==CONCENTRATION || i==INTIMIDATE || i==JUMP || i==LISTEN || i==SPOT){
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
        lvl1.add("Fire Blast 1d6");
        lvl1.add("Play with Fire");
        lvl1.add("Deflect Attack");
        lvl1.add("Fire Kick");
        lvl1.add("Fire Whip");
        lvl1.add("Explosion");
        lvl1.add("Blades of Fire");

        //level 5
        lvl5.add("Fire Blast 2d6");
        lvl5.add("Heat Wave");
        lvl5.add("Burning Rush");
        lvl5.add("Fire Sweep");
        lvl5.add("Fire in the Stomach");
        lvl5.add("Flowing air Strike");

        //level 10
        lvl10.add("Fire Blast 3d6");
        lvl10.add("Incandescence");
        lvl10.add("Intensity");

        //level 15
        lvl15.add("Fire Blast 4d6");
        lvl15.add("Breath of the Dragon");
        lvl15.add("Fire Burst");
        lvl15.add("Wall of Fire");
        lvl15.add("Flamethrower");
        lvl15.add("Pyrotechnics");

        //level 20
        lvl20.add("Fire Blast 5d6");

        setSeeds();
    }
}
