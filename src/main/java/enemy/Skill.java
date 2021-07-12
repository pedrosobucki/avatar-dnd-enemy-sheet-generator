package enemy;

import java.util.ArrayList;

public class Skill {
    public static final int STR=0;
    public static final int DEX=1;
    public static final int CON=2;
    public static final int INT=3;
    public static final int WIS=4;
    public static final int CHA=5;

    private String name;
    private String description;
    private int abilityMod;

    private int rank;
    private boolean check=false;

    public Skill(String name, int abilityMod){
        this.name=name;
        this.abilityMod=abilityMod;
    }
    public Skill(String name){
        this.name=name;
    }
    public Skill(){}

    //setters
    public void setAttributes(String description, int rank, boolean isChecked){
        this.description=description;
        this.rank=rank;
        this.check=isChecked;
    }
    public void setAttributes(int rank){
        this.rank=rank;
    }
    public void setAttributes(int rank, boolean isChecked){
        this.rank=rank;
        this.check=isChecked;
    }
    public void setExtra(String description, int abilityMod){
        this.description=description;
        this.abilityMod=abilityMod;
    };

    //getters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getAbilityMod() {
        return abilityMod;
    }
    public int getRank() {
        return rank;
    }
    public boolean isChecked() {
        return check;
    }

}
