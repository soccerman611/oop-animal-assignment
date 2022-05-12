/*
Name: Steven Vezina
Date: May 4th 2022
Desc: animal competition yes
*/

import java.util.*;

public class Main {
    static Animal user = new Animal();
    static Animal user2 = new Animal();
    static String KnownAttribute;
    static String KnownAttribute2;


    public static void main(String[] args) {
        int MainInput = 0; //Input will be asked from the player a lot during this
        int Gamemode = 0; //1 is main mode, 3 is freeplay
        int DifficultySelect = 0; //1 is easy, 2 is normal, 3 is hard
        int Inputisvalid = 0;
        int freeplaycounter = 1;
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
                    System.out.println("What attribute do you want? 0 for Quick Thinking, 1 for Special Boost, 2 for Another Chance, 3 for Thorns, 4 for Environment Boost");
                    System.out.println("5 for Double Vision, 6 for Tough Spot, 7 for Iron Armor, 8 for Neutral Response");
                    AttributeChoose = sin.nextInt();

                    if (AttributeChoose < 0 || AttributeChoose > 8){
                        System.out.println("why");
                        continue;
                    }
                    Inputisvalid++;
             
                }
                ChooseAnAnimal(MainInput, freeplaycounter, AttributeChoose);
                freeplaycounter++;   
                Inputisvalid = 0; 
            }   
        }

        if (Gamemode == 1){
            System.out.println("not freeplay");

            while (Inputisvalid < 3){
                if (Inputisvalid == 0){
                    Scanner sin = new Scanner(System.in);
                    System.out.println("What animal do you want? 1 for Tiger, 2 for Wolf, 3 for Spider, 4 for Vulture, 5 for Shark, 6 for Pufferfish");
                    MainInput = sin.nextInt();
                    if (MainInput < 1 || MainInput > 6){
                        System.out.println("Why");
                        continue;
                    }
                    Inputisvalid++;
                    ChooseAnAnimal(MainInput, freeplaycounter, AttributeChoose);


                }

                if (Inputisvalid == 1){
                    Scanner sin = new Scanner(System.in);
                    System.out.println("What attribute do you want? 0 for Quick Thinking, 1 for Special Boost, 2 for Another Chance, 3 for Thorns, 4 for Environment Boost");
                    System.out.println("5 for Double Vision, 6 for Tough Spot, 7 for Iron Armor, 8 for Neutral Response");
                    AttributeChoose = sin.nextInt();

                    if (AttributeChoose < 0 || AttributeChoose > 8){
                        System.out.println("Why");
                        continue;
                    }
                    Inputisvalid++;



                }

                Scanner sin = new Scanner(System.in);
                System.out.println("What difficulty? 1 for Easy, 2 for Normal, 3 for Hard");
                DifficultySelect = sin.nextInt();
                if (DifficultySelect < 1 || DifficultySelect > 3){
                    System.out.println("Why");
                    continue;
                }
                Inputisvalid = 10;

            }
            ChooseAnAnimal(MainInput, AttributeChoose, freeplaycounter);
            Inputisvalid = 0;
        }

        /*Pufferfish amongus = new Pufferfish();
        System.out.println(amongus.Desc());*/

        int score = 0;
        int RandomEnv = 0;
        RandomEnv = (int)(Math.random()*3) + 1;

        int num = 6;

        

        

       
        /*score = amongus.calculate();
        System.out.println(score);*/

        System.out.println(user.Desc());
        System.out.println(KnownAttribute);
        System.out.println(user2.Desc());
        System.out.println(KnownAttribute2);

        System.out.println("Welcome to the fight !");
        System.out.println("Today the " + user +  " and the " + user2 + " fight!");
        
        
        

   
        
    }

    //Animal user, Animal user2

    public static void ChooseAnAnimal(int freeplaycounter, int MainInput, int AttributeChoose){


        if (freeplaycounter == 1){ //set user's animal
            AttributeList javamoment = new AttributeList();
            KnownAttribute = javamoment.Attributes(AttributeChoose);

            switch(MainInput){

                case 1: 
                user = new Tiger();
                break;
                case 2: 
                user = new Wolf();
                break;
                case 3:
                user = new Spider();
                break;
                case 4:
                user = new Vulture();
                break;
                case 5:
                user = new Shark();
                break;
                case 6:
                user = new Pufferfish();
                break;
            }


        }
        if (freeplaycounter > 1){
            AttributeList javamoment2 = new AttributeList();
            KnownAttribute2 = javamoment2.Attributes(AttributeChoose);

            switch(MainInput){

                case 1:
                user2 = new Tiger();
                break;
                case 2:
                user2 = new Wolf();
                break;
                case 3:
                user2 = new Spider();
                break;
                case 4:
                user2 = new Vulture();
                break;
                case 5:
                user2 = new Shark();
                break;
                case 6:
                user2 = new Pufferfish();
                break; 
            }



        }

        


        
        


    }

}
