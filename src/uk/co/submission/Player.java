package uk.co.submission;

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
}
