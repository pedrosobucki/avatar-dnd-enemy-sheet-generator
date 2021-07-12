package pdfbox;

import enemy.Bender;
import enemy.Enemy;
import enemy.Skill;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDFWriter {
    public static final String TRUE="Yes";
    public static final String FALSE="Off";

     public PDFWriter(Enemy enemy) {
         try {
             PDDocument document = PDDocument.load(new File("C:/Users/pedro/Desktop/Pedro/Textos/RPG/Avatar/" +
                     "autogenerated enemy sheet/character sheet/enemy_sheet_form.pdf"));
             PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
             fillStats(enemy, acroForm);
             if(enemy instanceof Bender){
                 fillSeeds((Bender) enemy, acroForm);
             }
             fillSkills(enemy, acroForm);

             String code = getDateAndTime();
             document.save("C:/Users/pedro/Desktop/Pedro/Textos/RPG/Avatar/autogenerated enemy sheet" +
                     "/Enemies/"+enemy.getEnemyName()+" lvl"+enemy.getLevel()+" ("+code+").pdf");
             document.close();
             System.out.println("Enemy sheet successfully created!");
         }catch (Exception e){
             System.out.println("Failed to generate enemy sheet! Error: "+e.getMessage());
         }
     }

     private String getDateAndTime(){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
         LocalDateTime now = LocalDateTime.now();
         return dtf.format(now);
     }
     private void fillStats(Enemy enemy, PDAcroForm acroForm){
         try{
             PDField field = acroForm.getField("tb_enemy_type");
             field.setValue(enemy.getEnemyName());
             field = acroForm.getField("tb_level");
             field.setValue(Integer.toString(enemy.getLevel()));

             field = acroForm.getField("tb_strength");
             field.setValue(Integer.toString(enemy.getStr()));
             field = acroForm.getField("tb_dexterity");
             field.setValue(Integer.toString(enemy.getDex()));
             field = acroForm.getField("tb_constitution");
             field.setValue(Integer.toString(enemy.getCon()));
             field = acroForm.getField("tb_intelligence");
             field.setValue(Integer.toString(enemy.getInt()));
             field = acroForm.getField("tb_wisdom");
             field.setValue(Integer.toString(enemy.getWis()));
             field = acroForm.getField("tb_charisma");
             field.setValue(Integer.toString(enemy.getCha()));

             field = acroForm.getField("tb_hp");
             field.setValue(Integer.toString(enemy.getHp()));
             field = acroForm.getField("tb_ac");
             field.setValue(Integer.toString(enemy.getAc()));
             field = acroForm.getField("tb_initiative");
             field.setValue(Integer.toString(enemy.getInitiative()));
             field = acroForm.getField("tb_grapple");
             field.setValue(Integer.toString(enemy.getGrapple()));
             field = acroForm.getField("tb_bab");
             field.setValue(Integer.toString(enemy.getBab()));

             field = acroForm.getField("tb_fortitude");
             field.setValue(Integer.toString(enemy.getFortitude()));
             field = acroForm.getField("tb_reflex");
             field.setValue(Integer.toString(enemy.getReflex()));
             field = acroForm.getField("tb_will");
             field.setValue(Integer.toString(enemy.getWill()));
         }catch(Exception e){
             System.out.println("An error occurred while filling the stats! ERROR: "+e.getMessage());
         }
     }
     private void fillSeeds(Bender enemy, PDAcroForm acroForm){
         try{
             String seeds="";
             for(int i=0;i<enemy.getSeeds().size();i++){
                 seeds+=enemy.getSeeds().get(i)+";\n";
             }
             PDField field = acroForm.getField("tb_seeds");
             field.setValue(seeds);
         }catch (Exception e){
             System.out.println("An error occurred while filling seeds! ERROR: "+e.getMessage());
         }
     }
     private void fillSkills(Enemy enemy, PDAcroForm acroForm){
         try{
             Skill skill;
             PDField field;
             int mod=0;
             for(int i=0;i<enemy.getSkills().size();i++){
                skill = enemy.getSkills().get(i);
                if(skill.getAbilityMod()==Skill.STR){
                    mod=enemy.getStr();
                }else if(skill.getAbilityMod()==Skill.DEX){
                    mod=enemy.getDex();
                }else if(skill.getAbilityMod()==Skill.CON){
                    mod=enemy.getCon();
                }else if(skill.getAbilityMod()==Skill.INT){
                    mod=enemy.getInt();
                }else if(skill.getAbilityMod()==Skill.WIS){
                    mod=enemy.getWis();
                }else if(skill.getAbilityMod()==Skill.CHA){
                    mod=enemy.getCha();
                }
                field = acroForm.getField("tb_"+skill.getName()+"_rank");
                field.setValue(Integer.toString(skill.getRank()));
                field = acroForm.getField("tb_"+skill.getName());
                field.setValue(Integer.toString(skill.getRank()+mod));
                if(skill.isChecked()){
                    field = acroForm.getField("cb_"+skill.getName());
                    field.setValue(TRUE);
                }
                if(skill.getDescription()!=null){
                    field = acroForm.getField("tb_"+skill.getName()+"_desc");
                    field.setValue(skill.getDescription());
                }
             }
         }catch (Exception e){
             System.out.println("An error occurred while filling skills! ERROR: "+e.getMessage());
         }
     }
}