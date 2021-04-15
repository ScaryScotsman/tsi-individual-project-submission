package uk.co.submission;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int noOfPlayers = 2;

    public static void main(String[] args) {
        // write your code here
        System.out.println("I am working properly!");
    }

    public static List generateDeck(){
        String[] cardSuits = {"H","D","S","C"};
        String[] cardValues = {"1","2","3","4","5","6","7","8","9","10","K","Q","J","A"};
        List cardDeck = new ArrayList<String>();

        for (String suits: cardSuits) {
            for (String value: cardValues){
                cardDeck.add(suits + value);
            }
        }

        return cardDeck;
    }

//  TODO: After queen removal deck will not be dealt evenly among the players, logic needs to handle to deal an additional card to one player
    public static void dealHand(Player player, List cardDeck, int cardsToBeDealt){

        Random rand = new Random();
        int intRandom;
        List playerHand = new ArrayList<String>();

        for (int j = 0; j < cardsToBeDealt; j++) {
            intRandom = rand.nextInt(cardDeck.size());
            playerHand.add(cardDeck.get(intRandom));
        }

        player.setHand(playerHand);
    }
}
