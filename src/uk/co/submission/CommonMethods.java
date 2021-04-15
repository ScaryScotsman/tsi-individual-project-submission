package uk.co.submission;

public class CommonMethods {
    public static int stringCount(String someString, char someChar){
        int count = 0;

        for(char stringChar: someString.toCharArray()){
            if (stringChar == someChar)
                    count++;
        }

        return count;
    }
}
