package core;

public class PlacedWordTracker {
	private int number;
	private Coordinate coordinate;
	private String word;
	
	public PlacedWordTracker(int number, Coordinate coordinate, String word){
		this.number = number;
		this.coordinate = coordinate;
		this.word = word;
	}
	
	public int getNumber(){
		return number;
	}
	public void setNumber(int newNumber) {
		number = newNumber;
	}
	
	public Coordinate getCoordinate(){
		return coordinate;
	}
	public String getWord(){
		return word;
	}
	
}
