import java.util.ArrayList;


public class driver {

	public static void main(String[] args) {
		Pile deck = new Pile();
		deck.populate();
		//System.out.println(deck.getTop());
		//System.out.println(deck.getTop().getNext());
		//System.out.println(deck);
		deck = deck.Shuffle();
		//System.out.println("Shuffled: ");
		//System.out.println(deck);
		ArrayList<Card> deckCopy = new ArrayList<Card>();
		Pile compHand = new Pile();
		Pile userHand = new Pile();
		System.out.println("Deck: " + deck.getNumCards());
		for(int i = 0; i < 52; i++){
			deckCopy.add(deck.getCard(i));
		}
		System.out.println("DeckCopy: " + deckCopy.size());
		for(int i = 0; i < deckCopy.size(); i++){
			System.out.println(i);
			if(((i) % 2) == 0){
				userHand.Add(deckCopy.get(i));
			}else{
				compHand.Add(deckCopy.get(i));				
			}
		}
		//System.out.println(userHand);
		//System.out.println(compHand);
	}

}
