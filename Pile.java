import java.util.ArrayList;


public class Pile {
	private Card top;
	private Card bottom;
	private int numCards;
	
	public Pile(){
		
	}
	public void Add(Card newCard){
		if(top == null){
			this.setTop(newCard);
		}else{
			if(this.getBottom() == null){
				bottom = newCard;
				top.setNext(newCard);
				bottom.setPrevious(top);
			}else{
				Card notLast = bottom;
				bottom = newCard;
				notLast.setNext(bottom);
				newCard.setPrevious(notLast);
			}		
		}
		setNumCards(getNumCards() + 1);
	}
	public Card getCard(int index){
		Card current = this.getTop();
		for(int i = 0; i <= this.numCards; i++){
			if(index == current.getID()){
				//System.out.println("Found: " + current + " - " + index);
				return this.Remove(current);
			}else{
				current = current.getNext();
			}
		}
		//System.out.println("Counldn't find " + index);
		return null;
	}
	public Card Remove(Card badCard){
		Card first = this.getTop();
		for(int i = 0; i < this.getNumCards(); i++){
			//System.out.println("Current Card: " + first);
			//System.out.println(first.Compare(badCard));
			if(first.Compare(badCard) == 0){
				if(first.hasPrevious()){
					first.getPrevious().setNext(first.getNext());
				}
				if(first.hasNext()){
					first.getNext().setPrevious(first.getPrevious());
				}
				this.setNumCards(this.getNumCards() - 1);
				return badCard;
			}else{
				first = first.getNext();
			}
		}
		return null;
		
	}
	public boolean Contains(Card current){
		Card temp = this.getTop();
		for(int i = 0; i < this.getNumCards(); i++){
			if(current == temp){
				return true;
			}else{
				temp = temp.getNext();
			}
		}
		return false;
	}
	public void populate(){
		String suit;
		int ID = 0;
		for(int i = 1; i <= 4; i++){
			if(i == 1){
				suit = "Spades";
			}else if(i == 2){
				suit = "Diamonds";
			}else if(i == 3){
				suit = "Clubs";
			}else{
				suit = "Hearts";
			}
			for(int j = 1; j <= 13; j++){
				String val = "";
				if(j == 1){
					val = "Ace";
				}else if(j == 12){
					val = "Queen";
				}else if(j == 11){
					val = "Jack";
				}else if(j == 13){
					val = "King";
				}else{
					val = ("" + j + "");
				}
				Card current = new Card(val, suit, ID);
				ID++;
				this.Add(current);
			}
		}
	}
	public Pile Shuffle(){
		ArrayList<Card> temp = new ArrayList<Card>();
		Pile shuffled = new Pile();
		Card cur = this.getTop();
		for(int i = 0; i < this.numCards; i++){
			temp.add(cur);
			cur = cur.getNext();
		}
		//System.out.println(temp.size());
		for(int i = this.getNumCards(); i > 0; i--){
			int nextIndex = (int) (Math.random() * i);
			//System.out.println(nextIndex);
			shuffled.Add(temp.get(nextIndex));
			temp.remove(temp.get(nextIndex));
			temp.trimToSize();
		}
		//System.out.println(shuffled.getNumCards());
		return shuffled;
	}
	public String toString(){
		Card current = this.getTop();
		for(int i = 0; i < this.getNumCards(); i++){
			System.out.println(current);
			current = current.getNext();
		}
		return ("\nNumber of Cards: " + this.getNumCards());
	}
	public Card getTop() {
		return top;
	}

	public void setTop(Card top) {
		this.top = top;
	}

	public Card getBottom() {
		return bottom;
	}
	public void setBottom(Card bottom) {
		this.bottom = bottom;
	}
	public int getNumCards() {
		return numCards;
	}
	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}
}
