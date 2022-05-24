public class iTurnModifier{

    int ATKScore = 0;
    int EnvID = 0;
    Desert test = new Desert();
    AttributeList test2 = new AttributeList();
    

    public int happy(int num){ //test function just put the name of the variable in the brackets
        System.out.println("hello hi");
        return num;

    } 

    // User calculations

    public int calculatetestUser(int tempscore, int MainInput, int rounds, String KnownAttribute, Environment Env){

        /* ------BASELINE SCORE--------
        This is added to the ATKScore no matter what, before all other calculations take place.
        Attacking will always get you at least 1 point, and Special attacks will always give 2 points.
        */

        if (MainInput == 1){ //if attack have a baseline increase of 1
            ATKScore = 1;
            
        }
        if (MainInput == 3){ //if special have a baseline of 2
            ATKScore = 2;
            
        }
        /*ATKScore = ATKScore + Env.TypeBoost();*/

        /* ---ATTRIBUTE CALCULATIONS---
        These check for Attributes and change the score depending on them.
        Some attributes (Mainly the ones on Guarding) are not present here and is calculated in the Fight method of main.
        Special boost is not here either due to Java not recognizing that it is the enemy's turn and giving it the boost even though it lacks the attribute.
        I hate java.
        */






        //Head Start: Increase by 1 if it is round 1.
        if (rounds == 3 && KnownAttribute == "HEAD START"){ 
            ATKScore = ATKScore + 1;
            System.out.println("What a sick joke!");
        }
        


        System.out.println(KnownAttribute + " is user");

        




        /*ATKScore = ATKScore + test.TypeBoost() + test2.Test();*/

        

        return ATKScore;

    }




    
    public int calculatetest(int tempscore, int MainInput, int rounds, String KnownAttribute2, Environment Env){

        /* ------BASELINE SCORE--------
        This is added to the ATKScore no matter what, before all other calculations take place.
        Attacking will always get you at least 1 point, and Special attacks will always give 2 points.
        */

        if (MainInput == 1){ //if attack have a baseline increase of 1
            ATKScore = 1;
            
        }
        if (MainInput == 3){ //if special have a baseline of 2
            ATKScore = 2;
            
        }
        /*ATKScore = ATKScore + Env.TypeBoost();*/

        /* ---ATTRIBUTE CALCULATIONS---
        These check for Attributes and change the score depending on them.
        Some attributes (Mainly the ones on Guarding) are not present here and is calculated in the Fight method of main.
        Special boost is not here either due to Java not recognizing that it is the enemy's turn and giving it the boost even though it lacks the attribute.
        I hate java.
        */






        //Head Start: Increase by 1 if it is round 1.

        if (rounds == 3 && KnownAttribute2 == "HEAD START"){ 
            ATKScore = ATKScore + 1;
            System.out.println("What a sick joke!");
        }
        

        System.out.println(ATKScore + " is the ATKSCore.");

        /*ATKScore = ATKScore + test.TypeBoost() + test2.Test();*/

        

        return ATKScore;

    }

    

    /*public int Guardcheck(int tempscore, int GuardCheck){
        ATKScore--;
        if (ATKScore < 0){
            ATKScore = 0;
        }
        return ATKScore;

    }*/

    public int calculatenew(){
        return 0;
    }
}