package proj2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class GameOfLifeModel extends Observable{
	int age = 0;
	private Population pop;
	public List<Point> myList = new ArrayList<Point>();


	/**
	 * Constructor for new GameOfLifeModel
	 */
	public GameOfLifeModel(){
		this.pop = new Population(250,250);
	}
	
	/**
	 * Turns a cell on/off
	 * @param Point myPoint
	 */
	public void toggle(Point myPoint){
		if(pop.get(myPoint) != null){
			Cell c = pop.get(myPoint);
			c.changeState();
			pop.put(myPoint, c);
		
			setChanged();
			notifyObservers();
	}
		else return;
	}
	
	/**
	 * Replaces current population with an empty new Population
	 */
	public void clearCurrPop(){
		this.pop = new Population(50,50);
	}
	
	
	/**
	 * Searches the current working population for all alive cells and
	 * adds them to myList to be painted
	 * @return List<Point>
	 */
	public List<Point> setPainted(){
		for(int i = 0; i < pop.numRows; i++){
			for(int j = 0; j < pop.numCols; j++){
				if(pop.get(new Point(i,j)).state == 0){
					myList.remove(new Point(i,j));
				}
				else if(pop.get(new Point(i,j)).state == 1){
					if(myList.contains(new Point(i,j)) == false){
						myList.add(new Point(i,j));
					}
				}
			}
		}
		return myList;
	}
	
	/**
	 * startGame makes a call to setNeighbors, and then determines whether or not
	 * a cell should live, die, or populate based on numNeighbors
	 */
	public void startGame(){
		this.pop.setNeighbors();
		for(int i = 0; i < pop.numRows; i++){
			for(int j = 0; j < pop.numCols; j++){
				Cell c = pop.get(new Point(i,j));
				if(c.getNeighbors() <= 1){
					c.state = 0;
					if(myList.contains(new Point(i,j))){
						myList.remove(new Point(i,j));
					}
				}
				else if(c.getNeighbors() >= 4){
					c.state = 0;
					if(myList.contains(new Point(i,j))){
						myList.remove(new Point(i,j));
					}
				}
				else if (c.getNeighbors() == 3 || c.getNeighbors() == 2){
					if(c.getNeighbors() ==3){
						c.state = 1;
						myList.add(new Point(i,j));
					}
					else if(c.getNeighbors() == 2){
						if(myList.contains(new Point(i,j)) == false){
							myList.add(new Point(i,j));
						}
					}
				}
			}}
			this.age +=1;
			setChanged();
			notifyObservers();
	}

	/**
	 * runGameOfLife is used by the ActionListener for the Start Button
	 * As long as the list of alive cells is not empty, continue the game
	 */
	public void runGameOfLife(){
		while(myList.isEmpty()==false){
			this.startGame();
		}
		return;
	}

	
	/**
	 * Populates the screen with default shapes
	 * @param String shapeName
	 */
	public void setShape(String shapeName) {
		this.clearCurrPop();
		this.age = 0;
		if(shapeName == "Glider"){
			pop.put(new Point(20, 20), new Cell(1, new Point(20,20)));
			pop.put(new Point(20, 21), new Cell(1, new Point(20,21)));
			pop.put(new Point(20, 22), new Cell(1, new Point(20,22)));
			pop.put(new Point(19, 22), new Cell(1, new Point(19,22)));
			pop.put(new Point(18, 21), new Cell(1, new Point(18,21)));
		}
		else if(shapeName == "Small Exploder"){
			pop.put(new Point(20, 20), new Cell(1, new Point(20,20)));
			pop.put(new Point(20, 21), new Cell(1, new Point(20,21)));
			pop.put(new Point(20, 19), new Cell(1, new Point(20,19)));
			pop.put(new Point(21,19), new Cell(1, new Point(21,19)));
			pop.put(new Point(22,20), new Cell(1, new Point(22,20)));
			pop.put(new Point(21,21), new Cell(1, new Point(21,21)));
			pop.put(new Point(19,20), new Cell(1, new Point(19,20)));

		}
		else if(shapeName == "Exploder"){
			pop.put(new Point(20,20), new Cell(1, new Point(20,20)));
			pop.put(new Point(21,20), new Cell(1, new Point(21,20)));
			pop.put(new Point(22,20), new Cell(1, new Point(22,20)));
			pop.put(new Point(23,20), new Cell(1, new Point(23,20)));
			pop.put(new Point(24,20), new Cell(1, new Point(24,20)));

			pop.put(new Point(20,24), new Cell(1, new Point(20,24)));
			pop.put(new Point(21,24), new Cell(1, new Point(21,24)));
			pop.put(new Point(22,24), new Cell(1, new Point(22,24)));
			pop.put(new Point(23,24), new Cell(1, new Point(23,24)));
			pop.put(new Point(24,24), new Cell(1, new Point(24,24)));

			pop.put(new Point(20, 22), new Cell(1, new Point(20,22)));
			pop.put(new Point(24,22), new Cell(1, new Point(24,22)));
		}
		else if(shapeName == "Random"){
			for(int i = 0; i < 500; i++){
				//Not yet optimized when screen size is changed
				int randNum1 = (int) Math.floor(Math.random()*101);
				int randNum2 = (int) Math.floor(Math.random()*101);
				pop.put(new Point(randNum1, randNum2), new Cell(1, new Point(randNum1, randNum2)));
			}
		}
		else{
			myList.clear();
		}
		setChanged();
		notifyObservers();
	}
	
}//end GameOfLifeModel
