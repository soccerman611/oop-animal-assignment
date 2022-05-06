/*
Name: Steven Vezina
Date: May 4th 2022
Desc: animal competition yes
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int MainInput = 0; //Input will be asked from the player a lot during this
        int Gamemode = 0; //1 is main mode, 3 is freeplay
        int DifficultySelect; //1 is easy, 2 is normal, 3 is hard
        int Inputisvalid = 0;
        int freeplaycounter = 0;
        int AttributeChoose = 0;

        while (Inputisvalid == 0){
            Scanner sin = new Scanner(System.in);
            System.out.println("Do you want Main Mode or Freeplay Mode? 1 for Main Mode, 2 for Freeplay mode");
            MainInput = sin.nextInt();

            if (MainInput < 1 || MainInput > 2){
                System.out.println("Invalid input!");
                continue;
            }
            Inputisvalid++;

            if (MainInput == 1){
                Gamemode = 1;
            }
            else {
                Gamemode = 2;
            }

        }
        Inputisvalid = 0;
        MainInput = 0;

        if (Gamemode == 2){ //freeplay animal select
            System.out.println("Fortnite");

            for (int i = 0; i < 2; i++){
                while (Inputisvalid == 0){
                    Scanner sin = new Scanner(System.in);
                    System.out.println("What animal do you want? 1 for Tiger, 2 for Wolf, 3 for Spider, 4 for Vulture, 5 for Shark, 6 for Pufferfish");
                    MainInput = sin.nextInt();
                    if (MainInput < 1 || MainInput > 6){
                        System.out.println("idiot");
                        continue;
                    }
                    Inputisvalid++;

                }
                Inputisvalid = 0;

                while (Inputisvalid == 0){
                    Scanner sin = new Scanner(System.in);
                    System.out.println("What attribute do you want? 1 for Quick Thinking, 2 for Special Boost, 3 for Another Chance, 4 for Thorns, 5 for Environment Boost");
                    System.out.println("6 for Double Vision, 7 for Tough Spot, 8 for Iron Armor, 9 for Neutral Response");
                    AttributeChoose = sin.nextInt();

                    if (AttributeChoose < 1 || AttributeChoose > 9){
                        System.out.println("why");
                        continue;
                    }
                    Inputisvalid++;
             
                }
                ChooseAnAnimal(MainInput, freeplaycounter, AttributeChoose);
                freeplaycounter = 1;   
                Inputisvalid = 0; 
            }

            
        }
   
        
    }

    public static void ChooseAnAnimal(int freeplaycounter, int MainInput, int AttributeChoose){
        System.out.println("Among Us");

    }

}
