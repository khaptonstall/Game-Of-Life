package proj2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GameOfLifeCanvas extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private int squareW = 10; //cell width
	private int squareH = 10; //cell height
	public Population myPop;
	GameOfLifeModel myModel;
		
	/**
	 * Initialize array to keep track of alive points
	 */
	private List<Point> paintedSquares = new ArrayList<Point>();


	public GameOfLifeCanvas(GameOfLifeModel m){
		myModel = m;
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point myPoint = e.getPoint();
				int myY = myPoint.y / 10;
				int myX = myPoint.x / 10;
				myModel.toggle(new Point(myY, myX));
			}
		}); 
		
		addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				Point myPoint = e.getPoint();
				int myY = myPoint.y / 10;
				int myX = myPoint.x / 10;
				myModel.toggle(new Point(myY, myX));
			}
		});
		
	}
	

	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);   
	
		//Paint grey background
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Paint alive cells
		g.setColor(Color.YELLOW);
		for(int i = 0; i < paintedSquares.size(); i++){
			//Stick around till 200
			if(myModel.age > 200){
				if(i % 5 == 0){
					g.setColor(Color.CYAN);
				}
				else if(i % 2 == 0){
					g.setColor(Color.MAGENTA);
				}
				else{
					g.setColor(Color.GREEN);
				}
			}
			Point p = paintedSquares.get(i);
			g.fillRect(p.y * 10, p.x*10, squareW, squareH);
		}
		
		//Paint grid lines
		g.setColor(Color.BLACK);
		for(int i = 10; i < this.getWidth(); i+=10){
			g.drawLine(i, 0, i, this.getHeight());
		}
		for(int j = 10; j < this.getHeight() + 10; j+=10){
			g.drawLine(0, j, this.getWidth(), j);
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		paintedSquares = myModel.setPainted();
		this.repaint();
		}	 


}//end class


