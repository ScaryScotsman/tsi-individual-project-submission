package uk.co.submission;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        List listOfPlayers = new ArrayList();
        List cardDeck;
        int cardsToBeDealt;
        int noOfPlayers;
        int roundCounter = 1;
        String playerSelection;
        boolean gameloop = true;
        boolean roundLoop;

        cardDeck = generateDeck();
        shuffleDeck(cardDeck);
        removeQueens(cardDeck);

        System.out.println("How many players are there? 1 - 3 ");
        noOfPlayers = reader.nextInt() + 1;
        cardsToBeDealt = cardDeck.size() / noOfPlayers;

        for(int i = 1; i < noOfPlayers ; i++) {
            System.out.println("What's your name? ");
            Player humanPlayer = new Player(reader.next());

            listOfPlayers.add(humanPlayer);
            dealHand(humanPlayer, cardDeck, cardsToBeDealt);
        }

        Player cpuPlayer = new Player("Bishop");
        listOfPlayers.add(cpuPlayer);
        dealHand(cpuPlayer, cardDeck, cardsToBeDealt + 1);

        while(gameloop) {
            for(int i = 0; i < listOfPlayers.size() ; i++) {
                roundLoop = true;

                while (roundLoop) {
                    Player currentPlayer = (Player) listOfPlayers.get(i);
                    Player opponentPlayer;

                    System.out.println(String.format("ROUND %s : %s ", roundCounter, currentPlayer.getName().toUpperCase()));

                    System.out.println("What would you like to do? ");
                    System.out.println("1: View your hand 2: Play a pair 3: View opponent's hand 4: Choose opponent's card ");

                    playerSelection = reader.next();
                    switch (playerSelection) {
                        case "1":
                            System.out.println(currentPlayer.toString());
                            break;

                        case "2":
                            currentPlayer.playPair();

                            if (currentPlayer.getHand().isEmpty()) {
                                System.out.println("Well done, you've managed to clear your deck");
                                listOfPlayers.remove(currentPlayer);
                            }
                            break;

                        case "3":
                            System.out.println("What player's hand would you like to view: ");
                            CommonMethods.printPlayers(listOfPlayers, currentPlayer);

                            playerSelection = reader.next();
                            opponentPlayer = (Player) listOfPlayers.get(Integer.parseInt(playerSelection));

                            System.out.println(currentPlayer.viewOpponentsHand(opponentPlayer));
                            break;

                        case "4":
                            System.out.println("What player's hand would you like to choose from: ");
                            CommonMethods.printPlayers(listOfPlayers, currentPlayer);

                            playerSelection = reader.next();
                            opponentPlayer = (Player) listOfPlayers.get(Integer.parseInt(playerSelection));

                            System.out.println(String.format("What card would you like to take? 1 - %s", opponentPlayer.getHand().size()));
                            playerSelection = reader.next();

                            currentPlayer.chooseOpponentsCard(opponentPlayer, Integer.parseInt(playerSelection));
                            break;

                        default:
                            break;
                    }

                    System.out.println("Are you done this round? Y/N ");
                    playerSelection = reader.next();

                    if (playerSelection.equals("Y")) {
                        roundLoop = false;
                    }
                }
            }

            if(listOfPlayers.size() == 1){
                System.out.println(String.format("%s you are the scabby queen!", listOfPlayers.get(0).toString()));
                System.out.println("Would you like to play another game. Y/N");
                playerSelection = reader.next();

                gameloop = false ? playerSelection == "N" :  true;
                roundCounter = 0;
            }
            roundCounter++;
        }



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
