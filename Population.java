package proj2;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Population {
	public int numRows;
	public int numCols;
	
	
	private Map<Point, Cell> pop;
	
	/**
	 * Constructor
	 * @param rows
	 * @param cols
	 */
	public Population(int rows, int cols){
		this.pop = new HashMap<Point, Cell>();
		this.numRows = rows;
		this.numCols = cols;
		for(int i = 0; i < this.numRows; i++){
			for(int j =0; j < this.numCols; j++){
				this.pop.put(new Point(i,j), new Cell(0, new Point(i,j)));
			}
	}
	}

	/**
	 * Set the private population to myPop
	 * @param myPop
	 */
	public void setPop(Map<Point, Cell> myPop){
		this.pop = myPop;
	}
	
	/**
	 * Return the number of rows in the population
	 * @return int numRows
	 */
	public int getNumRows(){
		return this.numRows;
	}
	
	/**
	 * Return the number of columns in the population
	 * @return int numCols
	 */
	public int getNumCols(){
		return this.numCols;
	}

	/**
	 * Get the current population
	 * @return Map<Point, Cell> pop
	 */
	public Map<Point, Cell> getPop() {
		return pop;
	}
	
	public Cell get(Point p){
		return pop.get(p);
	}
	
	public void put(Point p, Cell c){
		pop.put(p, c);
	}

	public void setNeighbors(){
		
		for(int i = 0; i< this.numRows; i++){
			for(int j = 0; j< this.numCols; j++){
				Cell c;
				c = this.pop.get(new Point(i,j));
				c.clearNeighbors();
				
				Point cLoc = c.loc;
				int left = Math.max(cLoc.y-1, 0);
				int up = Math.max(cLoc.x-1, 0);
				int down = Math.min(cLoc.x+1, this.numRows-1);
				int right = Math.min(cLoc.y+1, this.numCols-1);
				
				
				c.addNeighbor(this.pop.get(new Point(up, left)));
				c.addNeighbor(this.pop.get(new Point(up, right)));
				c.addNeighbor(this.pop.get(new Point(down ,left)));
				c.addNeighbor(this.pop.get(new Point(down, right)));
				c.addNeighbor(this.pop.get(new Point(down, c.loc.y)));//down
				c.addNeighbor(this.pop.get(new Point(up, c.loc.y)));//up
				c.addNeighbor(this.pop.get(new Point(c.loc.x, left)));//left
				c.addNeighbor(this.pop.get(new Point(c.loc.x, right)));//right				
				
				this.pop.put(new Point(i,j), c);

			}
		}
	
	
}}//End Population class
