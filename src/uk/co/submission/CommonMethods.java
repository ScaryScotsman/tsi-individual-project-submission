package uk.co.submission;

import java.util.List;

public class CommonMethods {
    public static int stringCount(String someString, char someChar){
        int count = 0;

        for(char stringChar: someString.toCharArray()){
            if (stringChar == someChar)
                    count++;
        }

        return count;
    }

    public static void printPlayers(List playerList, Player player){
        for(int i = 0; i < playerList.size(); i++){
            Player playerI = (Player)playerList.get(i);

            if(playerI == player){
                continue;
            }

            System.out.println(String.format("%s %s", i, playerI.getName()));
        }
    }
}
