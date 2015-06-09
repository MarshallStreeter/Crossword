package core;

public class Coordinate {
    private int r;
    private int c;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    public int getR() {
    	return r;
    }
    
    public int getC() {
    	return c;
    }
    
    //Returns true if the Coordinates are equals
    //If either Coordinate is null, they won't be considered equal
    public boolean equals(Coordinate otherCoordinate) {
    	boolean retVal = false;
    	if (this == null || otherCoordinate == null) {
    		retVal = false;
    	}
    	else if (this.getR() == otherCoordinate.getR()) {
    		if (this.getC() == otherCoordinate.getC()) {
    			retVal = true;
    		}
    	}
    	return retVal;
    }
}