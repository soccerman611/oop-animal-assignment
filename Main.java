/*
Name: Steven Vezina
Date: May 4th 2022
Desc: choose 2 animals to face off against each other, or choose 1 animal and face off against a pre-chosen animal of an existing difficulty.
you can choose attributes for your animal that give it a unique ability. an environment is randomly chosen to be used for the battle (but it is not fully implemented)
i plan to have a point based battle system where your attacks give you points, and whichever animal has the most points after 3 turns wins
*/

import java.util.*;

public class Main {
    static Animal user = new Animal(); //these variables are static so i can access them from anywhere in Main
    static Animal user2 = new Animal();
    static String KnownAttribute;
    static String KnownAttribute2;
    


    public static void main(String[] args) {
        int MainInput = 0; //Input will be asked from the player a lot during this
        int Gamemode = 0; //1 is main mode, 3 is freeplay
        int DifficultySelect = 0; //1 is easy, 2 is normal, 3 is hard
        int Inputisvalid = 0; // to make sure nobody makes the wrong input
        int freeplaycounter = 1; //for the freeplay mode
        int AttributeChoose = 0;

        

        while (Inputisvalid == 0){ //ask for what game mode the player wants
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

            for (int i = 0; i < 2; i++){ //do this twice for the user and the other user
                while (Inputisvalid == 0){ //input user animal
                    Scanner sin = new Scanner(System.in);
                    if (i == 1){
                        System.out.println("Now choose the enemy's animal and attributes.");
                    }
                    System.out.println("What animal do you want? 1 for Tiger, 2 for Wolf, 3 for Spider, 4 for Vulture, 5 for Shark, 6 for Pufferfish");
                    MainInput = sin.nextInt();
                    if (MainInput < 1 || MainInput > 6){
                        System.out.println("idiot");
                        continue;
                    }
                    Inputisvalid++;

                }
                Inputisvalid = 0;

                while (Inputisvalid == 0){ //input user attribute
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
                ChooseAnAnimal(MainInput, freeplaycounter, AttributeChoose, Gamemode); //jump to chooseananimal method
                freeplaycounter++;   // increase this for next time i go to the method in the loop
                Inputisvalid = 0; 
            }   
        }

        if (Gamemode == 1){ //normal mode, no freeplay
            System.out.println("not freeplay");

            while (Inputisvalid < 3){ //put all of the input under 1 loop to check for valid input, if the number is 3 then the user can move on
                if (Inputisvalid == 0){ //input for user animal
                    Scanner sin = new Scanner(System.in);
                    System.out.println("What animal do you want? 1 for Tiger, 2 for Wolf, 3 for Spider, 4 for Vulture, 5 for Shark, 6 for Pufferfish");
                    MainInput = sin.nextInt();
                    if (MainInput < 1 || MainInput > 6){
                        System.out.println("Why");
                        continue;
                    }
                    Inputisvalid++;
                    


                }

                if (Inputisvalid == 1){ //input for user attribute
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

                Scanner sin = new Scanner(System.in); //ask for difficulty select
                System.out.println("What difficulty? 1 for Easy, 2 for Normal, 3 for Hard");
                DifficultySelect = sin.nextInt();
                if (DifficultySelect < 1 || DifficultySelect > 3){
                    System.out.println("Why");
                    continue;
                }
                Inputisvalid = 10;

            }
            Inputisvalid = 0;

            int EnemyAttribute = 0; //set up variable here for the switch statement



            AttributeList javamoment2 = new AttributeList(); //java moment

            switch (DifficultySelect){ //switch statement, set up the enemy you face depending on the difficulty
                case 1:
                user2 = new Pufferfish();
                EnemyAttribute = 8;
                break;
                case 2:
                user2 = new Vulture();
                EnemyAttribute = 4;
                break;
                case 3:
                user2 = new Tiger();
                EnemyAttribute = 2;
                break;

            }
            KnownAttribute2 = javamoment2.Attributes(EnemyAttribute); //set the attribute of the enemy
            ChooseAnAnimal(MainInput, freeplaycounter, AttributeChoose, Gamemode); //set up your animal that you choose by jumping to chooseananimal
        }


        int score = 0; //main battle score
        int turn = 0;
        int rounds = 3;
        int RandomEnv = 0; //choose a random environment
        RandomEnv = (int)(Math.random()*1) + 1;
        Environment Env = new Environment();
        

        if (RandomEnv == 1){
            Env = new Desert();
        }

        
        


        

        

       
        /*score = amongus.calculate();
        System.out.println(score);*/

        System.out.println(user.Desc());
        System.out.println(KnownAttribute);
        System.out.println(user2.Desc());
        System.out.println(KnownAttribute2);

        System.out.println("Welcome to the fight !");
        System.out.println("Today the " + user.Species() +  " and the " + user2.Species() + " fight!");
        System.out.println("They will fight in the " + Env.Name() + " today.");
        System.out.println(Env.Desc());

        if (KnownAttribute == "ANOTHER CHANCE" || KnownAttribute2 == "ANOTHER CHANCE"){
            rounds++;
        }
        System.out.println("You will have " + rounds + " rounds to fight the enemy. Good luck!");

        


        
        
        

   
        
    }

    //Animal user, Animal user2

    public static void ChooseAnAnimal(int MainInput, int freeplaycounter, int AttributeChoose, int Gamemode){ //ok future me remember that java is funny and putting var in wrong order breaks stuff

        if (Gamemode == 1){ //no freeplay
            AttributeList javamoment = new AttributeList();
            KnownAttribute = javamoment.Attributes(AttributeChoose); //set the attribute by jumping to the method in AttributeList.java

            switch (MainInput){ //set up user animal depending on what you inputted in maininput

                case 1:
                user = new Tiger(); //user comes from the static variable from the start
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
            return; //exit the method before anything weird happens
        }

        //**everything past here is related to freeplay mode**//


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
            return;
            


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
    public static void Fight(int score, int MainInput, int Gamemode, int turn){ //method for fighting, left empty because i want to work on this tomorrow
        
        switch(MainInput){

            case 1:
            System.out.println("Attack");
            case 2:
            System.out.println("Defend");
            case 3:
            System.out.println("Special");
            
        }
    }

}
