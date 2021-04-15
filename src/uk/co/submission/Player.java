package uk.co.submission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Player {
    private String name;
    private List hand;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List getHand() {
        return hand;
    }
    public void setHand(List hand) {
        this.hand = hand;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String returnString;
        returnString = String.format("%s your current hand is %s",name, hand.toString());
        return returnString;
    }

    public List playPair(){
        List cardPair = new ArrayList();
        
        comparehand: {
            for (int i = 0; i < this.hand.size(); i++) {
                for (int j = 0; j < this.hand.size(); j++) {
                    if ((this.hand.get(i).toString().charAt(1) == this.hand.get(j).toString().charAt(1))
                            && (this.hand.get(i).toString().charAt(0) != this.hand.get(j).toString().charAt(0))) {
                        System.out.println(this.hand.get(i));
                        System.out.println(this.hand.get(j));
                        cardPair.add(this.hand.get(i));
                        cardPair.add(this.hand.get(j));
                        break comparehand;
                    }
                }
            }
        }        
        this.hand.removeAll(cardPair);
        
        return this.hand;
    }

    public String viewOpponentsHand(Player oppenent){
        String message = String.format("%s currently has %s cards.", oppenent.getName(), oppenent.getHand().size());
        return message;
    }

    public void chooseOpponentsCard(Player opponent, int card){
        Object opponentCard = opponent.getHand().get(card);

        this.hand.add(opponentCard);
        opponent.getHand().remove(opponentCard);
    }
}
