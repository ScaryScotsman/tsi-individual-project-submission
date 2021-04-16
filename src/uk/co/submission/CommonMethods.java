package uk.co.submission;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CommonMethods {
    public static final String gameRulesPath = "scabby-queen-rules.txt";

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

    public static String readFile(String filePath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(filePath));
        String fileData = "";
        while(fileReader.hasNextLine()){
            fileData += fileReader.nextLine()  + "\n";
        }
        return fileData;
    }
}
