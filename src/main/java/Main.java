import enemy.*;
import helper.ValidateInput;
import pdfbox.PDFWriter;

public class Main {

    public static void main(String[] args){
        String enemyName = "";
        int chosenEnemy = 0;
        int level = 0;
        boolean flag=false;

        System.out.println("\n" +
                "    _           _              ___ ___  ___ \n" +
                "   /_\\__ ____ _| |_ __ _ _ _  | _ \\ _ \\/ __|\n" +
                "  / _ \\ V / _` |  _/ _` | '_| |   /  _/ (_ |\n" +
                " /_/ \\_\\_/\\__,_|\\__\\__,_|_|   |_|_\\_|  \\___|\n" +
                "                                            \n");

        flag=false;
        while(flag==false){
            System.out.println("Select the type of Enemy you want to generate:\n1.Airbender;\n2.Earthbender;\n3.Waterbender;\n4.Firebender;");
            chosenEnemy=ValidateInput.integer();
            switch (chosenEnemy){
                case Bender.AIRBENDER:
                    System.out.println("Airbender chosen.\n");
                    enemyName = "Airbender";
                    level=chooseLevel();
                    Airbender airbender = new Airbender(level);
                    new PDFWriter(airbender);
                    flag=true;
                    break;
                case Bender.EARTHBENDER:
                    System.out.println("Earthbender chosen.\n");
                    enemyName = "Earthbender";
                    level=chooseLevel();
                    Earthbender earthbender = new Earthbender(level);
                    new PDFWriter(earthbender);
                    flag=true;
                    break;
                case Bender.WATERBENDER:
                    System.out.println("Waterbender chosen.\n");
                    enemyName = "Waterbender";
                    level=chooseLevel();
                    Waterbender waterbender = new Waterbender(level);
                    new PDFWriter(waterbender);
                    flag=true;
                    break;
                case Bender.FIREBENDER:
                    System.out.println("Fierbender chosen.\n");
                    enemyName = "Firebender";
                    level=chooseLevel();
                    Firebender firebender = new Firebender(level);
                    new PDFWriter(firebender);
                    flag=true;
                    break;
                default:
                    System.out.println("Please choose a valid number.");
            }
        }
    }
    private static int chooseLevel(){
        boolean flag=false;
        int level=0;
        while(flag==false){
            System.out.print("Enter the Enemy's level: ");
            level = ValidateInput.integer();
            if(level<1 || level>20){
                System.out.println("The level must be between 1 and 20.");
            }else{
                flag=true;
            }
        }
        return level;
    }
}
