/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards.model;

import java.util.ArrayList;

/**
 *
 * @author NottyNerd
 */
public class Suit {
    public ArrayList<String> suit =  new ArrayList<>();
    //populate face values
    public Suit()
    {
    suit.add("Hearts");
    suit.add("Spades");
    suit.add("Clubs");
    suit.add("Diamonds");

    }

    public ArrayList<String> getSuit() {
        return suit;
    }

    public void setSuit(ArrayList<String> suit) {
        this.suit = suit;
    }
    
    
}
