package enemy;

import helper.StatCalculator;

import java.util.ArrayList;

public class Monk extends NonBender{

    public Monk(int level){
        this.level=level;
        enemyName = "Monk";
        hitDice=8;
        naturalArmor=StatCalculator.setNaturalArmor(level, ARMOR_BONUS_A);

        //abilities
        ArrayList<Integer> abilities = StatCalculator.rollAbilities();
        str=abilities.get(3);
        dex=abilities.get(5)+level/8;
        con=abilities.get(0);
        inte=abilities.get(1);
        wis=abilities.get(4);
        cha=abilities.get(2);

        //total skill points
        skillPoints=StatCalculator.setSkillPoints(level, inte);

        //stats
        hp=StatCalculator.rollHp(level, con, hitDice);
        ac=StatCalculator.setArmorClass(dex, naturalArmor)+wis+level/5;
        bab=StatCalculator.setBaseAttackBonus(level, BAB_MONK);
        initiative=dex;
        grapple=bab+str;

        //saves
        fortitude=StatCalculator.setSave(level, con, ADVANTAGE);
        reflex=StatCalculator.setSave(level, dex, ADVANTAGE);
        will=StatCalculator.setSave(level, wis, ADVANTAGE);

        //distribute skill ranks
        fillNativeSkills();
        fillNonNativeSkills(nonNativeSkills);
    }

    @Override
    protected void fillNativeSkills() {
        int randomRank;
        for(int i=0;i<skills.size() && skillPoints>0;i++){
            if(i==KNOWLEDGE1){
                randomRank= StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes("Religion", randomRank, true);
                skillPoints-=randomRank;
            }else if(i==BALANCE || i==CLIMB || i==CONCENTRATION || i==ESCAPE_ARTIST || i==DIPLOMACY || i==JUMP || i==HIDE || i==LISTEN || i==MOVE_SILENTLY || i==SENSE_MOTIVE || i==SPOT || i==SWIM || i==TUMBLE){
                randomRank=StatCalculator.classSkillRank(level);
                skills.get(i).setAttributes(randomRank, true);
                skillPoints-=randomRank;
            }else if(i==EXTRA1 || i==CRAFT1 || i==CRAFT2 || i==CRAFT3 || i==KNOWLEDGE2 || i==KNOWLEDGE3 || i==KNOWLEDGE4 || i==KNOWLEDGE5 || i==PERFORM1 || i==PERFORM2 || i==PERFORM3 || i==PROFESSION1 || i==PROFESSION2|| i==EXTRA2|| i==EXTRA3){
                //operation is already done outside the method
            }else{
                nonNativeSkills.add(i);
            }
        }
    }
}
