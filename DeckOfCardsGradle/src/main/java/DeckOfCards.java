import deckofcards.model.Card;
import deckofcards.model.Face;
import deckofcards.model.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author NottyNerd
 */
public class DeckOfCards {

    List<Card> mCard;
    public static final int totalNumberOfCards =52;
   
    
    public DeckOfCards(List<Card> card)
    {
        this.mCard = card;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
         ArrayList<String> lSuit = new Suit().getSuit();
          ArrayList<String> lFace = new Face().getFaces();
         ArrayList<Card> allcards = new ArrayList<Card>(totalNumberOfCards);
         
        //combine the cards here, add the face to suit.
        for(Iterator<String> it = lSuit.iterator(); it.hasNext();) {
            String suit = it.next(); 
            lFace.stream().forEach((face) -> {
                allcards.add(new Card(face, suit));
             });
        }
        
        System.out.println(allcards.toString());
        
        DeckOfCards deckOfCards = new DeckOfCards(allcards);
        deckOfCards.shuffle();
        System.out.println("********************* Shuffling *********************");
        
        System.out.println(allcards.toString());
        
        
        System.out.println("********************* End Shuffling *********************");
        System.out.println("********************* Deal One Card *********************");
        //now we dealOneCard at a time
        int nCardsToDeal = 54;
        while(nCardsToDeal>0){
            try {
                 System.out.println(deckOfCards.dealOneCard().toString());
                 --nCardsToDeal;
            } catch (Exception e) {
                nCardsToDeal = 0;
            }
       
        }
        
        
    }
    
    /*
        Randomly permutes cards in the deck in linear time
    */
    public void shuffle()
    {
        
        Collections.shuffle(mCard);
        
    }
    
    public Card dealOneCard()
     {
        Card rCard =null;
        try
        {

            rCard = mCard.get(0); 
            mCard.remove(rCard);
        }
        catch (Exception ex)
        {
            System.out.println("No card available to deal, deck is now empty.");
            return null;
        }
        return rCard;
    }
}
