package uk.co.submission;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static int noOfPlayers = 2;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        List listOfPlayers = new ArrayList();
        List cardDeck;
        int cardsToBeDealt;

        cardDeck = generateDeck();
        shuffleDeck(cardDeck);
        removeQueens(cardDeck);

        System.out.println("How many players are there? 1 - 3");
        noOfPlayers = reader.nextInt() + 1;
        cardsToBeDealt = cardDeck.size() / noOfPlayers;

        for(int i = 1; i < noOfPlayers ; i++) {
            System.out.println("What's your name? ");
            Player humanPlayer = new Player(reader.next());

            listOfPlayers.add(humanPlayer);
            dealHand(humanPlayer, cardDeck, cardsToBeDealt);
        }

        Player cpuPlayer = new Player("Bishop");
        dealHand(cpuPlayer, cardDeck, cardsToBeDealt + 1);

        reader.close();
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

    public static List shuffleDeck(List cardDeck){
        Collections.shuffle(cardDeck);
        return cardDeck;
    }

    public static List removeQueens(List cardDeck){
        Iterator<String> cardDeckIterator = cardDeck.iterator();

        while ((CommonMethods.stringCount(cardDeck.toString(),'Q') > 1) && (cardDeckIterator.hasNext())){
                if(cardDeckIterator.next().contains("Q")){
                    cardDeckIterator.remove();
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
            cardDeck.remove(intRandom);
        }

        player.setHand(playerHand);
    }
}
