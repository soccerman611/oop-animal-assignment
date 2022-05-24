public class TurnModifier{

    int ATKScore = 0;

    // User calculations

    public int calculateUser(int MainInput, int rounds, String KnownAttribute, Environment Env, Animal user){

        String AnimalType = user.type(); //Set the property of the user object to a String for comparisons
        String Environment = Env.Name(); //Set the property of the Env object to a String for comparisons

        /* ------BASELINE SCORE--------
        This is added to the ATKScore no matter what, before all other calculations take place.
        Attacking will always get you at least 2 point, and Special attacks will always give at least 3 points.
        */

        if (MainInput == 1){ //if attack have a baseline of 2
            ATKScore = 2;
            
        }
        if (MainInput == 3){ //if special have a baseline of 3
            ATKScore = 3;
            
        }

        //Note: Guard related code uses ATKScore as its main variable, but ATKScore's value is returned to GuardCalc

        if (MainInput == 2){ //if guard have a baseline of 2
            ATKScore = 1;

        }

        /* ---ATTRIBUTE CALCULATIONS---
        These check for Attributes and change the score depending on them.
        Guard calculations are done first because I don't want the attack related attributes
        messing with the GuardCalc score when it is returned to GuardCalc.
        
        */

        //Iron Armor: increase by 1 (GUARD ONLY)
        if (MainInput == 2 && KnownAttribute == "IRON ARMOR"){
            ATKScore++;
        }

        //Tough Spot: increase by 1 in a bad environment (GUARD ONLY)
        if (MainInput == 2 && KnownAttribute == "TOUGH SPOT"){
            

            if (Environment == "DESERT" && AnimalType == "WATER"){ //Water is weaker in Desert
                ATKScore = 2;
            }
            else if (Environment == "CITY" && AnimalType == "NORMAL"){ //Normal is weaker in City
                ATKScore = 2;
            }
            else if (Environment == "LAKE" && AnimalType == "FLYING"){ //Flying is weaker in Lake
                ATKScore = 2;
            }
            return ATKScore; //return it right before the attack related attributes

        }


        //Head Start: Increase by 1 if it is round 1.
        if (rounds == 5 && KnownAttribute == "HEAD START"){ 
            ATKScore = ATKScore + 1;
        }
        

        //Special Boost: Increase by 1 after using a special move
        if (MainInput == 3 && KnownAttribute == "SPECIAL BOOST"){
            ATKScore++;
        }
        
        //Environment Boost: Increase by 1 if the user is in a good environment
        if (AnimalType == Env.TypeBoost() && MainInput == 1){
            if (KnownAttribute == "ENVIRONMENT BOOST"){ //Only increase ATKScore if the attribute is correct
                ATKScore++;
            }
        }

        //Neutral Response: You are unaffected by the environment

        if (KnownAttribute == "NEUTRAL RESPONSE"){
            return ATKScore; // skip the remaining calculations as they involve the environments
        }

        // ENVIRONMENT CALCULATIONS: Advantages and disadvantages of the Environment are here.

        if (AnimalType == Env.TypeBoost() && MainInput == 1){ //+1 boost in ATKScore if your Animal's type matches the Environment's optimal type
            ATKScore++;
        }

        if (AnimalType == "WATER" && Environment == "DESERT" && MainInput == 1){ //Already talked about at line 49 to 55
            ATKScore--;
        }

        if (AnimalType == "NORMAL" && Environment == "CITY" && MainInput == 1){
            ATKScore--;
        }

        if (AnimalType == "FLYING" && Environment == "LAKE" && MainInput == 1){
            ATKScore--;
        }

        return ATKScore; //Nothing else to do, return ATKScore

    }

    //Enemy calculations
    public int calculateEnemy(int MainInput, int rounds, String KnownAttribute2, Environment Env, Animal user2 ){

        /* Most of this code here is a near identical version of the calculateUser method.
        Some aspects are changed to fit the enemy, like user being user2.
        Can't use 1 method for both the user and the enemy due to problems.
        Will not comment this as it's basically the same stuff. */

        String AnimalType = user2.type(); //Set this up again, but made sure that it is for User2
        String Environment = Env.Name();

        /* ------BASELINE SCORE--------
        This is added to the ATKScore no matter what, before all other calculations take place.
        Attacking will always get you at least 2 point, and Special attacks will always give 3 points.
        */

        if (MainInput == 1){ 
            ATKScore = 2;
            
        }
        if (MainInput == 3){ 
            ATKScore = 3;
            
        }

        if (MainInput == 2){ 
            ATKScore = 1;

        }

        /* ---ATTRIBUTE CALCULATIONS---
        These check for Attributes and change the score depending on them.
        Guard calculations are done first.
        
        */

        //Iron Armor: increase by 1 (GUARD ONLY)
        if (MainInput == 2 && KnownAttribute2 == "IRON ARMOR"){
            ATKScore++;
        }

        //Tough Spot: increase by 1 in a bad environment (GUARD ONLY)
        if (MainInput == 2 && KnownAttribute2 == "TOUGH SPOT"){

            if (Environment == "DESERT" && AnimalType == "WATER"){
                ATKScore = 2;
            }
            else if (Environment == "CITY" && AnimalType == "NORMAL"){
                ATKScore = 2;
            }
            else if (Environment == "LAKE" && AnimalType == "FLYING"){
                ATKScore = 2;
            }
            return ATKScore;

        }


        //Head Start: Increase by 1 if it is round 1.
        if (rounds == 5 && KnownAttribute2 == "HEAD START"){ 
            ATKScore++;
        }

        //Special Boost: Increase by 1 after using a special move, not affected by Head Start for Balancing Reasons
        if (MainInput == 3 && KnownAttribute2 == "SPECIAL BOOST"){
            ATKScore++;
        }
        
        //Environment Boost: Increase by 1 if the user is in a good environment
        if (AnimalType == Env.TypeBoost() && MainInput == 1){
            if (KnownAttribute2 == "ENVIRONMENT BOOST"){
                ATKScore++;
            }
        }

        //Neutral Response: You are unaffected by the environment

        if (KnownAttribute2 == "NEUTRAL RESPONSE"){
            return ATKScore; // skip the remaining calculations
        }

        // ENVIRONMENT CALCULATIONS: Advantages and disadvantages of the Environment are here.

        if (AnimalType == Env.TypeBoost() && MainInput == 1){
            ATKScore++;
        }

        if (AnimalType == "WATER" && Environment == "DESERT" && MainInput == 1){
            ATKScore--;
        }

        if (AnimalType == "NORMAL" && Environment == "CITY" && MainInput == 1){
            ATKScore--;
        }

        if (AnimalType == "FLYING" && Environment == "LAKE" && MainInput == 1){
            ATKScore--;
        }

        return ATKScore; //return ATKScore as there is nothing else to calculate


       

    }

}