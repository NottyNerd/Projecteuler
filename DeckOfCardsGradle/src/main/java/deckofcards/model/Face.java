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
public class Face {
    public ArrayList<String> faces =  new ArrayList<>();

    //populate face values
    public Face()
    {
    faces.add("Ace");
    faces.add("2");
    faces.add("3");
    faces.add("4");
    faces.add("5");
    faces.add("6");
    faces.add("7");
    faces.add("8");
    faces.add("9");
    faces.add("10");
    faces.add("Jack");
    faces.add("Queen");
    faces.add("King");
    }
    
    public ArrayList<String> getFaces() {
        return faces;
    }

    public void setFaces(ArrayList<String> faces) {
        this.faces = faces;
    }
}
