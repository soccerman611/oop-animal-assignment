public class iTurnModifier{

    int ATKScore = 0;
    int EnvID = 0;
    Desert test = new Desert();
    AttributeList test2 = new AttributeList();

    public int happy(int num){ //test function just put the name of the variable in the brackets
        System.out.println("hello hi");
        return num;

    }

    public int calculatetest(){

        ATKScore = ATKScore + test.TypeBoost() + test2.Test();
        return ATKScore;

    }

    public int calculatenew(){
        return 0;
    }
}