/** ****************************************************
 * NAME: KEVAL VARIA
 * CLASS: CS4B
 * PROGRAM: BLACKJACK PART 1
 * FILE: CARDS.JAVA
 ***************************************************** */
package blackjack;

import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.image.Image;

/**
 *
 * @author keval
 */
public class Cards {

    // class variable declaration
    private int rank1, rank2;
    private int suit1, suit2;

    // default constructor
    Cards() {
        this.rank1 = this.rank2 = 0;
        this.suit1 = this.suit2 = 0;
    }

    /**
    * Function: getRandomRank()
    * - generate a random number between 1 and 13 to express a random rank from the deck between Ace, 2, 3.., Queen, King
    **/
    private int getRandomRank() {
        return (ThreadLocalRandom.current().nextInt(1, 13 + 1));
    }

    
    /**
    * Function: getRandomSuit()
    * - generate a random number between 1 and 4 to express a random suit from the deck: Diamonds, Clubs, Hearts, Spades
    **/
    private int getRandomSuit() {
        return (ThreadLocalRandom.current().nextInt(1, 4 + 1));
    }
    
    
    /**
    * Function: prepareHands()
    * - Distribute cards to the player (avoid using the same random cards as there can only be one of each set)
    **/
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

    
    /**
    * Function: getRank1()
    * - Obtain the rank of the first card in hand
    **/
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

    
    /**
    * Function: getRank2()
    * - Obtain the rank of the second card in hand
    **/
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

    
    /**
    * Function: getSuit1()
    * - Obtain the suit of the first card in hand
    **/
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

    /**
    * Function: getSuit2()
    * - Obtain the suit of the second card in hand
    **/
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

    /**
    * Function: getResult()
    * - Obtain the sum of the two cards
    **/
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
    * Function: getImageCard1()
    * - Obtain the image of the first card in hand to display to the UI
    **/
    public Image getImageCard1() {
        return new Image("File:\\\\\\\\C:\\Users\\keval\\Documents\\NetBeansProjects\\Blackjack\\src\\cards\\png\\" + getRank1() + "_of_" + getSuit1().toLowerCase() + ".png");
    }

    /**
    * Function: getImageCard2()
    * - Obtain the image of the second card in hand to display to the UI
    **/
    public Image getImageCard2() {
        return new Image("File:\\\\\\\\C:\\Users\\keval\\Documents\\NetBeansProjects\\Blackjack\\src\\cards\\png\\" + getRank2() + "_of_" + getSuit2().toLowerCase() + ".png");
    }

    /**
     * Override toString Function
     * @return String
     */
    @Override
    public String toString() {
        return ("\n\nCARD #1: " + getRank1() + " of " + getSuit1() + "\n"
                + "CARD #2: " + getRank2() + " of " + getSuit2() + "\n"
                + "SUM: " + getResult() + "\n\n");
    }

}
