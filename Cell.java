package proj2;

import java.awt.Point;

public class Cell {
	
	
	public int state;
	public Point loc;
	private int numNeighbors;
	
	/**
	 * Constructor
	 * @param state
	 * @param loc
	 */
	Cell(int state, Point loc){
		this.state = state;
		this.loc = loc;
		numNeighbors = 0;
		
	}

	
	/**
	 * Turn Cell on/off
	 */
	public void changeState(){
		if(this.state == 0){
			this.state = 1;
		}
		else{
			this.state = 0;
		}
	}
	
	/**
	 * Get the location of a Cell
	 * @return Point loc
	 */
	public Point getLoc(){
		return this.loc;
	}
	
	/**
	 * Set the location of a Cell
	 * @param loc
	 */
	public void setLoc(Point loc){
		this.loc = loc;
	}
	
	/**
	 * Adds 1 neighbor to current working cell if Cell c is alive
	 * @param Cell c
	 */
	public void addNeighbor(Cell c){
		if(c.state == 1){
			this.numNeighbors +=1;
		}
		else {
			return;
		}
	}
	
	/**
	 * Get the number of neighbors a Cell has
	 * @return int numNeighbors
	 */
	public int getNeighbors(){
		return this.numNeighbors;
	}
	
	/**
	 * Return numNeighbors to 0
	 */
	public void clearNeighbors(){
		this.numNeighbors = 0;
	}

	@Override
	public String toString() {
		return String.format("Cell [state=%s, loc=%s, numNeighbors=%s]", state,
				loc, numNeighbors);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + numNeighbors;
		result = prime * result + state;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (numNeighbors != other.numNeighbors)
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	
	
}
