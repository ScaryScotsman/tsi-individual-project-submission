package uk.co.submission;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("I am working properly!");
    }

    public static ArrayList generateDeck(){
        String[] cardSuits = {"H","D","S","C"};
        String[] cardValues = {"1","2","3","4","5","6","7","8","9","10","K","Q","J","A"};
        ArrayList cardDeck = new ArrayList();

        for (String suits: cardSuits) {
            for (String value: cardValues){
                cardDeck.add(suits + value);
            }
        }

        return cardDeck;
    }
}
