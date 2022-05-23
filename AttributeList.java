public class AttributeList {

    public String Attributes(int AttributeChoose){
        String[] Atr = {"HEAD START", "SPECIAL BOOST", "ANOTHER CHANCE", "THORNS", "ENVIRONMENT BOOST", "DOUBLE VISION", "TOUGH SPOT", "IRON ARMOR", "NEUTRAL RESPONSE"};

        switch(AttributeChoose){

            case 0: return Atr[AttributeChoose];
            case 1: return Atr[AttributeChoose];
            case 2: return Atr[AttributeChoose];
            case 3: return Atr[AttributeChoose];
            case 4: return Atr[AttributeChoose];
            case 5: return Atr[AttributeChoose];
            case 6: return Atr[AttributeChoose];
            case 7: return Atr[AttributeChoose];
            case 8: return Atr[AttributeChoose];
            
 
        }

        return "aaaaaa";
  
    }

    public String Attributes2(int EnemyAttribute){
        String[] Atr = {"QUICK THINKING", "SPECIAL BOOST", "ANOTHER CHANCE", "THORNS", "ENVIRONMENT BOOST", "DOUBLE VISION", "TOUGH SPOT", "IRON ARMOR", "NEUTRAL RESPONSE"};

        switch (EnemyAttribute){

            case 0: return Atr[EnemyAttribute];
            case 1: return Atr[EnemyAttribute];
            case 2: return Atr[EnemyAttribute];
            case 3: return Atr[EnemyAttribute];
            case 4: return Atr[EnemyAttribute];
            case 5: return Atr[EnemyAttribute];
            case 6: return Atr[EnemyAttribute];
            case 7: return Atr[EnemyAttribute];
            case 8: return Atr[EnemyAttribute];

        }
        return "Saul";
    }

    

    public int Test(){
        return 1;
    }

    

    

    

    
   
}