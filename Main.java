/*
Name: Steven Vezina
Date: May 4th 2022
Desc: animal competition yes
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int MainInput; //Input will be asked from the player a lot during this
        int Gamemode = 0; //1 is main mode, 3 is freeplay
        int DifficultySelect; //1 is easy, 2 is normal, 3 is hard
        int Inputisvalid = 0;

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

        if (Gamemode == 2){ //freeplay
            
        }

        
        


       
        
    }

}
