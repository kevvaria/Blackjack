/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author keval
 */
public class Cards {

    private int rank1, rank2;
    private int suit1, suit2;

    Cards() {
        this.rank1 = this.rank2 = 0;
        this.suit1 = this.suit2 = 0;
    }

    private int getRandomRank() {
        return (ThreadLocalRandom.current().nextInt(1, 13 + 1));
    }

    private int getRandomSuit() {
        return (ThreadLocalRandom.current().nextInt(1, 4 + 1));
    }

    public void perpareHands() {
        this.rank1 = getRandomRank();
        this.suit1 = getRandomSuit();

        this.rank2 = this.rank1;
        this.suit2 = this.suit1;

        while(this.rank1 == this.rank2 && this.suit1 == this.suit2) {
            this.rank2 = getRandomRank();
            this.suit2 = getRandomSuit();
        }
    }

    public String getRank1() {
        if(this.rank1 == 1) {
            return "ACE";
        }
        else if(this.rank1 >= 2 && this.rank1 <= 10) {
            return (this.rank1 + "");
        }
        else if(this.rank1 == 11) {
            return "JACK";
        }
        else if(this.rank1 == 12) {
            return "QUEEN";
        }
        else {
            return "KING";
        }
    }

    public String getRank2() {
        if(this.rank2 == 1) {
            return "ACE";
        }
        else if(this.rank2 >= 2 && this.rank2 <= 10) {
            return (this.rank2 + "");
        }
        else if(this.rank2 == 11) {
            return "JACK";
        }
        else if(this.rank2 == 12) {
            return "QUEEN";
        }
        else {
            return "KING";
        }
    }

    public String getSuit1() {
        switch(this.suit1) {
            case 1:
                return "HEARTS";
            case 2:
                return "DIAMONDS";
            case 3:
                return "CLUBS";
            default:
                return "SPADES";
        }
    }

    public String getSuit2() {
        switch(this.suit2) {
            case 1:
                return "HEARTS";
            case 2:
                return "DIAMONDS";
            case 3:
                return "CLUBS";
            default:
                return "SPADES";
        }
    }

    public String getResult() {
        if(this.rank1 == 1 && this.rank2 == 11) {
            return "21 = Black Jack";
        }
        else if(this.rank1 == 11 && this.rank2 == 1) {
            return "21 = Black Jack";
        }
        else {
            return ("" + (this.rank1 + this.rank2));
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return ("\n\nCARD #1: " + getRank1() + " of " + getSuit1() + "\n"
                + "CARD #2: " + getRank2() + " of " + getSuit2() + "\n"
                + "SUM: " + getResult() + "\n\n");
    }
    
    

}
