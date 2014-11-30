package proj2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameOfLifeView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton nextButton;
	private javax.swing.JButton startButton;
	private javax.swing.JButton stopButton;
	private javax.swing.JComboBox<String> shapes;
	private javax.swing.JTextField count;
	
	private String[] setShapes = {"Clear", "Glider", "Small Exploder", "Exploder", "Random"};
	
	
	private GameOfLifeModel myModel;
    
    GameOfLifeView(GameOfLifeModel model){
    	myModel = model;
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    
	    //Add the canvas to the pane
	    GameOfLifeCanvas myCanvas = new GameOfLifeCanvas(model);
	    model.addObserver(myCanvas);
	    c.gridwidth = 5;
	    pane.add(myCanvas, c);
	    
	    
	    c.gridwidth = 1; //Reset buttons to width = 1
	   
	    startButton = new JButton("Start");
	    c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 20;
	    pane.add(startButton, c);
	    
	    stopButton = new JButton("Stop");
	    c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 20;
	    pane.add(stopButton, c);
	    
	    nextButton = new JButton("Next");
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 20;
	    pane.add(nextButton, c);
	    
	    shapes = new JComboBox<>(setShapes);
	    c.weightx = 0.5;
	    c.gridx = 3;
	    c.gridy = 20;
	    pane.add(shapes, c);
	    
	    count = new JTextField(10);
	    c.gridx = 4;
	    c.gridy = 20;
	    pane.add(count, c);
	    
	    this.setContentPane(pane);
    }

    public void addNextListener(ActionListener l){
    	nextButton.addActionListener(l);
    }
    
    public void addStartListener(ActionListener l){
    	startButton.addActionListener(l);
    }
    
    public void addStopListener(ActionListener l){
    	stopButton.addActionListener(l);
    }
    
    public void setAge(String myAge){
    	count.setText(myAge);
    }
    
    public void addShapesListener(ActionListener l){
    	shapes.addActionListener(l);
    }
    
}
	

    

