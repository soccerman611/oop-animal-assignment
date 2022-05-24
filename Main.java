/*
OOP Animal Competition

Name: Steven Vezina
Date: May 24th 2022
Desc: choose 2 animals to face off against each other, or choose 1 animal and face off against a pre-chosen animal of an existing difficulty.

Check the README file for more information about the program!
*/

import java.util.*;

public class Main {
    /*Static Variables
    These variables are static so I can use them anywhere and have them stay the same, even in methods in Main
    */
    static Animal user = new Animal(); //User's animal object
    static Animal user2 = new Animal(); //Enemy animal object
    static String KnownAttribute; //Used in AttributesMethod to convert the input into a String from an Array
    static Environment Env = new Environment(); //Environment object
    static String KnownAttribute2; //Same as KnownAttribute, but for the enemy
    static int GuardCheck = 0; //used in the Fight method to check if anyone has guarded in the previous turn
    static int rounds = 5; //Default amount of rounds for battles
    static int tempscore = 0; //This value is added to either the user or enemy score after going to the Fight method
    static int UserorEnemy = 1; //checks if it is the user turn or enemy turn, to know which method to go to in iTurnModifier
    


    public static void main(String[] args) { //main method
        int MainInput = 0; //Input will be asked from the player a lot during this
        int Gamemode = 0; //1 is main mode, 2 is freeplay
        int DifficultySelect = 0; //1 is easy, 2 is normal, 3 is hard
        int Inputisvalid = 0; // to make sure nobody makes the wrong input
        int freeplaycounter = 1; //for the freeplay mode
        int AttributeChoose = 0; //Input for Attributes, will be converted into a String in Attributes method
        int SpecialCountUser1 = 1; //both of these variables track how many times you have used the special move
        int SpecialCountUser2 = 1;

        

        while (Inputisvalid == 0){ //ask for what game mode the player wants
            Scanner sin = new Scanner(System.in);
            System.out.println("Do you want Main Mode or Freeplay Mode? 1 for Main Mode, 2 for Freeplay mode");
            MainInput = sin.nextInt();

            if (MainInput < 1 || MainInput > 2){ //failsafe
                System.out.println("Invalid input!");
                continue;
            }
            Inputisvalid++;

            if (MainInput == 1){
                Gamemode = 1; //main
            }
            else {
                Gamemode = 2; //freeplay
            }

        }
        Inputisvalid = 0;
        MainInput = 0; //reset these values for later

        if (Gamemode == 2){ //freeplay animal select

            for (int i = 0; i < 2; i++){ //do this twice for the user and the enemy
                while (Inputisvalid == 0){ //input user animal
                    Scanner sin = new Scanner(System.in);
                    if (i == 1){ //do this if it's the second time around in the loop
                        System.out.println("Now choose the enemy's animal and attributes.");
                    }
                    System.out.println("What animal do you want? 1 for Tiger, 2 for Wolf, 3 for Spider, 4 for Vulture, 5 for Shark, 6 for Pufferfish");
                    MainInput = sin.nextInt();
                    if (MainInput < 1 || MainInput > 6){ //failsafe
                        System.out.println("Invalid input!");
                        continue;
                    }
                    Inputisvalid++;

                }
                Inputisvalid = 0; //reset this for attribute choosing

                while (Inputisvalid == 0){ //input user attribute
                    Scanner sin = new Scanner(System.in);
                    System.out.println("What attribute do you want? 1 for Head Start, 2 for Special Boost, 3 for Another Chance, 4 for Environment Boost");
                    System.out.println("5 for Double Vision, 6 for Tough Spot, 7 for Iron Armor, 8 for Neutral Response"); //split this up for readability
                    AttributeChoose = sin.nextInt();

                    if (AttributeChoose < 1 || AttributeChoose > 8){ //failsafe
                        System.out.println("Invalid input!");
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
                    System.out.println("What attribute do you want? 1 for Head Start, 2 for Special Boost, 3 for Another Chance, 4 for Environment Boost");
                    System.out.println("5 for Double Vision, 6 for Tough Spot, 7 for Iron Armor, 8 for Neutral Response");
                    AttributeChoose = sin.nextInt();

                    if (AttributeChoose < 1 || AttributeChoose > 8){
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
                case 1: //Pufferfish with Iron Armor
                user2 = new Pufferfish();
                EnemyAttribute = 7;
                break;
                case 2: //Vulture with Environment Boost
                user2 = new Vulture();
                EnemyAttribute = 4;
                break;
                case 3: //Tiger with Special Boost
                user2 = new Tiger();
                EnemyAttribute = 2;
                break;

            }
            KnownAttribute2 = javamoment2.Attributes(EnemyAttribute); //set the attribute of the enemy
            ChooseAnAnimal(MainInput, freeplaycounter, AttributeChoose, Gamemode); //set up your animal that you choose by jumping to chooseananimal
        }


        int score = 0; //Your score
        int enemyscore = 0; //Enemy's score
        int turn = -1; //enemy turn count is 1, used in for loop
        int userturns = 1; //same idea as turn
        
        
        int RandomEnv = 0; //choose a random environment
        RandomEnv = (int)(Math.random()*3) + 1;
        
        

        if (RandomEnv == 1){ //set environment appropiately depending on randomizer
            Env = new Desert();
        }
        else if (RandomEnv == 2){
            Env = new City();
        }
        else if (RandomEnv == 3){
            Env = new Lake();
        }

        //ENEMY INTRODUCTION CODE
        System.out.println("Welcome to the fight !");
        System.out.println("Today the " + user.Species() +  " and the " + user2.Species() + " fight!");
        System.out.println("Your attribute is " + KnownAttribute + ". The enemy's attribute is " + KnownAttribute2);
        System.out.println("They will fight in the " + Env.Name() + " today.");
        System.out.println(Env.Desc());

        // Make changes to the turn system depending on an animal's attribute.

        //Another Chance: Increase round count to 6
        if (KnownAttribute == "ANOTHER CHANCE" || KnownAttribute2 == "ANOTHER CHANCE"){
            rounds++;
        }
        //Double vision: Increase turn count to 2 and give score penalty
        if (KnownAttribute == "DOUBLE VISION"){
            userturns = 2;
            score = -5;
        }
        if (KnownAttribute2 == "DOUBLE VISION"){
            turn = -2;
            enemyscore = -5;
        }

        
        

        
        System.out.println("You will have " + rounds + " rounds to fight the enemy. Good luck!");

        // battle loop

        for (int i = 0; i < rounds; i++){ //do this loop for 5 or 6 rounds, depends on attributes
            //user turn
            UserorEnemy = 1; //1 means user turn
            for (int l = userturns; l > 0; l--){ //loops how many times the user can do an action before moving to enemy turn

                

                while (Inputisvalid == 0){
                    Scanner sin = new Scanner(System.in); //ask for input for an attack
                    System.out.println("What do you want to do? 1 for Attack, 2 for Guard, 3 for Special (one per battle)");
                    MainInput = sin.nextInt();
                    if (MainInput > 3 || MainInput < 1){ //failsafe for invalid input
                        System.out.println("Invalid input!");
                        continue;
                    }

                    if (MainInput == 1 && KnownAttribute == "IRON ARMOR"){ //failsafe check for Iron Armor attribute
                        System.out.println("You cannot attack with the IRON ARMOR Attribute!");
                        continue;
                    }

                    if (MainInput == 3 && SpecialCountUser1 == 0){ //prevents a second special move from being used
                        System.out.println("You have used up all your special moves!");
                        continue;
                    }

                    

                    if (MainInput == 3 && SpecialCountUser1 == 1){ //special move detector
                        System.out.println("Used up your special move!");
                        SpecialCountUser1 = 0;
                    }
                    Inputisvalid++;
                    
                }
                
                
                Inputisvalid = 0; //reset this for the enemy turn

            }
            tempscore = Fight(tempscore, MainInput, Gamemode, turn, userturns); //jump to fight method in main
            score = score + tempscore; //tempscore's result is added to main score
            MainInput = 0; //reset these for enemy turn
            tempscore = 0; 
            //enemy turn
            UserorEnemy = 0; //0 means enemy turn
            for (int m = 0; m > turn; m--){ //loops how many times the enemy can do an action before moving to user turn
                

                while (Inputisvalid == 0){ //If enemy randomly chooses an invalid option, do not skip its turn and retry until it is valid.

                    MainInput = (int)(Math.random()*3) + 1; //enemy chooses moves at random for simplicity
                    

                    if (MainInput == 3 && SpecialCountUser2 == 0){
                        continue;
                    }

                    if (MainInput == 1 && KnownAttribute2 == "IRON ARMOR"){
                        continue;
                    }

                    if (MainInput == 3 && SpecialCountUser2 == 1){
                        SpecialCountUser2 = 0;
                    }
                    tempscore = Fight(tempscore, MainInput, Gamemode, turn, userturns); //jump to fight method
                    enemyscore = enemyscore + tempscore; //add result of tempscore to enemyscore

                    Inputisvalid = 1;

                }
                Inputisvalid = 0; //reset this


            }
            
        }
        System.out.println("All rounds are done!");
        System.out.println("Your animal earned " + score + " points by the end of the fight.");
        System.out.println("Your opponent earned " + enemyscore + " points by the end of the fight.");

        if (score > enemyscore){
            System.out.println("You won the battle!");
        }
        else if (score < enemyscore){
            System.out.println("You lost the battle!");
        }
        else if (score == enemyscore){
            System.out.println("No contest!");
        }


        
    }


    public static void ChooseAnAnimal(int MainInput, int freeplaycounter, int AttributeChoose, int Gamemode){ //Choose an animal method

        if (Gamemode == 1){ //no freeplay
            AttributeList javamoment = new AttributeList(); //Make an object of the Attributelist to make it work for some reason
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

        //everything past here is related to freeplay mode


        if (freeplaycounter == 1){ //set user's animal
            AttributeList javamoment = new AttributeList(); //again, make an object of attributelist to make it work
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
        if (freeplaycounter > 1){ //set enemy animal and attributes
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
    public static int Fight(int tempscore, int MainInput, int Gamemode, int turn, int userturns){

        // Fight handles every valid move and is used as a hub to jump to the calculate method in iTurnModifier

        TurnModifier calc = new TurnModifier(); //Jumping to the method in another class doesn't work unless I make an object of the class.
        int AttackCalc = 0; //variables AttackCalc and GuardCalc made just for the calculate methods
        int GuardCalc = 0;
        
        
        switch(MainInput){

            /*---------------------ATTACKING---------------------------*/

            case 1: //For attacks

            if (UserorEnemy == 1){ //if user attacking, go to this method
                System.out.println("You attacked the enemy animal!");
                AttackCalc = calc.calculateUser(MainInput, rounds, KnownAttribute, Env, user); //jump to this method in iTurnModifier
            }
            else if (UserorEnemy == 0) { //if enemy attacking, go to this method
                System.out.println("The enemy attacked! "); 
                AttackCalc = calc.calculateEnemy(MainInput, rounds, KnownAttribute2, Env, user2); //jump to this method in iTurnModifier
            }

            if (GuardCheck > 0){ //if guardcheck is still above 0 from a previous turn
                AttackCalc = AttackCalc - GuardCheck; //reduce damage
                System.out.println("Guard detected! " + GuardCheck + " points of damage nullified!");
                GuardCheck = 0; //reset this
            }
            System.out.println(AttackCalc + " points of damage dealt!");
            return AttackCalc; //return the result of the calculations back to Fight method

            /* ------------------GUARDING-------------------------*/

            case 2:
            GuardCheck = 0; //reset this at start
            if (UserorEnemy == 1){ //If User, jump to a different method
                System.out.println("You guarded!");
                GuardCalc = calc.calculateUser(MainInput, rounds, KnownAttribute, Env, user2); //go to same method
                GuardCheck = GuardCheck + GuardCalc; //add result of GuardCalc to GuardCheck
            }
            else if (UserorEnemy == 0) {//If Enemy, jump to a different method
                System.out.println("The enemy guarded!");
                GuardCalc = calc.calculateEnemy(MainInput, rounds, KnownAttribute2, Env, user2); //go to same method
                GuardCheck = GuardCheck + GuardCalc;
            }

            AttackCalc = 0; //You didn't attack, so have no damage dealt and return it
            return AttackCalc;

            /*---------------------------SPECIAL MOVE------------------------------*/

            case 3:

            if (UserorEnemy == 1){ //if user, go to this method
                System.out.println("User used a special attack!");
                AttackCalc = calc.calculateUser(MainInput, rounds, KnownAttribute, Env, user2);
            }
            else if (UserorEnemy == 0) { //if enemy go to this method
                System.out.println("The enemy used a special attack!");
                AttackCalc = calc.calculateEnemy(MainInput, rounds, KnownAttribute2, Env, user2);
            }

            if (GuardCheck > 0){ //check if whoever in previous turn used guard
                System.out.println("Guard detected!");
                AttackCalc = AttackCalc - GuardCheck;
                System.out.println(GuardCheck + " points of damage nullified!");
                GuardCheck = 0; //reset guard check
            }

            System.out.println(AttackCalc + " points of damage dealt!");

            
            return AttackCalc;
            

        }
        return 0; //default return is 0 if something weird happens
    }

}
