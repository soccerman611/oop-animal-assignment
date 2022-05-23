public class iTurnModifier{

    int ATKScore = 0;
    int EnvID = 0;
    Desert test = new Desert();
    AttributeList test2 = new AttributeList();

    public int happy(int num){ //test function just put the name of the variable in the brackets
        System.out.println("hello hi");
        return num;

    }



    public int calculatetest(int tempscore, int MainInput, int rounds, String KnownAttribute, String KnownAttribute2){

        if (MainInput == 1){ //if attack have a baseline increase of 1
            ATKScore++;
        }
        if (MainInput == 3){ //if special have a baseline increase of 2
            ATKScore = ATKScore + 2;
        }

        //if animal has this attribute and its the first round, increase by one
        if (rounds == 1 && KnownAttribute == "HEAD START" || rounds == 1 && KnownAttribute2 == "HEAD START"){ 
            ATKScore++;
        }




        /*ATKScore = ATKScore + test.TypeBoost() + test2.Test();*/
        if (ATKScore < 0){
            ATKScore = 0;
        }
        return ATKScore;

    }

    public int Guardcheck(int tempscore, int GuardCheck){
        ATKScore--;
        if (ATKScore < 0){
            ATKScore = 0;
        }
        return ATKScore;

    }

    public int calculatenew(){
        return 0;
    }
}