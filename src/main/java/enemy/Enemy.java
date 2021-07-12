package enemy;

import helper.StatCalculator;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Enemy {
    //bab code
    public static final int BAB_BENDER=0;
    public static final int BAB_MONK=0;
    //save type
    public static final int ADVANTAGE=0;
    public static final int DISADVANTAGE=0;

    //armor bonus category
    public static final int ARMOR_BONUS_A=0;
    public static final int ARMOR_BONUS_B=1;
    public static final int ARMOR_BONUS_C=2;
    public static final int ARMOR_BONUS_D=4;

    //info
    protected String enemyName;
    protected int level;
    protected int skillPoints;
    protected int naturalArmor;
    protected int hitDice;

    //abilities
    protected int str;
    protected int dex;
    protected int con;
    protected int inte;
    protected int wis;
    protected int cha;

    //stats
    protected int hp;
    protected int ac;
    protected int initiative;
    protected int bab;
    protected int grapple;

    //saves
    protected int fortitude;
    protected int reflex;
    protected int will;

    //skills
    protected Skill appraise = new Skill("appraise", Skill.INT);
    protected Skill balance = new Skill("balance", Skill.DEX);
    protected Skill bluff = new Skill("bluff", Skill.CHA);
    protected Skill climb = new Skill("climb", Skill.STR);
    protected Skill concentration = new Skill("concentration", Skill.CON);
    protected Skill craft1 = new Skill("craft1", Skill.INT);
    protected Skill craft2 = new Skill("craft2", Skill.INT);
    protected Skill craft3 = new Skill("craft3", Skill.INT);
    protected Skill decipherScript = new Skill("decipher", Skill.INT);
    protected Skill diplomacy = new Skill("diplomacy", Skill.CHA);
    protected Skill disableDevice = new Skill("disable", Skill.INT);
    protected Skill disguise = new Skill("disguise", Skill.CHA);
    protected Skill escapeArtist = new Skill("escape", Skill.DEX);
    protected Skill forgery = new Skill("forgery", Skill.INT);
    protected Skill gatherInformation = new Skill("gather", Skill.CHA);
    protected Skill handleAnimal = new Skill("handle", Skill.CHA);
    protected Skill heal = new Skill("heal", Skill.WIS);
    protected Skill hide = new Skill("hide", Skill.DEX);
    protected Skill intimidate = new Skill("intimidate", Skill.CHA);
    protected Skill jump = new Skill("jump", Skill.STR);
    protected Skill knowledge1 = new Skill("knowledge1", Skill.INT);
    protected Skill knowledge2 = new Skill("knowledge2", Skill.INT);
    protected Skill knowledge3 = new Skill("knowledge3", Skill.INT);
    protected Skill knowledge4 = new Skill("knowledge4", Skill.INT);
    protected Skill knowledge5 = new Skill("knowledge5", Skill.INT);
    protected Skill listen = new Skill("listen", Skill.WIS);
    protected Skill moveSilently = new Skill("move", Skill.DEX);
    protected Skill openLock = new Skill("open", Skill.DEX);
    protected Skill perform1 = new Skill("perform1", Skill.CHA);
    protected Skill perform2 = new Skill("perform2", Skill.CHA);
    protected Skill perform3 = new Skill("perform3", Skill.CHA);
    protected Skill profession1 = new Skill("profession1", Skill.WIS);
    protected Skill profession2 = new Skill("profession2", Skill.WIS);
    protected Skill ride = new Skill("ride", Skill.DEX);
    protected Skill search = new Skill("search", Skill.INT);
    protected Skill senseMotive = new Skill("sense", Skill.WIS);
    protected Skill sleightOfHand = new Skill("sleight", Skill.DEX);
    protected Skill spot = new Skill("spot", Skill.WIS);
    protected Skill survival = new Skill("survival", Skill.WIS);
    protected Skill swim = new Skill("swim", Skill.STR);
    protected Skill tumble = new Skill("tumble", Skill.DEX);
    protected Skill useRope = new Skill("rope", Skill.DEX);
    protected Skill extra1 = new Skill("extra1");
    protected Skill extra2 = new Skill("extra2");
    protected Skill extra3 = new Skill("extra3");

    protected ArrayList<Skill> skills = new ArrayList<Skill>();
    protected ArrayList<Integer> nonNativeSkills = new ArrayList();

    //skills indexes
    public static final int APPRAISE = 0;
    public static final int BALANCE = 1;
    public static final int BLUFF = 2;
    public static final int CLIMB = 3;
    public static final int CONCENTRATION = 4;
    public static final int CRAFT1 = 5;
    public static final int CRAFT2 = 6;
    public static final int CRAFT3 = 7;
    public static final int DECIPHER_SCRIPT = 8;
    public static final int DIPLOMACY = 9;
    public static final int DISABLE_DEVICE = 10;
    public static final int DISGUISE = 11;
    public static final int ESCAPE_ARTIST = 12;
    public static final int FORGERY = 13;
    public static final int GATHER_INFORMATION = 14;
    public static final int HANDLE_ANIMAL = 15;
    public static final int HEAL = 16;
    public static final int HIDE = 17;
    public static final int INTIMIDATE = 18;
    public static final int JUMP = 19;
    public static final int KNOWLEDGE1 = 20;
    public static final int KNOWLEDGE2 = 21;
    public static final int KNOWLEDGE3 = 22;
    public static final int KNOWLEDGE4 = 23;
    public static final int KNOWLEDGE5 = 24;
    public static final int LISTEN = 25;
    public static final int MOVE_SILENTLY = 26;
    public static final int OPEN_LOCK = 27;
    public static final int PERFORM1 = 28;
    public static final int PERFORM2 = 29;
    public static final int PERFORM3 = 30;
    public static final int PROFESSION1 = 31;
    public static final int PROFESSION2 = 32;
    public static final int RIDE = 33;
    public static final int SEARCH = 34;
    public static final int SENSE_MOTIVE = 35;
    public static final int SLEIGHT_OF_HAND = 36;
    public static final int SPOT = 37;
    public static final int SURVIVAL = 38;
    public static final int SWIM = 39;
    public static final int TUMBLE = 40;
    public static final int USE_ROPE = 41;
    public static final int EXTRA1 = 42;
    public static final int EXTRA2 = 43;
    public static final int EXTRA3 = 44;

    public Enemy(){
        skills.add(appraise);
        skills.add(balance);
        skills.add(bluff);
        skills.add(climb);
        skills.add(concentration);
        skills.add(craft1);
        skills.add(craft2);
        skills.add(craft3);
        skills.add(decipherScript);
        skills.add(diplomacy);
        skills.add(disableDevice);
        skills.add(disguise);
        skills.add(escapeArtist);
        skills.add(forgery);
        skills.add(gatherInformation);
        skills.add(handleAnimal);
        skills.add(heal);
        skills.add(hide);
        skills.add(intimidate);
        skills.add(jump);
        skills.add(knowledge1);
        skills.add(knowledge2);
        skills.add(knowledge3);
        skills.add(knowledge4);
        skills.add(knowledge5);
        skills.add(listen);
        skills.add(moveSilently);
        skills.add(openLock);
        skills.add(perform1);
        skills.add(perform2);
        skills.add(perform3);
        skills.add(profession1);
        skills.add(profession2);
        skills.add(ride);
        skills.add(search);
        skills.add(senseMotive);
        skills.add(sleightOfHand);
        skills.add(spot);
        skills.add(survival);
        skills.add(swim);
        skills.add(tumble);
        skills.add(useRope);
        skills.add(extra1);
        skills.add(extra2);
        skills.add(extra3);
    }
    public Enemy(int level){
        skills.add(appraise);
        skills.add(balance);
        skills.add(bluff);
        skills.add(climb);
        skills.add(concentration);
        skills.add(craft1);
        skills.add(craft2);
        skills.add(craft3);
        skills.add(decipherScript);
        skills.add(diplomacy);
        skills.add(disableDevice);
        skills.add(disguise);
        skills.add(escapeArtist);
        skills.add(forgery);
        skills.add(gatherInformation);
        skills.add(handleAnimal);
        skills.add(heal);
        skills.add(hide);
        skills.add(intimidate);
        skills.add(jump);
        skills.add(knowledge1);
        skills.add(knowledge2);
        skills.add(knowledge3);
        skills.add(knowledge4);
        skills.add(knowledge5);
        skills.add(listen);
        skills.add(moveSilently);
        skills.add(openLock);
        skills.add(perform1);
        skills.add(perform2);
        skills.add(perform3);
        skills.add(profession1);
        skills.add(profession2);
        skills.add(ride);
        skills.add(search);
        skills.add(senseMotive);
        skills.add(sleightOfHand);
        skills.add(spot);
        skills.add(survival);
        skills.add(swim);
        skills.add(tumble);
        skills.add(useRope);
        skills.add(extra1);
        skills.add(extra2);
        skills.add(extra3);
    }

    //getters
    public String getEnemyName() {
        return enemyName;
    }
    public int getLevel() {
        return level;
    }
    public int getStr() {
        return str;
    }
    public int getDex() {
        return dex;
    }
    public int getCon() {
        return con;
    }
    public int getInt() {
        return inte;
    }
    public int getWis() {
        return wis;
    }
    public int getCha() {
        return cha;
    }
    public int getHp() {
        return hp;
    }
    public int getAc() {
        return ac;
    }
    public int getInitiative() {
        return initiative;
    }
    public int getBab() {
        return bab;
    }
    public int getGrapple() {
        return grapple;
    }
    public int getFortitude() {
        return fortitude;
    }
    public int getReflex() {
        return reflex;
    }
    public int getWill() {
        return will;
    }
    public ArrayList<Skill> getSkills() {
        return skills;
    }

    protected abstract void fillNativeSkills();
    protected void fillNonNativeSkills(ArrayList<Integer> nonNativeSkills){
        int randomRank;
        Collections.shuffle(nonNativeSkills);
        for(int i=0;i<nonNativeSkills.size() && skillPoints>0;i++){
            randomRank= StatCalculator.notClassSkillRank(level);
            skills.get(nonNativeSkills.get(i)).setAttributes(randomRank);
            skillPoints-=randomRank;
        }
    }
}