
public class Card {
	private int value;
	private String suit;
	private Card previous;
	private Card next;
	private int ID;
	
	public Card(){
		this.setValue("");
		this.setSuit("");
	}
	public Card(String value, String suit, int ID){
		this.setValue(value);
		this.setSuit(suit);
		this.setID(ID);
	}
	public int Compare(Card current){
		//System.out.println("Card 1: " + this.toString() + "\nCard 2: " + current.toString());
		if((current.getSuit().equalsIgnoreCase(this.getSuit())) && (current.getValue() == this.getValue())){
			return 0;
		}else if(current.getSuit().equalsIgnoreCase(this.getSuit())){
			if(this.getValue() > current.getValue()){
				return 2;
			}else{
				return 1;
			}
		}else{
			return -1;
		}
	}
	public String toString(){
		String val;
		if(this.getValue() == 11){
			val = "Jack";
		}else if(this.getValue() == 12){
			val = "Queen";
		}else if(this.getValue() == 13){
			val = "King";
		}else if(this.getValue() == 1){
			val = "Ace";
		}else{
			val = ("" + this.getValue());
		}
			return val + " of " + this.getSuit();
		
	}
	public boolean hasNext(){
		if(this.next == null){
			return false;
		}else{
			return true;
		}
	}
	public boolean hasPrevious(){
		if(this.previous == null){
			return false;
		}else{
			return true;
		}
	}
	public int getValue() {
		return value;
	}
	public void setValue(String value) {
		int trueVal = 0;
		if(value.equalsIgnoreCase("King")){
			trueVal = 13;
		}else if(value.equalsIgnoreCase("Queen")){
			trueVal = 12;
		}else if(value.equalsIgnoreCase("Jack")){
			trueVal = 11;
		}else if(value.equalsIgnoreCase("Ace")){
			trueVal = 1;
		}else{
			trueVal = Integer.parseInt(value);
		}
		this.value = trueVal;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public Card getPrevious() {
		return previous;
	}
	public void setPrevious(Card previous) {
		this.previous = previous;
	}
	public Card getNext() {
		return next;
	}
	public void setNext(Card next) {
		this.next = next;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
