/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards.model;

/**
 *
 * @author NottyNerd
 */
public class Card {
    private String mFace;
    private String mSuit;
    
    public Card(String face, String suit)
    {
    this.mFace = face;
    this.mSuit = suit;
    }
    
    
    
    @Override
    public String toString() {
        return mFace +" of " + mSuit; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
