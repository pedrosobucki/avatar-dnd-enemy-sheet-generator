package enemy;

import helper.StatCalculator;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Bender extends Enemy {
    public static final int AIRBENDER=1;
    public static final int EARTHBENDER=2;
    public static final int WATERBENDER=3;
    public static final int FIREBENDER=4;

    //seeds
    protected ArrayList<String> seeds = new ArrayList<String>();
    protected ArrayList<String> lvl1 = new ArrayList<String>();
    protected ArrayList<String> lvl5 = new ArrayList<String>();
    protected ArrayList<String> lvl10 = new ArrayList<String>();
    protected ArrayList<String> lvl15 = new ArrayList<String>();
    protected ArrayList<String> lvl20 = new ArrayList<String>();
    protected void setSeeds(){
        for(int i=0;i<lvl1.size();i++){
            seeds.add(lvl1.get(i));
        }
        if(level>=5){
            for(int i=0;i<lvl5.size();i++){
                seeds.add(lvl5.get(i));
            }
        }
        if(level>=10){
            for(int i=0;i<lvl10.size();i++){
                seeds.add(lvl10.get(i));
            }
        }
        if(level>=15){
            for(int i=0;i<lvl15.size();i++){
                seeds.add(lvl15.get(i));
            }
        }
        if(level>=20){
            for(int i=0;i<lvl20.size();i++){
                seeds.add(lvl20.get(i));
            }
        }
    }
    protected abstract void establishLevelSeeds();
    public ArrayList<String> getSeeds() {
        return seeds;
    }
}
